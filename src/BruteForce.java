import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.readString;

public class BruteForce {
	public static int alphabetRusLetters = 33;
	static Scanner scanner = new Scanner(System.in);//работа с консолью
	public static void bruteForceKeysLoopCaesar() {
		System.out.print("Введите имя папки для файлов перебора методом Brute Force:\n");

		String packageBruteForce;
		while ((packageBruteForce = scanner.nextLine()).equals("")) {
			System.out.println("Пустая строка! Название папки не может быть пустой строкой или пробелом\n" +
					"Проверьте правильность написания папки" +
					"\n-------------------------------------------------------" +
					"\nВведите имя папки для файлов перебора методом Brute Force:");
		}
		System.out.print("-------------------------------------------------------\n" +
				"Введите путь и имя к ЗАШИФРОВАННОМУ файлу:\n");

		while (true) {
			Path creationAfterCaesar;
			String pathToTheFile;
			while ((pathToTheFile = scanner.nextLine()).equals("")) {
				System.out.print("");
			}
			if (Files.exists(Path.of(pathToTheFile.replaceAll(" ", "")))&&
					pathToTheFile.toLowerCase().endsWith(".txt")) {
				creationAfterCaesar = Path.of(pathToTheFile.replaceAll(" ", ""));
				Path dir = Path.of(Paths.get(creationAfterCaesar.toFile().getAbsolutePath()).getParent() + "\\" +
						packageBruteForce.replaceAll(" ", ""));
				try {
					String stringToBrForceOutFileTXT = readString(creationAfterCaesar, StandardCharsets.UTF_8);
					String newDirForFile = "";
					if (Files.exists(dir)) {
						for (int key = 1; key <= alphabetRusLetters; key++) {

							newDirForFile = dir.toString() + "\\Brute-Force_Key_" + key + ".txt";
							Files.writeString(Path.of(newDirForFile), Caesar.decryptionTextFile(key,
									stringToBrForceOutFileTXT));
						}
						System.out.println("Файлы с перебором ключей по алфавиту, созданы в папку \"" +
								packageBruteForce.replaceAll(" ", "") + "\"\nпо пути: " + dir);
						System.out.println(newDirForFile);
						break;
					} else {

						Files.createDirectory(dir);
						for (int key = 1; key <= alphabetRusLetters; key++) {
							newDirForFile = dir.toString() + "\\Brute-Force_Key_" + key + ".txt";
							Files.writeString(Path.of(newDirForFile), Caesar.decryptionTextFile(key,
									stringToBrForceOutFileTXT));
						}
						System.out.println("Файлы методом Brute Force созданы и записаны в папку:\n\"" +
								packageBruteForce + "\"\nпо пути: " + dir);
						System.out.println(newDirForFile);
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else
				System.out.println("Путь задан не правильно\n" +
						"Проверьте правильность написания пути или имя файла и его расширение" +
						"\n-------------------------------------------------------" +
						"\nВведите путь и имя к ЗАШИФРОВАННОМУ файлу:");
		}
	}
}
