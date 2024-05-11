package co.edu.uptc.presenter;

//@Author: Gabriel Santiago Cely. 202213440

import java.io.IOException;

public class Test {

    //Por favor abrir el programa en ventanas separadas
    //Tener en cuenta que si se ejecuta desde la carpeta principal "Taller Sockets" el programa no funciona, dado que el cliente se puede acceder por un BindException
    public static void main(String[] args) throws IOException {
        new CalculatorServer().start();
    }
}
