public class CalculatorView {
    public String getUserInput() {
        System.out.println("Введите строку(каждое число или символ через пробел): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }
}
