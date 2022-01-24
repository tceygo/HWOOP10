package sample;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileStoreg file = new FileStoreg();

		
		Translation enUa = new Translation(file.getVocabulary());
		String[] text = null;

		File eng = new File("English/English.in");
		String result = "";
		try (Scanner sc = new Scanner(eng)) {
			result = sc.nextLine();
			text = result.split(" ");
			for (int i = 0; i < text.length; i++) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		File ua = new File("Ukraine/Ukrainian.out");
		try (PrintWriter pw = new PrintWriter(ua)) {
			for(int i = 0; i < text.length; i++) {
				if(enUa.dictionary.get(text[i])!= null) {
					pw.print(enUa.dictionary.get(text[i]));
				} else {
					pw.print(text[i]);
				}
				if(i!= text.length - 1) {
					pw.print(" ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		enUa.addWord();
		
		file.save(enUa);
		
	}

}
