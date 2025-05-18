package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesServices {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesServices(MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Listar todas as missões
    public List<MissoesDTO> listarMissoes() {
        return missoesRepository.findAll()
                .stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Listar missão por ID
    public MissoesDTO listarMissoesID(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    // Criar missão
    public MissoesDTO criarMissao(MissoesDTO missao) {
        MissoesModel missaoModel = missoesMapper.map(missao);
        MissoesModel salvo = missoesRepository.save(missaoModel);
        return missoesMapper.map(salvo);
    }

    // Deletar missão
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    // Alterar missão
    public MissoesDTO alterarMissao(Long id, MissoesDTO missaoAlteradaDTO) {
        if (missoesRepository.existsById(id)) {
            MissoesModel missaoAtualizada = missoesMapper.map(missaoAlteradaDTO);
            missaoAtualizada.setId(id);
            MissoesModel salvo = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(salvo);
        }
        return null;
    }
}