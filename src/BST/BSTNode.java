package BST;

/**
 * Clase para implementar el nodo de un �rbol BST
 * 
 * 
 *
 */
public class BSTNode <T extends Comparable<T>> {

	/**
	 * El contenido del nodo que ser� de tipo gen�rico
	 */
	private T info;
	/**
	 * Nodo hijo izquierdo
	 */
	private BSTNode<T> left;
	/**
	 * Nodo hijo derecho
	 */
	private BSTNode<T> right;
	
	/**
	 * Constructor por defecto para la clase al que se le pasa la informaci�n del nodo a crear
	 * 
	 * @param clave  La informaci�n para el nodo
	 */
	public BSTNode(T clave) {
		this.info = clave;
		this.left = null;
		this.right = null;
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
	 * Modifica el valor del atributo left
	 * 
	 * @param left  El nuevo valor para left
	 */
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	/**
	 * Modifica el valor del atributo right
	 * 
	 * @param right  El nuevo valor para right
	 */
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	/**
	 * Devuelve el valor del atributo left
	 * 
	 * @return  El valor del atributo left
	 */
	public BSTNode<T> getLeft() {
		return left;
	}

	/**
	 * Devuelve el valor del atributo right
	 * 
	 * @return  El valor del atributo right
	 */
	public BSTNode<T> getRight() {
		return right;
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
