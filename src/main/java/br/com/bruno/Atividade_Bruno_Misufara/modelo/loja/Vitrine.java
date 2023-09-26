package br.com.bruno.Atividade_Bruno_Misufara.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Vitrine")
public class Vitrine implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY para geração automática de chaves primárias
    private UUID id;
    private Date dataInicio;
    private Date dataFim;

    @OneToMany(mappedBy = "vitrine", cascade = CascadeType.ALL)
    private List<ItensVitrine> listaProdutos;

    public Vitrine() {
    }

    public Vitrine(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<ItensVitrine> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ItensVitrine> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
