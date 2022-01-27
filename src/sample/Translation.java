package sample;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.parser.Entity;

public class Translation {

	private Map<String, String> dictionary = new TreeMap<>();

	public Translation(Map<String, String> dictionary) {
		super();
		this.dictionary = dictionary;
	}

	public Translation() {
		super();
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	public void addWord() {
		String k = "";
		String v = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть слово:");
		k = sc.nextLine();
		System.out.println("Введіть переклад:");
		v = sc.nextLine();
		if (!k.equals("")) {
			this.dictionary.put(k, v);
		}
	}

	public String toCSV(Entry<String, String> p) {
		String line = "";

		line = line + p.getKey() + ";" + p.getValue();

		return line;

	}

	public TreeMap<String, String> fromCSV(String[] elements) {
		String[] element = null;
		TreeMap<String, String> temp = new TreeMap<>();
		for (int i = 0; i < elements.length; i++) {
			element = elements[i].split(";");
			temp.put(element[0], element[1]);

		}
		return temp;
	}

	@Override
	public String toString() {
		return "Translation [dictionary=" + dictionary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dictionary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Translation other = (Translation) obj;
		return Objects.equals(dictionary, other.dictionary);
	}

}
