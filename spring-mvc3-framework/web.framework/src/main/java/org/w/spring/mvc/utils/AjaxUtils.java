package org.w.spring.mvc.utils;

import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 *ajax 工具类
 *
 * @version 1.0
 * Created by wenzhouyang on 8/7/2014.
 */
public class AjaxUtils {

    /**
     * 判断是否是ajax请求
     *
     * @param request httpServletRequest
     *                @see javax.servlet.http.HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }

    /**
     * 是否是ajax文件上传
     *
     * 要求ajax文件上传时，必须传参数ajaxUpload
     *
     * @param request httpServletRequest
     *                @see javax.servlet.http.HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxUploadRequest(HttpServletRequest request) {
        return request.getParameter("ajaxUpload") != null;
    }
}
