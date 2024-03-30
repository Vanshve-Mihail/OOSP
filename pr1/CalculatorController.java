public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }
    public void calculate() {
        String input = view.getUserInput();
        model = new CalculatorModel(input);

        double result = model.calculate();
        view.displayResult(result);
    }
}
