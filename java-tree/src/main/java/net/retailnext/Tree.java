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
	    n.setParentID(targetNode.getId());
		return n.getId();
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

  public boolean deleteNode(String id ) throws Exception {
	 
	  
	  
	Node targetNode = searchNodeDFS(root, id);
	Node parent = searchNodeDFS(root, targetNode.getParentID());
	
	parent.getChildren().remove(targetNode);
    return true;
  }
}

