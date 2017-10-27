package HW7;

import java.util.HashMap;
import java.util.Scanner;

public class MCP {

	public static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		int numberOfMatrix = Integer.parseInt(scan.nextLine());
		
		HashMap<String, int[]> map = new HashMap<String, int[]>();

		for (int i = 0; i < numberOfMatrix; i++) {
			String s = scan.nextLine();
			String[] strarr = s.split(" |(\t)|(,)");
			int[] size = new int[2];
			size[0] = Integer.parseInt(strarr[1]);
			size[1] = Integer.parseInt(strarr[2]);	
			map.put(strarr[0], size);
		}

	

		
		String s = scan.nextLine();
		//while(scan.hasNext()){
		while (s.length() != 0) {
		//	System.out.println("error");
			int flag = 1;
					
			if (s.length() == 1) {
				System.out.println(0);
				flag = 0;
			} else {
				stack stk = new stack();
				int total = 0;
				
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != ')') {
						stk.push(s.substring(i, i + 1));
						// System.out.println(stk.getTop());
					} else {
						if(stk.empty()){
							System.out.println("error");
							flag = -1;
							break;
						}
						String c = stk.pop();

						stack output = new stack();
						
						while (!c.equals("(") && (!stk.empty())) {
							output.push(c);
							c = stk.pop();
						}
						if(output.getTop()!=1){
							System.out.println("error");
							flag = -1;
							break;
						}
						int index_a = 0;
						int[] a = new int[10];
						String newstr = "";
						while (!output.empty()) {
							String out = output.pop();
							newstr = newstr + out;
							//System.out.println(out);
							if(map.get(out) == null){
								System.out.println("error");
								flag = -1;
								break;
							}
							a[index_a++] = map.get(out)[0];
							a[index_a++] = map.get(out)[1];

						}
						if(flag==-1)
							break;
						if (a[1] == a[2]) {
							int[] k = new int[2];
							k[0] = a[0];
							k[1] = a[index_a - 1];
							map.put(newstr, k);
							stk.push(newstr);
							total = total + a[0] * a[1] * a[index_a - 1];
						} else {
							System.out.println("error");
							flag = -1;
							break;
						}

					}
				}
				if(flag==1)
					System.out.println(total);

			}
			s = scan.nextLine();
		}
	}

}
