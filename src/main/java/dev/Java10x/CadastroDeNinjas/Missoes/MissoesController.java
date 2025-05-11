package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")


public class MissoesController {

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

    @GetMapping("/listarTudo")
    public String listarTodasMissoes(){
        return "Listar todas as missões";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissaoID(){
        return "Deletando missão por id";
    }

}
