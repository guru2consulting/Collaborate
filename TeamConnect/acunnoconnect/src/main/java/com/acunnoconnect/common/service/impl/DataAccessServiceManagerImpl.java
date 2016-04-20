package com.acunnoconnect.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.acunnoconnect.common.exceptions.AcunnoServiceException;
import com.acunnoconnect.common.service.DataAccessServiceManager;
import com.acunnoconnect.common.service.MailServiceManager;
import com.acunnoconnect.common.support.util.ApplicationMessages;
import com.acunnoconnect.common.support.vo.core.ParameterVO;
import com.acunnoconnect.dataaccess.dao.DataAccessDAO;
import com.acunnoconnect.dataaccess.dao.DataAccessMongoDAO;
import com.acunnoconnect.web.utils.ApplicationConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class DataAccessServiceManagerImpl.
 */
@Service
@Configurable
public class DataAccessServiceManagerImpl implements DataAccessServiceManager {
	
	/** The data access dao. */
	@Autowired
	public DataAccessDAO dataAccessDao;
	
	/** The data access mongo dao. */
	@Autowired
	public DataAccessMongoDAO dataAccessMongoDao;
	
	/** The mail service manager. */
	@Autowired
	public MailServiceManager mailServiceManager;
	
	
	
	/**
	 * Gets the data access dao.
	 *
	 * @return the data access dao
	 */
	public DataAccessDAO getDataAccessDao() {
		return dataAccessDao;
	}

	/**
	 * Sets the data access dao.
	 *
	 * @param dataAccessDao the new data access dao
	 */
	public void setDataAccessDao(DataAccessDAO dataAccessDao) {
		this.dataAccessDao = dataAccessDao;
	}

	/**
	 * Gets the data access mongo dao.
	 *
	 * @return the data access mongo dao
	 */
	public DataAccessMongoDAO getDataAccessMongoDao() {
		return dataAccessMongoDao;
	}

	/**
	 * Sets the data access mongo dao.
	 *
	 * @param dataAccessMongoDao the new data access mongo dao
	 */
	public void setDataAccessMongoDao(DataAccessMongoDAO dataAccessMongoDao) {
		this.dataAccessMongoDao = dataAccessMongoDao;
	}
	
	/**
	 * Gets the mail service manager.
	 *
	 * @return the mail service manager
	 */
	public MailServiceManager getMailServiceManager() {
		return mailServiceManager;
	}

	/**
	 * Sets the mail service manager.
	 *
	 * @param mailServiceManager the new mail service manager
	 */
	public void setMailServiceManager(MailServiceManager mailServiceManager) {
		this.mailServiceManager = mailServiceManager;
	}



