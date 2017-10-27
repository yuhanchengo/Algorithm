package HW5;

import java.util.HashMap;
import java.util.Scanner;

public class huffman {
	public static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		String input = scan.next();
		
		//long start = System.currentTimeMillis();
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		for (int c = 0; c < input.length(); c++) {
			if (h.containsKey("" + input.charAt(c))) {
				h.replace("" + input.charAt(c), h.get("" + input.charAt(c)), h.get(("" + input.charAt(c))) + 1);
			} else {
				h.put("" + input.charAt(c), 1);
			}
		}
		for(String s:h.keySet()){
			System.out.println(s + " " + h.get(s));
		}
		//System.out.println("here");
		//System.out.println("finish hashMap "+ (System.currentTimeMillis() - start));
		int hashSize = h.size();
		returnObj o;
		o = findMin(h);
		//System.out.println(o.getReturnString()+" "+o.getReturnFreq());
		Node root = new Node(o.getReturnString(), o.getReturnFreq(), null, null);
		Node left = null;
		Node right = null;
		while (root.getNodeInfo().length() != hashSize) {
			//System.out.println(root.getNodeInfo().length());
			returnObj robj = findMin(h);
			if (!robj.getReturnString().equals(root.getNodeInfo())) {
				if (robj.getReturnFreq() < root.getFreq()) {
					left = new Node(robj.getReturnString(), robj.getReturnFreq(), null, null);
					right = root;
				} else {
					right = new Node(robj.getReturnString(), robj.getReturnFreq(), null, null);
					left = root;
				}
				if (left != null && right != null) {
					//System.out.println("left: "+left.getNodeInfo() + "right: "+right.getNodeInfo());
					root = new Node(left.getNodeInfo() + right.getNodeInfo(), left.getFreq() + right.getFreq(), left,
							right);
					//System.out.println(root.getNodeInfo()+"!");
					h.put(left.getNodeInfo() + right.getNodeInfo(), left.getFreq() + right.getFreq());
					left = right = null;
				}
			} else {
				left = root;
			}

		}
		System.out.println("here");
		//System.out.println("create Tree "+ (System.currentTimeMillis() -start));
		printHuffmanCode(root, hashSize);
		//long end = System.currentTimeMillis();
		//System.out.println("end process " + (end-start));
	}

	public static void printHuffmanCode(Node trav, int length) {
		int outputNum = 0;
		String output = "";
		while (outputNum<length) {
			Node left = trav.getLeftNode();
			Node right = trav.getRightNode();
			if(left.getLeftNode()==null && left.getRightNode()==null && right.getLeftNode()==null&& right.getRightNode()==null){
				System.out.println(left.getNodeInfo()+":"+(output+"0"));
				System.out.println(right.getNodeInfo()+":"+(output+"1"));
				outputNum+=2;
			}else if (left.getLeftNode() == null && left.getRightNode() == null) {
				System.out.println(left.getNodeInfo() + ":" + (output + "0"));
				outputNum++;
				trav = right;
				output += "1";
			}else if (right.getLeftNode() == null && right.getRightNode() == null) {
				System.out.println(right.getNodeInfo() + ":" + (output + "1"));
				outputNum++;
				trav = left;
				output += "0";
			}

		}

	}

	public static returnObj findMin(HashMap<String, Integer> inputHash) {
		String min = "";
		int freq = 102;
		for (String ele : inputHash.keySet()) {
			if (inputHash.get(ele) < freq) {
				freq = inputHash.get(ele);
				min = ele;
			}
		}
		returnObj ro = new returnObj(min, freq);

		inputHash.remove(min);

		return ro;

	}
}

class returnObj {
	private String str = "";
	private int freq = 0;

	returnObj(String s, int f) {
		str = s;
		freq = f;
	}

	public String getReturnString() {
		return str;
	}

	public int getReturnFreq() {
		return freq;
	}
}


