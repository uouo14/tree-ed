package BST;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTreeTests {

	@Test
	public void addNodes() {
		BSTree<Integer> tree = new BSTree<Integer>();
		assertEquals(true, tree.add(5));
		assertEquals(true, tree.add(7));
		assertEquals(true, tree.add(9));
		assertEquals(true, tree.add(3));
		assertEquals(true, tree.add(1));
		assertEquals(true, tree.add(2));
		assertEquals(true, tree.add(6));
	}
	
	@Test
	public void preOrder() {
		BSTree<Integer> tree = getSampleTree();
		assertEquals("5\t3\t1\t2\t7\t6\t9", tree.preOrder());
	}
	
	@Test
	public void postOrder() {
		BSTree<Integer> tree = getSampleTree();
		assertEquals("2\t1\t3\t6\t9\t7\t5", tree.postOrder());
	}
	
	@Test
	public void inOrder() {
		BSTree<Integer> tree = getSampleTree();
		assertEquals("1\t2\t3\t5\t6\t7\t9", tree.inOrder());
	}
	
	@Test
	public void remove() {
		BSTree<Integer> tree = getSampleTree();
		assertEquals(true, tree.remove(5));
		assertEquals("3\t1\t2\t7\t6\t9", tree.preOrder());
	}
	
	@Test
	public void search() {
		BSTree<Integer> tree = getSampleTree();
		assertEquals(false, tree.search(20));
		assertEquals(true, tree.search(5));
		assertEquals(true, tree.search(9));
	}
	
	@Test
	public void classs() {
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.add(50);
		tree.add(70);
		tree.add(30);
		tree.add(15);
		tree.add(40);
//		tree.add(1);
//		tree.add(25);
//		tree.add(60);
		tree.add(90);
//		tree.add(56);
//		tree.add(62);
//		tree.add(87);
//		tree.add(99);
//		tree.add(33);
//		tree.add(46);
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println(tree.inOrder());
		tree.remove(50);
		System.out.println("---------------------------------------------\n");
		System.out.println(tree.inOrder());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		tree.remove(70);
		System.out.println("---------------------------------------------\n");
		System.out.println(tree.inOrder());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		tree.remove(30);
		System.out.println("---------------------------------------------\n");
		System.out.println(tree.inOrder());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		tree.remove(90);
		System.out.println("---------------------------------------------\n");
		System.out.println(tree.inOrder());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		tree.remove(40);
		System.out.println("---------------------------------------------\n");
		System.out.println(tree.inOrder());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		tree.remove(15);
		System.out.println("---------------------------------------------\n");
		System.out.println(tree.inOrder());
	}
	
	@Test
	public void case1() {
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.add(6);
		tree.add(2);
		tree.add(8);
		tree.add(7);
		tree.add(9);
		tree.add(1);
		tree.add(4);
		tree.add(3);
		tree.add(5);
		System.out.println("---------------------- BEFORE ----------------------");
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.inOrder());
		tree.remove(5);
		System.out.println("---------------------- AFTER ----------------------\n");
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.inOrder());
	}
	
	@Test
	public void case2() {
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.add(6);
		tree.add(2);
		tree.add(8);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(5);
		System.out.println("---------------------- BEFORE ----------------------");
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.inOrder());
		tree.remove(4);
		System.out.println("---------------------- AFTER ----------------------\n");
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.inOrder());
	}
	
	@Test
	public void case3() {
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.add(6);
		tree.add(2);
		tree.add(8);
		tree.add(7);
		tree.add(9);
		tree.add(1);
		tree.add(4);
		tree.add(3);
		tree.add(5);
		System.out.println("---------------------- BEFORE ----------------------");
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.inOrder());
		tree.remove(6);
		System.out.println("---------------------- AFTER ----------------------\n");
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.inOrder());
		
		assertEquals("5\t2\t1\t4\t3\t8\t7\t9", tree.preOrder());
		assertEquals("5\t2\t1\t4\t3\t8\t7\t9", tree.preOrder());
		assertEquals("5\t2\t1\t4\t3\t8\t7\t9", tree.preOrder());
	}
	
	private BSTree<Integer> getSampleTree() {
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.add(5);
		tree.add(7);
		tree.add(9);
		tree.add(3);
		tree.add(1);
		tree.add(2);
		tree.add(6);
		return tree;
	}

}
