package com.acunnoconnect.common.support.vo.web;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;
import com.acunnoconnect.web.utils.ApplicationConstants;


/**
 * @author Dell
 * 
 */

public class DiscussionQuestionVO implements BaseInterfaceVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -469495930162848437L;

	int questionId;
	String question;
	String questionHeader;
	String keywords;
	//keywords and tags are same, keywords needs to be removed
	
	String questiontags;
	String groupId;
	String status;
	String attachment;
	String attachedFileName;
	String acceptedResponseId;
	String createDate;
	String userLocation;
	String createdby;
	String viewscount;
	boolean myQuestion;
	String emailId;
	int responseCount;
	Date dateCreated;
	List<String> tags;
	String sTags;

	/**
	 * 
	 * @return
	 */
	public JSONObject getJSONObject() {
		JSONObject postObject = new JSONObject();
		postObject.put(ApplicationConstants.ASKED_BY, this.getCreatedby());
		postObject.put(ApplicationConstants.RESPONSE_COUNT,
				this.getResponseCount());
		postObject.put(ApplicationConstants.QUESTION_HEADER, this.getQuestionHeader());
		postObject.put(ApplicationConstants.QUESTION, this.getQuestion());
		postObject.put(ApplicationConstants.POST_STATUS, this.getStatus());
		postObject.put(ApplicationConstants.VIEWS_COUNT, this.getViewscount());
		postObject.put(ApplicationConstants.ASKED_DATE, this.getCreateDate());
		postObject.put(ApplicationConstants.QUESTION_ID, this.getQuestionId());
		postObject.put(ApplicationConstants.GROUP_ID, this.getGroupId());
		postObject.put("attachment", this.getAttachment());
		postObject.put("attachedFileName", this.getAttachedFileName());
		postObject.put(ApplicationConstants.GROUP_ID, this.getGroupId());
		postObject.put(ApplicationConstants.QUESTION_TAGS, this.getsTags());
		postObject.put(ApplicationConstants.MYQUESTION,
				this.isMyQuestion() ? ApplicationConstants.YES
						: ApplicationConstants.NO);
		return postObject;
	}
	
	
	public JSONObject getDummyJSONObject() {
		JSONObject postObject = new JSONObject();
		postObject.put(ApplicationConstants.ASKED_BY, ApplicationConstants.BLANK);
		postObject.put(ApplicationConstants.RESPONSE_COUNT,
				ApplicationConstants.BLANK);
		postObject.put(ApplicationConstants.QUESTION_HEADER, ApplicationConstants.NO_LISTINGS_HEADER);
		postObject.put(ApplicationConstants.QUESTION, ApplicationConstants.NO_LISTINGS_BODY);
		postObject.put(ApplicationConstants.POST_STATUS, ApplicationConstants.STATUS_EMPTY);
		postObject.put(ApplicationConstants.QUESTION_ID, ApplicationConstants.BLANK);
		postObject.put(ApplicationConstants.GROUP_ID, ApplicationConstants.BLANK);
		postObject.put(ApplicationConstants.MYQUESTION,ApplicationConstants.YES);
		return postObject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getResponseCount() {
		return responseCount;
	}

	public void setResponseCount(int responseCount) {
		this.responseCount = responseCount;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getAttachedFileName() {
		return attachedFileName;
	}

	public void setAttachedFileName(String attachedFileName) {
		this.attachedFileName = attachedFileName;
	}


	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isMyQuestion() {
		return myQuestion;
	}

	public void setMyQuestion(boolean myQuestion) {
		this.myQuestion = myQuestion;
	}

	public String getQuestionHeader() {
		return questionHeader;
	}

	public void setQuestionHeader(String questionHeader) {
		this.questionHeader = questionHeader;
	}


	public String getViewscount() {
		return viewscount;
	}


	public void setViewscount(String viewscount) {
		this.viewscount = viewscount;
	}


	public List<String> getTags() {
		return tags;
	}


	public void setTags(List<String> tags) {
		this.tags = tags;
	}


	public String getsTags() {
		return sTags;
	}


	public void setsTags(String sTags) {
		this.sTags = sTags;
	}


	public String getAcceptedResponseId() {
		return acceptedResponseId;
	}


	public void setAcceptedResponseId(String acceptedResponseId) {
		this.acceptedResponseId = acceptedResponseId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getQuestiontags() {
		return questiontags;
	}


	public void setQuestiontags(String questiontags) {
		this.questiontags = questiontags;
	}

}
