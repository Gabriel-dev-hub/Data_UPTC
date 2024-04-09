package main;

// Gabriel Santiago Cely
// 202213440

public class Main {
    public static void main(String[] args) {
        NumberSimpleList list = new NumberSimpleList();

        System.out.println("Se insertan los datos 4, 8, 3 y 5:");
        list.insert(4);
        list.insert(8);
        list.insert(3);
        list.insert(5);
        System.out.println(list.show());

        System.out.println("Se verifica si existe el nodo con el dato 7:");
        System.out.println(list.exists(7));

        System.out.println("Se verifica si existe el nodo con el dato 5:");
        System.out.println(list.exists(5));

        System.out.println("Se elimina el nodo con el dato 4(head)");
        list.delete(4);

        System.out.println("Se compureba en la lista que se haya eliminado el nodo con el dato 4:");
        System.out.println(list.show());

        System.out.println("Se elimina el nodo con el dato 3");
        list.delete(3);

        System.out.println("La lista final queda:");
        System.out.println(list.show());
    }
}
