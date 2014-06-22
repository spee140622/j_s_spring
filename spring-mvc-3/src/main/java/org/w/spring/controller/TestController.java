package org.w.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenzhouyang on 2014/8/3.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/sayHello")
    public @ResponseBody String helloWorld() {
        return "helloWorld";
    }
}
