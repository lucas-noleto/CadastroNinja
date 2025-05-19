package dev.Java10x.CadastroDeNinjas.Missoes;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO salvo = missoesServices.criarMissao(missao);

        return ResponseEntity.status(HttpStatus.CREATED).body("Missão criada com sucesso: "+salvo.getNomeMissao() + " id: "+salvo.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        if(missoesServices.alterarMissao(id,missaoAtualizada)!=null){
            return ResponseEntity.ok("Missão de id: "+id+" editado com sucesso");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de id: " + id + " não encontrado!");
        }


    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<String> listarMissaoID(@PathVariable Long id){
        if (missoesServices.listarMissoesID(id)!=null) {
            MissoesDTO visu= missoesServices.listarMissoesID(id);
            return ResponseEntity.ok("Missao de id: "+id+" Encontrado com sucesso! Segue informações: "
                    +" Nome: "+ visu.getNomeMissao()
                    +" Dificuldade: "+visu.getDificuldade()
                    +" ID: "+visu.getId());


        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de id: " + id + " não encontrado!");
        }
    }

    @GetMapping("/todos")
    public List<MissoesDTO> listarTodasMissoes(){
        return missoesServices.listarMissoes();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoID(@PathVariable Long id){

        if(missoesServices.listarMissoesID(id)!= null) {
            missoesServices.deletarMissao(id);
            return ResponseEntity.ok("Missão de id: "+id+" deletado com sucesso");
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de id: "+id+" não encontrado!");
        }
    }
}