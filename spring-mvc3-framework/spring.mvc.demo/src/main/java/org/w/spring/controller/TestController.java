package org.w.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.w.spring.mvc.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wenzhouyang on 2014/8/3.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {

    @RequestMapping(value = "/sayHello")
    public @ResponseBody String helloWorld(HttpServletRequest request, HttpServletResponse response) {
        getRequest();
        getResponse();
        return "helloWorld" + request.getContextPath();
    }

    @RequestMapping(value = "/sayTest")
    @ResponseBody
    public String test1(WebRequest request) {
        return "test";
    }
}
