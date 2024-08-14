package entidades;

//Classe Livro representando os livros da biblioteca
public class Livro {
 String titulo;
 int codigo; // Elemento único do livro
 private int ano;
 private char status; // Se o livro está emprestado ou se está livre (E/L)

 // Construtor
 public Livro(String titulo, int codigo, int ano, char status) {
     this.titulo = titulo;
     this.codigo = codigo;
     this.ano = ano;
     this.status = status;
 }

 // Getters e Setters
 public String getTitulo() {
     return titulo;
 }

 public void setTitulo(String titulo) {
     this.titulo = titulo;
 }

 public int getCodigo() {
     return codigo;
 }

 public void setCodigo(int codigo) {
     this.codigo = codigo;
 }

 public int getAno() {
     return ano;
 }

 public void setAno(int ano) {
     this.ano = ano;
 }

 public char getStatus() {
     return status;
 }

 public void setStatus(char status) {
     this.status = status;
 }
}