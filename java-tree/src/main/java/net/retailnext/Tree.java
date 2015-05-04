package net.retailnext;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	
	private Node root;
	
	
	public Tree() {
		//
	}
	
	
	public void addNode(String id , Node n) throws Exception {
		
		Node targetNode = searchNode(this.root, id);
		
		if(this.root == null) {
			this.root = n;
			return;
		}
		
		if(targetNode == null) {
			throw new Exception("Target Node with " + id + " not found");
		}
		
	    targetNode.addChild(n);
		
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
			
			currentLevel = secondLevel;
			
		}
		//not found
		return null;
	}
	
	public Node retriveNode(String id) {
		return searchNode(root, id);
	}
}

