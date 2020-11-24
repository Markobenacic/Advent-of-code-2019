package marko.benacic.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class First {
	
	public static int WIDTH = 25;
	public static int LENGTH = 6;
	public static int LAYER_SIZE = WIDTH * LENGTH;
	
	public static void main(String[] args) throws IOException{
		
		ArrayList<Character> arr = new ArrayList<Character>();
		
		FileReader fr = new FileReader(new File("day8_captcha.txt"));
		
		BufferedReader br = new BufferedReader(fr);
		
		int c = 0;
		
		while((c = br.read()) != -1) {
			char character = (char) c;
			arr.add(character);
		}
		
		System.out.println(arr.size());
		System.out.println(LAYER_SIZE);
		
		
		
		int numOfLayers = arr.size() / LAYER_SIZE;
		
		System.out.println(numOfLayers*LAYER_SIZE);
		
		int[] numOfZeros = new int[numOfLayers];
		
		for(int i = 0; i < numOfLayers; i++) {
			for(int j = 0 ; j < LAYER_SIZE ; j++) {
				if(arr.get(i*LAYER_SIZE + j) == '0') {
					numOfZeros[i]++;
				}
			}
		}
		
		int redniBrLayera = 0;
		for(int i = 0; i < numOfLayers; i++) {
			if(numOfZeros[i] < numOfZeros[redniBrLayera]) {
				redniBrLayera = i;
			}
		}
		
		int numOfOne = 0;
		int numOfTwo = 0;
		
		for(int i = 0; i < LAYER_SIZE;i++) {
			if(arr.get(redniBrLayera * LAYER_SIZE + i) == '1') {
				numOfOne++;
			}else if (arr.get(redniBrLayera * LAYER_SIZE + i) == '2') {
				numOfTwo++;
			}
		}
		
		System.out.println(numOfOne * numOfTwo);
	}
}
