package AVL;

/**
 * Clase para implementar el nodo de un �rbol BST
 * 
 * 
 *
 */
public class AVLNode <T extends Comparable<T>> {

	/**
	 * El contenido del nodo que ser� de tipo gen�rico
	 */
	private T info;
	/**
	 * Nodo hijo izquierdo
	 */
	private AVLNode<T> left;
	/**
	 * Nodo hijo derecho
	 */
	private AVLNode<T> right;
	
	private int BF;
	
	private int height;
	
	/**
	 * Constructor por defecto para la clase al que se le pasa la informaci�n del nodo a crear
	 * 
	 * @param clave  La informaci�n para el nodo
	 */
	public AVLNode(T clave) {
		this.info = clave;
		this.left = null;
		this.right = null;
		this.height = 0;
		this.BF = 0;
	}

	/**
	 * Modifica el valor del atributo info
	 * 
	 * @param info  El nuevo valor para info
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Devuelve el valor del atributo info
	 * 
	 * @return  El valor del atributo info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Returns the value of the balance factor
	 * @return The value of the balance factor
	 */
	public int getBF() {
		return BF;
	}

	/**
	 * Sets the balance factor
	 * @param bF The value for the balance factor
	 */
	public void setBF(int bF) {
		BF = bF;
	}

	/**
	 * Returns the value of the height
	 * @return The height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height
	 * @param height The value for the height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Modifica el valor del atributo left
	 * 
	 * @param left  El nuevo valor para left
	 */
	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	/**
	 * Modifica el valor del atributo right
	 * 
	 * @param right  El nuevo valor para right
	 */
	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

	/**
	 * Devuelve el valor del atributo left
	 * 
	 * @return  El valor del atributo left
	 */
	public AVLNode<T> getLeft() {
		return left;
	}

	/**
	 * Devuelve el valor del atributo right
	 * 
	 * @return  El valor del atributo right
	 */
	public AVLNode<T> getRight() {
		return right;
	}
	
	public void calculateBFHeight() {
		int rH = (right == null ? 0 : right.height + 1);
		int lH = (left == null ? 0 : left.height + 1);
		this.BF = rH - lH;
		this.height = Math.max(rH, lH);
	}	

	/**
	 * Metodo que devuelve una cadena con la informaci�n del BTSNode
	 * 
	 * @return  Un String que representa al objeto BTSNode
	 */
	@Override
	public String toString() {
		return info.toString();
	}
}
