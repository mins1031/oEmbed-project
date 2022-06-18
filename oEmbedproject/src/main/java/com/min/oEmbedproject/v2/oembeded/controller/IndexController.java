package com.min.oEmbedproject.v2.oembeded.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @GetMapping("/v2/")
    public String index(){

        log.info("visit index");

        return "index.html";
    }


}
