package org.launchcode.PizzaMath.controllers;

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
        double smallArea = Math.pow(customCalculation.getSmallSize()/2, 2) * 3.14;
        double mediumArea = Math.pow(customCalculation.getMediumSize()/2, 2) * 3.14;
        double largeArea = Math.pow(customCalculation.getLargeSize()/2, 2) * 3.14;
        double xLargeArea = Math.pow(customCalculation.getxLargeSize()/2, 2) * 3.14;
        double[] pizzaSizeArr = {smallArea, mediumArea, largeArea, xLargeArea};
        double[] pizzaCountArr = {0, 0, 0, 0};

        System.out.println(1);

        double totalPizzaArea = (customCalculation.getSmallCount() * 14.13) +
                (customCalculation.getMediumCount() * 28.26) +
                (customCalculation.getTeenCount() * 56.52) +
                (customCalculation.getAdultCount() * 42.39);

        double minSliceCount = customCalculation.getSmallCount() + customCalculation.getMediumCount() + customCalculation.getTeenCount() * 2 + customCalculation.getAdultCount() * 2;
        double minNumberPizzas = minNumberPizzas(minSliceCount);

        System.out.println(2);

        while (totalPizzaArea > 0) {
            for (int i = 0; i < 3; i++) {
                System.out.println(minNumberPizzas + " min number of pizzas");
                while ((totalPizzaArea / minNumberPizzas) + 10 >= pizzaSizeArr[i] && (totalPizzaArea / minNumberPizzas) < pizzaSizeArr[i + 1]) {
                    if (totalPizzaArea - pizzaSizeArr[i] < pizzaSizeArr[i]/2) {
                        pizzaCountArr[i+1]++;
                        totalPizzaArea = totalPizzaArea - pizzaSizeArr[i+1];
                        System.out.println(totalPizzaArea + " next size up added");
                    } else {
                        pizzaCountArr[i]++;
                        totalPizzaArea = totalPizzaArea - pizzaSizeArr[i];
                        System.out.println(totalPizzaArea + " this size added");
                    }
                    minNumberPizzas--;
                }
                System.out.println(totalPizzaArea + " area left.");
            }
            System.out.println(3.2);

            if (minSliceCount - (minNumberPizzas * 8) > 0) {
                for (int k = 0; k < 3; k++) {
                    if (totalPizzaArea <= pizzaSizeArr[k]) {
                        pizzaCountArr[k]++;
                        totalPizzaArea = totalPizzaArea - pizzaSizeArr[k];
                    }
                }
            }
        }

        System.out.println(4);

        model.addAttribute("smallPizzas", pizzaCountArr[0]);
        model.addAttribute("mediumPizzas", pizzaCountArr[1]);
        model.addAttribute("largePizzas", pizzaCountArr[2]);
        model.addAttribute("xLargePizzas", pizzaCountArr[3]);
        System.out.println("Calculator ran.");
        System.out.println(pizzaCountArr[0] + " small pizzas, " + pizzaCountArr[1] + " medium pizzas, " + pizzaCountArr[2] + " large pizzas, and " + pizzaCountArr[3] + " x-large pizzas.");
        return "customCalcResult";
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
