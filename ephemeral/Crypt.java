package com.java.ephemeral;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Crypt {
	
	File f1,f2;
	public FileInputStream fis;
	public FileOutputStream fos;
	public BufferedOutputStream bos;
	public BufferedInputStream bis;
	
	public Crypt(String in,String out) throws IOException {
		f1 = new File(in);
		fis = new FileInputStream(f1);
		bis = new BufferedInputStream(fis);
		
		f2 = new File(out);
		fos = new FileOutputStream(f2);
		bos = new BufferedOutputStream(fos);
	}
}
