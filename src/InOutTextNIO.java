import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.*;

public class InOutTextNIO {


	public static void main(String[] args) {
		Path sourceFilePath = Path.of("Esenin.txt");
		Path creation = Path.of("ShifrEsenin.txt");
		//System.out.println(Files.exists(sourceFilePath));
		try {
			byte[] sourceFile = readAllBytes(sourceFilePath);
			String s = new String(sourceFile, StandardCharsets.UTF_8);
			char []ch =  s.toCharArray();
//			String s = Files.readString(sourceFilePath, StandardCharsets.UTF_8);
//			System.out.println("s = " + s);
			byte[] encryption = new byte[ch.length];
			for (int i = 0; i < encryption.length; i++) {
				encryption[i]=(byte)ch[i];
				System.out.print(encryption[i]);
			}
			write(creation,encryption);
			//write(creation,encryption);
			byte[] test = readAllBytes(sourceFilePath);
			String s2 = new String(sourceFile, StandardCharsets.UTF_8);
			System.out.println(s2 );

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

