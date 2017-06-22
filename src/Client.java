/**
 * Created by sesc on 20.06.17.
 */
//package de.fhac.rn.xml;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBException;

//import mypackage.EchoMessage;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, JAXBException {
        System.out.println("client starts");
        Socket socket = new Socket("localhost", 5123);
        if(socket.isConnected()) {
            System.out.println("success");
        }

        UTFOutputStream dataOutputStream = new UTFOutputStream(socket.getOutputStream());
        
        String msg = XMLHandler.getInstance().getMazeCom();
       
        System.out.println(msg);
        
        dataOutputStream.writeUTF8(msg);
        dataOutputStream.flush();
        
//        XMLSerialisation serializer = new XMLSerialisation(socket.getLocalAddress().getHostName());

//        Scanner scanner = new Scanner(System.in);
//        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//        while (scanner.hasNextLine()) {
//            EchoMessage message = serializer.getNewMessage();
//            message.setContent(scanner.nextLine());
//            dataOutputStream.writeUTF(serializer.messageToXMLString(message));
//            EchoMessage answer = serializer.xmlStringToMessage(dataInputStream.readUTF());
//
//            System.out.println(answer.getSender() + ": " + answer.getContent());
//        }
//        scanner.close();
        socket.close();
    }
    

}