public class CalculatorModel {
    private String[] tokens;
    private int pos;

    public CalculatorModel(String line) {
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

    private double multiply() {
        double first = factor();
        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/") && !operator.equals("//") && !operator.equals("^")) {
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
            } else if (operator.equals("^")) {
                first = Math.pow(first, second);
            }
        }
        return first;
    }

    private double factor() {
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
        } else  {
            pos++;
            return Double.parseDouble(next);
        }
    }
}
