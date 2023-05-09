package sky.pro.junittests.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.junittests.utilities.CalculatorUtility;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorUtility calculatorUtility;

    public CalculatorController(CalculatorUtility calculatorUtility) {
        this.calculatorUtility = calculatorUtility;
    }

    @GetMapping("/")
    public String welcome(){
        return calculatorUtility.welcome();
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        return calculatorUtility.solve("plus",num1,num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        return calculatorUtility.solve("minus",num1,num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        return calculatorUtility.solve("multiply",num1,num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        return calculatorUtility.solve("divide",num1,num2);
    }
}
