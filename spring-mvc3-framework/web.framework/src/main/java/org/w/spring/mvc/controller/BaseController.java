package org.w.spring.mvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.w.spring.mvc.beans.MvcConstants;
import org.w.spring.mvc.utils.AjaxUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基础控制器
 *
 * @version 1.0
 * Created by wenzhouyang on 8/7/2014.
 */
public class BaseController {

    /**
     * request
     */
    private HttpServletRequest request;

    /**
     * response
     */
    private HttpServletResponse response;

    /**
     * 通过注解在每一个请求方法执行前获取到httpServletRequest和httpServletResponse对象
     *
     * @param request  HttpServletRequest
     *                 @see javax.servlet.http.HttpServletRequest
     * @param response HttpServletResponse
     *                 @see javax.servlet.http.HttpServletResponse
     */
    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 获取 httpServletRequest对象
     *
     * @return httpServletRequest
     * @see javax.servlet.http.HttpServletRequest
     * @exception java.lang.NullPointerException if request is null throw NullPointerException
     */
    public HttpServletRequest getRequest() {
        if (request == null)
            throw new NullPointerException("request is null");
        return request;
    }

    /**
     * 获取httpServletResponse对象
     * @return httpServletResponse
     * @see javax.servlet.http.HttpServletResponse
     * @exception java.lang.NullPointerException if response is null throw NullPointerException
     */
    public HttpServletResponse getResponse() {
        if (response == null)
            throw new NullPointerException("response is null");
        return response;
    }

    /**
     * 获取session对象
     *
     * @return httpSession
     * @see javax.servlet.http.HttpSession
     * @exception java.lang.NullPointerException if request is null throw NullPointerException
     */
    public HttpSession getSession() {
        if (request != null)
            return request.getSession();
        throw new NullPointerException("request is null");
    }

    /**
     * 获取httpSession对象
     *
     * @param create 是否创建session true：如果session不存在则进行创建，存在直接返回；false:如果不存在，返回NULL
     * @return httpSession
     * @see javax.servlet.http.HttpSession
     * @exception java.lang.NullPointerException if request is null throw NullPointerException
     */
    public HttpSession getSession(boolean create) {
        if (request != null)
            return request.getSession(create);
        throw new NullPointerException("request is null");
    }

    /**
     * 是否是ajax请求
     *
     * @return boolean
     */
    public boolean isAjaxRequest() {
        return AjaxUtils.isAjaxRequest(getRequest());
    }

    public Object getUserInfo() {
        HttpSession session = getSession(false);
        if (session == null) {
            throw new NullPointerException("session为空");
        }

        return session.getAttribute(MvcConstants.SESSION_USER_FLAG);
    }
}
