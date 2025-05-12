package com.orbis.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.orbis.ventas.business.EditorialBusiness;
import com.orbis.ventas.business.LibroBusiness;
import com.orbis.ventas.domain.Editorial;
import com.orbis.ventas.domain.Libro;


@Controller
public class LibroController {
    
    @Autowired
    private EditorialBusiness editorialBusiness;
    @Autowired
    private LibroBusiness libroBusiness;
    
 
    @GetMapping("/editoriales")
    public String listarEditoriales(Model model) {
        model.addAttribute("editoriales", editorialBusiness.findAll());
        return "ver_editoriales"; 
//         return "allEditoriales"; // otro template
    }
    
    @GetMapping("/libros/{idEditorial}")
    public String buscarPorEditorial(@PathVariable Integer idEditorial, Model model) {
        Editorial editorial = editorialBusiness.findById(idEditorial); 
        List<Libro> libros = libroBusiness.findByEditorial(idEditorial);

        model.addAttribute("libros", libros); 
        model.addAttribute("editorial", editorial);

        return "mostrar_libros"; 
    }
   
    
    
}