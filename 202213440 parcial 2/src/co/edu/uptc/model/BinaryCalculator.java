package co.edu.uptc.model;

import co.edu.uptc.structures.MyQueue;
import co.edu.uptc.structures.MyStack;

public class BinaryCalculator {
    private String numbers;

    public BinaryCalculator(String numbers) {
        this.numbers = numbers;
    }

    public String calculate() {
        String[] numbers = this.numbers.split("\\s+");
        MyQueue<Integer> result = new MyQueue<>();

        for (String num : numbers) {
            if (!num.matches("[01]+")) {
                throw new IllegalArgumentException("El número '" + num + "' no es un número binario válido.");
            }

            MyStack<Integer> stack = new MyStack<>();
            for (char c : num.toCharArray()) {
                stack.push(Character.getNumericValue(c));
            }
            MyQueue<Integer> newResult = new MyQueue<>();
            int carry = 0;

            while (!stack.isEmpty() || !result.isEmpty() || carry != 0) {
                int addition = carry;
                if (!stack.isEmpty()) {
                    addition += stack.pop();
                }
                if (!result.isEmpty()) {
                    addition += result.pull();
                }
                newResult.push(addition % 2);
                carry = addition / 2;
            }
            result = newResult;
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.insert(0, result.pull());
        }
        return sb.toString();
    }

}