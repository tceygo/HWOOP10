package sample;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class FileStoreg {

	File vocabulary = new File("vocabulary/vocabulary.csv");

	public Map<String, String> getVocabulary() {
		Translation t = new Translation();
		String[] lines = null;
		String line = "";

		try (Scanner sc = new Scanner(vocabulary)) {
			for (; sc.hasNextLine();) {
				line = line + sc.nextLine() + System.lineSeparator();
				
			}
			lines = line.split(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
		TreeMap<String, String> temp = t.fromCSV(lines);
		return temp;
	}

	public void save(Translation dic) {
		Translation tr = new Translation();
		Set<Map.Entry<String, String>> pairs = dic.getDictionary().entrySet();

		try (PrintWriter pw = new PrintWriter(vocabulary)) {
			for (Entry<String, String> p : pairs) {
				pw.println(tr.toCSV(p));
			}
			// line = line + p.getKey() + ";" + p.getValue() + System.lineSeparator();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
