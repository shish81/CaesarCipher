import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordsAnalysisTxt {
	public static void textAnalysis() {
		Scanner sc = new Scanner(System.in);
		int alphabetRusLettersKey = 33;
		String regularForSplit = "[^а-яА-Я]+";
		System.out.println("Выберете текстовый файл, который будет взят и преобразован в набор множества слов");
		String[] wordsArray = ReadWriteTextFileNIO.readSourceTxtFile().toLowerCase().split(regularForSplit);
		Set<String> words = new HashSet<>(Arrays.asList(wordsArray));
		System.out.println("Выберете зашифрованный текстовый файл, который будет анализироваться");
		String stringFileCaesar = ReadWriteTextFileNIO.readSourceTxtFile();
		Set<String> setWordsToCaesarText = new HashSet<>(); //= 	setStringsOfText(stringFileCaesar);
		System.out.println("""
				-------------------------------------------------------------------------------------------
				Введите число случайных слов, найденных при анализе в шифре, которые не будут учитываться
				""");
		int numberOfRandomWords;
		while (true) {
			if (sc.hasNextInt()) {
				numberOfRandomWords = sc.nextInt();
				break;

			} else {
				System.out.println("""
						"Некорректный ввод.
						Ожидается ввод целого числа ".
						-------------------------------------------------------------------------------------------
						Введите число случайных слов, найденных при анализе в шифре, которые не будут учитываться""");
				sc.next();
			}
		}
		System.out.println("""

				---------------------------------------------------------------------------
				Найдено множество похожих слов, исходя из текста взятого за основу слов:""");
		int key;
		int printKey = 0;
		int printCountWord = 0;
		for (key = 1; key < alphabetRusLettersKey; key++) {
			setWordsToCaesarText.clear();

			int tmp = 0;
			String[] wordsCaesarText = Caesar.decryptionTextFile(key, stringFileCaesar).split(regularForSplit);
			for (String s : wordsCaesarText) {
				for (String e : words) {
					if (s.equals(e) && s.length() > 2) {
						setWordsToCaesarText.add(s);
						//equalsOfKey = key;
						tmp++;
						if (tmp > printCountWord) {
							printCountWord = tmp;
						}
						if (key > printKey) {
							printKey = key;
						}
					}
				}
			}
			if (tmp > numberOfRandomWords) {
				System.out.printf("По ключу = %d\n", key);
				System.out.println("Найдено похожи слов = " + setWordsToCaesarText);
				System.out.println("Количество слов = " + setWordsToCaesarText.size());
				System.out.println("--------------------------------------------------");
			}
		}

		System.out.print("--------------------------------------------------\n" +
				"Исходя их анализа, больше всего, сходства есть по ключу - " + printKey + "\n");
	}

}

