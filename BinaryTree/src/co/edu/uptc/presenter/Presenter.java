package co.edu.uptc.presenter;

import java.util.Comparator;
import co.edu.uptc.model.*;

import co.edu.uptc.structures.BinaryTree;

public class Presenter {

    public Presenter() {

    }
    public static void main(String[] args) throws Exception {
        
        // Expresion lambda:
        BinaryTree<Integer> tree = new BinaryTree<>((a, b) -> a - b);

        // Clase anonima:
        BinaryTree<Integer> tree2 = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        // Referencia a metodo:
        BinaryTree<String> tree3 = new BinaryTree<>(String::compareTo);

        //Clase concreta:
        BinaryTree<Student> tree4 = new BinaryTree<>(new StudentComparator());


        System.out.println("El arbol está vacío? " + tree.isEmpty());

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(25);
        tree.insert(31);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);

        System.out.println(tree.preOrder());

        System.out.println("El arbol está vacío? " + tree.isEmpty());
        System.out.println("El 20 existe? " + tree.exist(20));
        System.out.println("el 100 existe? " + tree.exist(100));

        System.out.println(tree.inOrder());

        System.out.println("Eliminando el 10");
        tree.remove(10);
        System.out.println("El 10 existe? " + tree.exist(10));

        System.out.println(tree.preOrder());

        System.out.println("Eliminando el 5");
        tree.remove(5);
        System.out.println("El 5 existe? " + tree.exist(5));

        System.out.println(tree.inOrder());

        System.out.println("Eliminando el 20");
        tree.remove(20);
        System.out.println("El 20 existe? " + tree.exist(20));

        System.out.println(tree.inOrder());

        Student student1 = new Student(1, "Juan", 20);
        Student student2 = new Student(2, "Pedro", 30);
        Student student3 = new Student(3, "Maria", 25);
        Student student4 = new Student(4, "Ana", 22);
        tree4.insert(student1);
        tree4.insert(student2);
        tree4.insert(student3);
        tree4.insert(student4);

        System.out.println("El arbol está vacío? " + tree4.isEmpty());
        System.out.println("El estudiante con el código 1 existe? " + tree4.exist(new Student(1, null, 0)));
        System.out.println("Información del estudiante con código 4: " + tree4.search(new Student(4, null, 0)));
        System.out.println("El estudiante con el código 5 existe? " + tree4.exist(new Student(5, "Luis", 40)));

        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());

        int i = 0;
        for (i = 0; i < 12; i++) {
            tree2.insert(i);
        }

        System.out.println(tree2.preOrder());
    }
}
