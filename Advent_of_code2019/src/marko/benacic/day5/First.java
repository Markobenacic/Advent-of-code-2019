package marko.benacic.day5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class First {

	public static int PARAMETER_MODE = 0;
	public static int IMMEDIATE_MODE = 1;
	
	public static int MULTIPLICATION = 2;
	public static int ADDITION = 1;
	public static int INPUT = 3;
	public static int OUTPUT = 4;
	
	public static void main(String[] args) throws IOException{
		Path path = Paths.get("day5_captcha.txt");
		Scanner sc = new Scanner(path);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		String s = sc.next();
		
		String[] str = s.split(",");
		
		for(int i = 0; i < str.length; i++) {
			arr.add(Integer.parseInt(str[i]));
		}
		
		int input = 1;
		
		
		int pointer = 0;
		int pointerIncrement = 4;
		
		while(arr.get(pointer) != 99) {
			
			int opcodeAndModes = arr.get(pointer);
			int opcode = opcodeAndModes % 10; 
			int modes[];
			
			
			
			
			
			if(opcode == 1) {
				int x = opcodeAndModes / 100;
				modes = new int[3];
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				x /= 10;
				modes[2] = x % 10;
				
				int a = modes[0] == 1 ? arr.get(pointer + 1) : arr.get(arr.get(pointer + 1));
				int b = modes[1] == 1 ? arr.get(pointer + 2) : arr.get(arr.get(pointer + 2));
				int dest = arr.get(pointer + 3);
				
				arr.set(dest, a + b);
				
				pointerIncrement = 4;
				
			}else if (opcode == 2) {
				int x = opcodeAndModes / 100;
				modes = new int[3];
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				x /= 10;
				modes[2] = x % 10;
				
				int a = modes[0] == 1 ? arr.get(pointer + 1) : arr.get(arr.get(pointer + 1));
				int b = modes[1] == 1 ? arr.get(pointer + 2) : arr.get(arr.get(pointer + 2));
				int dest = arr.get(pointer + 3);
				
				arr.set(dest, a * b);
				
				pointerIncrement = 4;
			}else if(opcode == 3) {
				//input
				
				// mora bit u parameter mode
				modes = new int[1];
				modes[0] = 0;
				int address = arr.get(pointer +1);
				
				arr.set(address, input);
				
				pointerIncrement = 2;
				
			}else if(opcode == 4) {
				//output
				
				//isto mora bit u parameter mode
				modes = new int[1];
				modes[0] = 0;
				int address = arr.get(pointer + 1);
				System.out.println(arr.get(address));
				
				pointerIncrement = 2;
				
			}else {
				System.out.println("unknown opcode");
				break;
			}
			pointer += pointerIncrement;
		}

	}
	
	public static int[] getParameterModes(int opcode) {
		
		ArrayList<Integer> parameterModes = new ArrayList<Integer>();
		return new int[0];
	}
	
	public static int getOpcode(int opcode) {
		return opcode % 10;
	}
}
