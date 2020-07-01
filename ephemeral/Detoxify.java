package com.java.ephemeral;

import java.io.IOException;

public class Detoxify extends Crypt{
	
	int keyWord;
	
	public Detoxify(String in, String out) throws IOException {
		super(in,out);
		change();
	}
	
	private void change() throws IOException {
		int count = 0;
		byte[] b = new byte[1];
		bis.read(b);
		System.out.println(b[0]);
		keyWord=b[0];
		while(bis.read(b,0,b.length) != -1) {
			bos.write(b[0]^keyWord);
		}
		bos.flush();
		
		bos.close();
		fos.close();
		bis.close();
		fis.close();
	}
	



}
