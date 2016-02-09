package concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsReadFile {

	public static void main(String[] fileName, String searchString)
			throws IOException, InterruptedException {

		int counter = 0;

		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 3; i++) {
			Runnable worker = new Threads(fileName[i], searchString);
			executor.execute(worker);

		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");

	}

}
