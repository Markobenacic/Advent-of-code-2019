package marko.benacic.day2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("day2_captcha.txt");
		Scanner sc = new Scanner(path);
		
		String s = sc.next();
		
		String[] str = s.split(",");
		
		int[] arr = new int[str.length];
		
		for(int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int realnoun = 120;
		int realverb = 120;
		
		outerloop:
		for(int noun = 0; noun < 100; noun++) {
			for(int verb = 0; verb < 100; verb++) {
				
				int[] arr2 = new int[str.length];
				for(int i = 0; i < str.length; i++) {
					arr2[i] = arr[i];
				}
				
				arr2[1] = noun;
				arr2[2] = verb;
				
				int pointer = 0;
				
				while(arr2[pointer] != 99) {
					if(arr2[pointer] == 1) {
						int a = arr2[arr2[pointer + 1]];
						int b = arr2[arr2[pointer + 2]];
						int dest = arr2[pointer + 3];
						arr2[dest] = a + b;
					}else if(arr2[pointer] == 2) {
						int a = arr2[arr2[pointer + 1]];
						int b = arr2[arr2[pointer + 2]];
						int dest = arr2[pointer + 3];
						arr2[dest] = a*b;
					}else {
						System.out.println("wrong opcode");
					}
					pointer+=4;
				}
				if(arr2[0] == 19690720) {
					realnoun = noun;
					realverb = verb;
					break outerloop;
				}
			}
		}
		System.out.println(realnoun + " " + realverb);
		
	}

}
