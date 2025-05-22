package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/ninjas")
public class NinjaControllerUI {

    private final NinjasServices ninjasServices;

    public NinjaControllerUI(NinjasServices ninjasServices) {
        this.ninjasServices = ninjasServices;
    }

    // Listar todos os ninjas
    @GetMapping("/visualizar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjasServices.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ninjas/visualizar";
    }

    // Visualizar ninja por ID
    @GetMapping("/{id}")
    public String visualizarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjasServices.listarNinjasID(id);
        if (ninja == null) {
            model.addAttribute("erro", "Ninja não encontrado!");
            return "ninjas/erro";
        }
        model.addAttribute("ninja", ninja);
        return "ninjas/visualizar";
    }

    // Formulário de criação
    @GetMapping("/criar")
    public String mostrarFormularioCriar(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "ninjas/criar";
    }

    // Processar criação
    @PostMapping("/criar")
    public String criarNinja(@ModelAttribute NinjaDTO ninja) {
        ninjasServices.criarNinja(ninja);
        return "redirect:/ui/ninjas";
    }

    // Formulário de edição
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjasServices.listarNinjasID(id);
        if (ninja == null) {
            model.addAttribute("erro", "Ninja não encontrado!");
            return "ninjas/erro";
        }
        model.addAttribute("ninja", ninja);
        return "ninjas/editar";
    }

    // Processar edição
    @PostMapping("/editar/{id}")
    public String editarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninja) {
        ninjasServices.atualizarNinja(id, ninja);
        return "redirect:/ui/ninjas";
    }

    // Deletar ninja
    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjasServices.listarNinjasID(id);
        if (ninja == null) {
            model.addAttribute("erro", "Ninja não encontrado!");
            return "ninjas/erro";
        }
        ninjasServices.deletarNinja(id);
        return "redirect:/ui/ninjas";
    }
}