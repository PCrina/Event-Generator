
public class Worker implements Runnable {
	Eveniment ev;
	
	public Worker(Eveniment e) {
		this.ev = e;
	}
	
	public void run() {
		int result;
		switch (ev.type) {
			case "PRIME":  result = ev.PRIME();
						   synchronized (Main.prime) {
							   Main.prime.add(result);
						   }
						   break;
			case "FACT":   result = ev.FACT();
						   synchronized (Main.fact) {
							   Main.fact.add(result);
						   }
						   break;
			case "SQUARE": result = ev.SQUARE();
				 		   synchronized (Main.square) {
				 			   Main.square.add(result);
				 		   }
						   break;
			case "FIB":	   result = ev.FIBO();
						   synchronized (Main.fib) {
							   Main.fib.add(result);
						   }
						   break;
		}
	}
}
