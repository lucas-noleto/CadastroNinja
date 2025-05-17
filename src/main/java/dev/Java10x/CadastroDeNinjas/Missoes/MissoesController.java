package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")


public class MissoesController {

    private MissoesServices missoesServices;

    private MissoesController (MissoesServices missoesServices){
    this.missoesServices = missoesServices;
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){

        return missoesServices.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesServices.alterarMissao(id, missaoAtualizada);
    }

    @GetMapping("/todos/{id}")
    public MissoesModel listarMissaoID(@PathVariable Long id){
        return missoesServices.listarMissoesID(id);
    }

    @GetMapping("/todos")
    public List<MissoesModel> listarTodasMissoes(){

        return missoesServices.listarMissoes();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoID(@PathVariable Long id){

        missoesServices.deletarMissao(id);
    }

}
