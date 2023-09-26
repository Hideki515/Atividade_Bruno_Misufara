package br.com.bruno.Atividade_Bruno_Misufara.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dataNascimento;
    
    //Relacionamento 1..* com a classe Compra
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> listaCompras;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public void setDataNascimento(String dataNascimento){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try{
            sdf.setLenient(false);
            this.dataNascimento = sdf.parse(dataNascimento);
        } catch (ParseException ex){
            System.out.println("A data deve estar no formato dd/mm/yyyy");
        }
    }

    public int calcularIdade(){
        if (this.dataNascimento != null){
            //calcular a idade
            Calendar dtNasc = new GregorianCalendar();
            dtNasc.setTime(this.dataNascimento);
            Calendar hoje = Calendar.getInstance();
            int idade = hoje.get(Calendar.YEAR) - dtNasc.get(Calendar.YEAR);
            dtNasc.add(Calendar.YEAR, idade);
            if (hoje.before(dtNasc)){
                idade --;
            }
            return idade;
        }else {
            return 0;
        }
    }
}
