import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		MenuCaesar.printHello();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			MenuCaesar.printMenu();
			int commandMenu;
			while (true) {
				try {
					if (scanner.hasNext()) {
						commandMenu = scanner.nextInt();
						if (commandMenu >= 0 && commandMenu <= 5) {
							break;
						} else {
							System.out.println("\"Некорректный ввод. Ожидается ввод числа по номеру опций из списка\"." +
									"\n-------------------------------------------------------");
							MenuCaesar.printMenu();
						}
					}
				} catch (InputMismatchException e) {
					System.out.println("\"Некорректный ввод. Ожидается ввод числа по номеру опций из списка\"." +
							"\n-------------------------------------------------------");
					MenuCaesar.printMenu();
					scanner.next();
				}
			}
			if (commandMenu == 1) {
				System.out.print("""
						-----------------------------------------------------------------------------
						Вы находитесь в пункте меню
						1 - Шифровка текстового файла по ключу
						-----------------------------------------------------------------------------
						""");
				String sourceText = ReadWriteTextFileNIO.readSourceTxtFile();
				System.out.println("Введите Ключ-Цифру от 1 до 32");
				int keyIn;
				while (true) {
					try {
						if (scanner.hasNext()) {
							keyIn = scanner.nextInt();
							if (keyIn > 0 && keyIn < 33) {
								break;
							} else {
								System.out.println("\"Некорректный ввод. Ожидается ввод числа от 1 до 32\"." +
										"\n-------------------------------------------------------");
							}
						}
					} catch (InputMismatchException e) {
						System.out.println("\"Некорректный ввод. Ожидается ввод числа от 1 до 33\"." +
								"\n-------------------------------------------------------");
						scanner.next();
					}
				}
				String encryptionText = Caesar.encryptionTextFile(keyIn, sourceText);
				ReadWriteTextFileNIO.writeNewTextFile(encryptionText);
			}
			if (commandMenu == 2) {
				System.out.print("""
						-----------------------------------------------------------------------------
						Вы находитесь в пункте меню
						2 - Расшифровка текстового файла по заданному ключу
						-----------------------------------------------------------------------------
						""");
				int keyIn;

				System.out.println("Выберете текстовый файл для расшифровки");
				String sourceText = ReadWriteTextFileNIO.readSourceTxtFile();
				System.out.println("Введите Ключ-Цифру от 1 до 32");
				while (true) {
					try {
						if (scanner.hasNext()) {
							keyIn = scanner.nextInt();
							if (keyIn > 0 && keyIn < 33) {
								break;
							} else {
								System.out.println("\"Некорректный ввод. Ожидается ввод числа от 1 до 32\"." +
										"\n-------------------------------------------------------");
							}
						}
					} catch (InputMismatchException e) {
						System.out.println("\"Некорректный ввод. Ожидается ввод числа от 1 до 32\"." +
								"\n-------------------------------------------------------");
						scanner.next();
					}
				}
				String encryptionText = Caesar.decryptionTextFile(keyIn, sourceText);
				System.out.println("Создан текст, путем расшифровки по заданному ключу.\n" +
						"Требуется сохранить данный текст в  файл c расширением - \".txt\" ");
				ReadWriteTextFileNIO.writeNewTextFile(encryptionText);
			}
			if (commandMenu == 3) {
				System.out.print("""
						-----------------------------------------------------------------------------
						Вы находитесь в пункте меню:
						3 - Расшифровка методом -Brute Force- путем Перебора ключей по алфавиту,
						    с созданием файлов, с номерами ключей в названии файла
						-----------------------------------------------------------------------------
						""");
				BruteForce.bruteForceKeysLoopCaesar();
			}
			if (commandMenu == 4) {
				System.out.print("""
						-----------------------------------------------------------------------------
						Вы находитесь в пункте меню:
						4 - Сравнение и поиск схожих слов, в зашифрованном  тексте, с текстовым файлом, 
						выбранного пользователем.
						-----------------------------------------------------------------------------
						""");
				WordsAnalysisTxt.textAnalysis();
			}
			if (commandMenu == 0) {
				break;
			}
		}
		scanner.close();
	}
}
