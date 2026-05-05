// arquivo: src/apl2/Node.java

//Kauê Cordeiro Abreu 10741435
//Felipe Melo 10741166

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
    private Node Right;
    private Node Left;

    private float nota;
    private String nome;

    public Node(float not){
        nota = not;
        nome = null;
        Right = null;
        Left = null;
    };

    public Node() {this(-1);}

    //GET E SETS

    //Nome
    public String getNome(){return nome;}
    public void setNome(String name){nome = name;}

    //Nota
    public float getNota(){return nota;}
    public void setNota(float nota1){nota = nota1;}

    //Left

    public Node getLeft(){return Left;}
    public void setLeft(Node left1){Left = left1;}

    //Right

    public Node getRight(){return Right;}
    public void setRight(Node right1){Right = right1;}


}
