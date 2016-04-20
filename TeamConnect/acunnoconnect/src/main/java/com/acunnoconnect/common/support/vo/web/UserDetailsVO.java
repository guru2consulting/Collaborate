package com.acunnoconnect.common.support.vo.web;

import java.util.List;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;

public class UserDetailsVO implements BaseInterfaceVO,
Comparable<UserDetailsVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1932377975089856828L;


	public int compareTo(UserDetailsVO arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	  private String emailId;
	  
	  private String firstName;
	  
	  private String lastName;
	  
	  private String department;
	  
	  private String officeAddress;
	  
	  List<UserDetailsVO> followerDetails;
	  
	  List<UserDetailsVO> followedDetails;
	  
	  List<UserDetailPostVO> userDetailsPost;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public List<UserDetailsVO> getFollowerDetails() {
		return followerDetails;
	}

	public void setFollowerDetails(List<UserDetailsVO> followerDetails) {
		this.followerDetails = followerDetails;
	}

	public List<UserDetailsVO> getFollowedDetails() {
		return followedDetails;
	}

	public void setFollowedDetails(List<UserDetailsVO> followedDetails) {
		this.followedDetails = followedDetails;
	}

	public List<UserDetailPostVO> getUserDetailsPost() {
		return userDetailsPost;
	}

	public void setUserDetailsPost(List<UserDetailPostVO> userDetailsPost) {
		this.userDetailsPost = userDetailsPost;
	}
	  
	}
