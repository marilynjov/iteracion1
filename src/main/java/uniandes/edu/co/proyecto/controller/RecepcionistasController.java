package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecepcionistasController {
    
    @GetMapping("/recepcionistas")
    public String recepcionistas() {
        return "recepcionistas"; 
        
    } 
}

