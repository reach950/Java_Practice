package com.example.chat;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Frame {

	TextField tf = new TextField();
	TextArea ta = new TextArea();
	Socket s = null;
	DataOutputStream dos = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient cc = new ChatClient();
		cc.launchFrame();
	}

	public void launchFrame() {
		this.setLocation(550, 250);
		this.setSize(300, 300);
		this.add(tf, BorderLayout.SOUTH);
		this.add(ta, BorderLayout.NORTH);
		this.pack();
		super.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				disconnect();
				System.exit(0);
			}

		});
		tf.addActionListener(new TFActionListener());
		this.setVisible(true);
		this.connectToServer();
	}

	public void connectToServer() {
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			System.out.println("connectted!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			dos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class TFActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = tf.getText();
			ta.setText(ta.getText() + str);
			tf.setText("");
			try {
				dos.writeUTF(str);
				dos.flush();
				// dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
