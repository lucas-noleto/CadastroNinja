package dev.Java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjasServices {

    private NinjasRepository ninjasRepository;

    public NinjasServices(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }

    //Listar todos os ninjas
    public List <NinjaModel> listarNinjas(){
        return ninjasRepository.findAll();
    }

    //Listar ninja por ID
    public NinjaModel listarNinjasID(Long id ){
        Optional<NinjaModel> ninjaModel = ninjasRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja( NinjaModel ninja){
        return ninjasRepository.save(ninja);

    }

    //Deletar ninja
    public void deletarNinja(Long id){
        ninjasRepository.deleteById(id);
    }

    //Editar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjasRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjasRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
