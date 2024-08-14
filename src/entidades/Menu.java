package entidades;

import java.util.Scanner;

//Classe Menu para exibir o menu de opções e lidar com as entradas do usuário
public class Menu {
 public void mostrarMenu() {
     ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
     Pilha pilha = new Pilha(10); // Define a capacidade máxima da pilha
     Scanner scanner = new Scanner(System.in);
     int opc;

     do {
         System.out.println("====================== Menu ======================");
         System.out.println("1. Adicionar um livro na biblioteca");
         System.out.println("2. Remover livro (pelo código)");
         System.out.println("3. Visualizar o estoque da biblioteca");
         System.out.println("4. Emprestar um livro (pelo código)");
         System.out.println("5. Devolver um livro (pelo código)");
         System.out.println("6. Visualizar livros emprestados");
         System.out.println("0. Finalizar o programa");
         System.out.println("==================================================");

         System.out.print("Insira a opção desejada: ");
         opc = scanner.nextInt();

         switch (opc) {
             case 1:
                 scanner.nextLine(); // Clear the buffer
                 System.out.print("Insira o título do livro: ");
                 String titulo = scanner.nextLine();
                 System.out.print("Insira o código do livro: ");
                 int codigo = scanner.nextInt();
                 System.out.print("Insira o ano do livro: ");
                 int ano = scanner.nextInt();
                 Livro livro = new Livro(titulo, codigo, ano, 'L');
                 lista.inserir(livro);
                 break;

             case 2:
                 System.out.print("Insira o código do livro que deseja remover: ");
                 int codigoRemover = scanner.nextInt();
                 Celula celulaRemover = lista.buscarLivroPorCodigo(codigoRemover);
                 lista.remover(celulaRemover);
                 break;

             case 3:
                 lista.mostrar();
                 break;

             case 4:
                 scanner.nextLine(); // Clear the buffer
                 System.out.print("Insira o nome do aluno: ");
                 String nomeAluno = scanner.nextLine();
                 System.out.print("Insira a matrícula do aluno: ");
                 int matriculaAluno = scanner.nextInt();
                 Aluno aluno = new Aluno(matriculaAluno, nomeAluno);
                 System.out.print("Insira o código do livro que deseja emprestar: ");
                 int codigoEmprestar = scanner.nextInt();
                 OperacoesEspecificas.emprestismo(pilha, lista, codigoEmprestar, aluno);
                 break;

             case 5:
                 System.out.print("Insira o código do livro que deseja devolver: ");
                 int codigoDevolver = scanner.nextInt();
                 OperacoesEspecificas.devolucao(pilha, lista, codigoDevolver);
                 break;

             case 6:
                 pilha.mostrar();
                 break;

             case 0:
                 System.out.println("Programa finalizado");
                 break;

             default:
                 System.out.println("Opção inexistente!!!");
                 break;
         }
     } while (opc != 0);

     scanner.close();
 }
}
