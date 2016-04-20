package com.acunnoconnect.common.support.util;

import com.acunnoconnect.common.support.vo.core.ParameterVO;
import com.acunnoconnect.web.utils.ApplicationConstants;

public class ApplicationDBQueryUtil {

	public static void getAddUserToDBQuery(ParameterVO paramVO) {

	}

	/**
	 * 
	 * @param paramVO
	 * @return
	 */
	public static String addNewGroupToDB(ParameterVO paramVO) {
		StringBuilder createGroupQuery = new StringBuilder();
		createGroupQuery = createGroupQuery
				.append("insert into intutics_registeredGroup(GroupName, AdminEmail,LinkedInUrl,Status,VerificationCode,CreateDate) values (")
				.append("\'").append(ApplicationConstants.BLANK).append("\','")
				.append(paramVO.getGroupVO().getSuperAdminEmailId()).append("',\'")
				.append(ApplicationConstants.BLANK).append("\',\'")
				.append(ApplicationConstants.STATUS_INACTIVE).append("\',\'")
				.append(paramVO.getGroupVO().getValidationCode())
				.append("\',\'")
				.append(paramVO.getTodaysDateString()).append("\');");

		System.out.println("sql_UserEntryTable : "
				+ createGroupQuery.toString());
		return createGroupQuery.toString();
	}

	/**
	 * 
	 * @param paramVO
	 * @return
	 */
	public static String activateGroupUpdateGroupTable(ParameterVO paramVO) {
		StringBuilder updateGroupQuery = new StringBuilder();
		updateGroupQuery = updateGroupQuery
				.append("update intutics_registeredGroup set Status=\'")
				.append(ApplicationConstants.STATUS_ACTIVE)
				.append("\',VerificationCode=\'")
				.append(ApplicationConstants.BLANK)
				.append("\',ValidationDate=\'")
				.append(paramVO.getTodaysDateString()).append("\';");
		System.out.println("Update Group table : "
				+ updateGroupQuery.toString());
		return updateGroupQuery.toString();
	}

	/**
	 * 
	 * @param paramVO
	 * @return
	 */
	public static String activateGroupSelectGroupId(ParameterVO paramVO) {
		StringBuilder selectGroupID = new StringBuilder();
		selectGroupID = selectGroupID
				.append("select VerificationCode from intutics_registeredGroup where AdminEmail='")
				.append(paramVO.getGroupVO().getSuperAdminEmailId())
				.append("' and VerificationCode=\'")
				.append(paramVO.getGroupVO().getValidationCode()).append("\';");
		System.out.println("Update Group table : " + selectGroupID.toString());
		return selectGroupID.toString();

	}

	/**
	 * 
	 * @param paramVO
	 * @return
	 */
	public static String createAdminUser(ParameterVO paramVO) {
		StringBuffer createAdminUser = new StringBuffer();
		createAdminUser = createAdminUser
				.append("insert into ")
				.append(paramVO.getGroupId())
				.append("_UserTable(EmailId, FirstName,LastName,Password,Status,Role,Verificationcode,CreateDate,ValidationDate) ")
				.append("values (").append("\'")
				.append(paramVO.getGroupVO().getSuperAdminEmailId()).append("\','")
				.append(ApplicationConstants.BLANK).append("',\'")
				.append(ApplicationConstants.BLANK).append("\',\'")
				.append(ApplicationConstants.PASSWORD_DEFAULT).append("\',\'")
				.append(ApplicationConstants.STATUS_ACTIVE).append("\',\'")
				.append(ApplicationConstants.GROUP_ADMIN).append("\',\'")
				.append(ApplicationConstants.BLANK).append("',\'")
				.append(paramVO.getTodaysDateString())
				.append("\',\'")
				.append(paramVO.getTodaysDateString()).append("\');");
		System.out.println(createAdminUser.toString());
		return createAdminUser.toString();
	}

	public static String userLoginActionGetUserInfo(ParameterVO paramVO) {
		StringBuilder validateUserQuery = new StringBuilder();
		validateUserQuery = validateUserQuery
				.append("select Password, Role, Status from ")
				.append(paramVO.getUserEntitlementsVO().getGroupIdList().get(0))
				.append("_UserTable").append(" where EmailId='")
				.append(paramVO.getUserEntitlementsVO().getEmailId())
				.append("\';");

		System.out
				.println("validateUserQuery: " + validateUserQuery.toString());

		return validateUserQuery.toString();
	}

	/**
	 * 
	 * @param paramVO
	 * @return
	 */
	public static String userLoginActionGetUserId(ParameterVO paramVO) {
		StringBuffer updateUserGroupTable = new StringBuffer();
		updateUserGroupTable = updateUserGroupTable
				.append("select GroupId from intutics_usergrouptable where EmailId=\'")
				.append(paramVO.getUserEntitlementsVO().getEmailId())
				.append("\');");
		System.out.println("updateUserGroupTable : " + updateUserGroupTable);
		return updateUserGroupTable.toString();
	}
}
