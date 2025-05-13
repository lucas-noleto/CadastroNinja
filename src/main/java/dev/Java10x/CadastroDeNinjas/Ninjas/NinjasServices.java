package dev.Java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;

import java.util.List;

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
}
