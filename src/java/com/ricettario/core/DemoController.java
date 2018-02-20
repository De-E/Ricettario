/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricettario.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Controller
public class DemoController
{
    @RequestMapping(value = "/demo")
    public String getIndex()
    {
        return "index";
    }
    
    @RequestMapping(value = "/demo/home")
    public ModelAndView getHome()
    { 
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Learning Spring");
        return modelAndView;
    }
}
