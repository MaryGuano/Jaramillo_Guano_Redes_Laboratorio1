


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;


public class ClientUDP {
   
        private static int SERVER_PORT =9091;//DECLARAR EL PUERTO DEL SERVIDOR
public static void main(String[]args)throws IOException{
	String serverAddress = JOptionPane.showInputDialog("Enter IP address pd machine that in \n"+
" runing the date service on port "+":"); //DECLARO DIRECCION IP DEL SERVIDOR
	DatagramSocket clientSocket =new DatagramSocket();//CREACION DE UN NUEVO SOCKET
        //envia informacion
	byte bufferSend[]=serverAddress.getBytes();//ABIR LA VARIABLE BUFFERSEND QUE ALMACENA LA INFORMACION 
	DatagramPacket sendPacket=new DatagramPacket(bufferSend, bufferSend.length,InetAddress.getByName(serverAddress),SERVER_PORT);
	clientSocket.send(sendPacket);
        
	// RECIBIR INFORMACION
	byte bufferReceive[]=new byte[128];
	DatagramPacket receivePacket= new DatagramPacket(bufferReceive,bufferReceive.length);
	clientSocket.receive(receivePacket);
	
        //IMPRIME LA INFORMACION RECIBIDA
	InputStream myInputStream=new ByteArrayInputStream(receivePacket.getData());
	BufferedReader input=new BufferedReader(new InputStreamReader (myInputStream));
	String answer = input.readLine();
	
	JOptionPane.showMessageDialog(null,answer);
	clientSocket.close();
	System.exit(0);
	}
    }

