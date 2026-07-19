package com.mgja.act3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mgja.act3.models.Jugador;
import com.mgja.act3.services.IEquipoService;
import com.mgja.act3.services.IJugadorService;





@Controller
public class JugadorController 
{
    @Autowired
    private IJugadorService servicio;

    @Autowired
    private IEquipoService equipoService;

    @GetMapping("/")
    public String listarjugadores(Model modelo) 
    {
        modelo.addAttribute("jugador",servicio.listarJugadores());
        return "index";
    }
    
    @GetMapping("/nuevo")
    public String nuevojugador(Model modelo) 
    {
        modelo.addAttribute("jugador", new Jugador());
        modelo.addAttribute("listaEquipos", equipoService.listarEquipos());
        return "form";
    }
    
    @PostMapping("/")
    public String guardarjugador(@ModelAttribute Jugador jugador) 
    {
        servicio.guardarJugador(jugador);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editarjugador(@PathVariable Integer id, Model modelo) 
    {
        Jugador jugador = servicio.obtenerPorId(id);
        modelo.addAttribute("jugador", jugador);
        modelo.addAttribute("listaEquipos", equipoService.listarEquipos());
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarjugador(@PathVariable Integer id) 
    {
        servicio.eliminarJugador(id);
        return "redirect:/";
    }
    
}
