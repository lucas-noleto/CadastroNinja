package dev.Java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjasServices {

    private final NinjasRepository ninjasRepository;
    private final NinjaMapper ninjaMapper;

    public NinjasServices(NinjasRepository ninjasRepository, NinjaMapper ninjaMapper) {
        this.ninjasRepository = ninjasRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
//        return ninjasRepository.findAll()
//                .stream()
//                .map(ninjaMapper::map)
//                .collect(Collectors.toList());
        List<NinjaModel> ninjas = ninjasRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());


    }

    // Listar ninja por ID
    public NinjaDTO listarNinjasID(Long id ){
        Optional<NinjaModel> ninjaModel = ninjasRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        NinjaModel salvo = ninjasRepository.save(ninja);
        return ninjaMapper.map(salvo);
    }

    // Deletar ninja
    public void deletarNinja(Long id){
        ninjasRepository.deleteById(id);
    }

    // Editar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaAtualizadoDTO){
        if(ninjasRepository.existsById(id)){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaAtualizadoDTO);
            ninjaAtualizado.setId(id);
            NinjaModel salvo = ninjasRepository.save(ninjaAtualizado);
            return ninjaMapper.map(salvo);
        }
        return null;
    }
}