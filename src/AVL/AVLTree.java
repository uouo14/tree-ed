package AVL;

public class AVLTree <T extends Comparable<T>> implements Tree<T>  {
	
	AVLNode<T> root;

	public AVLTree() {
		root = null;
	}
	
	@Override
	public AVLNode<T> getRoot() {
		return root;
	}

	@Override
	public void setRoot(AVLNode<T> root) {
		this.root = root;
		
	}
	
	public void checkNull(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
	}
	
	private AVLNode<T> addLoop(T element, AVLNode<T> potentialParent) {
		if (potentialParent.getInfo().compareTo(element) > 0) {
			if (potentialParent.getLeft() == null) {
				potentialParent.setLeft(new AVLNode<T>(element));
			} else {
				potentialParent.setLeft(addLoop(element, potentialParent.getLeft()));
			}
		} else {
			if (potentialParent.getRight() == null) {
				potentialParent.setRight(new AVLNode<T>(element));
			} else {
				potentialParent.setRight(addLoop(element, potentialParent.getRight()));
			}
		}
		return checkRotation(potentialParent);
	}
	
	public AVLNode<T> checkRotation(AVLNode<T> origin) {
		origin.calculateBFHeight();
		if (Math.abs(origin.getBF()) < 2) {
			return origin;
		}
		if (origin.getBF() > 0) {
			if (origin.getRight().getBF() > 0) {
				return simpleRotationRight(origin);
			} else {
				return doubleRotationRight(origin);
			}
		} else {
			if (origin.getLeft().getBF() < 0) {
				return simpleRotationLeft(origin);
			} else {
				return doubleRotationLeft(origin);
			}
		}
	}
	
	private AVLNode<T> simpleRotationRight(AVLNode<T> node) {
//		System.out.println("Right");
		AVLNode<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node.calculateBFHeight();
		aux.calculateBFHeight();
		return aux;
	}
	
	private AVLNode<T> simpleRotationLeft(AVLNode<T> node) {
//		System.out.println("Left");
		AVLNode<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node.calculateBFHeight();
		aux.calculateBFHeight();
		return aux;
	}
	
	private AVLNode<T> doubleRotationRight(AVLNode<T> node) {
//		System.out.println("DRight");
		node = simpleRotationRight(node);
		return simpleRotationLeft(node);
	}
	
	private AVLNode<T> doubleRotationLeft(AVLNode<T> node) {
//		System.out.println("DLeft");
		node = simpleRotationLeft(node);
		return simpleRotationRight(node);
	}
	

