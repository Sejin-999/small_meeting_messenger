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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class client_chat extends JFrame{
	
	client_chat(String getNick){
		JPanel inputPanel = new JPanel();
		
		JTextField textFiled ;
		JButton subBTN;
		JButton escBTN;
		JTextArea textArea;
		
		setTitle("한국공학대 - 소모임 - 메신저");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		escBTN = new JButton("돌아가기");
		escBTN.setBounds(670,15,100,45);
		add(escBTN);
		
		textArea = new JTextArea(10,30);
		textArea.setBackground(Color.gray);
		textArea.setEditable(false);
		textArea.setBounds(100,100,580,400);
		add(textArea);
		
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
	
	public static void main(String[] args) {
		 
		client_chat ch = new client_chat("Nick");
		ch.getContentPane().setBackground(Color.white);
		
    }
	
}
