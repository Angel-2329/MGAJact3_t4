package com.mgja.act3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mgja.act3.models.Jugador;
import com.mgja.act3.repository.JugadorRepository;





@Controller
public class JugadorController 
{
    @Autowired
    private JugadorRepository repositorio;

    @GetMapping("/")
    public String listarjugadores(Model modelo) 
    {
        modelo.addAttribute("jugador",repositorio.findAll());
        return "index";
    }
    
    @GetMapping("/nuevo")
    public String nuevojugador(Model modelo) 
    {
        modelo.addAttribute("messi",new Jugador());
        return "form";
    }
    
    @PostMapping("/")
    public String guardarjugador(@ModelAttribute Jugador jugador) 
    {
        repositorio.save(jugador);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editarjugador(@PathVariable Integer id, Model modelo) 
    {
        Jugador jugador = repositorio.findById(id).orElse(null);
        modelo.addAttribute("jugador", jugador);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarjugador(@PathVariable Integer id) 
    {
        repositorio.deleteById(id);
        return "redirect/";
    }
    
}
