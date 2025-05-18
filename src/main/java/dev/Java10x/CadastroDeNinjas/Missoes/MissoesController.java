package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesServices missoesServices;

    public MissoesController(MissoesServices missoesServices){
        this.missoesServices = missoesServices;
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesServices.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        return missoesServices.alterarMissao(id, missaoAtualizada);
    }

    @GetMapping("/todos/{id}")
    public MissoesDTO listarMissaoID(@PathVariable Long id){
        return missoesServices.listarMissoesID(id);
    }

    @GetMapping("/todos")
    public List<MissoesDTO> listarTodasMissoes(){
        return missoesServices.listarMissoes();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoID(@PathVariable Long id){
        missoesServices.deletarMissao(id);
    }
}