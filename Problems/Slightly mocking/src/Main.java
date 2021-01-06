class Calculator {
    private CalculatorEngine engine;

    public Calculator(CalculatorEngine engine) {
        this.engine = engine;
    }

    public String divide(int a, int b) {
        try {
            int result = engine.divide(a, b);
            return "Division of " + a + " by " + b + " = " + result;
        } catch (ArithmeticException ae) {
            return "Division by zero is prohibited";
        }

    }
}