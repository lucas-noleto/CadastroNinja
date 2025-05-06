package dev.Java10x.CadastroDeNinjas;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//Entity transforuma uma classe em uma entidade do DB
@Entity
@Table(name= "tbcadastro_de_ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //Um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira
    private MissoesModel missoes;

    public NinjaModel(){

    }

    public NinjaModel(String nome, String email, int idade, MissoesModel missoes){
        this.email=email;
        this.nome = nome;
        this.idade=idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
