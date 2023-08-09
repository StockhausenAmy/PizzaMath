package org.launchcode.PizzaMath.controllers;

import org.launchcode.PizzaMath.models.ChainCalculation;
import org.launchcode.PizzaMath.models.CustomCalulation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {

    @PostMapping("/customCalc")
    public String processCustomCalcForm(@ModelAttribute CustomCalulation customCalculation, Errors errors, Model model) {
        System.out.println("Starting custom Calc");
        double smallArea = Math.pow(customCalculation.getSmallSize() / 2, 2) * 3.14;
        double mediumArea = Math.pow(customCalculation.getMediumSize() / 2, 2) * 3.14;
        double largeArea = Math.pow(customCalculation.getLargeSize() / 2, 2) * 3.14;
        double xLargeArea = Math.pow(customCalculation.getxLargeSize() / 2, 2) * 3.14;

        double[] pizzaSizeArr = {smallArea, mediumArea, largeArea, xLargeArea};
        double[] pizzaPeopleCountArr = {customCalculation.getSmallCount(), customCalculation.getMediumCount(), customCalculation.getTeenCount(), customCalculation.getAdultCount()};

        int[] customPizzaCountArr = calculator(pizzaSizeArr, pizzaPeopleCountArr);

        model.addAttribute("smallPizzas", customPizzaCountArr[0]);
        model.addAttribute("mediumPizzas", customPizzaCountArr[1]);
        model.addAttribute("largePizzas", customPizzaCountArr[2]);
        model.addAttribute("xLargePizzas", customPizzaCountArr[3]);

        return "customCalcResult";
    }

    @PostMapping("/chainMath")
    public String processChainMathForm(@ModelAttribute ChainCalculation chainCalculation, Errors errors, Model model) {
        System.out.println("Starting chain calc");
        double smallArea = Math.pow(chainCalculation.getSmallSize() / 2, 2) * 3.14;
        double mediumArea = Math.pow(chainCalculation.getMediumSize() / 2, 2) * 3.14;
        double largeArea = Math.pow(chainCalculation.getLargeSize() / 2, 2) * 3.14;
        double xLargeArea = Math.pow(chainCalculation.getxLargeSize() / 2, 2) * 3.14;

        double[] pizzaSizeArr = {smallArea, mediumArea, largeArea, xLargeArea};
        double[] pizzaPeopleCountArr = {chainCalculation.getSmallCount(), chainCalculation.getMediumCount(), chainCalculation.getTeenCount(), chainCalculation.getAdultCount()};

        System.out.println(pizzaSizeArr);
        System.out.println(pizzaPeopleCountArr);

        int[] chainPizzaCountArr = calculator(pizzaSizeArr, pizzaPeopleCountArr);

        model.addAttribute("smallPizzas", chainPizzaCountArr[0]);
        model.addAttribute("mediumPizzas", chainPizzaCountArr[1]);
        model.addAttribute("largePizzas", chainPizzaCountArr[2]);
        model.addAttribute("xLargePizzas", chainPizzaCountArr[3]);

        return "customCalcResult";
    }


    private int[] calculator(double[] pizzaSizeArr, double[] pizzaPeopleCountArr) {

        int[] pizzaCountArr = {0, 0, 0, 0};

        double totalPizzaArea = (pizzaPeopleCountArr[0] * 14.13) +
                (pizzaPeopleCountArr[1] * 28.26) +
                (pizzaPeopleCountArr[2] * 56.52) +
                (pizzaPeopleCountArr[3] * 42.39);

        double minSliceCount = pizzaPeopleCountArr[0] + pizzaPeopleCountArr[1] + pizzaPeopleCountArr[2] * 2 + pizzaPeopleCountArr[3] * 2;

        double minNumberPizzas = minNumberPizzas(minSliceCount);

        while (totalPizzaArea > 0) {
            for (int i = 0; i < 3; i++) {
                System.out.println(minNumberPizzas + " min number of pizzas");
                while ((i==2 && totalPizzaArea > 0) || ((totalPizzaArea / minNumberPizzas) + 10 >= pizzaSizeArr[i] && (totalPizzaArea / minNumberPizzas) < pizzaSizeArr[i + 1])) {
                    if (totalPizzaArea - pizzaSizeArr[i] < pizzaSizeArr[i]/2) {
                        pizzaCountArr[i+1]++;
                        totalPizzaArea = totalPizzaArea - pizzaSizeArr[i+1];
                        minNumberPizzas--;
                    } else {
                        pizzaCountArr[i]++;
                        totalPizzaArea = totalPizzaArea - pizzaSizeArr[i];
                        minNumberPizzas--;
                    }
                    minNumberPizzas--;
                }
            }

            if (minSliceCount - (minNumberPizzas * 8) > 0) {
                for (int k = 0; k < 3; k++) {
                    if (totalPizzaArea <= pizzaSizeArr[k]) {
                        pizzaCountArr[k]++;
                        totalPizzaArea = totalPizzaArea - pizzaSizeArr[k];
                    }
                }
            }
        }

        return pizzaCountArr;
    }

    private double minNumberPizzas (double minSliceCount) {
        double numberPizzaRec = 0;
        for (int i = 0; i < 1000; i++) {
            if (minSliceCount - (i * 8) >= 0) {
                numberPizzaRec++;
            }
        }
        return numberPizzaRec;
    }
}
