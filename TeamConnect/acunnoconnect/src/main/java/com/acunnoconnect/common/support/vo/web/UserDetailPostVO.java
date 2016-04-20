package com.acunnoconnect.common.support.vo.web;

import java.sql.Date;

import com.acunnoconnect.common.support.vo.BaseInterfaceVO;

public class UserDetailPostVO  implements BaseInterfaceVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6311471231332574776L;
	String postForEmailId;
	String postByEmailId;
	String postContent;
	String status;
	String createDate;
	
	public String getPostForEmailId() {
		return postForEmailId;
	}
	public void setPostForEmailId(String postForEmailId) {
		this.postForEmailId = postForEmailId;
	}
	public String getPostByEmailId() {
		return postByEmailId;
	}
	public void setPostByEmailId(String postByEmailId) {
		this.postByEmailId = postByEmailId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
