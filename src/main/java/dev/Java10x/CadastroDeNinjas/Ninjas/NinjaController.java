package dev.Java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    @Autowired
    private NinjasServices ninjasServices;

//    public NinjaController(NinjasServices ninjasServices){
//        this.ninjasServices = ninjasServices;
//    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description =
    "essa rota é uma mensagem de boas vindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa página!";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    @Operation(summary = "Cria ninjas", description = "Essa rota é uma mensagem de boas vindas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO ninjaDTO= ninjasServices.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: "+ ninjaDTO.getNome() + " id: "+ninjaDTO.getId());
    }

    // Procurar ninja por ID
    @GetMapping("/todos/{id}")
    public ResponseEntity<String> listarNinjaID(@PathVariable Long id){

        if (ninjasServices.listarNinjasID(id)!=null) {
            NinjaDTO visu= ninjasServices.listarNinjasID(id);
            return ResponseEntity.ok("Ninja de id: "+id+" Encontrado com sucesso! Segue informações: "
                    +" Nome: "+ visu.getNome()
                    +"Email: "+visu.getEmail()
                    +" ID: "+visu.getId()
                    +" Rank: "+visu.getRank());


        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de id: " + id + " não encontrado!");
        }
    }

    // Mostrar todos os ninjas
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas(){
        List<NinjaDTO> visu= ninjasServices.listarNinjas();
        return ResponseEntity.ok(visu);
    }

    // Editar ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorID(@Parameter(description = "Usuario manda id no caminho da requisição")
                                                        @PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        if (ninjasServices.atualizarNinja(id, ninjaAtualizado)!=null) {
            return ResponseEntity.ok("Ninja de id: "+id+" editado com sucesso");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de id: " + id + " não encontrado!");
        }
    }

    // Deletar
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id)
    {
        if(ninjasServices.listarNinjasID(id)!= null) {
            ninjasServices.deletarNinja(id);
            return ResponseEntity.ok("Ninja de id: "+id+" deletado com sucesso");
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de id: "+id+" não encontrado!");
        }
    }
}