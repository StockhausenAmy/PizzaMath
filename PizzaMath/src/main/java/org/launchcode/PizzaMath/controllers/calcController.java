package org.launchcode.PizzaMath.controllers;

import org.launchcode.PizzaMath.models.CustomCalulation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class calcController {

    @GetMapping("/customCalc")
    public String displayCustomCalc() {
        return "customCalc";
    }

    @PostMapping("/customCalc")
    public String processCustomCalcForm(@ModelAttribute CustomCalulation customCalculation, Errors errors, Model model) {
        double smallArea = Math.pow(customCalculation.getSmallSize()/2, 2) * 3.14;
        double mediumArea = Math.pow(customCalculation.getMediumSize()/2, 2) * 3.14;
        double largeArea = Math.pow(customCalculation.getLargeSize()/2, 2) * 3.14;
        double xLargeArea = Math.pow(customCalculation.getxLargeSize()/2, 2) * 3.14;

        double totalPizzaArea = (customCalculation.getSmallCount() * 4.5) +
                (customCalculation.getMediumCount() * 9) +
                (customCalculation.getTeenCount() * 18) +
                (customCalculation.getAdultCount() * 13.5);

        double minSliceCount = customCalculation.getSmallCount() + customCalculation.getMediumCount() + customCalculation.getTeenCount() * 2 + customCalculation.getAdultCount() * 2;

        return "result";
    }

    private double minNumberPizzas (double minSliceCount) {
        double numberPizzaRec = 0;
        for (int i = 1; i < 1000; i++) {
            if (minSliceCount - (i * 8) >= 4) {
                numberPizzaRec++;
            }
        }
        return numberPizzaRec;
    }
}
