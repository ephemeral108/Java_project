package com.java.ephemeral;

import java.io.IOException;
import java.util.Random;

public class Toxify extends Crypt{

	public Toxify(String in,String out) throws IOException {
		super(in,out);
		change();
	}
	
	private void change() throws IOException {
		int count = 0;
		byte[] b = new byte[1];
		Random r = new Random();
		int rd = r.nextInt(10);
		while (rd == 0) {
			rd = r.nextInt(10);
		}
		
		bos.write(rd);

		while(bis.read(b) != -1) {
			bos.write(b[0]^rd);
		}
		
		bos.flush();
		bos.close();
		fos.close();
		bis.close();
		fis.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
