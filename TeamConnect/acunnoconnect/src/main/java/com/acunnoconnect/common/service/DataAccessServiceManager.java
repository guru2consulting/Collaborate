package com.acunnoconnect.common.service;

import com.acunnoconnect.common.exceptions.AcunnoServiceException;
import com.acunnoconnect.common.support.vo.core.ParameterVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataAccessServiceManager.
 */
public interface DataAccessServiceManager {
	
	/**
	 * Validate user login.
	 *
	 * @param parameterVO the parameter vo
	 * @return true, if successful
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public boolean validateUserLogin(ParameterVO parameterVO) throws AcunnoServiceException;
	
	/**
	 * Gets the user group messages.
	 *
	 * @param parameterVO the parameter vo
	 * @return the user group messages
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void getUserGroupMessages(ParameterVO parameterVO) throws AcunnoServiceException; 
	
	
	/**
	 * Gets the question details.
	 *
	 * @param parameterVO the parameter vo
	 * @return the question details
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void getQuestionDetails(ParameterVO parameterVO) throws AcunnoServiceException;
	
	
	/**
	 * Post response.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void postResponse(ParameterVO parameterVO) throws AcunnoServiceException;
	
	
	/**
	 * Post message.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void postMessage(ParameterVO parameterVO) throws AcunnoServiceException;
	
	
	
	/**
	 * Register new user.
	 *
	 * @param parameteVO the paramete vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void registerNewUser(ParameterVO parameteVO) throws AcunnoServiceException;
	
	
	/**
	 * Activate new user.
	 *
	 * @param parameteVO the paramete vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void activateNewUser(ParameterVO parameteVO) throws AcunnoServiceException;
	
	
	/**
	 * Gets the all responses.
	 *
	 * @param parameterVO the parameter vo
	 * @return the all responses
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void getAllResponses(ParameterVO parameterVO) throws AcunnoServiceException;
	
	/**
	 * Adds the new user group.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void addNewUserGroup(ParameterVO parameterVO) throws AcunnoServiceException;
	
	/**
	 * Fetch my user groups.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void fetchMyUserGroups(ParameterVO parameterVO) throws AcunnoServiceException;
	
	
	
	/**
	 * Fetch all user groups.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void fetchAllUserGroups(ParameterVO parameterVO) throws AcunnoServiceException;
	
	/**
	 * Search active users.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void searchActiveUsers(ParameterVO parameterVO) throws AcunnoServiceException;
	
	/**
	 * Adds the usersto group.
	 *
	 * @param parameterVO the parameter vo
	 * @throws AcunnoServiceException the acunno service exception
	 */
	public void addUserstoGroup(ParameterVO parameterVO) throws AcunnoServiceException;
	
	
	

}
