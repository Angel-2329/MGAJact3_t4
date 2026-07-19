package com.mgja.act3.services;

import java.util.List;

import com.mgja.act3.models.Jugador;

public interface  IJugadorService 
{
    List<Jugador> listarJugadores();
    void guardarJugador (Jugador jugador);
    Jugador obtenerPorId (Integer id);
    void eliminarJugador (Integer id);
}
