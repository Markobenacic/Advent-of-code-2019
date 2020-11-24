package marko.benacic.day7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Second {

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
		
		
		Amplifier2 ampA;
		Amplifier2 ampB;
		Amplifier2 ampC;
		Amplifier2 ampD;
		Amplifier2 ampE;
		
		
		
		
		outerloop:
		for(long i = 5; i < 10; i++) {
			for(long j = 5; j < 10; j++) {
				if(i != j) {
					for(long k = 5; k < 10; k++) {
						if(j != k && i != k) {
							for(long l = 5; l < 10; l++) {
								if(i != l && j != l && k != l) {
									for(long m = 5; m < 10; m++) {
										if(i != m && j != m && k != m&& l != m) {
											ampA = new Amplifier2(arr,i);
											long outputA = ampA.run(0);
											ampB = new Amplifier2(arr, j);
											long outputB = ampB.run(outputA);
											ampC = new Amplifier2(arr, k);
											long outputC = ampC.run(outputB);
											ampD = new Amplifier2(arr, l);
											long outputD = ampD.run(outputC);
											ampE = new Amplifier2(arr, m);
											long outputE = ampE.run(outputD);
											long output = outputE;
											
											while(true) {
												outputA = ampA.run(output);
												outputB = ampB.run(outputA);
												outputC = ampC.run(outputB);
												outputD = ampD.run(outputC);
												outputE = ampE.run(outputD);
												if(outputE == output) {
													break;
												}else {
													output = outputE;
												}
												
											}
											
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
		System.out.println("maxoutput: " + maxOutput);
		
		
		
	}

}
