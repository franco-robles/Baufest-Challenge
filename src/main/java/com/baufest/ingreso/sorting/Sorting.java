package com.baufest.ingreso.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores){
        Comparator<Jugador> comparar  =  new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                if(o2.getPuntuacion() - o1.getPuntuacion() != 0){
                    //para ordenar por puntuacion de manera decendente
                    return o2.getPuntuacion() - o1.getPuntuacion();
                }else{
                    // en caso de empate con la puntuacion esto permite
                    // ordena por nombre de manera a asendente
                    return o1.getNombre().compareTo(o2.getNombre());
                }

            }
        };
        Collections.sort(jugadores, comparar);
        return jugadores;
	}

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
     * nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores){
        Comparator<Jugador> comparar = new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                if(o1.getPuntuacion() == o2.getPuntuacion()){
                    if(o1.getPerdidas() == o2.getPerdidas()){
                        return o1.getNombre().compareTo(o2.getNombre());
                    }
                    return o1.getPerdidas() - o2.getPerdidas();
                }else{
                    return  o2.getPuntuacion() - o1.getPuntuacion();
                }

            }
        };
        Collections.sort(jugadores, comparar);
        return jugadores;
	}
}
