package com.baufest.ingreso.alphabetSoup;

import java.util.ArrayList;
import java.util.List;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]) {
        this.soup = soup;
    }

    /**
     * El objetivo de este ejercicio es implementar una función que determine si una palabra está en una sopa de letras.
     * <p>
     * ### Reglas
     * - Las palabras pueden estar dispuestas direcciones horizontal o vertical, _no_ en diagonal.
     * - Las palabras pueden estar orientadas en cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
     * para abajo o viceversa.
     * - El cambio de dirección puede estar a media palabra, de modo que, por ejemplo, parte de la palabra
     * esté horizontal y de izquierda a derecha, parte esté vertical y de arriba hacia abajo, y otra parte horizontal
     * de derecha a la izquierda.
     *
     * @param word Palabra a buscar en la sopa de letras.
     * @return {@link Boolean}	true si la palabra se encuentra
     * en la sopa de letras.
     */
    public boolean isPresent(String word) {
        //primero busco si la primer letra de la palabra esta presente, y luego tengo que recorrer desde ese punto buscando la palabra,
        //en caso que la palabra no sea esa, tengo que continuar buscando la siguiente aparicion de la primer letra de la palabra
        char[] letras = word.toCharArray();
        boolean encontrada = false;
        //buscar la  letra
        for (int i = 0; i < this.soup.length && !encontrada; i++) {
            for (int j = 0; j < this.soup[i].length && !encontrada; j++) {
                if (this.soup[i][j] == letras[0]) {
                    encontrada = esLaPalabra(i, j, 1, letras);//comprueba si la palara esta desde esta posicion, buscando la letra siguiente
                }
            }
        }
        return encontrada;
    }

    private boolean esLaPalabra(int i, int j, int letra, char[] letras) {
        boolean lastChar = letra == letras.length - 1;
        if (lastChar) { //caso base
            if (i + 1 < soup.length && soup[i + 1][j] == letras[letra]) {
                return true;
            } else if (i - 1 >= 0 && soup[i - 1][j] == letras[letra]) {
                return true;
            } else if (j + 1 < soup[i].length && soup[i][j + 1] == letras[letra]) {
                return true;
            } else if (i - 1 >= 0 && soup[i][j - 1] == letras[letra]) {
                return true;
            } else {
                return false;
            }

        } else { //paso recursivo
            if (i + 1 < soup.length && soup[i + 1][j] == letras[letra] && esLaPalabra(i + 1, j, letra + 1, letras)) {
                return true;
            } else if (i - 1 >= 0 && soup[i - 1][j] == letras[letra] && esLaPalabra(i - 1, j, letra + 1, letras)) {
                return true;
            } else if (j + 1 < soup[i].length && soup[i][j + 1] == letras[letra] && esLaPalabra(i, j + 1, letra + 1, letras)) {
                return true;
            } else if (j - 1 >= 0 && soup[i][j - 1] == letras[letra] && esLaPalabra(i, j - 1, letra + 1, letras)) {
                return true;
            } else {
                return false;
            }

        }
    }
}