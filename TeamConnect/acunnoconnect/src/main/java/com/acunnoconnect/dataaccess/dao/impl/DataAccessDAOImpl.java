package com.acunnoconnect.dataaccess.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import com.acunnoconnect.common.dao.ApplicationDaoSupport;
import com.acunnoconnect.common.support.ApplicationSqlQuerySupport;
import com.acunnoconnect.common.support.encrypt.ApplicationEcryptor;
import com.acunnoconnect.common.support.vo.core.ParameterVO;
import com.acunnoconnect.common.support.vo.web.DiscussionQuestionVO;
import com.acunnoconnect.common.support.vo.web.QuestionResponseVO;
import com.acunnoconnect.dataaccess.dao.DataAccessDAO;
import com.acunnoconnect.web.utils.ApplicationConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class DataAccessDAOImpl.
 */
public class DataAccessDAOImpl extends ApplicationDaoSupport implements DataAccessDAO {
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.dataaccess.dao.DataAccessDAO#validateUserLogin(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public boolean validateUserLogin(ParameterVO parameterVO) {

		Connection con = null;
		Statement stmtCommon = null;
		String role=null;
		String password = parameterVO.getUserEntitlementsVO().getPassword();
		String status=null;
		String firstName=null;
		String lastName = null;
		boolean validUser = false;
		parameterVO.setValidUser(false);

