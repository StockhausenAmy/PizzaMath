package org.launchcode.PizzaMath.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CalcPageController {

    @GetMapping("/customCalc/")
    public String displayCustomCalc() {
        return "customCalc";
    }

    @GetMapping("/chainMath/")
    public String displayChainMath() { return "chainMath"; }

}
