/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raffaelemancino.ricettario.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Raffaele Francesco Mancino
 */
@Controller
public class PageController
{
    @RequestMapping(value = "/")
    public String getIndex()
    {
        return "index";
    }
}
