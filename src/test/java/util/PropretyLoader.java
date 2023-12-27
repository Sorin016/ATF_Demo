package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropretyLoader {
    private static final String PROP_FILE="src/test/resources/data.properties";

    public static String loadProperty(String name){
        String value="";
        Properties prop=new Properties();
        try{
            prop.load(new FileInputStream(PROP_FILE));
        } catch (IOException e){
            e.printStackTrace();
        }
        if(name !=null){
            value=prop.getProperty(name);
        }
        return value;
    }
}
