package net.retailnext;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	
	private Node root;
	
	
	public Tree() {
		//
	}
	
	
	public String addNode(String id , Node n) throws Exception {
		
		
		if(this.root == null) {
			this.root = n;
			return n.getId();
		}

		
		Node targetNode = searchNodeDFS(this.root, id);
		
		
		if(targetNode == null) {
			throw new Exception("Target Node with " + id + " not found");
		}
		
	    targetNode.addChild(n);
		return n.getId();
	}
	
	
	private Node searchNode(Node root , String id) {
		if( root == null || id == null) {
			return null;
		}
		List<Node> currentLevel = new ArrayList<Node>();
		currentLevel.add(root);
		
		List<Node> secondLevel = new ArrayList<Node>();
		
		
		while(!currentLevel.isEmpty()) {
			
			
			for(Node n : currentLevel) {
				if(n.getId().equals(id)) {
					return n;
				}
				secondLevel.addAll(n.getChildren());
			}
			
			currentLevel = new ArrayList<Node>();
			
			if(!secondLevel.isEmpty()) {
				currentLevel.addAll(secondLevel);
			}
			
		}
		//not found
		return null;
	}
	
	
	public Node searchNodeDFS(Node root , String id) {
		
		if(root == null) {
			return null;
		}
		
		if(root.getId().equals(id)) {
			return root;
		}
		
		for(Node n : root.getChildren()) {
			
			Node t = searchNodeDFS(n, id);
			
			if(t != null) {
				return t;
			}
		}
		
		return null;
	}
	public Node retrieveNode(String id) {
		return searchNodeDFS(root, id);
	}
}

