package entidades;

//Classe ListaDuplamenteEncadeada para gerenciar os livros
public class ListaDuplamenteEncadeada extends Celula {
    private Celula primeiro;
    private Celula ultimo;

    public ListaDuplamenteEncadeada() {
        super(null); // Passa null porque esta célula inicial não contém um livro
        this.primeiro = this; // Inicia com a célula que contém null
        this.ultimo = this;
    }

    public boolean estaVazia() {
        return this.primeiro == this.ultimo;
    }

    public Celula getPrimeiro() {
        return primeiro;
    }

    public void inserir(Livro livro) {
        Celula novaCelula = new Celula(livro);
        novaCelula.anterior = this.ultimo;
        this.ultimo.proximo = novaCelula;
        this.ultimo = novaCelula;
    }

    public Celula buscarLivroPorCodigo(int codigo) {
        Celula atual = this.primeiro.proximo;
        while (atual != null) {
            if (atual.livro.codigo == codigo) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void remover(Celula celula) {
        if (celula != null) {
            Celula anterior = celula.anterior;
            Celula proximo = celula.proximo;
            if (anterior != null) {
                anterior.proximo = proximo;
            }
            if (proximo != null) {
                proximo.anterior = anterior;
            }
            if (celula == this.ultimo) {
                this.ultimo = anterior;
            }
        }
    }

    public void mostrar() {
        Celula atual = this.primeiro.proximo;
        System.out.println("=========== LISTA DE LIVROS ===========");
        if (estaVazia()) {
            System.out.println("Lista de livros está vazia!");
        } else {
            while (atual != null) {
                System.out.println("Titulo: " + atual.livro.getTitulo());
                System.out.println("Código: " + atual.livro.getCodigo());
                System.out.println("Ano: " + atual.livro.getAno());
                System.out.println("Status: " + (atual.livro.getStatus() == 'E' ? "Emprestado" : "Disponível"));
                System.out.println("=====================================");
                atual = atual.proximo;
            }
        }
    }
}
