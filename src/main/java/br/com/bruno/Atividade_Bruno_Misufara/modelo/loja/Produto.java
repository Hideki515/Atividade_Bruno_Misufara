package br.com.bruno.Atividade_Bruno_Misufara.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;
    private Double valor;
    private int qtdeEstoque;
    private int estoqueMinimo;
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "secao_id")
    private Secao secao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItensCompra> comprasRealizadas;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItensVitrine> listaVitrines;

    public Produto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public List<ItensCompra> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(List<ItensCompra> comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    public List<ItensVitrine> getListaVitrines() {
        return listaVitrines;
    }

    public void setListaVitrines(List<ItensVitrine> listaVitrines) {
        this.listaVitrines = listaVitrines;
    }

    public List<Produto> pesquisarProdutosBaixoEstoque(List<Produto> listaEstoque){
        List<Produto> listaBaixoEstoque = new ArrayList<>();
        for (Produto produto:listaEstoque){
            if(produto.estoqueMinimo > produto.getQtdeEstoque()){
                listaBaixoEstoque.add(produto);
            }
        }
        return listaBaixoEstoque;
    }
}
