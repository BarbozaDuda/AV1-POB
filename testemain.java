//importando
import java.util.ArrayList;
import java.util.Scanner;

//classe principal
public class Main 
{
  
  //método principal
    public static void main(String[] args) 
  {
    //var
        int op;
        String continua = "";
        int count = 0;

    //Tabela de produtos
    System.out.println("----------------------");
    System.out.println("Produto  Valor    ID  ");
    System.out.println("Shampoo  R$15,00  100 ");
    System.out.println("Condic.  R$13,00  101 ");
    System.out.println("CremeP   R$20,00  102 ");
    System.out.println("CremeH   R$25,00  103 ");
    System.out.println("----------------------");
    
    //carrinho
    System.out.println("Carrinho de compras: ");

        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
//se o usuário vai continuar ou não
        while (!continua.equals("fim")) 
        {
            if (count >= 1) 
            {
            System.out.print("\n\tDeseja continuar? (Digite 'sim' ou 'fim' para sair) ");
                continua = sc.nextLine();
            }

          //funcionalidades
          op = Produto.Menu();
          Produto produto = new Produto();
          switch (op) {
          case 1:
            produto = Produto.Incluir_Produto();
            produtos.add(produto);
            break;
          case 2: //alterar n
            break;
          case 3: //remover n
            break;
          case 4: //calcular carrinho
          //calcularTotal();
            break;
          case 5:
            Produto.Listar_Produtos(produtos); // listar carrinho
            break;
          case 6:
            Produto.Listar_Produto(produtos);//n
            break;
          case 7:
            System.out.println("\nPrograma finalizado com sucesso!");
            continua = "fim";
            break;
            }
            count++;
        }
    }
}
