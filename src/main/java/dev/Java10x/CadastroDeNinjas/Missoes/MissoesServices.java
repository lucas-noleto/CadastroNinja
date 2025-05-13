package dev.Java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesServices {

    private MissoesRepository missoesRepository;

    public MissoesServices(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes (){
        return missoesRepository.findAll();
    }
}
