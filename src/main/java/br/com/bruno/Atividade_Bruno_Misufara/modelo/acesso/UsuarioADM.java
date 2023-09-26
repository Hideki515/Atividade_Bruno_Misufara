package br.com.bruno.Atividade_Bruno_Misufara.modelo.acesso;

import br.com.bruno.Atividade_Bruno_Misufara.modelo.loja.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@PrimaryKeyJoinColumn(name = "Id_ADM")
public class UsuarioADM extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    //Relacionamento 1 com a classe Perfil
    @OneToOne
    @JoinColumn(name = "perfilUsuario")
    private Perfil perfilUsuario;

    public UsuarioADM() {
    }

    public UsuarioADM(String email, String senha) {
        super(email, senha);
    }

    public UsuarioADM(String email, String senha, Perfil perfilUsuario) {
        super(email, senha);
        this.perfilUsuario = perfilUsuario;
    }

    public UsuarioADM(UUID id, String nome, String email, String senha, Perfil perfilUsuario) {
        super(id, nome, email, senha);
        this.perfilUsuario = perfilUsuario;
    }

    public Perfil getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(Perfil perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }


}