	@Override
	public boolean add(T element) {
		checkNull(element);
		if (search(element)) {
			return false;
		}
		if (root == null) {
			root = new AVLNode<T>(element);
			return true;
		}
		root = addLoop(element, root);
		return true;
	}

	
	private AVLNode<T> deleteLoop(T element, AVLNode<T> currentNode) {
		if (currentNode == null) {
			return null;
		}
		switch (element.compareTo(currentNode.getInfo())) {
			case 0:
				if (currentNode.getRight() == null && currentNode.getLeft() == null) {
					return null;
				} else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
					return currentNode.getLeft() == null ? currentNode.getRight() : currentNode.getLeft();
				} 
				T info = getReplacementLeft(currentNode.getLeft()).getInfo();
//				remove(info);
				currentNode.setInfo(info);
				currentNode.setLeft(deleteLoop(info, currentNode.getLeft()));
				break;
			case -1:
				currentNode.setLeft(deleteLoop(element, currentNode.getLeft()));
				break;
			case 1:
				currentNode.setRight(deleteLoop(element, currentNode.getRight()));
				break;
			default:
				break;
		}
		return checkRotation(currentNode);
	}
	
	
	private AVLNode<T> getReplacementLeft(AVLNode<T> originNode) {
		if (originNode == null) {
			return null;
		}
		AVLNode<T> replacement = getReplacementLeft(originNode.getRight()); 
		if (replacement == null) {
			return originNode;
		}
		return replacement;
	}
	
	
	private AVLNode<T> getReplacementRight(AVLNode<T> originNode) {
		if (originNode == null) {
			return null;
		}
		if (getReplacementRight(originNode.getLeft()) == null) {
			return originNode;
		}
		return getReplacementRight(originNode.getLeft());
	}
	
	
	private boolean searchLoop(T element, AVLNode<T> parentNode) {
		if (parentNode == null) {
			return false;
		}
		switch (parentNode.getInfo().compareTo(element)) {
			case 0:
				return true;
			case -1:
				return searchLoop(element, parentNode.getRight());
			case 1:					
				return searchLoop(element, parentNode.getLeft());
			default:
				return false;
		}
	}
	
	@Override
	public boolean search(T element) {
		checkNull(element);
		return searchLoop(element, root);
	}

	@Override
	public boolean remove(T element) {
		if (root == null || !search(element)) {
			return false;
		}
		deleteLoop(element, root);
		return true;
	}
	
	
	private String exploreBranch(AVLNode<T> parentNode, char option) {
		StringBuilder output = new StringBuilder();
		if (parentNode == null) {
			return output.toString();
		}
		switch (option) {
			case 'p':
				output.append(parentNode + "\t");
				output.append(exploreBranch(parentNode.getLeft(), option));
				output.append(exploreBranch(parentNode.getRight(), option));
				break;
			case 't':
				output.append(exploreBranch(parentNode.getLeft(), option));
				output.append(exploreBranch(parentNode.getRight(), option));
				output.append(parentNode + "\t");
				break;
			case 'i':
				output.append(exploreBranch(parentNode.getLeft(), option));
				output.append(parentNode + "\t");
				output.append(exploreBranch(parentNode.getRight(), option));
				break;
			case 'o':
				output.append(exploreBranch(parentNode.getLeft(), option));
				output.append(parentNode + "(" + parentNode.getBF() + ", " + parentNode.getHeight() + ") \t");
				output.append(exploreBranch(parentNode.getRight(), option));
			default:
					break;
		}
		return output.toString();
	}
	
	@Override
	public String preOrder() {
		StringBuilder output = new StringBuilder();
		output.append(root + "\t");
		output.append(exploreBranch(root.getLeft(), 'p'));
		output.append(exploreBranch(root.getRight(), 'p'));
		return output.toString().strip();
	}

	@Override
	public String postOrder() {
		StringBuilder output = new StringBuilder();
		output.append(exploreBranch(root.getLeft(), 't'));
		output.append(exploreBranch(root.getRight(), 't'));
		output.append(root + "\t");
		return output.toString().strip();
	}

	@Override
	public String inOrder() {
		StringBuilder output = new StringBuilder();
		output.append(exploreBranch(root.getLeft(), 'i'));
		output.append(root + "\t");
		output.append(exploreBranch(root.getRight(), 'i'));
		return output.toString().strip();
	}
	
	protected String tumbarArbol(AVLNode<T> p, int esp) {
		StringBuilder cadena = new StringBuilder();
		if (p != null) {
			cadena.append(tumbarArbol(p.getRight(), esp + 1));
			for (int i = 0; i < esp; i++)
				cadena.append("\t");
			cadena.append(p + "\n");
			cadena.append(tumbarArbol(p.getLeft(), esp + 1));
		}
		return cadena.toString();
	}
	
	public void loop(AVLNode<T> og) {
		if (og == null) {
			return;
		}
		System.out.println("%d -> [H: %d] [BF: %d] (L: %s; R: %s)".formatted(og.getInfo(), og.getHeight(), og.getBF(), og.getLeft(), og.getRight()));
		loop(og.getLeft());
		loop(og.getRight());
		
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(exploreBranch(root.getLeft(), 'o'));
		output.append(root + "(" + root.getBF() + ", " + root.getHeight() + ")\t");
		output.append(exploreBranch(root.getRight(), 'o'));
		return output.toString().strip();
	}

}
