package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader { // we need this class to read the info from configuration.properties file

    public static String readProperty(String key){    // CAN'T  BE CHANGED EXCEPT THE NAME, LINE 14

        //File class assign given file to the java object
        File file =new File("configuration.properties"); //this file is under test-output under the same name.
                                                                 // we can use any name as long as they match 
        Properties properties = new Properties();
        //properties object will read the properties file
        try {
            properties.load((new FileInputStream(file)));
            //load method will load every value from file object to the properties object.

        } catch (IOException e) {
            e.printStackTrace();
        }
        //more actions surround by try and catch.
        return properties.getProperty(key);
        //I can read the value from properties object using the key.
    }
}
