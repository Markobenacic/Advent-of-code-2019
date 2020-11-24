package marko.benacic.day7;

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
		Path path = Paths.get("day7_captcha.txt");
		Scanner sc = new Scanner(path);
		
		
		ArrayList<Long> arr = new ArrayList<Long>();
		
		String s = sc.next();
		
		String[] str = s.split(",");
		
		for(int i = 0; i < str.length; i++) {
			arr.add(Long.parseLong(str[i]));
		}
		
		long settingA = 0;
		long settingB = 0;
		long settingC = 0;
		long settingD = 0;
		long settingE = 0;
		
		long maxOutput = 0;
		
		
		Amplifier ampA = null;
		Amplifier ampB = null;
		Amplifier ampC;
		Amplifier ampD;
		Amplifier ampE;
		
		
		
		
		outerloop:
		for(long i = 0; i < 5; i++) {
			for(long j = 0; j < 5; j++) {
				if(i != j) {
					for(long k = 0; k < 5; k++) {
						if(j != k && i != k) {
							for(long l = 0; l < 5; l++) {
								if(i != l && j != l && k != l) {
									for(long m = 0; m < 5; m++) {
										if(i != m && j != m && k != m&& l != m) {
											ampA = new Amplifier(arr,0,i);
											long outputA = ampA.run();
											ampB = new Amplifier(arr, outputA, j);
											long outputB = ampB.run();
											ampC = new Amplifier(arr, outputB, k);
											long outputC = ampC.run();
											ampD = new Amplifier(arr, outputC, l);
											long outputD = ampD.run();
											ampE = new Amplifier(arr, outputD, m);
											long outputE = ampE.run();
											long output = outputE;
											if(output > maxOutput) {
												maxOutput = output;
												settingA = i;
												settingB = j;
												settingC = k;
												settingD = l;
												settingE = m;
										}
										
										}
									}
								}
								
							}
						}
						
					}
				}
				
			}
		}
		
		System.out.println("settings " + settingA + " " + settingB + " " + settingC + " " + settingD + " " + settingE);
		System.out.println(maxOutput);
		
		
		
	}

}
