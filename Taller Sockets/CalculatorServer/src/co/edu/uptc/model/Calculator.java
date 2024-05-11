package co.edu.uptc.model;

public class Calculator {

    double result;
    double memory;

    public Calculator() {
        this.result = 0;
        this.memory = 0;
    }

    public Boolean processInput(String input) {
        String[] parts = input.split(" ");
        boolean isValid = false;

        try {
            double operand1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double operand2 = Double.parseDouble(parts[2]);

            double result = calculate(operand1, operator, operand2);
            setResult(result);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
        } catch (ArithmeticException e) {
            isValid = false;
        } catch (IllegalArgumentException e) {
            isValid = false;
        }
        return isValid;
    }

    public double calculate(double operand1, String operator, double operand2) {
        double result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                updateMemory(result);
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new ArithmeticException("No se puede dividir por cero");
                }
                break;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
        return result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public synchronized void updateMemory(double value) {
        memory += value;
    }

    public synchronized double getMemory() {
        return memory;
    }
}