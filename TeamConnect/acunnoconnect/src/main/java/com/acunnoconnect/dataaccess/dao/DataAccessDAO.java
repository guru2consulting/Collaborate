package com.acunnoconnect.dataaccess.dao;

import com.acunnoconnect.common.support.vo.core.ParameterVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataAccessDAO.
 */
public interface DataAccessDAO {
	
	/**
	 * Validate user login.
	 *
	 * @param parameterVO the parameter vo
	 * @return true, if successful
	 */
	public boolean validateUserLogin(ParameterVO parameterVO);
	
	/**
	 * Gets the user group messages.
	 *
	 * @param parameterVO the parameter vo
	 * @return the user group messages
	 */
	public void getUserGroupMessages(ParameterVO parameterVO);
	
	/**
	 * Gets the question details.
	 *
	 * @param parameterVO the parameter vo
	 * @return the question details
	 */
	public void getQuestionDetails(ParameterVO parameterVO);
	
	
	/**
	 * Post response.
	 *
	 * @param parameterVO the parameter vo
	 */
	public void postResponse(ParameterVO parameterVO);
	
	/**
	 * Post message.
	 *
	 * @param parameterVO the parameter vo
	 */
	public void postMessage(ParameterVO parameterVO);
	

}
