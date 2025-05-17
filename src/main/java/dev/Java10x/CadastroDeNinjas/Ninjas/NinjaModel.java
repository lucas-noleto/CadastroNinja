package dev.Java10x.CadastroDeNinjas.Ninjas;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

//Entity transforuma uma classe em uma entidade do DB
@Entity
@Table(name= "tbcadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name="img_url")
    private String imgUrl;

    @Column(name="idade")
    private int idade;

    //Um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira

    private MissoesModel missoes;


    //No args constructor


    //Arg constructor


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
