/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.Attr;
import org.xml.sax.SAXException;
 

/**
 *
 * @author ludiwang
 */
public class XMLData {

    private Document targetDoc;
    private Document checkDoc;
    private Document classDoc;
    private ArrayList<String> targetList = new ArrayList<String>();
    private ArrayList<String> classList = new ArrayList<String>();
    private ArrayList<String> checkList = new ArrayList<String>();
    private AppConfig appConfig;

    public XMLData(AppConfig inConfig) {
        this.appConfig = inConfig;
        init();
        System.out.println(targetList.toString() + "x") ;
    }

    private void init() {
        
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //File xmlFile = new File("C:\\Users\\wangc\\Google Drive\\java\\psdTargets.xml");
            File xmlFile = new File(this.appConfig.getProp().getProperty("targetsXMLFile"));
            targetDoc = dBuilder.parse(xmlFile);
            targetDoc.getDocumentElement().normalize();
            populateLists(targetDoc, "target");

            //xmlFile = new File("C:\\Users\\wangc\\Google Drive\\java\\psdChecks.xml");
            xmlFile = new File(this.appConfig.getProp().getProperty("checksXMLFile"));
            checkDoc = dBuilder.parse(xmlFile);
            checkDoc.getDocumentElement().normalize();
            populateLists(checkDoc, "check");

            //xmlFile = new File("C:\\Users\\wangc\\Google Drive\\java\\classes.xml");
            xmlFile = new File(this.appConfig.getProp().getProperty("classesXMLFile"));
            classDoc = dBuilder.parse(xmlFile);
            classDoc.getDocumentElement().normalize();
            populateLists(classDoc, "class");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void populateLists(Document doc, String searchTag) {
        //System.out.println(searchTag);
        NodeList nList = doc.getElementsByTagName(searchTag);

        for (int vCounter = 0; vCounter < nList.getLength(); vCounter++) {

            Node nNode = nList.item(vCounter);
            //get list of targets
            if (searchTag.equalsIgnoreCase("target")) {
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String targetName = eElement.getElementsByTagName("name").item(0).getTextContent();
                    //System.out.println(targetName);
                    targetList.add(targetName);
                    
                }
            }
            
            //get list of checks
            if (searchTag.equalsIgnoreCase("check")) {

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String ID = eElement.getAttribute("ID");
                    //System.out.println(eElement.getAttribute("ID"));
                    checkList.add(ID);
                }
            }
            
            if (searchTag.equalsIgnoreCase("class")) {

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String className = eElement.getElementsByTagName("name").item(0).getTextContent();
                    //System.out.println(className);
                    classList.add(className);
                }
            }  
        }

    }
    
    public ArrayList<String> getTargetList() {
        return this.targetList;
    }
    
    public ArrayList<String> getCheckList() {
        return this.checkList;
    }
    
    public ArrayList<String> getClassList() {
        return this.classList;
    }
    //return the runtarget for a certain target
    public String getRunTarget(String inTargetName) {
        NodeList nList = targetDoc.getElementsByTagName("target");
        String outRunTargetName = "";
        for (int i=0; i<targetList.size();i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element)nNode;
                String targetName = el.getElementsByTagName("name").item(0).getTextContent();
                String runTarget = el.getElementsByTagName("runTarget").item(0).getTextContent();
                if (targetName.equalsIgnoreCase(inTargetName)) {
                    outRunTargetName = runTarget;
                }
                
            }
        }
        return outRunTargetName;
    }
    
    private boolean validateXMLFile(String xsdPath, String xmlPath) {
       try {
           SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
           Schema schema = factory.newSchema(new File(xsdPath));
           Validator validator = schema.newValidator();
           
       } catch (SAXException e) {
           System.out.println("SAXException: " + e.getMessage());
           return false;
       }
       return false;
    }

}

