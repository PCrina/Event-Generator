

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable {
	String fileName;
	
	public Reader(String file) {
		this.fileName = file;	
	}
	
	public void run() {
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = in.readLine()) != null) {
				String[] tokens = line.split(",");
				int time = Integer.valueOf(tokens[0]);
				String type = tokens[1];
				int N = Integer.valueOf(tokens[2]);
				
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Eveniment ev = new Eveniment(N, type);
				try {
					Main.queue.put(ev);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			in.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}  
	}
}
