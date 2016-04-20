package com.acunnoconnect.common.support.vo.web;

import java.util.Date;

import org.json.JSONObject;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;
import com.acunnoconnect.web.utils.ApplicationConstants;

public class QuestionResponseVO implements BaseInterfaceVO, Comparable<QuestionResponseVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int questionId;
	//this will not be used for mongo operations, to be used for rdbms dbs
	private int responseId;
	//specific to mongodb operations
	private String idresponse;
	
	private String userId;
	private String responseStatus;
	private String responseContent;
	private String groupId;
	private boolean selected;
	private String selectedString;
	private String createdBy;
	private Date createDate;
	private String responseTime;
	private String createDateString;
	boolean myResponse;
	private String questionAskedBy;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * 
	 * @return
	 */
	public JSONObject getJSONObject() {
		JSONObject postObject = new JSONObject();
		postObject.put(ApplicationConstants.RESPONSE_ID, this.getResponseId());
		postObject.put(ApplicationConstants.QUESTION_ID, this.getQuestionId());
		postObject.put(ApplicationConstants.GROUP_ID, this.getGroupId());
		postObject
				.put(ApplicationConstants.RESPONSE, this.getResponseContent());
		postObject.put(ApplicationConstants.SELECTED, this.getSelectedString());
		postObject.put(ApplicationConstants.RESPONDEDBY, this.getCreatedBy());
		postObject.put(ApplicationConstants.RESPONDED_DATE, this.getCreateDateString());
		postObject.put(ApplicationConstants.MYRESPONSE,
				this.isMyResponse() ? ApplicationConstants.YES
						: ApplicationConstants.NO);
		return postObject;
	}

	public String getSelectedString() {
		return selectedString;
	}

	public void setSelectedString(String selectedString) {
		this.selectedString = selectedString;
	}

	public String getCreateDateString() {
		return createDateString;
	}

	public void setCreateDateString(String createDateString) {
		this.createDateString = createDateString;
	}

	public boolean isMyResponse() {
		return myResponse;
	}

	public void setMyResponse(boolean myResponse) {
		this.myResponse = myResponse;
	}

	
	public int compareTo(QuestionResponseVO o) {
		return (this.getSelectedString()).compareTo(o.getSelectedString());
	}

	public String getQuestionAskedBy() {
		return questionAskedBy;
	}

	public void setQuestionAskedBy(String questionAskedBy) {
		this.questionAskedBy = questionAskedBy;
	}

	public String getIdresponse() {
		return idresponse;
	}

	public void setIdresponse(String idresponse) {
		this.idresponse = idresponse;
	}


}
