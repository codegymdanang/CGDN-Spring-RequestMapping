package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(value = "/method0", method = RequestMethod.GET)
    public String method0() {
        return "method0";
    }

    //nhiều URI cho 1 phương thức
    @RequestMapping(value = {"/method1", "/method1/second"})
    public String method1() {
        return "method1";
    }

    @RequestMapping(value = "/method2", method = RequestMethod.POST)

    public String method2() {
        return "method2";
    }

    @RequestMapping(value = "/method3", method = {RequestMethod.POST, RequestMethod.GET})
    public String method3() {
        return "method3";
    }

    @RequestMapping(value = "/method4", headers = "name=CodeGymDaNang", method = RequestMethod.POST)
    public String method4() {
        return "method4";
    }

    @RequestMapping(value = "/method5", headers = {"name=CodeGymDaNang", "id=100"}, method = RequestMethod.POST)
    public String method5() {
        return "method5";
    }

    @RequestMapping(value = "/method6", consumes = {"application/json"}, method = RequestMethod.POST)
    public String method6() {
        return "method6";
    }

    @RequestMapping(value = "/method7/{id}")
    public ModelAndView method7(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("method7","id",id);
        return modelAndView;
    }

    @RequestMapping(value = "/method8/{id}/{name}")
    @ResponseBody
    public ModelAndView method8(@PathVariable("id") int id, @PathVariable("name") String name) {
        Object[] a = new Object[2];
        a[0] = id;
        a[1] = name;
        ModelAndView modelAndView = new ModelAndView("method8","model",a);
        return modelAndView;
    }


}
