package co.edu.uptc.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import co.edu.uptc.structures.*;

public class Checker {
    private MyStack<Character> stack;
    private int lineNumber =  1;

    public Checker() {
        stack = new MyStack<>();
    }

    public boolean checkBalance(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lineNumber = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().startsWith("//") || line.trim().startsWith("/*") || line.trim().startsWith("*") || line.trim().startsWith("*/")){
                    continue;
                }
                for (char c : line.toCharArray()) {
                    if (isOpeningSymbol(c)) {
                        stack.push(c);
                    } else if (isClosingSymbol(c)) {
                        if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                            setLineNumber(lineNumber); 
                            return false;
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                setLineNumber(lineNumber);
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public int getLineNumber() {
        return lineNumber;
    }
    
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    private boolean isOpeningSymbol(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    private boolean isClosingSymbol(char c) {
        return c == '}' || c == ']' || c == ')';
    }

    private boolean isMatching(char opening, char closing) {
        return (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']') ||
               (opening == '(' && closing == ')');
    }

}
