public class Calculator {
    private String[] tokens;
    private int pos;

    public Calculator(String line) {
        this.tokens = line.split(" ");
        this.pos = 0;
    }

    public double calculate() {
        double first = multiply();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }
            double second = multiply();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    public double multiply() {
        double first = factor();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/") && !operator.equals("//") && !operator.equals("^") && !operator.equals("**")) {
                break;
            } else {
                pos++;
            }
            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else if (operator.equals("/")) {
                first /= second;
            } else if (operator.equals("//")) {
                first %= second;
            } else if (operator.equals("^") || operator.equals("**")) {
                first = Math.pow(first, second);
            }
        }
        return first;
    }

    public double factor() {
        String next = tokens[pos];
        if (next.equals("(")) {
            pos++;
            double result = calculate();
            String closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalArgumentException("Ошибка");
            }
            if (closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalArgumentException("')' ошибка");
        } else if (next.equals("log")) {
            pos++;
            double argument = factor();
            return Math.log(argument)/Math.log(2);
        } else if (next.equals("exp")) {
            pos++;
            double argument = factor();
            return Math.exp(argument);
        } else if (next.equals("!")) {
            pos++;
            double argument = factor();
            return factorial((int) argument);
        } else {
            pos++;
            return Double.parseDouble(next);
        }
    }

    private double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Отрицательный аргумент");
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
