package AVL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLTreeTests {

	@Test
	public void addNodes() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
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
		AVLTree<Integer> tree = getSampleTree();
		assertEquals("3\t1\t2\t7\t5\t6\t9", tree.preOrder());
	}
	
	@Test
	public void postOrder() {
		AVLTree<Integer> tree = getSampleTree();
//		assertEquals("2\t1\t3\t6\t5\t9\t7", tree.postOrder());
	}
	
	@Test
	public void doubleRight() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(25);
		tree.add(30);
		tree.add(26);
		assertEquals("25\t26\t30", tree.inOrder());
	}
	
	@Test
	public void doubleLeft() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(75);
		tree.add(60);
		tree.add(65);
		assertEquals("60\t65\t75", tree.inOrder());
	}
	
	@Test
	public void inOrder() {
		AVLTree<Integer> tree = getSampleTree();
		assertEquals("1\t2\t3\t5\t6\t7\t9", tree.inOrder());
	}
	
	@Test
	public void remove() {
		AVLTree<Integer> tree = getSampleTree();
		assertEquals(true, tree.remove(5));
//		assertEquals("7\t3\t1\t2\t6\t9", tree.preOrder());
	}
	
	@Test
	public void search() {
		AVLTree<Integer> tree = getSampleTree();
		assertEquals(false, tree.search(20));
		assertEquals(true, tree.search(5));
		assertEquals(true, tree.search(9));
	}
	
	@Test
	public void height() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(5);
		assertEquals(0, tree.root.getBF());
		assertEquals(0, tree.root.getHeight());
		tree.add(6);
		assertEquals(1, tree.root.getBF());
		assertEquals(1, tree.root.getHeight());
		tree.add(2);
		assertEquals(0, tree.root.getBF());
		assertEquals(1, tree.root.getHeight());
		tree.add(7);
		assertEquals(1, tree.root.getBF());
		assertEquals(2, tree.root.getHeight());
		tree.add(9);
//		assertEquals(0, tree.root.getBF());
//		assertEquals(1, tree.root.getHeight());
	}
	
	@Test
	public void classs() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(50);
		tree.add(70);
		tree.add(30);
		tree.add(15);
		tree.add(40);
		tree.add(1);
		tree.add(25);
		tree.add(60);
		tree.add(90);
//		tree.add(56);
//		tree.add(62);
//		tree.add(87);
//		tree.add(99);
//		tree.add(33);
//		tree.add(46);
//		System.out.println(tree.toString());
//		System.out.println(tree.tumbarArbol(tree.root, 0));
	}
	
	@Test
	public void case1() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(6);
		tree.add(2);
		tree.add(8);
		tree.add(7);
		tree.add(9);
		tree.add(1);
		tree.add(4);
		tree.add(3);
		tree.add(5);
		tree.remove(5);
	}
	
	@Test
	public void case2() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(6);
		tree.add(2);
		tree.add(8);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(5);
		tree.remove(4);
	}
	
	@Test
	public void case3() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(6);
		tree.add(2);
		tree.add(8);
		tree.add(7);
		tree.add(9);
		tree.add(1);
		tree.add(4);
		tree.add(3);
		tree.add(5);
		tree.remove(6);
		assertEquals("5\t2\t1\t4\t3\t8\t7\t9", tree.preOrder());
		assertEquals("5\t2\t1\t4\t3\t8\t7\t9", tree.preOrder());
		assertEquals("5\t2\t1\t4\t3\t8\t7\t9", tree.preOrder());
	}
	
	@Test
	public void tetsing() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(7);
		tree.add(6);
		tree.add(5);
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);
		tree.add(8);
		tree.add(9);
		tree.add(10);
//		tree.loop(tree.root);
//		System.out.println(tree.tumbarArbol(tree.root, 0));
	}
	
	@Test
	public void ejercicioClase() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		int[] te = new int[] {1, 2, 3, 4, 5, 6, 10, 11, 8, 7};
		for (int i : te) {
			tree.add(i);
		}
		System.out.println(tree.tumbarArbol(tree.root, 0));
	}
	
	@Test
	public void classAVL() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(10);
		tree.add(16);
		tree.add(20);
		tree.add(6);
		tree.add(3);
		tree.add(5);
//		tree.add(9);
//		tree.add(80);
//		tree.add(90);
//		tree.add(4);
//		tree.add(1);
//		tree.add(18);
//		tree.add(22);
//		tree.add(24);
//		System.out.println(tree.tumbarArbol(tree.root, 0));
	}
	
	private AVLTree<Integer> getSampleTree() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
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
