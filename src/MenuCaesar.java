public class MenuCaesar {
	public static void printHello() {
		System.out.print("""
							===================ШИФР ЦЕЗАРЯ===================
				-----Прототип приложения предназначена для шифрования текстового файла-----
				---------------------------------------------------------------------------
				В шифровании задействован русский алфавит (33 буквы) в кодировке -UTF 8, c знаками пунктуации
				Действия программы перечислены в меню\s
				""");

	}

	public static void printMenu() {
		System.out.println("""
				----------------------------------------------------------------------------------
				                   МЕНЮ ПРОГРАММЫ
				1 - Шифровка текстового файла по ключу
				2 - Расшифровка текстового файла по заданному ключу
				3 - Расшифровка методом -Brute Force- путем Перебора ключей по алфавиту,
				    с созданием файлов, с номерами ключей в названии файла
				4 - Сравнение шифра текста, с текстом оригинала или частичного текста, исходного файла
				0 - Завершение программы
				Выберите одно из действий пункта меню
				----------------------------------------------------------------------------------""");

	}


}
