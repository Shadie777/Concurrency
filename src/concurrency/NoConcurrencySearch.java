package concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoConcurrencySearch {
	private static int counter = 0;

	public static void main(String fileName, String string) throws IOException {
		List<String> list = new ArrayList<>();
		List<String> wordsfound = new ArrayList<>();
		File file = new File(fileName);
		BufferedReader reader = null;
		int lineCount = 0;
		int countLine = 0;
		int countBuffer = 0;
		double time = 0;
		String line = " ";
		String lineNumber = "";

		try {
			reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				String[] words = line.split(" ");

				for (String word : words) {
					list.add(word);
					if (word.equals(string)) {
						// System.out.println("bang");
						wordsfound.add(word);
						counter++;

					}
				}

				if (countBuffer > 0) {
					countBuffer = 0;
					lineNumber += countLine + ",";
				}
				lineCount++;
			}
			System.out.println(fileName);
			System.out.println("listsize:" + (list.size()));
			System.out.println("linecount:" + lineCount);
			System.out.println("countbuffer:" + countBuffer);
			System.out.println("wordsfound" + wordsfound.size());
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}

		}
	}

	public static int getCounter() {
		return counter;
	}

}
