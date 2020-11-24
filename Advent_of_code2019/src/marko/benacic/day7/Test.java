package marko.benacic.day7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException{
		
		Path path = Paths.get("day7_captcha.txt");
		Scanner sc = new Scanner(path);
		
		
		ArrayList<Long> arr = new ArrayList<Long>();
		
		String s = sc.next();
		
		String[] str = s.split(",");
		
		for(int i = 0; i < str.length; i++) {
			arr.add(Long.parseLong(str[i]));
		}
		
		ArrayList<Long> arr2 = arrInit(arr);
		
		arr2.replaceAll(x -> x + 1);
		
		System.out.println(arr);
		
		System.out.println();
		System.out.println();
		
		System.out.println(arr2);
	}
	
	
	public static ArrayList<Long> arrInit(ArrayList<Long> array) {
		ArrayList<Long> arr2 = new ArrayList<Long>();
		
		for(int i = 0; i < array.size(); i++) {
			arr2.add(Long.valueOf(array.get(i)));
		}
		return arr2;
	}
}
