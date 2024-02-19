package jrobot;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ExtractProperties {
    static Properties prop;
    static String HomePath=System.getProperty("user.dir");
    public static String getProp(String value)
    {
        String result="null";
        try{
            prop=new Properties();
            InputStream input=new FileInputStream(HomePath+"/configuration.properties");
            prop.load(input);
            result=prop.getProperty(value);
            return result;
        }
        catch(Exception e)
        {
            System.out.println("Error while retrieving data from  configurations file:"+e.getMessage());
        }
        return result;
    }
}
