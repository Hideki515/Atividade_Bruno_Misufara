package br.com.bruno.Atividade_Bruno_Misufara.modelo.loja;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Compra")
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //Identificador utilizado em arquiteturas distribuidas - são universais
    private boolean concluida;
    private Date dataCompra;
    private Double valorFrete;

    //Relacionamento 1 com a classe CLiente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //Relacionamento 1..* com a classe ItensCompra
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<ItensCompra> itensComprados;

    public Compra() {
    }

    public Compra(Date dataCompra, Cliente cliente) {
        this.dataCompra = dataCompra;
        this.cliente = cliente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensCompra> getItensComprados() {
        return itensComprados;
    }

    public void setItensComprados(List<ItensCompra> itensComprados) {
        this.itensComprados = itensComprados;
    }

    public Double calcularValorFinal(){
        //Multiplicar a qtde pelo valor e somar
        Double totalCompra = 0.0;

        for (ItensCompra item :itensComprados){
            totalCompra += item.getQuantidade()*item.getValor();
        }
        return totalCompra;
    }



}
