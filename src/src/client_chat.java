package src;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class client_chat extends JFrame {
	JTextField textFiled ;
	JButton subBTN;
	JButton escBTN;
	JTextArea textArea;
	JScrollPane scroll;
	JFrame frame;
	
	
	client_chat(String getNick){
		JPanel inputPanel = new JPanel();
		frame = new JFrame();
		add(frame);
		
		setTitle("한국공학대 - 소모임 - 메신저");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		escBTN = new JButton("돌아가기");
		escBTN.setBounds(670,15,100,45);
		frame.add(escBTN);
		
		
		textArea = new JTextArea(10,30);
		//textArea.setBounds(100,100,580,400);
		textArea.setBackground(Color.gray);
		textArea.setEditable(false);
		textFiled = new JTextField(30);
		subBTN = new JButton("전송");
		
		textFiled.setBounds(0,517,600,45);
		add(textFiled);
		
		subBTN.setBounds(600,517,190,45);
		add(subBTN);
		
		setVisible(true);
		
		
		
		escBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				section_login sl = new section_login();
				sl.getContentPane().setBackground(Color.white);
				dispose(); 
			}
		});

	}
	
	
	public void start() throws IOException {
		while(true) {
			String nick;
			nick = "관리자";
			String ex = "예시 문구입니다.";
			byte[] buf =new byte[256];
			buf = ex.getBytes();
			textArea.append(nick+" :: "+new String(buf)+"\n");
			//textArea.setCaretPosition(textArea.getDocument().getLength());
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		 
		client_chat ch = new client_chat("Nick");
		ch.getContentPane().setBackground(Color.white);
		ch.start();
    }
	
}
