package com.acunnoconnect.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.acunnoconnect.common.service.DataAccessServiceManager;
import com.acunnoconnect.common.support.vo.core.ParameterVO;
import com.acunnoconnect.common.support.vo.web.DiscussionQuestionVO;
import com.acunnoconnect.common.support.vo.web.QuestionResponseVO;
import com.acunnoconnect.common.support.vo.web.UserEntitlementsVO;
import com.acunnoconnect.web.utils.ApplicationConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class AccunoConnectHomeController.
 */

@Controller
public class AccunoConnectHomeController extends AbstractBaseController {

	/** The message. */
	String message = "Welcome to Spring MVC!";

	/** The data access service manager. */
	@Autowired
	DataAccessServiceManager dataAccessServiceManager;

	
	/**
	 * Gets the user group messages.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param userEntitlementsVO
	 *            the user entitlements vo
	 * @param model
	 *            the model
	 * @return the user group messages
	 */
	@RequestMapping(value = "/getUserGroupMessages", method = RequestMethod.POST)
	public void getUserGroupMessages(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute ParameterVO parameterVO, Model model) {
		List<DiscussionQuestionVO> updatedQuestionList = null;
		try {
			// complete fetch basic objects from session
			dataAccessServiceManager.getUserGroupMessages(parameterVO);
			//updatedQuestionList = parameterVO.getQuestionsList();
			//JSONArray responseArray = new JSONArray(Arrays.asList(updatedQuestionList));
			JSONArray questionArray  = parameterVO.getQuestionsArray();
			JSONObject responseObject = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			if(questionArray!=null){
				responseObject.put("questions", questionArray);
				responseObject.put("questionscount",questionArray.length());
			}else{
				responseObject.put("questionscount","0");
			}
			System.out.println(responseObject.toString());
			response.getWriter().write(responseObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getQuestionDetails", method = RequestMethod.POST)
	public void getQuestionDetails(@ModelAttribute ParameterVO parameterVO,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		// complete fetch basic objects from session
		try {
		dataAccessServiceManager.getQuestionDetails(parameterVO);
		dataAccessServiceManager.getAllResponses(parameterVO);
		//JSONArray responseObject = createQuestionDetailResponseData(parameterVO);
		JSONObject responseObject = new JSONObject();
		responseObject.put("questiondetail", parameterVO.getQuestionObject());
		responseObject.put("responsecount", parameterVO.getResponseArray().length());
		responseObject.put("responses", parameterVO.getResponseArray());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().write(responseObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param updatedQuestionList
	 * @return
	 */
	private JSONArray createQuestionDetailResponseData(ParameterVO paramVO) {
		JSONArray responseObject = new JSONArray();
		JSONArray allResponsesArray = new JSONArray();
		JSONObject jsonObjResponse = new JSONObject();
		DiscussionQuestionVO discussionQuestionVO = paramVO.getQuestionVO();
		if (discussionQuestionVO != null) {
			responseObject.put(discussionQuestionVO.getJSONObject());
		}
		List<QuestionResponseVO> responseList = paramVO.getResponseList();
		if (responseList != null && !responseList.isEmpty()) {
			for (QuestionResponseVO responseVO : responseList) {
				allResponsesArray.put(responseVO.getJSONObject());
			}
			responseObject.put(allResponsesArray);
		}

		System.out.println(responseObject.toString());
		return responseObject;
	}
	
	
	@RequestMapping(value = "/postResponse", method = RequestMethod.POST)
	public void postResponseToGroup(
			@ModelAttribute ParameterVO parameterVO,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String responseStatus = ApplicationConstants.GROUP_MESSAGE_POST_FAILURE;
		String responseMessage = ApplicationConstants.RESPONSE_FAILURE;
		JSONArray responseArray = new JSONArray();
		JSONObject responseJson = new JSONObject();
		
		try {
		// complete fetch basic objects from session
		dataAccessServiceManager.postResponse(parameterVO);

		if (parameterVO.isReponseStatus()) {
			responseMessage = ApplicationConstants.RESPONSE_SUCCESS;
		}

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			responseJson.put("message", responseMessage);
			responseArray.put(responseJson);
			response.getWriter().write(responseArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param questionsVO
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "/postQuestionToGroup", method = RequestMethod.POST)
	public 
	void postQuestionToGroup(@ModelAttribute DiscussionQuestionVO questionsVO,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String responseStatus = ApplicationConstants.GROUP_MESSAGE_POST_FAILURE;
		ParameterVO parameterVO = new ParameterVO();
		
		try{
		boolean uploadFileFlag = false;
		parameterVO.setQuestionVO(questionsVO);

		//upload file code //
		/*
		MultipartHttpServletRequest requestUpdated = (MultipartHttpServletRequest) request;
        Iterator<String> itr = requestUpdated.getFileNames();
       	while (itr.hasNext()) {
				MultipartFile f = requestUpdated.getFile(itr.next());
				if (f != null) {
					InputStream filecontent = f.getInputStream();
					System.out.println(f.getName());
					String filename = f.getName();
					parameterVO.setEmailId(emailId);
					parameterVO.setListingType("question");
					parameterVO.setFileName(filename);
					updateFileUploadDetails(parameterVO);
					int read = 0;
					File uploadFile = new File(
							parameterVO.getGeneratedFileName());
					FileOutputStream fos = new FileOutputStream(uploadFile);
					System.out.println("parameterVO.getGeneratedFileName()::"
							+ parameterVO.getGeneratedFileName());
					 final byte[] bytes = new byte[1024];
					
					 while ((read = filecontent.read(bytes)) != -1) {
						 fos.write(bytes, 0, read);
				        }
					
					//f.transferTo(uploadFile);
					parameterVO.setUploadedFile(uploadFile);
					uploadFileFlag = true;
				}
			}
			*/
        
		   // complete fetch basic objects from session
	     dataAccessServiceManager.postMessage(parameterVO);
        }catch(Exception e){
        	parameterVO.setReponseStatus(false);
        	e.printStackTrace();
        }
       
		JSONObject responseObject = new JSONObject();
		responseObject.put("status",parameterVO.isReponseStatus());
		//responseObject = createQuestionDetailResponseData(parameterVO);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().write(responseObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
