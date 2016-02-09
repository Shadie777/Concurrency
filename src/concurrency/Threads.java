package concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Threads implements Runnable {

	private String searchString;
	BufferedReader br = null;
	List<String> list = new ArrayList<>();
	List<String> words = new ArrayList<>();
	List<String> wordsFound = new ArrayList<>();
	private int counter = 0;
	private String fileName;

	public Threads(String fileName, String searchString) {
		this.searchString = searchString;
		this.fileName = fileName;
	}

	@Override
	public void run() {

		String line = " ";

		File file = new File(fileName);

		try {
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");

				for (String word : words) {
					list.add(word);
					if (word.equals(searchString)) {
						counter++;

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(fileName);
		System.out.println("words found:" + counter);
	}

	public int getCounter() {
		return counter;
	}

}
