package net.retailnext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {

	private String id;
	private String name;
	
	
	private String attr;
	private List<Node> children;
	
	public Node() {
		this.id = UUID.randomUUID().toString();
		this.children = new ArrayList<Node>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	
	public void addChild(Node n) {
		this.children.add(n);
	}
	
}
