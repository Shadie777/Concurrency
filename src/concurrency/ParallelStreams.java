package concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String fileName, String string) {
		List<String> wordsFound = new ArrayList<>();
		List<String> textList = new ArrayList<>();
		Path dir = Paths.get(fileName);
		final AtomicInteger count = new AtomicInteger();

		String[] arrayOfWords = { string };
		Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

		try {
			Files.lines(dir).parallel().map(lines -> lines.split("\\s+"))
					// Stream<String[]>
					.flatMap(Arrays::stream)
					// Stream<String>
					.filter(e -> e.equals(string))
					.forEach(e -> count.getAndIncrement());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(fileName);
		System.out.println("words found:" + count);
	}
}
