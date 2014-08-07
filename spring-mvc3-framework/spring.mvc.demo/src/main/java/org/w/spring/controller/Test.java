package org.w.spring.controller;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.5
 *          Created by wenzhouyang on 8/7/2014.
 */
public class Test {

    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = ((ServletWebRequest) ra).getResponse();

        return ((ServletRequestAttributes)ra).getRequest();
    }
}
