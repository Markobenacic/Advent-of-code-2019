package marko.benacic.day1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("day1_captcha.txt");
		
		int sum = 0;
		
		Scanner sc = new Scanner(path);
		
		while(sc.hasNext()) {
			int module = Integer.parseInt(sc.next()) / 3 - 2;
			
			while(module > 0) {
				sum += module;
				module = module/3 - 2;
			}
		}
		
		System.out.println(sum);
	}

}
