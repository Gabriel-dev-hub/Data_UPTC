package co.edu.uptc.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class MenuPersistence {
    public Properties loadMenus(String configFile) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            properties.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
