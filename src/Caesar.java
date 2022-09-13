public class Caesar {
	private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
			'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
			'ъ', 'ы', 'ь', 'э', 'ю', 'я', '\n', ' ', '—', '.', ',', '«', '»', '\"', '(', ')', ':', '!',
			'?', '\u0000', '\r'};
	public static String alpht = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя —.,\n«»\"()\\:!?";

	protected static int keyVerification(int keyVerif) {
		if (keyVerif < 0) {
			keyVerif = Math.abs(keyVerif);
			return ALPHABET.length - keyVerif;
		} else if (keyVerif > ALPHABET.length) {
			keyVerif -= ALPHABET.length;
			return keyVerif;
		} else return keyVerif;
	}

	public static String encryptionTextFile(int key, String sourceText) {
		//	System.out.println(Caesar.ALPHABET.length);
		char[] sourceTextArray = sourceText.toLowerCase().toCharArray();
		char[] encryptionArray = new char[sourceTextArray.length];
		for (int sourceTextLoop = 0; sourceTextLoop < sourceTextArray.length; sourceTextLoop++) {
			for (int alphabetLoop = 0; alphabetLoop < ALPHABET.length; alphabetLoop++) {
				if (sourceTextArray[sourceTextLoop] == ALPHABET[alphabetLoop]) {
					encryptionArray[sourceTextLoop] = ALPHABET[(alphabetLoop + key) % ALPHABET.length];
				}
			}
		}
		return new String(encryptionArray);
	}


	public static String decryptionTextFile(int key, String encryptionText) {
		char[] encryptionTextArray = encryptionText.toCharArray();
		char[] decryptionTextFileArray = new char[encryptionTextArray.length];
		for (int encryptionTextLoop = 0; encryptionTextLoop < encryptionTextArray.length; encryptionTextLoop++) {
			for (int alphabetLoop = 0; alphabetLoop < ALPHABET.length; alphabetLoop++) {
				if (encryptionTextArray[encryptionTextLoop] == ALPHABET[alphabetLoop]) {
					if (alphabetLoop - key >= 0) {
						decryptionTextFileArray[encryptionTextLoop] = ALPHABET[alphabetLoop - key];
					}
					if (alphabetLoop - key < 0) {
						int math = Math.abs(alphabetLoop - key);
						decryptionTextFileArray[encryptionTextLoop] = ALPHABET[ALPHABET.length - math];
					}
				}
			}
		}
		return new String(decryptionTextFileArray);
	}
}

