import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.readString;


public class ReadWriteTextFileNIO {
	static Scanner scanner = new Scanner(System.in);//работа с консолью

	public static void writeFilesTxtString(Path path, String text) {
		try {
			Files.writeString(path, text, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeNewTextFile(String creationInTextNewFile) {
		System.out.print("-------------------------------------------------------\n" +
				"Введите путь и имя к файлу в который будет сохранен текст:\n");

		while (true) {
			String pathToTheFile;
			while ((pathToTheFile = scanner.nextLine()).equals("")) {
				System.out.print("");
			}
			if (!Files.exists(Path.of(pathToTheFile.replaceAll(" ", "")))) {
				Path path = Path.of(pathToTheFile.replaceAll(" ", ""));
				writeFilesTxtString(Path.of(pathToTheFile.replaceAll(" ", "")),
						creationInTextNewFile);
				System.out.println("---------------------------------------------------\n" +
						"Файл \"" + path.getFileName() + "\"успешно создан.\n" +
						"Путь к файлу: " + path.toAbsolutePath().getParent() + "\\" + path.getFileName()
						+ "\n-------------------------------------------------------");
				break;
			}

			if (Files.exists(Path.of(pathToTheFile.replaceAll(" ", "")))) {
				System.out.print("-------------------------------------------------------\n" +
						"Файл уже существует\n" +
						"Перезаписать файл, нажмите - \"1\"\n" +
						"Создать новый файл, нажмите - \"0\"\n");
				int command;
				while (true) {
					if (scanner.hasNextInt()) {
						command = scanner.nextInt();
						if (command >= 0 && command <= 1) {
							break;
						} else System.out.println("-------------------------------------------------------\n" +
								"\"Введите числа из списка действий - \"1\" или \"2 \".\n" +
								"Перезаписать файл, нажмите - \"1\"\n" +
								"Создать новый файл, нажмите - \"0\"\n");
					} else {
						System.out.println("\"Некорректный ввод.\n" +
								"Ожидается ввод числа по номеру опций из списка\"." +
								"\n-------------------------------------------------------");
						scanner.next();
					}
				}
				switch (command) {
					case 1:
						Path path = Path.of(pathToTheFile.replaceAll(" ", ""));
						writeFilesTxtString(Path.of(pathToTheFile.replaceAll(" ", "")),
								creationInTextNewFile);
						System.out.println("-------------------------------------------------------\n" +
								"Файл \"" + path.getFileName() + "\" успешно перезаписан.\n" +
								"Путь к файлу: " + path.toAbsolutePath().getParent() + "\\" + path.getFileName() +
								"\n-------------------------------------------------------");
						break;
					case 0:
						System.out.print("-------------------------------------------------------\n" +
								"Введите новый путь и новое имя к файлу:\n");
						scanner.nextLine();
						continue;
				}
				break;
			} else
				System.out.println("Путь задан не правильно\n" +
						"Проверьте правильность написания пути или имя файла и его расширение");

		}
	}


	public static String readSourceTxtFile() {
		String sourceTxtFile;

		System.out.println("Введите путь и имя к текстовому файлу, из которого будет взят текст");
		String sourceFilePath;


		while (true) {
			while ((sourceFilePath = scanner.nextLine()).equals("")) {
				System.out.print("");
			}
			if (Files.exists(Path.of(sourceFilePath.replaceAll(" ", "")))) {
				try {
					sourceTxtFile = readString(Path.of(sourceFilePath.replaceAll(" ", "")),
							StandardCharsets.UTF_8);
					//scanner.close();
					break;
				} catch (IOException e) {
					System.out.print("Файл не найден!\n" +
							"Проверьте правильность путь к файлу и его имя\n" +
							"Введите правильный путь и имя, к файлу\n" +
							"---------------------------------------------------------------\n" +
							"Введите путь и имя к файлу, из которого будет взят исходный текст\n");
				}
			} else System.out.println("Файл не найден!\n" +
					"Проверьте правильность путь к файлу и его имя\n" +
					"Введите правильный путь и имя, к файлу\n" +
					"---------------------------------------------------------------");
		}
		return sourceTxtFile;
	}
}



