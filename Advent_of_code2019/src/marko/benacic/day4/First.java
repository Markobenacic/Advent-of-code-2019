package marko.benacic.day4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class First {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("day4_captcha.txt");
		Scanner sc = new Scanner(path);
		
		String[] input = sc.next().split("-");
		
		long beg = Long.parseLong(input[0]);
		long end = Long.parseLong(input[1]);
		
		long legitPasswords = 0;
		long counter = 0;
		
		System.out.println(beg);
		System.out.println(end);
		
		for(long number = beg;number <= end; number++) {
			boolean hasDoubleDigit = false;
			boolean isEqualsOrIncreasing = true;
			
			long[] digits = new long[6];
			long number2 = number;
			
			for(int i = 5; i >= 0; i--) {
				digits[i] = number2 % 10;
				number2 /= 10;
			}
			
			for(int i = 0; i < 5; i++) {
				if(digits[i] == digits[i+1]) {
					hasDoubleDigit = true;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				for(int j = i; j < 6; j++) {
					if(digits[i] > digits[j]) {
						isEqualsOrIncreasing = false;
					}
				}
			}
			
			if(hasDoubleDigit && isEqualsOrIncreasing) {
				legitPasswords++;
			}
			System.out.println(counter++);
		}
		
		System.out.println(legitPasswords);

	}

}
