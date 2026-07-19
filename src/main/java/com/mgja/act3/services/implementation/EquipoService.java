package com.mgja.act3.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgja.act3.models.Equipo;
import com.mgja.act3.repository.EquipoRepository;
import com.mgja.act3.services.IEquipoService;

@Service
public class EquipoService implements IEquipoService
{
    @Autowired
    private EquipoRepository repositorio;

    @Override
    public List<Equipo> listarEquipos ()
    {
        return repositorio.findAll();
    }

    @Override
    public void guardarEquipo(Equipo equipo) 
    {
        repositorio.save(equipo);
    }

    @Override
    public Equipo obtenerPorId(Integer id) 
    {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarEquipo(Integer id) 
    {
        repositorio.deleteById(id);
    }
}
