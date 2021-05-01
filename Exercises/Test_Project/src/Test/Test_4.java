package Test;

import java.io.File;

public class Test_4 {

	public static void main(String[] args) {
		File dir = new File(args[0]);
        if (!dir.exists() || !dir.isDirectory() || !dir.canRead()) {
            System.exit(-1);
        }
		File[] entries = dir.listFiles();
		
		for (int i=0; i < entries.length; i++) {
            File f = entries[entries.length-1-i];
            if (f.isDirectory())
            	System.out.println(f.getName());
        }

	}

}
