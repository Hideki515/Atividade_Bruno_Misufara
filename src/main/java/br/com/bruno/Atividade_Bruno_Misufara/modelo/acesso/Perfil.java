package br.com.bruno.Atividade_Bruno_Misufara.modelo.acesso;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

@Entity
@PrimaryKeyJoinColumn(name = "Id_Perfil")
public class Perfil implements Serializable {

    @Id
    private Integer id;
    private String descricao;

    //Relacionamento 0..* com a classe UsuarioADM
    private List<UsuarioADM> listaUsuarios;

    public Perfil() {
    }

    public Perfil(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<UsuarioADM> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioADM> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
