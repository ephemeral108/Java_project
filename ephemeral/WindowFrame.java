package com.java.ephemeral;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class WindowFrame extends JFrame{
	
	private int x = 580; //window width
	private int y = 250; //window height
	
	File f;
	JPanel jp;
	JButton jb;
	JButton jb2;
	JButton to;
	JButton oneKey;
	JButton dto;
	JTextField jt;
	JTextField jt2;
	JFileChooser jc;
	JFileChooser jc2;
	
	WindowFrame(){
		subButton();
		TextField();
		subButton2();
		oneKey();
		TextField2();
		toxify();
		detoxify();
		createPanel();
		createWindow();
		this.add(jp);
		this.setVisible(true);
	}
	
	public void createPanel() {
		//FlowLayout fl = new FlowLayout();
		jp = new JPanel();
		jp.setSize(x,y);
		jp.setBackground(Color.BLUE);
		jp.setLayout(null);
		jp.add(jt);
		jp.add(jb);
		jp.add(jt2);
		jp.add(jb2);
		jp.add(to);
		jp.add(dto);
		jp.add(oneKey);
	}
	
	public void TextField() {
		jt = new JTextField("please enter file absolute path");
		jt.setSize(300, 30);
		jt.setLocation(40, 50);
	}
	
	
	public void subButton() {
		jb = new JButton();
		jb.setText("input");
		jb.setSize(80, 30);
		jb.setLocation(360, 50);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.setText(FileChooser());
			}
			
		});
		
	}
	
	public void oneKey() {
		oneKey = new JButton();
		oneKey.setText("folder");
		oneKey.setSize(80, 30);
		oneKey.setLocation(460, 50);
		oneKey.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.setText(FileChooser2());
			}
			
		});
		
	}
	
	public void TextField2() {
		File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
		String desktopPath = desktopDir.getAbsolutePath();
		jt2 = new JTextField(desktopPath);
		jt2.setSize(300, 30);
		jt2.setLocation(40, 100);
	}
	
	
	public void subButton2() {
		jb2 = new JButton();
		jb2.setText("output");
		jb2.setSize(80, 30);
		jb2.setLocation(360, 100);
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt2.setText(FileChooser2());
			}
			
		});
		
	}
	
	public String FileChooser() {
		jc = new JFileChooser();
		jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jc.setDialogTitle("Select file");
		jc.showOpenDialog(null);
		f = jc.getSelectedFile();
		if(f != null){
			return f.toString();
		}
		return null;
	}
	
	public String FileChooser2() {
		jc2 = new JFileChooser();
		jc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jc2.setDialogTitle("Select directories");
		jc2.showOpenDialog(null);
		f = jc2.getSelectedFile();
		if(f != null){
			return f.toString();
		}
		return null;
	}
	
	public void toxify() {
		to = new JButton();
		to.setText("encrypt");
		to.setSize(100, 30);
		to.setLocation(80, 150);
		to.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			//	JOptionPane.showMessageDialog(null, "encrypting...","", JOptionPane.INFORMATION_MESSAGE);
				try {
					//new Toxify(jt.getText(),jt2.getText()+"/encrypt.xu");
					new FileChecker(jt.getText(),jt2.getText());
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "error","", JOptionPane.INFORMATION_MESSAGE);
				}finally {
					//JOptionPane.showMessageDialog(null, "finished!!","", JOptionPane.INFORMATION_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "finished!!","", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}   
	
	public void detoxify() {
		dto = new JButton();
		dto.setText("decrypt");
		dto.setSize(100, 30);
		dto.setLocation(220, 150);
		dto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "decrypting...","", JOptionPane.INFORMATION_MESSAGE);
				try {
					new Detoxify(jt.getText(),jt2.getText()+"/decrypt.xu");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					JOptionPane.showMessageDialog(null, "finished!!","", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
	}
	
	
	public void createWindow() {
		this.setTitle("FileSpiltor");
		this.setSize(x,y);
		this.setLocation(x, y);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
