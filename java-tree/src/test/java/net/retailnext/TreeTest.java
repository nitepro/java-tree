package net.retailnext;

import org.junit.Assert;
import org.junit.Test;


public class TreeTest {

  @Test
  public void testAddNode() throws Exception{
    Tree t = new Tree();

    //Add Root Node
    Node rootNode = new Node();
    rootNode.setName("Root Node");
    String s = t.addNode(null ,rootNode);

    
    System.out.println(s);
    //Add Child Nodes to Root
    Node child1 = new Node();
    child1.setName("Child 1");
    String s1 = t.addNode(rootNode.getId(),child1);

    System.out.println(s1);
    Node child2 = new Node();
    child1.setName("Child 2");
    String child2Id = t.addNode(rootNode.getId(),child1);
    System.out.println(child2Id);
    
    Node child22 = new Node();
    child1.setName("Child 22");
    String s3 = t.addNode(child2.getId(), child1);

    System.out.println(s3);
    
    rootNode = t.retrieveNode(rootNode.getId());
    Assert.assertTrue(rootNode.getChildren().size()==2);

    child2 = t.retrieveNode(child2Id);
    Assert.assertTrue(child2.getChildren().size()==1);

  }

  @Test
  public void testRetrieve() throws Exception {
    Tree t = new Tree();
    Node rootNode = new Node();

    t.addNode(null, rootNode);

  }

}
