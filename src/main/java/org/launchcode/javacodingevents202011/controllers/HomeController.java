package org.launchcode.javacodingevents202011.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //handles GET requests to /
    @GetMapping()
    public String index(){
        return "index";
    }
}
