package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjasServices ninjasServices;

    public NinjaController(NinjasServices ninjasServices){
        this.ninjasServices = ninjasServices;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa página!";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjasServices.criarNinja(ninja);
    }

    // Procurar ninja por ID
    @GetMapping("/todos/{id}")
    public NinjaDTO listarNinjaID(@PathVariable Long id){
        return ninjasServices.listarNinjasID(id);
    }

    // Mostrar todos os ninjas
    @GetMapping("/todos")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjasServices.listarNinjas();
    }

    // Editar ninja
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjasServices.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjasServices.deletarNinja(id);
    }
}