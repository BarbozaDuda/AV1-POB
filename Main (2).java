import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Scanner sc = new Scanner(System.in);
        int opcao;

        while (true) {
            opcao = Menu();
            if (opcao == 1) {
                Produto produto = IncluirProduto();
                produtos.add(produto);
            } else if (opcao == 2) {
                AdicionarAoCarrinho(produtos, carrinho);
            } else if (opcao == 3) {
                ListarCarrinho(carrinho);
            } else if (opcao == 4) {
                break;
            }
        }
    }

    public static int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Incluir produto");
        System.out.println("2. Adicionar produto ao carrinho");
        System.out.println("3. Listar carrinho");
        System.out.println("4. Sair");
        System.out.print("Digite o número da opção: ");
        return sc.nextInt();
    }

    public static Produto IncluirProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIncluir Produto:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        return new Produto(id, nome, preco);
    }

    public static void AdicionarAoCarrinho(ArrayList<Produto> produtos, CarrinhoDeCompras carrinho) {
        Scanner sc = new Scanner(System.in);
        ListarProdutos(produtos);
        System.out.print("Digite o ID do produto que deseja adicionar ao carrinho: ");
        int idProduto = sc.nextInt();
        sc.nextLine();
        Produto produtoSelecionado = null;
        for (Produto produto : produtos) {
            if (produto.id == idProduto) {
                produtoSelecionado = produto;
                break;
            }
        }
        if (produtoSelecionado != null) {
            System.out.print("Digite a quantidade desejada: ");
            int quantidade = sc.nextInt();
            carrinho.adicionarItem(produtoSelecionado, quantidade);
            System.out.println("Produto adicionado ao carrinho!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void ListarProdutos(ArrayList<Produto> produtos) {
        System.out.println("\nLista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.id + " | Nome: " + produto.nome + " | Preço: " + produto.preco);
        }
    }

    public static void ListarCarrinho(CarrinhoDeCompras carrinho) {
        ArrayList<ItemCarrinho> itens = carrinho.getItens();
        System.out.println("\nCarrinho de Compras:");
        double valorTotal = 0.0;
        for (ItemCarrinho item : itens) {
            Produto produto = item.produto;
            int quantidade = item.quantidade;
            double subtotal = quantidade * produto.preco;
            System.out.println("ID: " + produto.id + " | Nome: " + produto.nome + " | Quantidade: " + quantidade + " | Subtotal: " + subtotal);
            valorTotal += subtotal;
        }
        System.out.println("Valor Total do Carrinho: " + valorTotal);
    }
}
