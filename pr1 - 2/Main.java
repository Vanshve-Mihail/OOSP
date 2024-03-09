import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Введите строку(каждое число или символ через пробел): ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Calculator calculator = new Calculator(line);
        System.out.println(calculator.calculate());
    }
}
