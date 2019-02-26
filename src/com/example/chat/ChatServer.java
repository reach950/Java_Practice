package com.example.chat;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		boolean started = false;
		try {
			ss = new ServerSocket(8888);
		} catch (BindException e) {
			System.out.println("exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		started = true;
		while(started){
			boolean accepted = false;
			try {
				s = ss.accept();
				accepted = true;
				System.out.println("a client connectted!");
				dis = new DataInputStream(s.getInputStream());
				while(accepted){
					String str = dis.readUTF();
					System.out.println(str);
				}
				//dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("exception");
			} finally {
				try {
					dis.close();
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

	}

}

