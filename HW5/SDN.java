package HW5;

import java.util.ArrayList;
import java.util.Scanner;

public class SDN {
	public static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int verticesNum = scan.nextInt();
		vertices[] graph = new vertices[verticesNum + 1];

		int lineNum = scan.nextInt();

		int outputNum = scan.nextInt();
		for (int i = 1; i <= verticesNum; i++) {
			vertices temp = new vertices();
			temp.setDt(scan.nextInt());
			temp.setID(i);
			graph[i] = temp;
			System.out.println("i: " + i + " " + graph[i].getDelayTime());
		}

		for (int j = 0; j < lineNum; j++) {
			int start = 0;
			int end = 0;
			int edgeDelay = 0;

			start = scan.nextInt();
			end = scan.nextInt();
			edgeDelay = scan.nextInt();

			System.out.println("Start: " + start + " end: " + end + " edgeDelay: " + edgeDelay);
			vertice v = new vertice();
			v.setEDT(edgeDelay);
			v.setVertices(graph[end]);
			v.setID(end);
			graph[start].addList(v);
			vertice temp = new vertice();
			temp.setEDT(edgeDelay);
			temp.setVertices(graph[start]);
			temp.setID(start);
			graph[end].addList(temp);
		}
		
		for(int i =0; i<outputNum; i++){
			int start = scan.nextInt();
			int destination = scan.nextInt();
			int min = 100000;
			for(int k=0; k<graph[start].getListLength(); k++){
				vertice[] stack = new vertice[100];
				int top = -1;
				if(graph[start].getArrEleID(k)!=destination){
					stack[++top] = graph[start].getVertice(k);
				}else{
					
				}
			}
			
		}

	}
	public void getPath(vertices vs, int start, int dest){
		
	}

}
