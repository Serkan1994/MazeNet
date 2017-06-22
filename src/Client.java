
/**
 * Created by sesc on 20.06.17.
 */
//package de.fhac.rn.xml;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBException;

import generated.AwaitMoveMessageType;
import generated.LoginReplyMessageType;
import generated.MazeCom;

//import mypackage.EchoMessage;

public class Client {

	private int id;

	private static boolean VERBOSE = true;

	public static void main(String[] args) throws UnknownHostException, IOException, JAXBException {
		new Client();
	}

	public Client() throws UnknownHostException, IOException, JAXBException {
		System.out.println("client starts");
		Socket socket = new Socket("localhost", 5123);
		if (socket.isConnected()) {
			System.out.println("success");
		}

		UTFOutputStream outputStream = new UTFOutputStream(socket.getOutputStream());

		String msg = XMLHandler.getInstance().createLoginMessage();

		outputStream.writeUTF8(msg);
		outputStream.flush();

		UTFInputStream inStream = new UTFInputStream(socket.getInputStream());
		

		while (true) {
			String answer = inStream.readUTF8();
			MazeCom mazeCom = XMLHandler.getInstance().getMessage(answer);
			switch (mazeCom.getMcType()) {
			case LOGINREPLY:
				LoginReplyMessageType loginReplyMsg = mazeCom.getLoginReplyMessage();
				this.id = loginReplyMsg.getNewID();
				if (VERBOSE) {
					System.out.println("Login Reply Message received.");
					System.out.println("ID: " + this.id);
				}
				break;
			case AWAITMOVE:
				AwaitMoveMessageType awaitMoveMsg = mazeCom.getAwaitMoveMessage();
				if (VERBOSE) {
					System.out.println("Await Move Message received.");
				}
			}
		}

	}
}