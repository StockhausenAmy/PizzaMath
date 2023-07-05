package org.launchcode.PizzaMath.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CalcPageController {

    @GetMapping("/customCalc/")
    public String displayCustomCalc() {
        System.out.println("Getting custom calc form");
        return "customCalc.html";
    }

    @GetMapping("/chainMath/")
    public String displayChainMath() { return "chainMath.html"; }

    @GetMapping("/customCalcResult/")
    public String displayCustomCalcResult() { System.out.println("Getting custom calc results");
    return "customCalcResult.html"; }

}
