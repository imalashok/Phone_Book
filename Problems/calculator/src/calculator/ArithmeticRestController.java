package calculator;

import org.springframework.web.bind.annotation.*;

@RestController
class ArithmeticRestController {
    public String calculate(String operation, int a, int b) {
        switch (operation) {
            case "+" :
                return "" + (a + b);
            case "-" :
                return "" + (a - b);
            case "*" :
                return "" + (a * b);
            default:
                return "Unknown operation";
        }
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return calculate("+", a, b);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam int a, @RequestParam int b) {
        return calculate("-", a, b);
    }

    @GetMapping("/mult")
    public String mult(@RequestParam int a, @RequestParam int b) {
        return calculate("*", a, b);
    }

    @GetMapping(path = "/*")
    public String defaultMethod(@RequestParam int a, @RequestParam int b) {
        return calculate("", a, b);
    }
}