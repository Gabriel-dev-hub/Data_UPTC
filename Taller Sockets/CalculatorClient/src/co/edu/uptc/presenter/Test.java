package co.edu.uptc.presenter;

//@Author: Gabriel Santiago Cely. 202213440

import java.io.IOException;
import java.net.UnknownHostException;

public class Test {

    //En caso de que el sistema arroje un BindException, hay que abrir ambos proyectos en ventanas separadas (Visual Studio Code)
    //Luego, se debe ejecutar el servidor y luego el cliente
    public static void main(String[] args) throws UnknownHostException, IOException {
        new CalculatorClient().start();
    }
}
