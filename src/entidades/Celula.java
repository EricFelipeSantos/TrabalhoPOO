package entidades;

//Classe Celula utilizada na lista duplamente encadeada
public class Celula {
 Livro livro;
 Celula anterior;
 Celula proximo;

 // Construtor
 public Celula(Livro livro) {
     this.livro = livro;
     this.anterior = null;
     this.proximo = null;
 }

 // Getters e Setters
 public Livro getLivro() {
     return livro;
 }

 public void setLivro(Livro livro) {
     this.livro = livro;
 }

 public Celula getAnterior() {
     return anterior;
 }

 public void setAnterior(Celula anterior) {
     this.anterior = anterior;
 }

 public Celula getProximo() {
     return proximo;
 }

 public void setProximo(Celula proximo) {
     this.proximo = proximo;
 }
}