package com.acunnoconnect.common.support.vo.core;

import java.io.File;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.acunnoconnect.common.support.util.ApplicationUtil;
import com.acunnoconnect.common.support.vo.web.DiscussionQuestionVO;
import com.acunnoconnect.common.support.vo.web.GroupVO;
import com.acunnoconnect.common.support.vo.web.MailingVO;
import com.acunnoconnect.common.support.vo.web.QuestionResponseVO;
import com.acunnoconnect.common.support.vo.web.UserDetailPostVO;
import com.acunnoconnect.common.support.vo.web.UserDetailsVO;
import com.acunnoconnect.common.support.vo.web.UserEntitlementsVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParameterVO.
 *
 * @author Mukul Raizada
 */
public class ParameterVO extends BaseParameterVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8976481214796263761L;

	/** The mailing vo. */
	private MailingVO mailingVO;

	/** The user entitlements vo. */
	private UserEntitlementsVO userEntitlementsVO;
	
	/** The questions list. */
	private List<DiscussionQuestionVO> questionsList;
	
	/** The response list. */
	private List<QuestionResponseVO> responseList;
	
	/** The user detail posts. */
	private List<UserDetailPostVO> userDetailPosts;
	
	/** The users list. */
	private List<UserDetailsVO> usersList;
	
	/** The user details vo. */
	private UserDetailsVO userDetailsVO;
	
	/** The group id. */
	private String groupId;
	
	/** The group admin. */
	private String groupAdmin;
	
	/** The question id. */
	private int questionId;
	
	/** The user role. */
	private String userRole;
	
	/** The logged in user name. */
	private String loggedInUserName;
	
	/** The logged in user id. */
	private String loggedInUserId;
	
	/** The webinfpath. */
	private String webinfpath;
	
	/** The question vo. */
	private DiscussionQuestionVO questionVO;
	
	/** The response vo. */
	private QuestionResponseVO responseVO;
	
	/** The question posted by. */
	private String questionPostedBy;
	
	/** The group vo. */
	private GroupVO groupVO;
	
	/** The logged in user. */
	private boolean loggedInUser;
	
	/** The valid user. */
	private boolean validUser;
	
	/** The listing type. */
	private String listingType;
	
	/** The approval action. */
	private String approvalAction;
	
	/** The error message. */
	private String errorMessage;
	
	/** The search content. */
	private String searchContent;
	
	/** The search string. */
	private String searchString;
	
	/** The email id. */
	private String emailId;
	
	/** The failure message. */
	private String failureMessage;
	
	/** The response content. */
	private String responseContent;
	
	/** The questions array. */
	private JSONArray questionsArray;
	
	/** The question object. */
	private JSONObject questionObject;
	
	/** The response array. */
	private JSONArray responseArray;
	
	/** The user group array. */
	private JSONArray userGroupArray;
	
	/** The users array. */
	private JSONArray usersArray;
	
	
	/**
	 * Checks if is valid user.
	 *
	 * @return true, if is valid user
	 */
	public boolean isValidUser() {
		return validUser;
	}

	/**
	 * Sets the valid user.
	 *
	 * @param validUser the new valid user
	 */
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}

	/**
	 * Gets the failure message.
	 *
	 * @return the failure message
	 */
	public String getFailureMessage() {
		return failureMessage;
	}

	/**
	 * Sets the failure message.
	 *
	 * @param failureMessage the new failure message
	 */
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	/** The follow user. */
	private String followUser;
	
	/** The file name. */
	private String fileName;
	
	/** The uploaded file. */
	private File uploadedFile;
	
	/** The downloaded file. */
	private File downloadedFile;
	
	/** The image array. */
	private List<String> imageArray;
	
	/** The generated file name. */
	private String generatedFileName;
	
	/** The file extn. */
	private String fileExtn;
	
	/** The file post type. */
	private String filePostType;
	
	/** The file post id. */
	private String filePostId;
	
	/**  Validation Code. */
	private String validationCode;
	
	/** The ip address current. */
	private String ipAddressCurrent;
	
	/** The ip address prev. */
	private String ipAddressPrev;
	
	/** The todays date. */
	String todaysDate;

	/**
	 * Gets the mailing vo.
	 *
	 * @return the mailing vo
	 */
	public MailingVO getMailingVO() {
		if (mailingVO == null) {
			mailingVO = new MailingVO();
		}
		return mailingVO;
	}

	/**
	 * Sets the mailing vo.
	 *
	 * @param mailingVO the new mailing vo
	 */
	public void setMailingVO(MailingVO mailingVO) {
		this.mailingVO = mailingVO;
	}

	/**
	 * Gets the todays date string.
	 *
	 * @return the todays date string
	 */
	public String getTodaysDateString() {
		return ApplicationUtil.getTodaysDateString();
	}

	/**
	 * Gets the user entitlements vo.
	 *
	 * @return the user entitlements vo
	 */
	public UserEntitlementsVO getUserEntitlementsVO() {
		if (userEntitlementsVO == null) {
			userEntitlementsVO = new UserEntitlementsVO();
		}
		return userEntitlementsVO;
	}

	/**
	 * Sets the user entitlements vo.
	 *
	 * @param userEntitlementsVO the new user entitlements vo
	 */
	public void setUserEntitlementsVO(UserEntitlementsVO userEntitlementsVO) {
		this.userEntitlementsVO = userEntitlementsVO;
	}

	/**
	 * Gets the group admin.
	 *
	 * @return the group admin
	 */
	public String getGroupAdmin() {
		return groupAdmin;
	}

	/**
	 * Sets the group admin.
	 *
	 * @param groupAdmin the new group admin
	 */
	public void setGroupAdmin(String groupAdmin) {
		this.groupAdmin = groupAdmin;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the new user role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * Checks if is logged in user.
	 *
	 * @return true, if is logged in user
	 */
	public boolean isLoggedInUser() {
		return loggedInUser;
	}

	/**
	 * Sets the logged in user.
	 *
	 * @param loggedInUser the new logged in user
	 */
	public void setLoggedInUser(boolean loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	/**
	 * Gets the question vo.
	 *
	 * @return the question vo
	 */
	public DiscussionQuestionVO getQuestionVO() {
		if (this.questionVO == null) {
			questionVO = new DiscussionQuestionVO();
		}
		return questionVO;
	}

	/**
	 * Sets the question vo.
	 *
	 * @param questionVO the new question vo
	 */
	public void setQuestionVO(DiscussionQuestionVO questionVO) {
		this.questionVO = questionVO;
	}

	/**
	 * Gets the logged in user name.
	 *
	 * @return the logged in user name
	 */
	public String getLoggedInUserName() {
		return loggedInUserName;
	}

	/**
	 * Sets the logged in user name.
	 *
	 * @param loggedInUserName the new logged in user name
	 */
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}

	/**
	 * Gets the questions list.
	 *
	 * @return the questions list
	 */
	public List<DiscussionQuestionVO> getQuestionsList() {
		return questionsList;
	}

	/**
	 * Sets the questions list.
	 *
	 * @param questionsList the new questions list
	 */
	public void setQuestionsList(List<DiscussionQuestionVO> questionsList) {
		this.questionsList = questionsList;
	}

	/**
	 * Gets the listing type.
	 *
	 * @return the listing type
	 */
	public String getListingType() {
		return listingType;
	}

	/**
	 * Sets the listing type.
	 *
	 * @param listingType the new listing type
	 */
	public void setListingType(String listingType) {
		this.listingType = listingType;
	}

	/**
	 * Gets the response list.
	 *
	 * @return the response list
	 */
	public List<QuestionResponseVO> getResponseList() {
		return responseList;
	}

	/**
	 * Sets the response list.
	 *
	 * @param responseList the new response list
	 */
	public void setResponseList(List<QuestionResponseVO> responseList) {
		this.responseList = responseList;
	}

	/**
	 * Gets the response vo.
	 *
	 * @return the response vo
	 */
	public QuestionResponseVO getResponseVO() {
		return responseVO;
	}

	/**
	 * Sets the response vo.
	 *
	 * @param responseVO the new response vo
	 */
	public void setResponseVO(QuestionResponseVO responseVO) {
		this.responseVO = responseVO;
	}

	/**
	 * Gets the approval action.
	 *
	 * @return the approval action
	 */
	public String getApprovalAction() {
		return approvalAction;
	}

	/**
	 * Sets the approval action.
	 *
	 * @param approvalAction the new approval action
	 */
	public void setApprovalAction(String approvalAction) {
		this.approvalAction = approvalAction;
	}

	/**
	 * Gets the group vo.
	 *
	 * @return the group vo
	 */
	public GroupVO getGroupVO() {
		if (groupVO == null) {
			groupVO = new GroupVO();
		}
		return groupVO;
	}

	/**
	 * Sets the group vo.
	 *
	 * @param groupVO the new group vo
	 */
	public void setGroupVO(GroupVO groupVO) {
		this.groupVO = groupVO;
	}

	/**
	 * Gets the group id.
	 *
	 * @return the group id
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * Sets the group id.
	 *
	 * @param groupId the new group id
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the logged in user id.
	 *
	 * @return the logged in user id
	 */
	public String getLoggedInUserId() {
		return loggedInUserId;
	}

	/**
	 * Sets the logged in user id.
	 *
	 * @param loggedInUserId the new logged in user id
	 */
	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	/**
	 * Gets the search content.
	 *
	 * @return the search content
	 */
	public String getSearchContent() {
		return searchContent;
	}

	/**
	 * Sets the search content.
	 *
	 * @param searchContent the new search content
	 */
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	/**
	 * Gets the user details vo.
	 *
	 * @return the user details vo
	 */
	public UserDetailsVO getUserDetailsVO() {
		return userDetailsVO;
	}

	/**
	 * Sets the user details vo.
	 *
	 * @param userDetailsVO the new user details vo
	 */
	public void setUserDetailsVO(UserDetailsVO userDetailsVO) {
		this.userDetailsVO = userDetailsVO;
	}

	/**
	 * Gets the search string.
	 *
	 * @return the search string
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * Sets the search string.
	 *
	 * @param searchString the new search string
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * Gets the users list.
	 *
	 * @return the users list
	 */
	public List<UserDetailsVO> getUsersList() {
		return usersList;
	}

	/**
	 * Sets the users list.
	 *
	 * @param usersList the new users list
	 */
	public void setUsersList(List<UserDetailsVO> usersList) {
		this.usersList = usersList;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the follow user.
	 *
	 * @return the follow user
	 */
	public String getFollowUser() {
		return followUser;
	}

	/**
	 * Sets the follow user.
	 *
	 * @param followUser the new follow user
	 */
	public void setFollowUser(String followUser) {
		this.followUser = followUser;
	}

	/**
	 * Gets the user detail posts.
	 *
	 * @return the user detail posts
	 */
	public List<UserDetailPostVO> getUserDetailPosts() {
		return userDetailPosts;
	}

	/**
	 * Sets the user detail posts.
	 *
	 * @param userDetailPosts the new user detail posts
	 */
	public void setUserDetailPosts(List<UserDetailPostVO> userDetailPosts) {
		this.userDetailPosts = userDetailPosts;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the uploaded file.
	 *
	 * @return the uploaded file
	 */
	public File getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * Sets the uploaded file.
	 *
	 * @param uploadedFile the new uploaded file
	 */
	public void setUploadedFile(File uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/**
	 * Gets the generated file name.
	 *
	 * @return the generated file name
	 */
	public String getGeneratedFileName() {
		return generatedFileName;
	}

	/**
	 * Sets the generated file name.
	 *
	 * @param generatedFileName the new generated file name
	 */
	public void setGeneratedFileName(String generatedFileName) {
		this.generatedFileName = generatedFileName;
	}

	/**
	 * Gets the file extn.
	 *
	 * @return the file extn
	 */
	public String getFileExtn() {
		return fileExtn;
	}

	/**
	 * Sets the file extn.
	 *
	 * @param fileExtn the new file extn
	 */
	public void setFileExtn(String fileExtn) {
		this.fileExtn = fileExtn;
	}

	/**
	 * Gets the file post type.
	 *
	 * @return the file post type
	 */
	public String getFilePostType() {
		return filePostType;
	}

	/**
	 * Sets the file post type.
	 *
	 * @param filePostType the new file post type
	 */
	public void setFilePostType(String filePostType) {
		this.filePostType = filePostType;
	}

	/**
	 * Gets the file post id.
	 *
	 * @return the file post id
	 */
	public String getFilePostId() {
		return filePostId;
	}

	/**
	 * Sets the file post id.
	 *
	 * @param filePostId the new file post id
	 */
	public void setFilePostId(String filePostId) {
		this.filePostId = filePostId;
	}

	/**
	 * Gets the downloaded file.
	 *
	 * @return the downloaded file
	 */
	public File getDownloadedFile() {
		return downloadedFile;
	}

	/**
	 * Sets the downloaded file.
	 *
	 * @param downloadedFile the new downloaded file
	 */
	public void setDownloadedFile(File downloadedFile) {
		this.downloadedFile = downloadedFile;
	}

	/**
	 * Gets the image array.
	 *
	 * @return the image array
	 */
	public List<String> getImageArray() {
		return imageArray;
	}

	/**
	 * Sets the image array.
	 *
	 * @param imageArray the new image array
	 */
	public void setImageArray(List<String> imageArray) {
		this.imageArray = imageArray;
	}

	/**
	 * Gets the webinfpath.
	 *
	 * @return the webinfpath
	 */
	public String getWebinfpath() {
		return webinfpath;
	}

	/**
	 * Sets the webinfpath.
	 *
	 * @param webinfpath the new webinfpath
	 */
	public void setWebinfpath(String webinfpath) {
		this.webinfpath = webinfpath;
	}

	/**
	 * Gets the validation code.
	 *
	 * @return the validation code
	 */
	public String getValidationCode() {
		return validationCode;
	}

	/**
	 * Sets the validation code.
	 *
	 * @param validationCode the new validation code
	 */
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	/**
	 * Gets the ip address current.
	 *
	 * @return the ip address current
	 */
	public String getIpAddressCurrent() {
		return ipAddressCurrent;
	}

	/**
	 * Sets the ip address current.
	 *
	 * @param ipAddressCurrent the new ip address current
	 */
	public void setIpAddressCurrent(String ipAddressCurrent) {
		this.ipAddressCurrent = ipAddressCurrent;
	}

	/**
	 * Gets the ip address prev.
	 *
	 * @return the ip address prev
	 */
	public String getIpAddressPrev() {
		return ipAddressPrev;
	}

	/**
	 * Sets the ip address prev.
	 *
	 * @param ipAddressPrev the new ip address prev
	 */
	public void setIpAddressPrev(String ipAddressPrev) {
		this.ipAddressPrev = ipAddressPrev;
	}

	/**
	 * Gets the todays date.
	 *
	 * @return the todays date
	 */
	public String getTodaysDate() {
		return todaysDate;
	}

	/**
	 * Sets the todays date.
	 *
	 * @param todaysDate the new todays date
	 */
	public void setTodaysDate(String todaysDate) {
		this.todaysDate = todaysDate;
	}

	/**
	 * Gets the question id.
	 *
	 * @return the question id
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * Sets the question id.
	 *
	 * @param questionId the new question id
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * Gets the response content.
	 *
	 * @return the response content
	 */
	public String getResponseContent() {
		return responseContent;
	}

	/**
	 * Sets the response content.
	 *
	 * @param responseContent the new response content
	 */
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	/**
	 * Gets the questions array.
	 *
	 * @return the questions array
	 */
	public JSONArray getQuestionsArray() {
		return questionsArray;
	}

	/**
	 * Sets the questions array.
	 *
	 * @param questionsArray the new questions array
	 */
	public void setQuestionsArray(JSONArray questionsArray) {
		this.questionsArray = questionsArray;
	}

	/**
	 * Gets the question object.
	 *
	 * @return the question object
	 */
	public JSONObject getQuestionObject() {
		return questionObject;
	}

	/**
	 * Sets the question object.
	 *
	 * @param questionObject the new question object
	 */
	public void setQuestionObject(JSONObject questionObject) {
		this.questionObject = questionObject;
	}

	/**
	 * Gets the response array.
	 *
	 * @return the response array
	 */
	public JSONArray getResponseArray() {
		return responseArray;
	}

	/**
	 * Sets the response array.
	 *
	 * @param responseArray the new response array
	 */
	public void setResponseArray(JSONArray responseArray) {
		this.responseArray = responseArray;
	}

	/**
	 * Gets the question posted by.
	 *
	 * @return the question posted by
	 */
	public String getQuestionPostedBy() {
		return questionPostedBy;
	}

	/**
	 * Sets the question posted by.
	 *
	 * @param questionPostedBy the new question posted by
	 */
	public void setQuestionPostedBy(String questionPostedBy) {
		this.questionPostedBy = questionPostedBy;
	}

	/**
	 * Gets the user group array.
	 *
	 * @return the user group array
	 */
	public JSONArray getUserGroupArray() {
		return userGroupArray;
	}

	/**
	 * Sets the user group array.
	 *
	 * @param userGroupArray the new user group array
	 */
	public void setUserGroupArray(JSONArray userGroupArray) {
		this.userGroupArray = userGroupArray;
	}

	/**
	 * Gets the users array.
	 *
	 * @return the users array
	 */
	public JSONArray getUsersArray() {
		return usersArray;
	}

	/**
	 * Sets the users array.
	 *
	 * @param usersArray the new users array
	 */
	public void setUsersArray(JSONArray usersArray) {
		this.usersArray = usersArray;
	}
}
