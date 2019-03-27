

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	// COADA DE EVENIMENTE
	static ArrayBlockingQueue<Eveniment> queue;

	// STRUCTURILE REZULTAT
	static ArrayList<Integer> prime = new ArrayList<>();
	static ArrayList<Integer> fact = new ArrayList<>();
	static ArrayList<Integer> square = new ArrayList<>();
	static ArrayList<Integer> fib = new ArrayList<>();


	public static void printFile(String file) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(file + ".out");
			switch (file) {

			case "PRIME":  for(int i = 0; i < prime.size(); i++)
								out.println(prime.get(i));
						   break;
			case "FACT":  for(int i = 0; i < fact.size(); i++)
								out.println(fact.get(i));
						   break;
			case "SQUARE": for(int i = 0; i < square.size(); i++)
								out.println(square.get(i));
						   break;
			case "FIB":	  for(int i = 0; i < fib.size(); i++)
								out.println(fib.get(i));
						   break;
			}

			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws InterruptedException {

		int dim_coada = Integer.valueOf(args[0]);
		queue = new ArrayBlockingQueue<>(dim_coada);

		int evenimente_fisier = Integer.valueOf(args[1]);
		int nrOfThreads = args.length - 2;

		Thread threads[] = new Thread[nrOfThreads];

		for(int i = 0; i < nrOfThreads; i++) {
			threads[i] = new Thread(new Reader(args[2 + i]));
		}

		for(int i = 0; i < nrOfThreads; i++)
			threads[i].start();

		int core = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(core);

		for(int i = 0; i < evenimente_fisier * nrOfThreads; i++) {
			try {
				executor.submit(new Worker(queue.take()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		executor.shutdown();

		if (!executor.awaitTermination(60000, TimeUnit.SECONDS))
		    System.err.println("Threads didn't finish in 60000 seconds!");

		for(int i = 0; i < nrOfThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(prime);
		Collections.sort(fact);
		Collections.sort(square);
		Collections.sort(fib);

		printFile("PRIME");
		printFile("FACT");
		printFile("SQUARE");
		printFile("FIB");

	}
}
