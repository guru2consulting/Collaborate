package com.acunnoconnect.web.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.acunnoconnect.common.service.DataAccessServiceManager;
import com.acunnoconnect.common.support.vo.core.ParameterVO;

public abstract class AbstractBaseController{
	

	protected DataAccessServiceManager dataAccessServiceManager;
	
	
	/**
	 * 
	 * @param paramVO
	 */
	protected void updateFileUploadDetails(ParameterVO paramVO){
		StringBuffer fileNameUpdated = new StringBuffer();
		Calendar cal = GregorianCalendar.getInstance();
		fileNameUpdated.append(paramVO.getEmailId()).append("_").append(cal.get(GregorianCalendar.YEAR)).append(cal.get(GregorianCalendar.MONTH)).append(cal.get(GregorianCalendar.DAY_OF_MONTH))
								.append(cal.get(GregorianCalendar.HOUR_OF_DAY)).append(cal.get(GregorianCalendar.MINUTE)).append(cal.get(GregorianCalendar.SECOND));
		paramVO.setGeneratedFileName(fileNameUpdated.toString());
		String fileName = paramVO.getFileName();
		int dotindex = fileName.lastIndexOf(".");
		String extn = fileName.substring(dotindex+1,fileName.length());
		System.out.println("File extension ::"+extn);
		paramVO.setFileExtn(extn);
	}
	

}
