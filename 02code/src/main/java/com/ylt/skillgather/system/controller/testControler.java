package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testControler {

    @RequestMapping("/aa")
    public String testfun()
    {
        return "test";
    }

}
