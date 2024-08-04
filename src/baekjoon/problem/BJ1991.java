package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.spi.AbstractResourceBundleProvider;


class Node {
	String name;

	Node left;

	Node right;

	public Node(String name, Node left, Node right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
}

public class BJ1991 {

	public static StringBuffer sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());

		Node rootNode = new Node("A", null, null);

		Map<String, Node> nodeMap = new HashMap<>();
		nodeMap.put("A", rootNode);

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			Node currentNode = nodeMap.get(name);
			Node leftNode = null;
			Node rightNode = null;

			if(!left.equals(".")) {
				leftNode = new Node(left, null, null);
				nodeMap.put(left, leftNode);

			}
			if(!right.equals(".")) {
				rightNode = new Node(right, null, null);
				nodeMap.put(right, rightNode);
			}

			if(currentNode != null) {
				currentNode.left = leftNode;
				currentNode.right = rightNode;
			}
			else {
				Node newNode = new Node(name, leftNode, rightNode);
				nodeMap.put(name, newNode);
			}
		}

		preorder(rootNode);
		sb.append("\n");
		inorder(rootNode);
		sb.append("\n");
		postorder(rootNode);

		System.out.println(sb);
	}

	public static void preorder(Node node) {

		if(node == null) {
			return;
		}

		sb.append(node.name);

		preorder(node.left);
		preorder(node.right);
	}

	public static void inorder(Node node) {

		if(node == null) {
			return;
		}

		inorder(node.left);
		sb.append(node.name);
		inorder(node.right);
	}

	public static void postorder(Node node) {

		if(node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		sb.append(node.name);
	}

}
