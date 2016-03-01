package com.acunnoconnect.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acunnoconnect.common.support.vo.core.ParameterVO;
import com.acunnoconnect.common.support.vo.web.UserEntitlementsVO;
import com.acunnoconnect.dataaccess.service.DataAccessServiceManager;
import com.acunnoconnect.web.utils.ApplicationConstants;

@Controller
public class AccunoConnectHomeController extends AbstractBaseController{
	

	String message = "Welcome to Spring MVC!";
	
	@Autowired
	DataAccessServiceManager dataAccessServiceManager;
	
	@RequestMapping("/")
	public ModelAndView loginHomePage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("session", message);
		mv.addObject("name", name);
		return mv;
	}
	
 
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute UserEntitlementsVO userEntitlementsVO, Model model) {
		String responsePage = ApplicationConstants.DISCUSSION_LISTING;
		String responseFailure = ApplicationConstants.RESPONSE_FAILURE;
		ModelAndView mv = null;
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String selectoption = request.getParameter("selectoption");
		String ipAddressCurrent = request.getRemoteAddr();
		if (!StringUtils.isEmpty(emailId) && !StringUtils.isEmpty(password)
				&& !StringUtils.isEmpty(password)) {
			userEntitlementsVO.setIpAddressCurrent(ipAddressCurrent);
			ParameterVO parameterVO = new ParameterVO();
			parameterVO.setUserEntitlementsVO(userEntitlementsVO);
			// Update DB with newly created group user mail
	
			if(dataAccessServiceManager.validateUserLogin(parameterVO)){
				System.out.println("valid");
				mv = new ModelAndView(responsePage);
			}else{
				mv = new ModelAndView(responseFailure);
				System.out.println("Invalid");
			}
		}
	
		return responsePage;
	}
	
	

}
