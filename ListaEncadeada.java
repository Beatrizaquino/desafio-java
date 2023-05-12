

/**
 * Classe ListaEncadeada
 * Esta classe permite construir uma lista onde que cada
 * elemento aponta para o próximo, até chegar no fim com um
 * elemento que aponta para 'null'
 */
public class ListaEncadeada {
	/**
	 * Classe que define um elemento na lista
	 * Contém o valor e uma referência ao próximo
	 */
	public static class Elemento {
		String valor;
		Elemento prox;

		public Elemento(String valor) {
			this.valor = valor;
			this.prox = null;
		}

		/** Para escrever na tela os elementos
		* Ex: A --> B --> C --> null */
		@Override
		public String toString() {
			return this.valor + " --> " + this.prox;
		}
	}
	
	// ------- Atributos da classe ListaEncadeada -------
	// indica o início da lista.
	Elemento inicio;

	/**
	 * Este método adiciona um elemento no início da lista
	 * Ou seja, este novo valor será o primeiro da lista
	 * @param valor O valor que vai será adicionado
	*/
	public void addFirst(String valor) {
		Elemento novo = new Elemento(valor);
		novo.prox = inicio;
		inicio = novo;
	}

	/**
	 * Remove um elemento do início da lista
	 * @return o valor removido
	 */
	public String removeFirst() {
		String valor = inicio.valor;
		inicio = inicio.prox;
		return valor;
	}


	public ListaEncadeada clone() {
		ListaEncadeada copia = new ListaEncadeada();
		Elemento atual = this.inicio;
		Elemento anterior = null;
		while (atual != null) {
			Elemento novo = new Elemento(atual.valor);
			if (anterior == null) {
				copia.inicio = novo;
			} else {
				anterior.prox = novo;
			}
			anterior = novo;
			atual = atual.prox;
		}
		return copia;		
	}
	
	// Crie aqui outro método na classe ListaEncadeada
	public static void main(String[] args) {
	
		ListaEncadeada lista = new ListaEncadeada();
		lista.addFirst("Batata");
		lista.addFirst("Cenoura");
		lista.addFirst("Melancia");
		
		ListaEncadeada copia = lista.clone();
		
		// Adicionando um novo elemento apenas na cópia da lista
		copia.addFirst("Ameixa");
		
		System.out.println("Original: " + lista.inicio);
		System.out.println("Cópia: " + copia.inicio);
	}

}