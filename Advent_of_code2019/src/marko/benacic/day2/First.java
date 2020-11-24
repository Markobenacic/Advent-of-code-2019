package marko.benacic.day2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class First {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("day2_captcha.txt");
		Scanner sc = new Scanner(path);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		String s = sc.next();
		
		String[] str = s.split(",");
		
		for(int i = 0; i < str.length; i++) {
			arr.add(Integer.parseInt(str[i]));
		}
		
		arr.set(1, 12);
		arr.set(2,2);
		
		int pointer = 0;
		
		while(arr.get(pointer) != 99) {
			if(arr.get(pointer) == 1) {
				int a = arr.get(arr.get(pointer + 1) );
				int b = arr.get(arr.get(pointer + 2) );
				int dest = arr.get(pointer + 3);
				arr.set(dest , a + b);
			}else if (arr.get(pointer) == 2) {
				int a = arr.get(arr.get(pointer + 1) );
				int b = arr.get(arr.get(pointer + 2) );
				int dest = arr.get(pointer + 3);
				arr.set(dest , a * b);
			}else {
				System.out.println("unknown opcode");
				break;
			}
			pointer += 4;
		}
		
		System.out.println("value at position 0: " + arr.get(0));
		System.out.println(arr);
		
	}

}
