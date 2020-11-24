package marko.benacic.day7;

import java.util.ArrayList;

public class Amplifier {
	
	public ArrayList<Long> arr;
	private long input;
	private long phaseSetting;
	
	public Amplifier(ArrayList<Long> array, long input, long phaseSetting) {
		this.input = input;
		this.phaseSetting = phaseSetting;
		
		this.arr = arrInit(array);
	}
	
	public static ArrayList<Long> arrInit(ArrayList<Long> array) {
		ArrayList<Long> arr2 = new ArrayList<Long>();
		
		for(int i = 0; i < array.size(); i++) {
			arr2.add(Long.valueOf(array.get(i)));
		}
		return arr2;
	}
	
	
	
	public long run() {
		
		long output = 0;
		
		boolean firstInput = true;
		
		
		
		
		
		long pointer = 0;
		long pointerIncrement = 4;
		
		while(arr.get((int)(long)pointer) != 99) {
			
			long opcodeAndModes = arr.get((int)(long)pointer);
			long opcode = opcodeAndModes % 10; 
			long modes[];
			
			
			
			
			
			if(opcode == 1) {
				long x = opcodeAndModes / 100;
				modes = new long[3];
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				x /= 10;
				modes[2] = x % 10;
				
				long a = modes[0] == 1 ? arr.get((int)(long)pointer + 1) : arr.get((int)(long)arr.get((int)(long)pointer + 1));
				long b = modes[1] == 1 ? arr.get((int)(long)pointer + 2) : arr.get((int)(long)arr.get((int)(long)pointer + 2));
				long dest = arr.get((int)(long)pointer + 3);
				
				arr.set((int)dest, a + b);
				
				pointerIncrement = 4;
				
			}else if (opcode == 2) {
				long x = opcodeAndModes / 100;
				modes = new long[3];
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				x /= 10;
				modes[2] = x % 10;
				
				long a = modes[0] == 1 ? arr.get((int)(long)pointer + 1) : arr.get((int)(long)arr.get((int)(long)pointer + 1));
				long b = modes[1] == 1 ? arr.get((int)(long)pointer + 2) : arr.get((int)(long)arr.get((int)(long)pointer + 2));
				long dest = arr.get((int)(long)pointer + 3);
				
				arr.set((int)dest, a * b);
				
				pointerIncrement = 4;
			}else if(opcode == 3) {
				//input
				
				// mora bit u parameter mode
				
				
				if(firstInput == true) {
					firstInput = false;
					
					modes = new long[1];
					modes[0] = 0;
					long address = arr.get((int)(long)pointer +1);
					
					arr.set((int)address, phaseSetting);
					
					pointerIncrement = 2;
					
				}else {
					modes = new long[1];
					modes[0] = 0;
					long address = arr.get((int)(long)pointer +1);
					
					arr.set((int)address, input);
					
					pointerIncrement = 2;
				}
				
				
				
			}else if(opcode == 4) {
				//output
				
				//isto mora bit u parameter mode
				modes = new long[1];
				modes[0] = 0;
				long address = arr.get((int)(long)pointer + 1);
				System.out.println(arr.get((int)address));
				output = arr.get((int)address);
				
				
				
				pointerIncrement = 2;
				
			}else if(opcode == 5){
				modes = new long[2];
				long x = opcodeAndModes / 100;
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				
				long a = modes[0] == 1 ? arr.get((int)(long)pointer + 1) : arr.get((int)(long)arr.get((int)(long)pointer + 1));
				long b = modes[1] == 1 ? arr.get((int)(long)pointer + 2) : arr.get((int)(long)arr.get((int)(long)pointer + 2));
				
				if(a != 0) {
					pointer = b;
					pointerIncrement = 0;
				}else {
					pointerIncrement = 3;
				}
			}else if(opcode == 6) {
				modes = new long[2];
				long x = opcodeAndModes / 100;
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				
				long a = modes[0] == 1 ? arr.get((int)(long)pointer + 1) : arr.get((int)(long)arr.get((int)(long)pointer + 1));
				long b = modes[1] == 1 ? arr.get((int)(long)pointer + 2) : arr.get((int)(long)arr.get((int)(long)pointer + 2));
				
				if(a == 0) {
					pointer = b;
					pointerIncrement = 0;
				}else {
					pointerIncrement = 3;
				}
			}else if(opcode == 7) {
				modes = new long[3];
				long x = opcodeAndModes / 100;
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				x /= 10;
				modes[2] = x % 10;
				
				long a = modes[0] == 1 ? arr.get((int)(long)pointer + 1) : arr.get((int)(long)arr.get((int)(long)pointer + 1));
				long b = modes[1] == 1 ? arr.get((int)(long)pointer + 2) : arr.get((int)(long)arr.get((int)(long)pointer + 2));
				long dest = arr.get((int)(long)pointer + 3);
				
				if(a < b) {
					arr.set((int)dest, (long)1);
				}else {
					arr.set((int)dest, (long)0);
				}
				
				pointerIncrement = 4;
				
			}else if(opcode == 8) {
				modes = new long[3];
				long x = opcodeAndModes / 100;
				
				modes[0] = x % 10;
				x /= 10;
				modes[1] = x % 10;
				x /= 10;
				modes[2] = x % 10;
				
				long a = modes[0] == 1 ? arr.get((int)(long)pointer + 1) : arr.get((int)(long)arr.get((int)(long)pointer + 1));
				long b = modes[1] == 1 ? arr.get((int)(long)pointer + 2) : arr.get((int)(long)arr.get((int)(long)pointer + 2));
				long dest = arr.get((int)(long)pointer + 3);
				
				if(a == b) {
					arr.set((int)dest, (long)1);
				}else {
					arr.set((int)dest, (long)0);
				}
				
				pointerIncrement = 4;
			}
			else {
				System.out.println("unknown opcode");
				break;
			}
			pointer += pointerIncrement;
			
			
		}
		
		return output;
	}
}
