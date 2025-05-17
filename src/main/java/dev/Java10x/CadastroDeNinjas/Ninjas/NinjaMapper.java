package dev.Java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjasModel = new NinjaModel();
        ninjasModel.setId(ninjaDTO.getId());
        ninjasModel.setNome(ninjaDTO.getNome());
        ninjasModel.setEmail(ninjaDTO.getEmail());
        ninjasModel.setIdade(ninjaDTO.getIdade());
        ninjasModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjasModel.setMissoes(ninjaDTO.getMissoes());
        ninjasModel.setRank(ninjaDTO.getRank());

        return ninjasModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setRank(ninjaModel.getRank());

        return ninjaDTO;
    }



}
