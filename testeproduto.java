//importando
import java.util.ArrayList;
import java.util.Scanner;

//classe produto
public class Produto 
{
  //var
    public String comprador;
    public String nome;
    public int ID;
    public int quant;
    public float valor; 
    public float calc;

  //método auxiliar menu de opções 
    public static int Menu() 
  {
      //var
      int op;
      Scanner sc = new Scanner(System.in);
      
      System.out.println("\n(1) Incluir");
      System.out.println("(2) Alterar");//n
      System.out.println("(3) Remover");//n
      System.out.println("(4) Calcular carrinho");
    //listar um carrinho
      System.out.println("(5) Listar todos os produtos");
      System.out.println("(6) Listar produto");//n
      System.out.println("(7) Sair");

      System.out.print("\nDigite uma opção: ");
      op = sc.nextInt();
      sc.nextLine();

      return op;
    }
  
    //método auxiliar incluir produto no carrinho
    public static Produto Incluir_Produto() 
  {
        Scanner sc = new Scanner(System.in);
        Produto produto = new Produto();
    
System.out.println("\n---- Preencher dados do Produto ----\n");
    //solicitando id do produto
        System.out.print("ID do produto: ");
        produto.ID = sc.nextInt();
        sc.nextLine();
      //solicitando nome do produto
        System.out.print("Nome do produto: ");
        produto.nome = sc.nextLine();
     //solicitando valor do produto
        System.out.print("Valor do produto (R$): ");
        produto.valor = sc.nextFloat();
        sc.nextLine();
    //solicitando quantidade do produto
        System.out.print("Quantidade do produto: ");
        produto.quant= sc.nextInt();
        sc.nextLine();
    //solicitando nome do comprador
       System.out.print("Nome do comprador: ");
       produto.comprador = sc.nextLine(); 

        return produto;
  }
  
  //método auxiliar calcular carrinho
  public float calcularTotal() 
  {
    float total = 0;
    for (Produto p : produtos) 
    {
      total = total + p.getValor();
    }
      return total;
  }

  //método auxiliar imprime todos os dados 
  public static void produto(Produto p) 
  {
    System.out.println("\n---- Dados do Produto ----\n");
    System.out.println("ID do produto: " + p.ID);
    System.out.println("Quant do produto: " + p.quant);
    System.out.println("Nome do produto: " + p.nome);
    System.out.println("Valor do produto: R$ " + p.valor);
    System.out.println("Valor total: " + p.calc);
  }

   
   //método auxiliar que lista os carrinhos
  public static void Listar_Produtos(ArrayList<Produto> produtos) 
  {
    System.out.println("\n---- Lista de Produtos ----\n");
    for (Produto p : produtos) 
    {
      produto(p);
    }
  }

  //método auxiliar que lista apenas um produto
  public static void Listar_Produto(ArrayList<Produto> produtos) 
  {
    System.out.println("\n---- Listar Produto ----\n");
    //var
    String nome_prod;
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite o nome do produto: ");
    nome_prod = sc.nextLine();

    boolean produtoEncontrado = false;

    //verificar se produto existe
    for (Produto p : produtos) 
    {
      if (p.nome.equalsIgnoreCase(nome_prod)) 
      {
        produto(p);
        produtoEncontrado = true;
        break;
      }
    }
    //caso o produto não exista
    if (!produtoEncontrado) 
    {
      System.out.println("Produto não encontrado!");
    }
    
    }
  
  //Listar um produto
  Listar_Produto(ArrayList<Produto> produtos) 
  {
    System.out.println("\n---- Listar Produto ----\n");
    String nome_prod;
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite o nome do produto: ");
    nome_prod = sc.nextLine();

    boolean produtoEncontrado = false;
    
    //verificando se há produto
    for (Produto p : produtos) 
    {
      if (p.nome.equalsIgnoreCase(nome_prod)) 
      {
        produto(p);
        produtoEncontrado = true;
        break;
      }
    }
    
    //caso não exista 
    if (!produtoEncontrado) 
    {
      System.out.println("Produto não encontrado!");
    }
    
    }
  }
}
