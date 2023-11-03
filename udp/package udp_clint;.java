package udp_clint;
import java.io.*;
import java.net.*;
public class udp_clint {
	

	   public static void main(String args[]) throws Exception
	   {
	      BufferedReader inFromUser =
	         new BufferedReader(new InputStreamReader(System.in));
	      DatagramSocket clientSocket = new DatagramSocket();
	      InetAddress IPAddress = InetAddress.getByName("localhost"); //write server address
	      byte[] sendData = new byte[1024];
	      byte[] receiveData = new byte[1024];
	      String sentence = inFromUser.readLine();
	      sendData = sentence.getBytes();
	      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); //server port number 9876
	      clientSocket.send(sendPacket);
	      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	      clientSocket.receive(receivePacket);
	      String modifiedSentence = new String(receivePacket.getData());
	      System.out.println("FROM SERVER:" + modifiedSentence);
	      clientSocket.close();
	   }
	}
