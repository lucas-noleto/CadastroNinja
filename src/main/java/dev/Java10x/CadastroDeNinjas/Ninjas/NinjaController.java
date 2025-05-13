package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjasServices ninjasServices;

    public NinjaController(NinjasServices ninjasServices){
        this.ninjasServices=ninjasServices;
    }

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
    @GetMapping("/todos/{id}")
    public NinjaModel listarNinjaID(@PathVariable Long id){

        return ninjasServices.listarNinjasID(id);
    }


    //mostrar todos os ninjas
    @GetMapping("/todos")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjasServices.listarNinjas();

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
