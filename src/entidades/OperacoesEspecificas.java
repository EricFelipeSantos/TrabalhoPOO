package entidades;

//Classe OperacoesEspecificas contendo métodos estáticos para realizar operações específicas
public class OperacoesEspecificas {
 public static void emprestismo(Pilha pilha, ListaDuplamenteEncadeada lista, int codigoLivro, Aluno aluno) {
     // Verificar se o livro está disponível na lista
     Celula celulaLivro = lista.buscarLivroPorCodigo(codigoLivro);

     if (celulaLivro == null) {
         System.out.println("Livro não encontrado ou já emprestado.");
     } else {
         // Verificar se a pilha está cheia
         if (pilha.estaCheia()) {
             System.out.println("Não é possível emprestar mais livros. Limite atingido.");
         } else {
             // Marcando o livro como emprestado
             celulaLivro.getLivro().setStatus('E');

             // Empilhar o livro na pilha
             pilha.empilhar(celulaLivro.getLivro(), aluno);

             // Remover o livro da lista
             lista.remover(celulaLivro);

             System.out.println("Livro emprestado com sucesso!");
         }
     }
 }

 public static void devolucao(Pilha pilha, ListaDuplamenteEncadeada lista, int codigoLivro) {
     // Iterar sobre a pilha para encontrar o livro desejado
     for (int i = pilha.getTopo() - 1; i >= 0; i--) {
         if (pilha.getLivroAt(i).getCodigo() == codigoLivro) {
             // Atualizar o status do livro para disponível
             pilha.getLivroAt(i).setStatus('L');

             // Inserir o livro de volta na lista
             lista.inserir(pilha.getLivroAt(i));

             // Remover o livro da pilha
             for (int j = i; j < pilha.getTopo() - 1; j++) {
                 pilha.livros.set(j, pilha.getLivroAt(j + 1));
                 pilha.alunos.set(j, pilha.getAlunoAt(j + 1));
             }

             pilha.desempilhar();

             System.out.println("Livro devolvido com sucesso!");
             return;
         }
     }

     System.out.println("Livro não encontrado na lista de empréstimos.");
 }
}