	/* (non-Javadoc)
	 * @see com.acunnoconnect.dataaccess.service.DataAccessServiceManager#validateUserLogin(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public boolean validateUserLogin(ParameterVO parameterVO) throws AcunnoServiceException{
		return dataAccessMongoDao.validateUser(parameterVO);
	}
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.dataaccess.service.DataAccessServiceManager#getUserGroupMessages(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void getUserGroupMessages(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.getUserGroupMessages(parameterVO);
		 //dataAccessDao.getUserGroupMessages(parameterVO);
	}
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.dataaccess.service.DataAccessServiceManager#getQuestionDetails(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void getQuestionDetails(ParameterVO parameterVO) throws AcunnoServiceException{
		 //dataAccessDao.getQuestionDetails(parameterVO);
		dataAccessMongoDao.getQuestionDetails(parameterVO);
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.dataaccess.service.DataAccessServiceManager#postResponse(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void postResponse(ParameterVO parameterVO) throws AcunnoServiceException{
		//dataAccessDao.postResponse(parameterVO);
		dataAccessMongoDao.postResponse(parameterVO);
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#postMessage(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void postMessage(ParameterVO parameterVO) throws AcunnoServiceException{
	//	dataAccessDao.postMessage(parameterVO);
		dataAccessMongoDao.postMessage(parameterVO);
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#registerNewUser(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void registerNewUser(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.registerNewUser(parameterVO);
		if(parameterVO.isReponseStatus() && 
				parameterVO.getUserEntitlementsVO().getStatus().equalsIgnoreCase("inactive")){
			
				mailServiceManager.sendUserRegistrationLink(parameterVO);
				
				parameterVO.setResponseMessage(ApplicationMessages.REGISTER_USER_CHECKMAIL);
			
		}else if(parameterVO.isReponseStatus() && 
				parameterVO.getUserEntitlementsVO().getStatus().equalsIgnoreCase("active")){
			parameterVO.setResponseMessage(ApplicationMessages.REGISTER_USER_ALREADYPRESENT);
		}
		else if(parameterVO.isReponseStatus() && 
				parameterVO.getUserEntitlementsVO().getStatus().equalsIgnoreCase("deleted")){
				parameterVO.setResponseMessage(ApplicationMessages.REGISTER_USER_ALREADYPRESENT);
		}
		else{
			parameterVO.setResponseMessage(ApplicationMessages.REGISTER_DB_FAILURE);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#activateNewUser(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void activateNewUser(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.activateNewUser(parameterVO);
		if(parameterVO.getUserEntitlementsVO().getStatus().equalsIgnoreCase(ApplicationConstants.USER_ACTIVATED)
				){
				mailServiceManager.sendUserConfirmationMail(parameterVO);
				parameterVO.setResponseMessage(ApplicationMessages.USER_ACTIVATION_SUCCESSFUL);
			if(!parameterVO.getMailingVO().responseStatus){
				parameterVO.setResponseMessage(ApplicationMessages.REGISTER_MAILING_FAILURE);
			}
		}else if(parameterVO.getUserEntitlementsVO().getStatus().equalsIgnoreCase(ApplicationConstants.USER_DELETED)
				){
				mailServiceManager.sendUserConfirmationMail(parameterVO);
				parameterVO.setResponseMessage(ApplicationMessages.USER_ACTIVATION_DELETED);
			if(!parameterVO.getMailingVO().responseStatus){
				parameterVO.setResponseMessage(ApplicationMessages.REGISTER_MAILING_FAILURE);
			}
		}else if(parameterVO.getUserEntitlementsVO().getStatus().equalsIgnoreCase(ApplicationConstants.USER_ALREADYACTIVE)
				){
				mailServiceManager.sendUserConfirmationMail(parameterVO);
				parameterVO.setResponseMessage(ApplicationMessages.REGISTER_USER_ALREADYPRESENT);
			if(!parameterVO.getMailingVO().responseStatus){
				parameterVO.setResponseMessage(ApplicationMessages.REGISTER_MAILING_FAILURE);
			}
		}
		else{
			parameterVO.setResponseMessage(ApplicationMessages.REGISTER_USER_INVALID);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#getAllResponses(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void getAllResponses(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.getAllResponses(parameterVO);		
	}
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#addNewUserGroup(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void addNewUserGroup(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.addNewUserGroup(parameterVO);
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#fetchMyUserGroups(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void fetchMyUserGroups(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.fetchMyUserGroups(parameterVO);
	}
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#fetchAllUserGroups(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void fetchAllUserGroups(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.fetchAllUserGroups(parameterVO);
	}
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#searchActiveUsers(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void searchActiveUsers(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.searchActiveUsers(parameterVO);
	}
	
	
	/* (non-Javadoc)
	 * @see com.acunnoconnect.common.service.DataAccessServiceManager#addUserstoGroup(com.acunnoconnect.common.support.vo.core.ParameterVO)
	 */
	public void addUserstoGroup(ParameterVO parameterVO) throws AcunnoServiceException{
		dataAccessMongoDao.addUserstoGroup(parameterVO);
	}
}