		try {
			con = getConnection();
			stmtCommon = con.createStatement();

			// select groups to this user belongs
			StringBuilder selectUserAccessQuery = new StringBuilder();
			selectUserAccessQuery.append(ApplicationSqlQuerySupport.SELECT_USER_DETAILS).append("'").append(parameterVO.getUserEntitlementsVO().getEmailId()).append("'");
			System.out.println("selectUserGroupsQuery: "
					+ selectUserAccessQuery.toString());

			// check to see if the user exist in the table
			ResultSet userrs = stmtCommon.executeQuery(selectUserAccessQuery.toString());
			while (userrs.next()) {
					password = userrs.getString("PASSWORD");
					role = userrs.getString("Role");
					status = userrs.getString("Status");
					firstName = userrs.getString("FIRSTNAME");
					lastName = userrs.getString("LASTNAME");
				}
			if(!StringUtils.isEmpty(password)){
				password = ApplicationEcryptor.decryptString(password, parameterVO.getUserEntitlementsVO().getEmailId());
			}
			
				if (!StringUtils.isEmpty(status)
						&& ApplicationConstants.STATUS_ACTIVE
								.equalsIgnoreCase(status)
						&& !StringUtils.isEmpty(password)
						&& password.equalsIgnoreCase(parameterVO
								.getUserEntitlementsVO().getPassword())) {
					if (!StringUtils.isEmpty(role)) {
						
						parameterVO.setValidUser(true);
						validUser = true;
						parameterVO.getUserEntitlementsVO().setFirstName(firstName);
						parameterVO.getUserEntitlementsVO().setLastName(lastName);
						parameterVO.getUserEntitlementsVO().setUserRole(role);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			parameterVO
					.setFailureMessage(ApplicationConstants.USER_LOGIN_FAILURE);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return validUser;
	}
	
	/**
	 * Gets the user group messages.
	 *
	 * @param parameterVO the parameter vo
	 * @return the user group messages
	 */
	public void getUserGroupMessages(ParameterVO parameterVO) {
		Connection con = null;
		Statement stmtCommon = null;
		String returnResponse = ApplicationConstants.RESPONSE_FAILURE;

		int responseCount = -1;

		String postingType = parameterVO.getListingType();
		String status = postingType.equalsIgnoreCase(ApplicationConstants.OPEN) ? ApplicationConstants.STATUS_OPEN
				: postingType.equalsIgnoreCase(ApplicationConstants.CLOSED) ? ApplicationConstants.STATUS_CLOSED
						: ApplicationConstants.BLANK;

		StringBuffer postQuestionQuery = new StringBuffer();
		postQuestionQuery = postQuestionQuery
				.append(
						"select QuestionId,QuestionHeader,Status,Createdby,CreateDate,viewscount,")
				.append("(select  count(QuestionId) from intutics_responsetable b where b.QuestionId = a.QuestionId) as ResponseCount")
				.append(" from intutics_QuestionTable a");
		if (!StringUtils.isEmpty(status)) {
			postQuestionQuery.append(" where Status=\'").append(status).append(
					"\' order by CreateDate desc;");
		} else if (postingType.equalsIgnoreCase(ApplicationConstants.MYLISTING)) {
			postQuestionQuery.append(" where Createdby=\'").append(
					parameterVO.getLoggedInUserName()).append(
					"\'  and Status <> \'D\' order by CreateDate desc;");
		} else if (postingType.equalsIgnoreCase(ApplicationConstants.FOLLOWING)) {
			postQuestionQuery.append(" where createdBy in (select followedEmailId from intutics_followersdetailtable where followerEmailId=\'").append(
					parameterVO.getLoggedInUserName()).append(
					"\')  and Status <> \'D\' order by CreateDate desc;");
		} else {
			// additional condition added to filterout discarded cases
			postQuestionQuery
					.append(" where Status <> \'D\' order by CreateDate desc;");
		}
		System.out.println(postQuestionQuery);

		try {
			con = getConnection();
			stmtCommon = con.createStatement();
			// check to see if the user exist in the table
			ResultSet rs = stmtCommon
					.executeQuery(postQuestionQuery.toString());
			int questionId = -1;
			String questionheader;
			String createdBy;
			int viewscount = 0;
			Date createDate = null;
			List<DiscussionQuestionVO> discussionQuestionVOList = new ArrayList<DiscussionQuestionVO>();
			while (rs.next()) {
				DiscussionQuestionVO discussionQuestionVO = new DiscussionQuestionVO();
				questionId = rs.getInt("QuestionId");
				if (questionId > -1)
					discussionQuestionVO.setQuestionId(questionId);
				questionheader = rs.getString("QuestionHeader");
				if (!StringUtils.isEmpty(questionheader))
					discussionQuestionVO.setQuestionHeader(questionheader);
				status = rs.getString("Status");
				if (!StringUtils.isEmpty(status))
					discussionQuestionVO.setStatus(status);
				createdBy = rs.getString("Createdby");
				if (!StringUtils.isEmpty(createdBy))
					discussionQuestionVO.setCreatedby(createdBy);
				// check to see if question is mine
				if (createdBy.equalsIgnoreCase(parameterVO
						.getUserEntitlementsVO().getEmailId())) {
					discussionQuestionVO.setMyQuestion(true);
				} else {
					discussionQuestionVO.setMyQuestion(false);
				}
				createDate = rs.getDate("CreateDate");
				if (createDate != null)
					discussionQuestionVO.setDateCreated(createDate);
				responseCount = rs.getInt("ResponseCount");
				if (responseCount > -1)
					discussionQuestionVO.setResponseCount(responseCount);
				viewscount = rs.getInt("viewscount");
				if (viewscount > -1)
					discussionQuestionVO.setViewscount(String
							.valueOf(viewscount));

				discussionQuestionVOList.add(discussionQuestionVO);
				parameterVO.setQuestionsList(discussionQuestionVOList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.dataaccess.dao.DataAccessDAO#getQuestionDetails(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void getQuestionDetails(ParameterVO parameterVO){
		Connection con = null;
		Statement stmtCommon = null;
		String returnResponse = ApplicationConstants.RESPONSE_SUCCESS;

		int responseCount = -1;

		/*
		 * select ResponseId,
		 * QuestionId,Response,GroupId,Selected,Createdby,CreateDate from
		 * 19_responsetable
		 */
		int questionId = parameterVO.getQuestionId();
		StringBuffer fetchQuestionQuery = new StringBuffer();
		fetchQuestionQuery = fetchQuestionQuery
				.append(
						"select QuestionId,GroupId,QuestionHeader,Question,Status,Attachment,AttachedFileName,viewscount,Createdby,CreateDate,viewscount")
				.append(" from intutics_QuestionTable a").append(" where QuestionId=\'")
				.append(questionId).append("\';");

		StringBuffer fetchResponsesQuery = new StringBuffer();
		fetchResponsesQuery = fetchResponsesQuery
				.append(
						"select ResponseId, QuestionId,Response,GroupId,Selected,Createdby,CreateDate")
				.append(" from intutics_responsetable a").append(" where QuestionId=\'")
				.append(questionId).append("\' order by CreateDate desc;");
		try {
			con = getConnection();
			stmtCommon = con.createStatement();
			// check to see if the user exist in the table
			ResultSet rs = stmtCommon.executeQuery(fetchQuestionQuery
					.toString());
			String question;
			String createdBy;
			String questionHeader;
			String groupId;
			String viewscount;
			String status = ApplicationConstants.BLANK;
			Date createDate = null;
			String createDateString;
			String attachment;
			String attachedFileName;
			DiscussionQuestionVO discussionQuestionVO = new DiscussionQuestionVO();
			while (rs.next()) {
				questionId = rs.getInt("QuestionId");
				if (questionId > -1)
					discussionQuestionVO.setQuestionId(questionId);
				groupId = rs.getString("GroupId");
				if (!StringUtils.isEmpty(groupId))
					discussionQuestionVO.setGroupId(groupId);
				question = rs.getString("Question");
				if (!StringUtils.isEmpty(question))
					discussionQuestionVO.setQuestion(question);
				questionHeader = rs.getString("QuestionHeader");
				if (!StringUtils.isEmpty(question))
					discussionQuestionVO.setQuestionHeader(questionHeader);
				status = rs.getString("Status");
				if (!StringUtils.isEmpty(status))
					discussionQuestionVO.setStatus(status);
				attachment = rs.getString("Attachment");
				if (!StringUtils.isEmpty(attachment))
					discussionQuestionVO.setAttachment(attachment);
				attachedFileName = rs.getString("AttachedFileName");
				if (!StringUtils.isEmpty(attachedFileName))
					discussionQuestionVO.setAttachedFileName(attachedFileName);
				status = rs.getString("Status");
				if (!StringUtils.isEmpty(status))
					discussionQuestionVO.setStatus(status);
				createdBy = rs.getString("Createdby");
				if (!StringUtils.isEmpty(createdBy))
					discussionQuestionVO.setCreatedby(createdBy);
				if (createdBy.equalsIgnoreCase(parameterVO
						.getUserEntitlementsVO().getEmailId())) {
					discussionQuestionVO.setMyQuestion(true);
				} else {
					discussionQuestionVO.setMyQuestion(false);
				}
				createDateString = rs.getString("CreateDate");
				if (!StringUtils.isEmpty(createDateString))
					discussionQuestionVO.setCreateDate(createDateString);
				createDate = rs.getDate("CreateDate");
				if (createDate != null)
					discussionQuestionVO.setDateCreated(createDate);
				viewscount = rs.getString("viewscount");
				if (createDate != null)
					discussionQuestionVO.setViewscount(viewscount);
				discussionQuestionVO.setResponseCount(0);
				parameterVO.setQuestionVO(discussionQuestionVO);
			}

			ResultSet resultSet = stmtCommon.executeQuery(fetchResponsesQuery
					.toString());

			int responseId = -1;
			String selected = ApplicationConstants.BLANK;
			String response = ApplicationConstants.BLANK;

			/*
			 * select ResponseId,
			 * QuestionId,Response,GroupId,Selected,Createdby,CreateDate from
			 * 19_responsetable
			 */

			List<QuestionResponseVO> questionResponseVOList = new ArrayList<QuestionResponseVO>();
			while (resultSet.next()) {
				QuestionResponseVO questionResponseVO = new QuestionResponseVO();
				responseId = resultSet.getInt("ResponseId");
				if (responseId > -1)
					questionResponseVO.setResponseId(responseId);
				questionId = resultSet.getInt("QuestionId");
				if (responseId > -1)
					questionResponseVO.setQuestionId(questionId);
				groupId = resultSet.getString("GroupId");
				if (!StringUtils.isEmpty(groupId))
					questionResponseVO.setGroupId(groupId);
				response = resultSet.getString("Response");
				if (!StringUtils.isEmpty(response))
					questionResponseVO.setResponseContent(response);
				selected = resultSet.getString("Selected");
				if (!StringUtils.isEmpty(selected))
					questionResponseVO.setSelectedString(selected);
				createdBy = resultSet.getString("Createdby");
				if (!StringUtils.isEmpty(createdBy))
					questionResponseVO.setCreatedBy(createdBy);
				createDate = resultSet.getDate("CreateDate");
				if (createDate != null)
					questionResponseVO.setCreateDate(createDate);
				createDateString = resultSet.getString("CreateDate");
				if (!StringUtils.isEmpty(createDateString))
					questionResponseVO.setCreateDateString(createDateString);
				questionResponseVOList.add(questionResponseVO);
			}
			Collections.sort(questionResponseVOList);
			parameterVO.setResponseList(questionResponseVOList);
			parameterVO.getQuestionVO().setResponseCount(questionResponseVOList.size());

			// now increment the views count for the question
			// UPDATE 20_QuestionTable SET viewscount = viewscount + 1 where
			// QuestionId='63';
			StringBuffer incrementViewsCount = new StringBuffer();
			incrementViewsCount = incrementViewsCount
					.append("UPDATE ")
					.append(
							"intutics_questiontagtable a set viewscount  = viewscount + 1 where QuestionId=\'")
					.append(questionId).append("\';");

			//int responseIncrement = stmtCommon
				//	.executeUpdate(incrementViewsCount.toString());

			// fetch question tags
			StringBuffer fetchTagsQuery = new StringBuffer();
			fetchTagsQuery = fetchTagsQuery.append("select Tag").append(
					" from intutics_questiontagtable a").append(
							" where QuestionId=\'").append(questionId).append(
							"\';");

			System.out.println("FetchTagsQuery: " + fetchTagsQuery.toString());

			ResultSet tagsRsultSet = stmtCommon.executeQuery(fetchTagsQuery
					.toString());
			StringBuffer tagsStringBuffer = new StringBuffer();
			String questiontag;
			while (tagsRsultSet.next()) {
				questiontag = tagsRsultSet.getString("Tag");
				tagsStringBuffer.append(questiontag).append(
						ApplicationConstants.COMMA);
			}
			parameterVO.getQuestionVO().setsTags(tagsStringBuffer.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 * @param parameterVO
	 * @return
	 */
	public void postResponse(ParameterVO parameterVO) {
		Connection con = null;
		Statement stmtCommon = null;
		String returnResponse = ApplicationConstants.RESPONSE_FAILURE;

		StringBuffer postResponseQuery = new StringBuffer();
		postResponseQuery = postResponseQuery
				.append("insert into ")
//				.append(
//						parameterVO.getUserEntitlementsVO()
//								.getSelectedGroupId())
				.append(
						"intutics_responsetable(QuestionId,Response,GroupId,Selected,Attachment,AttachedFileName,CreatedBy,CreateDate) ")
				.append("values (").append("\'").append(
						parameterVO.getQuestionId()).append(
						"\','").append(
						parameterVO.getResponseContent())
				.append("',\'").append("").append("\',\'").append(
						ApplicationConstants.NO).append("\',\'").append(
						ApplicationConstants.NO).append("\',\'").append(
						ApplicationConstants.BLANK).append("\',\'").append(
						parameterVO.getEmailId())
				.append("',\'").append(parameterVO.getTodaysDateString())
				.append("\');");

		try {
			con = getConnection();
			stmtCommon = con.createStatement();
			// check to see if the user exist in the table
			int responseInt = stmtCommon.executeUpdate(postResponseQuery
					.toString());
			if (responseInt == 1) {
				returnResponse = ApplicationConstants.RESPONSE_SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				parameterVO.setResponseMessage(returnResponse);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void postMessage(ParameterVO parameterVO) {
		Connection con = null;
		Statement stmtCommon = null;
		String returnResponse = ApplicationConstants.RESPONSE_FAILURE;

		StringBuffer postQuestionQuery = new StringBuffer();
		postQuestionQuery = postQuestionQuery
				.append("insert into intutics_QuestionTable(QuestionHeader,Question,Keywords,GroupId,Status,Attachment,AttachedFileName,Createdby,CreateDate,SelectedResponseId,viewscount) ")
				.append("values (").append("\'").append(
						parameterVO.getQuestionVO().getQuestionHeader())
				.append("\',\'").append(
						parameterVO.getQuestionVO().getQuestion()).append(
						"\','").append(ApplicationConstants.BLANK).append(
						"',\'").append(
						parameterVO.getUserEntitlementsVO()
								.getSelectedGroupId()).append("\',\'").append(
										ApplicationConstants.STATUS_OPEN).append("\',\'")
				.append(parameterVO.getFileName()!=null?ApplicationConstants.YES:ApplicationConstants.NO).append("\',\'").append(
						parameterVO.getFileName()!=null?parameterVO.getFileName():ApplicationConstants.BLANK).append("\',\'").append(
						parameterVO.getUserEntitlementsVO().getEmailId())
				.append("',\'").append(parameterVO.getTodaysDateString())
				.append("\',\'").append(ApplicationConstants.BLANK).append(
						"\',\'").append(ApplicationConstants.ZERO).append(
						"\');");

		try {
			con = getConnection();
			stmtCommon = con.createStatement();
			// check to see if the user exist in the table
			System.out.println("postQuestionQuery:" + postQuestionQuery);
			int responseInt = stmtCommon.executeUpdate(postQuestionQuery
					.toString());

			if (responseInt == 1) {
				returnResponse = ApplicationConstants.RESPONSE_SUCCESS;
				StringBuffer selectQuestionId = new StringBuffer();
				selectQuestionId
						.append(
								"select max(QuestionId) as questionId, viewscount from intutics_QuestionTable where CreatedBy = \'").append(
								parameterVO.getUserEntitlementsVO()
										.getEmailId()).append("\'");

				ResultSet questionIdRS = stmtCommon
						.executeQuery(selectQuestionId.toString());

				while (questionIdRS.next()) {
					String questionId = questionIdRS.getString("questionId");
					if (!StringUtils.isEmpty(questionId)) {
						parameterVO.getQuestionVO().setQuestionId(
								Integer.valueOf(questionId));
					}
					String viewscount = questionIdRS.getString("viewscount");
					if (!StringUtils.isEmpty(viewscount)) {
						parameterVO.getQuestionVO().setViewscount(viewscount);
					}
				}

				// update the question tags table

				StringBuilder valuesString = new StringBuilder("");
				StringTokenizer questionTagsToken = new StringTokenizer(
						parameterVO.getQuestionVO().getsTags(), " ");
				String tag;
				while (questionTagsToken.hasMoreTokens()) {
					tag = questionTagsToken.nextToken();
					if (StringUtils.isEmpty(valuesString.toString())) {
						valuesString.append("('").append(
								tag.trim().replaceAll(" ", "_")).append("',")
								.append(
										parameterVO.getQuestionVO()
												.getQuestionId()).append(")");
					} else {
						valuesString.append(",('").append(
								tag.trim().replaceAll(" ", "_")).append("',")
								.append(
										parameterVO.getQuestionVO()
												.getQuestionId()).append(")");
					}

				}

				StringBuilder updateTagsTable = new StringBuilder();
				if(!StringUtils.isEmpty(valuesString.toString())){
					
				updateTagsTable.append("insert into intutics_questiontagtable(Tag,QuestionId) values(").append("'"+
						valuesString.toString()+"',"+parameterVO.getQuestionVO().getQuestionId());

				System.out.println(updateTagsTable.toString());
				int response = stmtCommon.executeUpdate(updateTagsTable
						.toString());
				if (response > -1) {
					returnResponse = ApplicationConstants.RESPONSE_SUCCESS;
				}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}

