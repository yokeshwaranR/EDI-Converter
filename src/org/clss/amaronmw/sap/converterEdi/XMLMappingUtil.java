package org.clss.amaronmw.sap.converterEdi;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLMappingUtil {
	
	public FileUploadUtil fileUploadUtil;
	
	public FTPConnectionUtil ftpConnectionUtil;
	
	public void XMLMappingToObject(String sapData) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		
		System.out.println("Calling XML mapping class");	
		
		RequestMapper requestMapper = new RequestMapper();
				
		String xml_string = sapData;
		
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xml_string));
		Element root = null;
		Document document = null;
		try {
			document  = builder.parse(is);
		    root = document.getDocumentElement();
		    System.out.println("Parsing String to XML");
		} catch(SAXException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(root.getNodeName());
		 
		//Get all employees
		NodeList nList = document.getElementsByTagName("EDI_DC40");
		System.out.println("============================");
		 
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 System.out.println("");    //Just a separator
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    //Print each employee's detail
		    Element eElement = (Element) node;
		    System.out.println("SEGMENT id : "    + eElement.getAttribute("SEGMENT"));
		    System.out.println("DOCNUM : "  + eElement.getElementsByTagName("DOCNUM").item(0).getTextContent());
		    System.out.println("CREDAT : "   + eElement.getElementsByTagName("CREDAT").item(0).getTextContent());
		    System.out.println("CRETIM : "    + eElement.getElementsByTagName("CRETIM").item(0).getTextContent());
		 }
		}
		
		NodeList nList2 = document.getElementsByTagName("E1EDKA1");
		System.out.println("============================");
		 
		for (int temp = 0; temp < nList2.getLength(); temp++)
		{
		 Node node2 = nList2.item(temp);
		 System.out.println("");    //Just a separator
		 if (node2.getNodeType() == Node.ELEMENT_NODE)
		 {
		    //Print each employee's detail
		    Element eElement2 = (Element) node2;
		    System.out.println("SEGMENT id : "    + eElement2.getAttribute("SEGMENT"));
		    System.out.println("PARVW 1 : "  + eElement2.getElementsByTagName("PARVW").item(0).getTextContent());
		    if(eElement2.getElementsByTagName("PARVW").item(0).getTextContent().equalsIgnoreCase("ZC")) {
		    	System.out.println("Called ZC");
		    	System.out.println("LIFNR : "  + eElement2.getElementsByTagName("LIFNR").item(0).getTextContent());
		    }
		 }
		}
		
	}



}
