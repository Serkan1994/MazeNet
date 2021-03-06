package util;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import generated.LoginMessageType;
import generated.MazeCom;
import generated.MazeComType;
import generated.MoveMessageType;
import generated.ObjectFactory;
import generated.PositionType;

public class XMLHandler {
	private static XMLHandler instance;
	
	private ObjectFactory of;
	private JAXBContext jc;
	
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public static XMLHandler getInstance() {
		if(instance == null)
			try {
				instance = new XMLHandler();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return instance;
	}
	
	private XMLHandler() throws JAXBException {
		
		of = new ObjectFactory();
	 	jc = JAXBContext.newInstance(MazeCom.class);
	 	marshaller = jc.createMarshaller();
	 	unmarshaller = jc.createUnmarshaller();
	}
	
    public String createLoginMessage() throws JAXBException {
        MazeCom msg = of.createMazeCom();
        msg.setMcType(MazeComType.LOGIN);
        LoginMessageType type = of.createLoginMessageType();
        type.setName("Playek");
        msg.setLoginMessage(type);
        StringWriter sw = new StringWriter();
        marshaller.marshal(msg,sw);
        return sw.toString();
    }
    
    public MoveMessageType createMoveMessage() {
    	return of.createMoveMessageType();
    }
    
    public MazeCom createMazeCom() {
    	return of.createMazeCom();
    }
    
    public PositionType createPosition() {
    	return of.createPositionType();
    }
    
    public String getXMLString(MazeCom mc) throws JAXBException {
    	StringWriter sw = new StringWriter();
        marshaller.marshal(mc,sw);
        return sw.toString();
    	
    }

    public MazeCom getMessage(String xmlString) throws JAXBException {
    	StringReader reader = new StringReader(xmlString);
    	return (MazeCom) unmarshaller.unmarshal(reader);
    }
	
    
 	
}
