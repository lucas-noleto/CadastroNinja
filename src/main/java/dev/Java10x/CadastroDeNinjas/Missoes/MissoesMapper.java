package dev.Java10x.CadastroDeNinjas.Missoes;

public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNinja(missoesModel.getNinja());
        missoesDTO.setNomeMissao(missoesModel.getNomeMissao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        return missoesModel;

    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNinja(missoesDTO.getNinja());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());

        return missoesDTO;
    }


}
