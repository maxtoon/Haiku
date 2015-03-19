package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class fileIO {
	
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;

		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("F:\\CookBookLibrary.TXT"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine+"  EOL"+"\n");
			
					while ((sCurrentLine = br.readLine()) != null){
						StringTokenizer st = new StringTokenizer(sCurrentLine, "|");
						String leftObject = st.nextToken();
						System.out.println(leftObject+"left \n");
						
					}
				}
			
			
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
