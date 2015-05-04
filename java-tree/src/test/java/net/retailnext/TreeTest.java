package net.retailnext;

import org.junit.*;

public class TreeTest {

  @Test
  public void testAddNode() throws Exception{
    Tree t = new Tree();

    //Add Root Node
    Node rootNode = new Node();
    rootNode.setName("Root Node");
    t.addNode(null ,rootNode);

    //Add Child Nodes to Root
    Node child1 = new Node();
    child1.setName("Child 1");
    t.addNode(rootNode.getId(),child1);

    Node child2 = new Node();
    child1.setName("Child 2");
    String child2Id = t.addNode(rootNode.getId(),child1);

    Node child22 = new Node();
    child1.setName("Child 22");
    t.addNode(child2.getId(), child1);

    rootNode = t.retrieveNode(rootNode.getId());
    Assert.assertTrue(rootNode.getChildren().size()==2);

    child2 = t.retrieveNode(child2Id);
    Assert.assertTrue(child2.getChildren().size()==1);

  }

  @Test
  public void testDelete() throws Exception {
    Tree t = new Tree();
    Node rootNode = new Node();
    t.addNode(null, rootNode);

    //Add Child Nodes to Root
    Node child1 = new Node();
    child1.setName("Child 1");
    t.addNode(rootNode.getId(),child1);

    Node child2 = new Node();
    child1.setName("Child 2");
    String child2Id = t.addNode(rootNode.getId(),child1);

    rootNode = t.retrieveNode(rootNode.getId());
    Assert.assertTrue(rootNode.getChildren().size()==2);


    Assert.assertTrue(t.deleteNode(child2Id));

    Assert.assertTrue(t.retrieveNode(rootNode.getId()).getChildren().size()==1);
  }

}
