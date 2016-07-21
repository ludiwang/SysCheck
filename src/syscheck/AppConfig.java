/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author wangc
 */

//
public class AppConfig {
    private Properties prop;
    public AppConfig(String propertyFilePath) {

        prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propertyFilePath);
            prop.load(input);
            //System.out.println(prop.getProperty(("confDir")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Properties getProp(){
        return prop;
    }
}
