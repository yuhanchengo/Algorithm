package hw8;
import java.util.HashMap;
import java.util.Scanner;

public class multiStage {
	public static Scanner scan;
	public static HashMap<Character, Integer> d;
	public static HashMap<Character, Integer> id;
	public static HashMap<Integer,Character> invId;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		d = new HashMap<Character, Integer>();
		id = new HashMap<Character,Integer>();
		invId = new HashMap<Integer, Character>();
		int stageNum = scan.nextInt();
		char sourceNode = '\0';


		for(int i=0; i<stageNum; i++){
			String line = scan.next();
			if(line.length() > 1){
				for(int j=0; j<line.length(); j++){
					d.put(line.charAt(j), 1000000);
				}
			}else{
				d.put(line.charAt(line.length()-1), 1000000);
			}
			if(i==stageNum-1){
				d.put(line.charAt(0), 0);
			}
			if(i==0){
				sourceNode = line.charAt(0);
			}

		}
		int i = 0;
		for(char c : d.keySet()){
			id.put(c, i);
			invId.put(i, c);
			i++;
		}
		int edgeNum = scan.nextInt();
		int[][] w = new int[d.size()-1][d.size()];
		for(int j = 0; j<d.size()-1; j++){
			for(int k = 0; k<d.size(); k++){
				w[j][k] = -1;
			}
		}
		for(i=0 ;i<edgeNum; i++){
			String line = scan.next();
			String[] s =line.split(":");
			char start = s[0].charAt(0);
			char end = s[0].charAt(1);
			int weight = Integer.parseInt(s[1]);
			w[id.get(start)][id.get(end)] = weight;
		}

//		for(int j = 0; j<d.size()-1; j++){
//			for(int k = 0; k<d.size(); k++){
//				System.out.print(w[j][k]+" ");
//			}
//			System.out.println();
//		}

		for(int j = d.size()-2; j>=0; j--){
			for(int k =0; k<d.size(); k++){
				if(w[j][k]!=-1){
					char s = invId.get(j);
					char e = invId.get(k);
					int weight = w[j][k] + d.get(e);
					if(d.get(s) > weight){
						d.replace(s, weight);
					}
				}
			}
//			for(char c:d.keySet()){
//				System.out.print(c + ":" + d.get(c)+ " ");
//			}
//			System.out.println();
		}
		System.out.println(d.get(sourceNode));

	}

}
