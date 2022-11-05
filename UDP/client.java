package UDP;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client {
	

	public static void main(String args[]) {
		try {
			DatagramSocket ds = new DatagramSocket();
            Scanner sc= new Scanner(System.in);
			String msg = sc.nextLine();
			byte[] bf = msg.getBytes();					
			DatagramPacket dp = new DatagramPacket(bf, bf.length,InetAddress.getByName("localhost"),9999);
			
			bf= new byte[300];
			DatagramSocket ds_recv= new DatagramSocket(8080);
			DatagramPacket dp_recv= new DatagramPacket(bf,bf.length);

			ds.send(dp);
            sc.close();

			ds_recv.receive(dp_recv);
			String ip= new String(bf);
			ip=ip.trim();
			System.out.println("IP: "+ip);
		

		} catch(IOException e) {}
	}
}
