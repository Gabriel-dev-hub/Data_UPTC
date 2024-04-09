package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;
import co.edu.uptc.structures.*;

public class RootSort {

    private PriorityQueue<Integer>[] queues;

    public RootSort() {
        queues = new PriorityQueue[6];
    }

    public List<Integer> ordenate(List<Integer> numbers) {
        List<Integer> firstList = organizeByPlace(numbers, 0);
        List<Integer> secondList = organizeByPlace(firstList, 1);
        List<Integer> finalList = organizeByPlace(secondList, 2);
        return finalList;
    }

    public List<Integer> organizeByPlace(List<Integer> numbers, int exponent) {
        for (int i = 0; i < 6; i++) {
            queues[i] = new PriorityQueue<>(6);
        }
    
        for (Integer number : numbers) {
            int value = getDigitValue(number, exponent);
            queues[value].push(number, value);
        }
    
        List<Integer> orderedList = new ArrayList<>();
        for (PriorityQueue<Integer> queue : queues) {
            while (!queue.isEmpty()) {
                orderedList.add(queue.pull());
            }
        }
        return orderedList;
    }
    
    private int getDigitValue(int number, int exponent) {
        switch (exponent) {
            case 0:
                return number % 10;
            case 1:
                return (number / 10) % 10;
            case 2:
                return number / 100;
            default:
                throw new IllegalArgumentException("El parámetro 'exponent' debe ser 0, 1 o 2");
        }
    }
}