package co.edu.uptc.model;

import co.edu.uptc.structures.MyQueue;
import co.edu.uptc.structures.MyStack;

public class Calculator {
    private String numbers;

    public Calculator(String numbers) {
        this.numbers = numbers;
    }

    public String add() {
        String[] nums = this.numbers.split("\\s+");
        MyQueue<Integer> result = new MyQueue<>();

        for (String num : nums) {
            MyStack<Integer> stack = new MyStack<>();

            for (char c : num.toCharArray()) {
                stack.push(Character.getNumericValue(c));
            }
            MyQueue<Integer> newResult = new MyQueue<>();
            int carry = 0;

            while (!stack.isEmpty() || !result.isEmpty() || carry != 0) {
                int sum = carry;
                if (!stack.isEmpty()) {
                    sum += stack.pop();
                }
                if (!result.isEmpty()) {
                    sum += result.pull();
                }
                newResult.push(sum % 10);
                carry = sum / 10;
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