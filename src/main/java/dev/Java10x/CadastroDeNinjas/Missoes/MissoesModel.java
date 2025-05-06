package dev.Java10x.CadastroDeNinjas.Missoes;

import dev.Java10x.CadastroDeNinjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private String dificuldade;

    //Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

    public MissoesModel(String nomeMissao, String dificuldade, List<NinjaModel> ninja) {
        this.nomeMissao = nomeMissao;
        this.dificuldade = dificuldade;
        this.ninja = ninja;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    //teste do amend
    //mais um amend
    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinja() {
        return ninja;
    }

    public void setNinja(List<NinjaModel> ninja) {
        this.ninja = ninja;
    }
}
