package HW5;

public class Node {
	private String info;
	private Node left;
	private Node right;
	private int freq;

	Node() {
		this.info = "";
		this.left = null;
		this.right = null;
		this.freq = 0;
	}

	Node(String s, int freq, Node leftLeaf, Node rightLeaf) {
		info = s;
		this.freq = freq;
		left = leftLeaf;
		right = rightLeaf;
	}

	public String getNodeInfo() {
		return this.info;
	}

	public Node getLeftNode() {
		return this.left;
	}

	public Node getRightNode() {
		return this.right;
	}

	public int getFreq() {
		return this.freq;
	}

}
