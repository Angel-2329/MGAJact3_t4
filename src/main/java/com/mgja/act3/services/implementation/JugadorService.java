package com.mgja.act3.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgja.act3.models.Jugador;
import com.mgja.act3.repository.JugadorRepository;
import com.mgja.act3.services.IJugadorService;

@Service
public class JugadorService implements IJugadorService 
{
    @Autowired
    private JugadorRepository repositorio;

    @Override
    public List<Jugador> listarJugadores()
    {
        return repositorio.findAll();
    }

    @Override
    public void guardarJugador (Jugador jugador)
    {
        repositorio.save(jugador);
    }

    @Override
    public Jugador obtenerPorId(Integer id)
    {
        return  repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarJugador (Integer id)
    {
        repositorio.deleteById(id);
    }
}