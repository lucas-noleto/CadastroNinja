package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){

        return "Essa é minha primeira mensagem nessa página!";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado!";
    }


    //procurar ninja por ID
    @GetMapping("/todosID")
    public String mostrarNinjaPorID(){

        return "Mostrar ninja por id";
    }


    //mostrar todos os ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar todos os ninjas";

    }

    //editar ninja
    @PutMapping("alterarID")
    public String alterarNinjaPorID(){
        return "Alterar ninja por id";
    }

    //deletar
    @DeleteMapping("/deletar")
    public String deletarNinjaPorID(){
        return "Deletando ninja por id";
    }


}
