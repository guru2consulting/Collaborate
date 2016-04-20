package com.acunnoconnect.common.support.vo.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;
import com.acunnoconnect.web.utils.ApplicationConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class UserEntitlementsVO.
 */
/**
 * @author Mukul Raizada
 * 
 */
public class UserEntitlementsVO implements BaseInterfaceVO,
		Comparable<UserEntitlementsVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The email id. */
	private String emailId;
	
	private String _id;

	private String password;

	private String selectedGroupId;

	private String userRole;
	
	private String action;

	private List<String> groupIdList;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The mirror emp id. */
	private String userId;

	/** The status. */
	private String status;

	/** User Alias */
	private String useralias;

	/** Validation Code */
	private String validationCode;

	/** Validation Code Date */
	private String validationCodeDate;
	
	private String remoteAddr;
	
	private String ipAddressPrev;
	/** Registation code */
	private String registrationDate;

	private boolean valid = false;

	private String newPassword;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUseralias() {
		return useralias;
	}

	public void setUseralias(String useralias) {
		this.useralias = useralias;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * 
	 * @return
	 */
	public JSONObject getJSONObject() {
		JSONObject postObject = new JSONObject();
		postObject.put(ApplicationConstants.USER_ID, this.getUserId());
		postObject
				.put(ApplicationConstants.USER_FIRSTNAME, this.getFirstName());
		postObject.put(ApplicationConstants.USER_LASTNAME, this.getLastName());
		postObject.put(ApplicationConstants.USER_ALIAS, this.getUseralias());
		postObject.put(ApplicationConstants.USER_STATUS, this.getStatus());
		postObject.put(ApplicationConstants.USER_VALID,
				this.isValid() ? ApplicationConstants.TRUE
						: ApplicationConstants.FALSE);
		return postObject;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	public String getValidationCodeDate() {
		return validationCodeDate;
	}

	public void setValidationCodeDate(String validationCodeDate) {
		this.validationCodeDate = validationCodeDate;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object passedObject) {
		boolean equal = false;
		if (passedObject instanceof UserEntitlementsVO) {
			UserEntitlementsVO passedVO = (UserEntitlementsVO) passedObject;
			if (!StringUtils.isEmpty(passedVO.getEmailId())
					&& !StringUtils.isEmpty(this.getEmailId())) {
				if (passedVO.getEmailId().equalsIgnoreCase(this.getEmailId())) {
					equal = true;
				}
			}
		}
		return equal;
	}

	public List<String> getGroupIdList() {
		List<String> newGroupIdList = null;
		if (groupIdList != null) {
			newGroupIdList = groupIdList;
		} else {
			newGroupIdList = new ArrayList<String>();
		}

		return newGroupIdList;
	}

	public void setGroupIdList(List<String> groupIdList) {
		this.groupIdList = groupIdList;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getSelectedGroupId() {
		return selectedGroupId;
	}

	public void setSelectedGroupId(String selectedGroupId) {
		this.selectedGroupId = selectedGroupId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	public int compareTo(UserEntitlementsVO userEntitlementsVO) {
		return this.getEmailId().compareTo(userEntitlementsVO.getEmailId());
	}

	public String getIpAddressPrev() {
		return ipAddressPrev;
	}

	public void setIpAddressPrev(String ipAddressPrev) {
		this.ipAddressPrev = ipAddressPrev;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getId() {
		return emailId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
