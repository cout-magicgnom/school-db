package apl2;



public class Node{
    private Node Right;
    private Node Left;

    private String id;
    private float nota;
    private String nome;

    public Node(String id1,String name,float not){
        id = id1;
        nota = not;
        nome = name;
        Right = null;
        Left = null;
    };

    //GET E SET

    //Id
    public String getId(){return id;}
    public void setId(String id1){id = id1;}

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

    //ToString class Node
    @Override
    public String toString() {
        return "(" + id + " ; " + nome + " ; " + nota + ")";
    }
}
