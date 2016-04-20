package com.acunnoconnect.web.utils;

/**
 * 
 * @author Mukul
 *
 */
public class ApplicationConstants {

	// Pages
	public static final String DISCUSSION_LISTING = "DiscussionListing";
	public static final String HOME_PAGE = "home";
	
	public static final String LOGGED_IN_USER = "loggedInUser";
	public static final String LOGGED_IN_USER_ROLE = "loggedInUserRole";
	public static final String LOGGED_IN_USER_NAME = "loggedInUserName";
	public static final String LOGGED_IN_USER_ID = "loggedInUserId";
	public static final String LOGGED_IN_USER_GROUP = "loggedInUserGroup";
	public static final String LOGGED_IN_USER_GROUP_ID = "loggedInUserGroupId";
	public static final String LOGGED_IN_USER_GROUP_NAME = "loggedInUserGroupName";
	public static final String GROUP_MEMBERS_ALL = "groupMembersAll";
	public static final String GROUP_LINKEDIN_URL = "linkedInUrl";
	public static final String NEW_MEMBERS_ADDED = "newMembersAdded";
	public static final String PARAMETER_VO = "parameterVO";
	public static final String USERS_GROUP_LIST = "usersGroupList";
	public static final String USERS_GROUP_TAG_LIST = "userGroupTagList";
	public static final String USERS_GROUP_TAGS = "userGroupTags";
	public static final String USER_VALIDATION_CODE = "userValidationCode";

	public static final String INTUTICS_UI_MESSAGE_LOGIN = "intuticsuimessagelogin";
	public static final String INTUTICS_UI_MESSAGE_GROUP_UPDATE = "intuticsuimessagegroupupdate";
	public static final String INTUTICS_UI_MESSAGE_NEWGROUP = "intuticsuimessagenewgroup";

	public static final String NO_LISTINGS_HEADER = "There are no listing under the selected category to display";
	public static final String NO_LISTINGS_BODY = "There are no listing to display.";

	public static final String BLANK = "";
	public static final String HYPHEN = "-";
	public static final String COMMA = ",";
	public static final String SPACE = " ";
	public static final String ZERO = "0";
	public static final String COLON = ":";
	public static final String PASSWORD_DEFAULT = "intutics123";

	// Mail for constants
	public static final String MAIL_CREATE_GROUP_VALIDATE = "mailCreateGroupValidate";
	public static final String MAIL_CREATE_GROUP_ACTIVATE = "mailCreateGroupActivate";
	public static final String MAIL_GROUP_MEMBER_ACTIVATE = "mailGroupMemberValidate";
	public static final String GROUP_PAGE_MESSAGE = "grouppagemessage";

	// cache
	public static final String PROJECT_CACHE_NAME = "projectBaseCache";
	public static final String PROJECT_POST_CACHE = "projectPostCache";
	public static final String PROJECT_CHAT_CACHE = "projectChatCache";

	// CALENDER DAYS
	public static final String AM = "am";
	public static final String PM = "pm";
	public static final String JAN = "jan";
	public static final String FEB = "feb";
	public static final String MAR = "mar";
	public static final String APR = "apr";
	public static final String MAY = "may";
	public static final String JUN = "jun";
	public static final String JUL = "jul";
	public static final String AUG = "aug";
	public static final String SEP = "sep";
	public static final String OCT = "oct";
	public static final String NOV = "nov";
	public static final String DEC = "dec";

	// user table attributes
	public static final String USER_FIRSTNAME = "username_first";
	public static final String USER_LASTNAME = "username_last";
	public static final String PASSWORD = "password";
	public static final String USER_ID = "userId";
	public static final String USER_ALIAS = "user_alias";
	public static final String USER_EMAILID = "user_Emailid";
	public static final String USER_STATUS = "user_status";
	public static final String USER_VALID = "user_valid";

	// Questions VO attributes
	public static final String ASKED_BY = "askedby";
	public static final String RESPONSE_COUNT = "responsecount";
	public static final String POSTEDDATE = "posteddate";
	public static final String QUESTION = "question";
	public static final String QUESTION_HEADER = "questionheader";
	public static final String QUESTION_ID = "questionId";
	public static final String QUESTION_TAGS = "questionTags";
	public static final String STATUS_OPEN = "O";
	public static final String STATUS_CLOSED = "C";
	public static final String STATUS_EMPTY = "Z";
	public static final String MYQUESTION = "myquestion";
	public static final String MYRESPONSE = "myresponse";
	public static final String VIEWS_COUNT = "viewscount";
	public static final String ASKED_DATE = "askeddate";

