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
    public String criarMissao(){
        return "Missão criada com sucesso!";
    }

    @PutMapping("/alterarID")
    public String alterarMissao(){
        return "Missão alterada com sucesso!";
    }

    @GetMapping("/listarID")
    public String listarMissaoPorID(){
        return "Missão listada com sucesso";
    }

    @GetMapping("/todos")
    public List<MissoesModel> listarTodasMissoes(){

        return missoesServices.listarMissoes();
    }

    @DeleteMapping("/deletarID")
    public String deletarMissaoID(){
        return "Deletando missão por id";
    }

}
