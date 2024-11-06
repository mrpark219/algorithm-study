package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5639 {

	public static class Node {
		int value;
		Node leftNode;
		Node rightNode;

		public Node(int value) {
			this.value = value;
		}

		public void insert(int n) {
			if(n < this.value) {
				if(this.leftNode == null) {
					this.leftNode = new Node(n);
				}
				else {
					this.leftNode.insert(n);
				}
			}
			else {
				if(this.rightNode == null) {
					this.rightNode = new Node(n);
				}
				else {
					this.rightNode.insert(n);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int first = Integer.parseInt(br.readLine());
		Node root = new Node(first);

		while(true) {

			String input = br.readLine();
			if(input == null || input.isEmpty()) {
				break;
			}

			int N = Integer.parseInt(input);

			root.insert(N);
		}

		postOrder(sb, root);

		System.out.println(sb);
	}

	public static void postOrder(StringBuilder sb, Node node) {
		if(node == null) {
			return;
		}

		postOrder(sb, node.leftNode);
		postOrder(sb, node.rightNode);
		sb.append(node.value).append("\n");
	}
}
