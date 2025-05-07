package dev.Java10x.CadastroDeNinjas.Ninjas;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforuma uma classe em uma entidade do DB
@Entity
@Table(name= "tbcadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private int idade;

    //Um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira

    private MissoesModel missoes;


    //No args constructor


    //Arg constructor


}
