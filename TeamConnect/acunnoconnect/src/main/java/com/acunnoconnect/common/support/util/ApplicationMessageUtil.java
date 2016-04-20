package com.acunnoconnect.common.support.util;

import com.acunnoconnect.common.support.vo.core.ParameterVO;

public class ApplicationMessageUtil {

	public static void setAddGroupSuccessMesssage(ParameterVO paramVO) {
		paramVO.setResponseMessage("New group created successFully, please check your email : "
				+ paramVO.getGroupVO().getSuperAdminEmailId());

	}

	public static void setAddGroupFailureMesssage(ParameterVO paramVO) {
		paramVO.setResponseMessage("New group could not be created now, please try after some time");

	}

}
