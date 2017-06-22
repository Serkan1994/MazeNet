
/**
 * Created by sesc on 20.06.17.
 */
//package de.fhac.rn.xml;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBException;

import AI.AI;
import AI.SimpleAI;
import AI.simpleAI;
import generated.AwaitMoveMessageType;
import generated.LoginReplyMessageType;
import generated.MazeCom;
import generated.MoveMessageType;

//import mypackage.EchoMessage;

public class Client {

	private int id;
	private AI ai;
	private Socket socket;

	private UTFOutputStream outStream;
	private UTFInputStream inStream;

	private static boolean VERBOSE = true;

	public static void main(String[] args) throws UnknownHostException, IOException, JAXBException {
		new Client();
	}

	public Client() throws IOException {
		if (VERBOSE) {
			System.out.println("Client starts");
		}

		this.socket = new Socket("localhost", 5123);

		if (VERBOSE) {
			if (socket.isConnected()) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
				return;
			}
		}

		outStream = new UTFOutputStream(socket.getOutputStream());
		inStream = new UTFInputStream(socket.getInputStream());
		
		ai = new SimpleAI();
	}

	public void login() throws JAXBException, IOException {
		String msg = XMLHandler.getInstance().createLoginMessage();

		outStream.writeUTF8(msg);
		outStream.flush();

	}

	public void communicate() throws IOException, JAXBException {

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
				MoveMessageType moveMsg = ai.getNextMove(awaitMoveMsg);
				if (VERBOSE) {
					System.out.println("Await Move Message received.");
				}
			default:
				break;
			}
		}

	}
}