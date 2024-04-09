package co.edu.uptc.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Persistence {
    public String convertFileToString(String filepath) {
        String result = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filepath));
            result = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
