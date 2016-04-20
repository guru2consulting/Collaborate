package com.acunnoconnect.common.support.vo.web;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;

public class GroupVO implements BaseInterfaceVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String superAdminEmailId;
	
	
	private String adminPassword;
	
	private String validationCode;
	
	private String approvalAction;
	
	private String groupId;
	
	private String groupName;
	
	private String groupDescription;
	
	private String linkedInUrl;
	
	private Date createDate;
	
	private Set<UserEntitlementsVO> newMembersAdded;
	
	private Set<UserEntitlementsVO> existingMembers;
	private Set<String> tags;
	String sTags;
	

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}


	public String getApprovalAction() {
		return approvalAction;
	}

	public void setApprovalAction(String approvalAction) {
		this.approvalAction = approvalAction;
	}

	
	public Set<UserEntitlementsVO> getNewMembersAdded() {
		return newMembersAdded;
	}

	public void setNewMembersAdded(Set<UserEntitlementsVO> newMembersAdded) {
		this.newMembersAdded = newMembersAdded;
	}

	public Set<UserEntitlementsVO> getExistingMembers() {
		return existingMembers;
	}

	public void setExistingMembers(Set<UserEntitlementsVO> existingMembers) {
		this.existingMembers = existingMembers;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Set<String> getTags() {
		if(tags==null){
			tags = new TreeSet<String>();
		}
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public String getsTags() {
		return sTags;
	}

	public void setsTags(String sTags) {
		this.sTags = sTags;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getSuperAdminEmailId() {
		return superAdminEmailId;
	}

	public void setSuperAdminEmailId(String superAdminEmailId) {
		this.superAdminEmailId = superAdminEmailId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
