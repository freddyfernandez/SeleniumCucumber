package pe.com.nttdata.SeleniumCucumber.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    public String loadProperty(String parameter){
        return System.getProperty(parameter);
    }

    public Properties loadProperties(){
        Properties props = new Properties();
        String filePath = new File("src/test/resources/params.properties").getAbsolutePath();
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            props.load(fileInput);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(fileInput !=null){
                try {
                    fileInput.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return props;
    }
}
