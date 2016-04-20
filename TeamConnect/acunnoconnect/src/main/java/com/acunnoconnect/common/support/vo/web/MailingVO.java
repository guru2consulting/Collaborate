package com.acunnoconnect.common.support.vo.web;

import java.util.Set;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;


public class MailingVO implements BaseInterfaceVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userFirstName;
	private String toEmailId;
	private String fromEmailId;
	private String subject;
	private String content;
	private String postContent;
	private String validationCode;
	private String validationPostId;
	private boolean userValidation;
	private boolean postValidation;
	private String mailFor;
	private String groupId;
	private String adminPassword;
	public boolean responseStatus = true;
	private Set<MailingVO> membersList;
	
	
	public String getToEmailId() {
		return toEmailId;
	}
	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}
	public String getFromEmailId() {
		return fromEmailId;
	}
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
			return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	public String getValidationPostId() {
		return validationPostId;
	}
	public void setValidationPostId(String validationPostId) {
		this.validationPostId = validationPostId;
	}
	public boolean isUserValidation() {
		return userValidation;
	}
	public void setUserValidation(boolean userValidation) {
		this.userValidation = userValidation;
	}
	public boolean isPostValidation() {
		return postValidation;
	}
	public void setPostValidation(boolean postValidation) {
		this.postValidation = postValidation;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getMailFor() {
		return mailFor;
	}
	public void setMailFor(String mailFor) {
		this.mailFor = mailFor;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Set<MailingVO> getMembersList() {
		return membersList;
	}
	public void setMembersList(Set<MailingVO> membersList) {
		this.membersList = membersList;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public boolean isResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}
}
