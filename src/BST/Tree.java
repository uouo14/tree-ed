package BST;

/**
 * Define el contrato para una estructura de datos genérica de árbol binario de búsqueda.
 * 
 * Esta interfaz proporciona operaciones para gestionar los elementos del árbol, incluyendo
 * inserción, eliminación y búsqueda. También admite varios métodos de recorrido y
 * visualización para mostrar la estructura del árbol y las propiedades de los nodos.
 * 
 * Todos los elementos deben ser comparables y no se permiten valores nulos en el árbol.
 * 
 * @param <T> el tipo de elementos almacenados en el árbol, debe implementar Comparable
 */
public interface Tree<T extends Comparable<T>> {

	/**
	 * Devuelve el nodo raíz del árbol.
	 *
	 * @return el nodo raíz, o null si el árbol está vacío
	 */

	BSTNode<T> getRoot();

	/**
	 * Establece el nodo raíz del árbol.
	 *
	 * @param root el nuevo nodo raíz a establecer
	 */
	void setRoot(BSTNode<T> root);

	/**
	 * Añade un elemento al árbol en la posición adecuada según el orden del ABB.
	 * 
	 * El elemento se inserta de manera que todos los elementos en el subárbol izquierdo
	 * sean menores que el elemento, y todos los elementos en el subárbol derecho sean
	 * mayores que el elemento.
	 *
	 * @param element el elemento a añadir al árbol
	 * @throws NullPointerException     si el elemento es null
	 * @return false si el elemento ya existe en el árbol
	 */

	boolean add(T element);

	/**
	 * Busca un elemento en el árbol.
	 * 
	 * Realiza una búsqueda binaria comenzando desde la raíz, comparando el elemento
	 * objetivo con los valores de los nodos para determinar la dirección de búsqueda.
	 *
	 * @param element el elemento a buscar
	 * @return true si el elemento existe en el árbol, false en caso contrario
	 * @throws NullPointerException si el elemento es null
	 */
	boolean search(T element);

	/**
	 * Elimina el elemento especificado del árbol.
	 * 
	 *
	 * @param element el elemento a eliminar del árbol
	 * @throws NullPointerException     si el elemento es null
	 * @return true si lo ha borrado, false caso contrario
	 */

	boolean remove(T element);

	/**
	 * Metodo que genera y devuelve una cadena con todos los nodos del arbol
	 * recorridos en preOrden y separados por tabulaciones
	 * 
	 * @return  Un String con el recorrido en preOrden del arbol
	 */
	String preOrder();
	
	/**
	 * Metodo que genera y devuelve una cadena con todos los nodos del arbol
	 * recorridos en postOrden y separados por tabulaciones
	 * 
	 * @return  Un String con el recorrido en preOrden del arbol
	 */
	String postOrder();
	
	/**
	 * Metodo que genera y devuelve una cadena con todos los nodos del arbol
	 * recorridos en inOrden y separados por tabulaciones
	 * 
	 * @return  Un String con el recorrido en preOrden del arbol
	 */
	String inOrder();

}
