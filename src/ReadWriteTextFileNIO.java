import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
		System.out.print("""
				-------------------------------------------------------
				Введите путь и имя к файлу в который будет сохранен текст:
				""");

		while (true) {
			String pathToTheFile;
			while ((pathToTheFile = scanner.nextLine()).equals("")) {
				System.out.print("");
			}
			if (!Files.exists(Path.of(pathToTheFile.replaceAll(" ", ""))) &&
					pathToTheFile.toLowerCase().endsWith(".txt")) {
				Path path = Path.of(pathToTheFile.replaceAll(" ", ""));
				writeFilesTxtString(Path.of(pathToTheFile.replaceAll(" ", "")),
						creationInTextNewFile);
				System.out.println("---------------------------------------------------\n" +
						"Файл \"" + path.getFileName() + "\"успешно создан.\n" +
						"Путь к файлу: " + path.toAbsolutePath().getParent() + "\\" + path.getFileName()
						+ "\n-------------------------------------------------------");
				break;
			}

			if (Files.exists(Path.of(pathToTheFile.replaceAll(" ", "")))
					&& pathToTheFile.toLowerCase().endsWith(".txt")) {
				System.out.print("""
						-------------------------------------------------------
						Файл уже существует
						Перезаписать файл, нажмите - "1"
						Создать новый файл, нажмите - "0"
						""");
				int command;
				while (true) {
					if (scanner.hasNextInt()) {
						command = scanner.nextInt();
						if (command >= 0 && command <= 1) {
							break;
						} else System.out.println("""
								-------------------------------------------------------
								"Введите числа из списка действий - "1" или "2 ".
								Перезаписать файл, нажмите - "1"
								Создать новый файл, нажмите - "0"
								""");
					} else {
						System.out.println("""
								"Некорректный ввод.
								Ожидается ввод числа по номеру опций из списка".
								-------------------------------------------------------""");
						scanner.next();
					}
				}
				switch (command) {
					case 1 -> {
						Path path = Path.of(pathToTheFile.replaceAll(" ", ""));
						writeFilesTxtString(Path.of(pathToTheFile.replaceAll(" ", "")),
								creationInTextNewFile);
						System.out.println("-------------------------------------------------------\n" +
								"Файл \"" + path.getFileName() + "\" успешно перезаписан.\n" +
								"Путь к файлу: " + path.toAbsolutePath().getParent() + "\\" + path.getFileName() +
								"\n-------------------------------------------------------");
					}
					case 0 -> {
						System.out.print("""
								-------------------------------------------------------
								Введите новый путь и новое имя к файлу:
								""");
						scanner.nextLine();
						continue;
					}
				}
				break;
			} else
				System.out.println("""
						Путь или имя с типом файла, заданы не правильно!
						Проверьте правильность написания пути или имя файла и его расширение""");

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
					System.out.print("""
							Файл не найден!
							Проверьте правильность путь к файлу и его имя
							Введите правильный путь и имя, к файлу
							---------------------------------------------------------------
							Введите путь и имя к файлу, из которого будет взят исходный текст
							""");
				}
			} else System.out.println("""
					Файл не найден!
					Проверьте правильность путь к файлу и его имя
					Введите правильный путь и имя, к файлу
					---------------------------------------------------------------""");
		}
		return sourceTxtFile;
	}
}



