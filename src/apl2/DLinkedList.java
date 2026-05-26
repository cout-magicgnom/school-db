
package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	private Node head;
	private Node tail;
	private int size;


	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.
	
	//CONSTRUTOR
	public DLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isFull() {
		return false;
	}

// OPERAÇÃO:		insert(<dados da pessoa>)
	public boolean insert(String id, String nome, float nota){
		if (isFull()) return false;
	
		Node novoNo = new Node(id, nome, nota);

		if (isEmpty()) {
			head = tail = novoNo;
		} else { 
			novoNo.setRight(head);
        	head.setLeft(novoNo); 
        	head = novoNo;
		}

		this.size++;
		return true;
	}


// OPERAÇÃO:		append(<dados da pessoa>)
	public void append(String id, String nome, float nota) {
		Node novoNo = new Node( id, nome, nota);

		if(isEmpty()){
			head = tail = novoNo;
		} else {
			tail.setRight(novoNo);
			novoNo.setLeft(tail);
			tail = novoNo;
		}
		size++;
	}


// OPERAÇÃO: 		removeHead()
	public Node removeHead() {
		if(isEmpty()) return null;

		Node removido = head;
		if(size == 1){
			head = tail = null;
		} else {
			head = head.getRight();
			head.setLeft(null);
		}
		size--;
		return removido;
	}


// OPERAÇÃO:		removeTail()
	public Node removeTail() {
		if(isEmpty()) return null;

		Node removido = tail;
		if(size == 1){
			head = tail = null;
		} else {
			tail = tail.getLeft();
			tail.setRight(null);
		}
		size--;
		return removido;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
	public Node removeNode(String id) {
		if(isEmpty()) return null;

		Node aux = head;
		while(aux != null){
			if(aux.getId().equals(id)){
				if(size == 1){
					head = tail = null;
				}
				else if(aux == head){
					head = head.getRight();
					head.setLeft(null);
				}
				else if(aux == tail){
					tail = tail.getLeft();
					tail.setRight(null);
				} else {
					aux.getLeft().setRight(aux.getRight());
					aux.getRight().setLeft(aux.getLeft());
				}
				aux.setLeft(null);
				aux.setRight(null);
				size--;

				return aux;
			}
			aux = aux.getRight();
		}
		return null;
	}
	


// OPERAÇÃO:		getHead()
	public Node getHead(){
		if(isEmpty()) return null;
		return head;
	}


// OPERAÇÃO:		getTail()
	public Node getTail() {
		if(isEmpty()) return null;
		return tail;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
	public Node getNode(String id) {
    	Node aux = head;

	    while (aux != null) {
	        if (aux.getId().equals(id)) {
	            return aux;
	        }
	        aux = aux.getRight();
	    }
	    return null;
	}


// OPERAÇÃO:		count()
	public int count() {
		return size;
	}


// OPERAÇÃO:		isEmpty()
	public boolean isEmpty() {
        return head == null;
    }


// OPERAÇÃO:		clear()
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}


// OPERAÇÃO:		toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("(").append(this.count()).append(")\n");

		for (Node node = this.head; node != null; node = node.getRight()) {

			// Nó anterior
			if (node.getLeft() == null) {
				sb.append("null");
			} else {
				sb.append(node.getLeft().getId());
			}

			sb.append(" <- (")
					.append(node.getId())
					.append("; ")
					.append(node.getNome())
					.append("; ")
					.append(node.getNota())
					.append(") -> ");

			// Próximo nó
			if (node.getRight() == null) {
				sb.append("null");
			} else {
				sb.append(node.getRight().getId());
			}

			sb.append("\n");
		}

		return sb.toString();
	}
}

