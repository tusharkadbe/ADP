package com.workscape.vehicleidentifier.util;

import java.io.File;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * @author Tushar
 *
 */
public class XmlUtil {
	
	/*
	 * xml file parsing utility.
	 * 
	 */
	
	public static Object parseXml(String fileName, Class...classType) throws JAXBException{
		ClassLoader classLoader = XmlUtil.class.getClassLoader();
		URL fileUrl = classLoader.getResource(fileName);
		Object obj = null;
		if(fileUrl != null){
			File file = new File(fileUrl.getFile());
			JAXBContext jaxbContext = JAXBContext.newInstance(classType);  
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			obj = jaxbUnmarshaller.unmarshal(file); 
		}else{
			System.out.println("File not found : " + fileUrl);
		}
		return obj;
    }
	

}