	/** RESPONSE CONTENT **/
	public static final String RESPONSE = "response";
	public static final String RESPONSE_ID = "responseId";
	public static final String GROUP_ID = "groupId";
	public static final String EMAIL_ID = "emailId";
	public static final String ACCEPTED = "accepted";
	public static final String SELECTED = "selected";
	public static final String RESPONDEDBY = "respondedBy";
	public static final String RESPONDED_DATE = "respondedDate";
	public static final String INTUTICS_SEARCH = "intuticssearch";
	public static final String USER_UNAVAILABLE = "userunavailable";
	public static final String USER_DELETED = "userdeleted";
	public static final String USER_ACTIVATED = "useractivated";
	public static final String USER_ALREADYACTIVE = "useralreadyactive";
	

	public static final String YES = "Y";
	public static final String NO = "N";

	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_INACTIVE = "I";
	public static final String STATUS_DISCARD = "D";

	public static final String POST_STATUS = "post_status";
	public static final String MAIL_POST_MESSAGE_KEY = "mail_post_message";
	public static final String POST_ID = "post_id";
	public static final String VALIDATION_CODE = "validation_code";

	/** MESSAGES : UI **/
	public static final String MAIL_POST_MESSAGE_SUCCESS = "We have sent a mail at  the to your emailId, please validate to post the message.";
	public static final String MAIL_POST_MESSAGE_FAILURE = "We have not been able to post the message, please try after some time.";
	public static final String GROUP_MESSAGE_POST_SUCCESSFUL = "Your post has been successfully shared with the group.";
	public static final String GROUP_MESSAGE_POST_FAILURE = "Your post has not been shared with the group encountered problem, try after some time.";
	public static final String USER_LOGIN_FAILURE = "Username or password is incorrect.";

	// user page attributes
	public static final String USER_TITLE = "userTitle";
	public static final String USER_IMAGE_URL = "userImageUrl";
	public static final String USER_POST = "userPost";
	public static final String POST_TIME = "postTime";
	public static final String USER_POST_TYPE = "userPostType";
	public static final String USER_LOCATION = "userLocation";

	// USER Role
	public static final String GROUP_ADMIN = "GA";
	public static final String GROUP_MEMBER = "GM";

	// request parameters
	public static final String OPERATION = "operation";
	public static final String INITIALIZE_HOME = "initializehome";
	public static final String UPDATE_HOME_POSTS = "updatehomeposts";
	public static final String INITIALIZE_LOGGED_IN_HOME = "initializeLoggedInUserhome";
	public static final String VALIDATE_USER = "validateuser";
	public static final String VALIDATE_POST = "validatepost";
	public static final String FAIL_USER = "failuser";
	public static final String FAIL_POST = "failpost";

	// Parameters Constant:
	public static final String IS_USER_LOGGEDIN = "isUserLoggedIn";
	public static final String TRUE = "true";
	public static final String FALSE = "false";

	// bean name constants
	/** The Constant USER_ENTITLEMENT_SERVICE_MANAGER. */
	public static final String MAIL_SERVICE_MANAGER = "mailServiceManager";
	public static final String DATA_ACCESS_SERVICE_MANAGER = "dataAccessServiceManager";
	public static final String PROJECT_CACHE_MANAGER = "projectCacheManager";
	public static final String CHAT_SERVICE_MANAGER = "chatServiceManager";
	public static final String FILE_UPLOAD_SERVICE_MANAGER = "fileUploadServiceManager";

	/** The Constant USER_ENTITLEMENT_RESPONSE TYPEs. */
	public static final String RESPONSE_MESSAGE = "message";
	public static final String RESPONSE_SUCCESS = "success";
	public static final String RESPONSE_FAILURE = "failure";
	public static final String RESPONSE_EXISTING = "existing";
	public static final String LOGIN_ERROR = "loginError";

	/** EMAIL MESSAGES ***/
	public static final String MESSAGE_PASSWORD_CHANGE_SUCCESS = "Password updated successfully";
	public static final String MESSAGE_PASSWORD_CHANGE_FAILURE = "Password has not been updated, please try later.";
	public static final String MESSAGE_PASSWORD_CHANGE_CURRENT_PW_INCORRECT = "Password has not been updated, please check current password.";
	public static final String MESSAGE_PASSWORD_CHANGE_TRY_LATER = "Password has not been updated, please check current password.";

	/** LISTING TYPE ****/
	public static final String LISTING_TYPE = "listingsType";
	/****/

	/** USER LOGIN RESPONSES **/
	public static final String USER_NOT_ACTIVE = "userNotActive";
	public static final String USERNAME_PASSWORD_NOT_VALID = "userNamePasswordNotValid";

	public static final String OPEN = "open";
	public static final String CLOSED = "closed";
	public static final String MYLISTING = "mylisting";
	public static final String FOLLOWING = "following";
	public static final String ENTIRE = "entire";
	
	/** SUPPORTED FILE TYPES **/
	public static final String XLS = ".xls";
	public static final String XLSX = ".xlsx";
	public static final String DOC = ".doc";
	public static final String DOCX = ".docx";
	public static final String PPT = ".ppt";
	public static final String PPTX = ".pptx";
	
	


}
