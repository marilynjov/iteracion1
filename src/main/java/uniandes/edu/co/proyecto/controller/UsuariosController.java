package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

//@RestController
@Controller
public class UsuariosController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {

        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios"; 
        
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), "Hilton");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{idusuario}/edit")
    public String usuarioEditarForm(@PathVariable("idusuario") Integer idusuario, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(idusuario);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{idusuario}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("idusuario") Integer idusuario, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(((Integer) idusuario), usuario.getNombre(), usuario.getCorreo(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{idusuario}/delete")
    public String reservaEliminar(@PathVariable("idusuario") Integer idusuario) {
        usuarioRepository.eliminarUsuario(idusuario);
        return "redirect:/usuarios";
    } 

}
