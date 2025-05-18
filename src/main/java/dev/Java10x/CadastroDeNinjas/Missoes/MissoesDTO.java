package dev.Java10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class MissoesDTO {



        private Long id;
        private String nomeMissao;
        private String dificuldade;
        private List<NinjaModel> ninja;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNomeMissao() {
            return nomeMissao;
        }

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
