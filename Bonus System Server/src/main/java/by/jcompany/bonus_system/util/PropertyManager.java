package by.jcompany.bonus_system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final String pathToResources =
        System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "main" +
            File.separator + "resources";
    static String propFile = "server.properties";
    
    public static String getPropertyValue(String propertyName) {
        Properties property = new Properties();
        String path = pathToResources + File.separator + propertyName;
        
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            property.load(fileInputStream);
            
            return property.getProperty("task.pointCost");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public static void saveTaskPointCost(String propertyName, String value) {
        Properties property = new Properties();
        String path = pathToResources + File.separator + propertyName;
        
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            property.setProperty("task.pointCost", value);
            property.store(fileOutputStream, "Store server properties");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}