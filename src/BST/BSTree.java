package BST;

public class BSTree <T extends Comparable<T>> implements Tree<T>  {
	
	BSTNode<T> root;

	public BSTree() {
		root = null;
	}
	
	@Override
	public BSTNode<T> getRoot() {
		return root;
	}

	@Override
	public void setRoot(BSTNode<T> root) {
		this.root = root;
		
	}
	
	public void checkNull(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
	}
	
	private void addLoop(T element, BSTNode<T> potentialParent) {
		if (potentialParent.getInfo().compareTo(element) > 0) {
			if (potentialParent.getLeft() == null) {
				potentialParent.setLeft(new BSTNode<T>(element));
			} else {
				addLoop(element, potentialParent.getLeft());
			}
		} else {
			if (potentialParent.getRight() == null) {
				potentialParent.setRight(new BSTNode<T>(element));
			} else {
				addLoop(element, potentialParent.getRight());
			}
		}
	}

	@Override
	public boolean add(T element) {
		checkNull(element);
		if (search(element)) {
			return false;
		}
		if (root == null) {
			root = new BSTNode<T>(element);
			return true;
		}
		addLoop(element, root);
		return true;
	}

	private BSTNode<T> deleteLoop(T element, BSTNode<T> currentNode) {
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
		return currentNode;
	}
	
	private BSTNode<T> getReplacementLeft(BSTNode<T> originNode) {
		if (originNode == null) {
			return null;
		}
		BSTNode<T> replacement = getReplacementLeft(originNode.getRight()); 
		if (replacement == null) {
			return originNode;
		}
		return replacement;
	}
	
	private BSTNode<T> getReplacementRight(BSTNode<T> originNode) {
		if (originNode == null) {
			return null;
		}
		if (getReplacementRight(originNode.getLeft()) == null) {
			return originNode;
		}
		return getReplacementRight(originNode.getLeft());
	}
	
	private boolean searchLoop(T element, BSTNode<T> parentNode) {
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
	
	private String exploreBranch(BSTNode<T> parentNode, char option) {
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
	
	protected String tumbarArbol(BSTNode<T> p, int esp) {
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

}
