package com.mgja.act3.services;

import java.util.List;

import com.mgja.act3.models.Equipo;

public interface  IEquipoService 
{
    List<Equipo> listarEquipos();
    void guardarEquipo(Equipo equipo);
    Equipo obtenerPorId(Integer id);
    void eliminarEquipo (Integer id);
}
