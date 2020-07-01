package com.java.ephemeral;

import java.io.File;
import java.io.IOException;

public class FileChecker {
	
	private int counter = 0;
	private File f;
	private File fn;
	private String name;
	public FileChecker(String in, String out) throws IOException {
		nameChecker(out);
		f = new File(in);
		if(f.isDirectory()) {
			File[] fs = f.listFiles();	
			for(File f:fs){				
				if(!f.isDirectory())	
					new Toxify(f.toString(),name);
					counter++;
					name = out + "/encrypt" + counter ;
			}
		}else {
			new Toxify(in,name);
		}
		
	}
	
	private void nameChecker(String out) {
		fn = new File(out);
		File[] fcn = fn.listFiles();
		
		for(File ff:fcn) {			
			if(ff.getName().indexOf("encrypt") != -1) {
				counter = Integer.parseInt(ff.getName().substring(7))+1;
			}
		}
		name = out + "/encrypt" + counter ;
	}

}
