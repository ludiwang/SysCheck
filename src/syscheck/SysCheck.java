/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ludiwang
 */
public class SysCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        String propertyFilePath = null;
        for (String s : args) {

            propertyFilePath = s;

        }
        if (propertyFilePath == null) {
            System.out.println("Missing Input Parameter, please prvide configuration file location.");
            System.exit(1);
        }

        AppConfig config = new AppConfig(propertyFilePath);
        //System.out.println(config.getProp().getProperty("classesXSDFile"));

        XMLData nXMLData = new XMLData(config);
        //String runTarget = nXMLData.getRunTarget("TBPM5_02");
        //Go through target list, check which targets should be checked from this host
        //and add it to crrentTargetList.
        ArrayList<String> allTargetList = nXMLData.getTargetList();
        ArrayList<String> currentTargetList = new ArrayList<>();
        for (int i = 0; i < allTargetList.size(); i++) {
            String targetName = allTargetList.get(i);
            String runTarget = nXMLData.getRunTarget(targetName);
            System.out.println(runTarget);
            if (runTarget.equalsIgnoreCase(getHostName())) {
                currentTargetList.add(targetName);
            }
        }

        System.out.println("Targets that need to be checked from this host are:");
        for (int i = 0; i < currentTargetList.size(); i++) {
            System.out.println(currentTargetList.get(i));
        }
        
        new OsFileDir("/tmp/test1");
        //System.out.println(runTarget);
        //System.out.println("HostName is: " + getHostName());
    }

    public static String getHostName() {
        String hostname = "unknown";
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
            //System.out.println(hostname);
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }
}
