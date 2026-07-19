package com.mgja.act3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mgja.act3.models.Equipo;
import com.mgja.act3.services.IEquipoService;

@Controller
public class EquipoController 
{
    @Autowired
    private IEquipoService equipoServicio;

    @GetMapping("/equipos")
    public String listarEquipos(Model modelo) 
    {
        modelo.addAttribute("equipos", equipoServicio.listarEquipos());
        return "listaEquipos";
    }

    @GetMapping("/nuevo-equipo")
    public String nuevoEquipo(Model modelo) 
    {
        modelo.addAttribute("equipo", new Equipo());
        return "formEquipo";
    }

    @PostMapping("/guardar-equipo")
    public String guardarEquipo(@ModelAttribute Equipo equipo) 
    {
        equipoServicio.guardarEquipo(equipo);
        return "redirect:/equipos";
    }
    
    @GetMapping("/editar-equipo/{id}")
    public String editarEquipo(@PathVariable Integer id, Model modelo) 
    {
        modelo.addAttribute("equipo", equipoServicio.obtenerPorId(id));
        return "formEquipo";
    }

    @GetMapping("/eliminar-equipo/{id}")
    public String eliminarjugador(@PathVariable Integer id) 
    {
        equipoServicio.eliminarEquipo(id);
        return "redirect:/";
    }
}