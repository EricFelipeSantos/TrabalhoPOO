package entidades;

import java.util.ArrayList;

//Classe Pilha para gerenciar os livros emprestados
public class Pilha {
 ArrayList<Livro> livros;
 ArrayList<Aluno> alunos;
 private int capacidade;

 public Pilha(int capacidade) {
     this.capacidade = capacidade;
     this.livros = new ArrayList<Livro>();
     this.alunos = new ArrayList<Aluno>();
 }

 public boolean estaCheia() {
     return livros.size() >= capacidade;
 }

 public boolean estaVazia() {
     return livros.isEmpty();
 }

 public void empilhar(Livro livro, Aluno aluno) {
     if (estaCheia()) {
         System.out.println("Não é possível emprestar mais livros. Limite atingido.");
     } else {
         livros.add(livro);
         alunos.add(aluno);
     }
 }

 public void desempilhar() {
     if (!estaVazia()) {
         livros.remove(livros.size() - 1);
         alunos.remove(alunos.size() - 1);
     }
 }

 public Livro topoLivro() {
     if (!estaVazia()) {
         return livros.get(livros.size() - 1);
     }
     return null;
 }

 public Aluno topoAluno() {
     if (!estaVazia()) {
         return alunos.get(alunos.size() - 1);
     }
     return null;
 }

 public int getTopo() {
     return livros.size();
 }

 public Livro getLivroAt(int index) {
     return livros.get(index);
 }

 public Aluno getAlunoAt(int index) {
     return alunos.get(index);
 }

 public void mostrar() {
     System.out.println("=========== LIVROS EMPRESTADOS ===========");
     if (estaVazia()) {
         System.out.println("Nenhum livro emprestado!");
     } else {
         for (int i = 0; i < livros.size(); i++) {
             System.out.println("Titulo: " + livros.get(i).getTitulo());
             System.out.println("Código: " + livros.get(i).getCodigo());
             System.out.println("Ano: " + livros.get(i).getAno());
             System.out.println("Emprestado para: " + alunos.get(i).getNome() + " (Matricula: " + alunos.get(i).getMatricula() + ")");
             System.out.println("=====================================");
         }
     }
 }
}