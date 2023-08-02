package com.baufest.ingreso.strings;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     *     Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     *     Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
        HashMap<Character, Integer> mapCharCant = new HashMap<>();
        //se agrega al map la informacion de cuantas veces aparece cada caracter
        for (char c: cadena.toCharArray()) {
                int cant = mapCharCant.getOrDefault(c, 0);
                mapCharCant.put(c, ++cant);
        }

        HashMap<Integer, Integer> mapCantDeCadaCant = new HashMap<>();
        //carga el map con la cantidad de veces que se repite la cantidad de aparicines
        for(char c: mapCharCant.keySet()){
            int cant = mapCantDeCadaCant.getOrDefault(mapCharCant.get(c), 0)+1;
            mapCantDeCadaCant.put(mapCharCant.get(c), cant);
        }

        if(mapCantDeCadaCant.size() < 2 ){
            //este es el caso en el que cada char tiene la misma cantidad de apariciones
            return true;
        }else if(mapCantDeCadaCant.size() == 2){//hay solo dos cantidades de apariciones
             List<Integer> listKey = mapCantDeCadaCant.keySet().stream().toList();

            // Si una de las cantidades de apariciones es 1 y la diferencia absoluta entre
            // las dos cantidades es 1, entonces es válido.
             if((mapCantDeCadaCant.get(listKey.get(0))==1 || mapCantDeCadaCant.get(listKey.get(1))==1 ) &&
                     (Math.abs(listKey.get(0)-listKey.get(1))==1) ){
                 return true;
             }
             return false;
        }else{
            return false;
        }
    }
}