package main;

import java.util.Iterator;

import model.Student;
import structures.SimpleList;
import structures.DoubleList;

public class Main {
    
    public static void main(String[] args) {

        // Simple List
        SimpleList<Student> student = new SimpleList<Student>();
        Student carlos = new Student("Carlos", 18, "123");
        Student jairo = new Student("Jairo", 30, "321");
        student.insert(carlos);
        student.insert(jairo);

        Iterator<Student> iterator = student.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        student.remove(jairo);
        System.out.println("Existe Carlos?: " + student.exists(carlos));
        System.out.println("Existe Jairo?: " + student.exists(carlos));

        // Double List
        DoubleList<Integer> list = new DoubleList<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        Iterator<Integer> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println(list.bothShow());
        System.out.println(list.invertedShow());
        list.remove(3);
        System.out.println(list.bothShow());
        System.out.println("Existe el 1?: " + list.exists(1));
        System.out.println("Existe el 3?: " + list.exists(3));
        System.out.println("Existe el 4?: " + list.exists(4));
        System.out.println("Cual es el anterior al 2?: " + list.getPrevious(2));

        SimpleList<String> list2 = new SimpleList<>();
        list2.insert("1");
        list2.insert("2");
        list2.insert("3");

        //System.out.println("Lista: " + list2.show());
        System.out.println("borrando '2'...");
        list2.remove("2");
        //System.out.println("Lista nueva: " + list2.show());
        System.out.println("Existe '3'? " + list2.exists("3"));
        System.out.println("Existe '4'? " + list2.exists("4"));
    }
}
