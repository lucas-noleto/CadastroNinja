package dev.Java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar missao especifica
    public MissoesModel listarMissoesID (Long id){
        Optional <MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    //Cria missão
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Deletar missao
    public void deletarMissao (Long id){
        missoesRepository.deleteById(id);
    }
}
