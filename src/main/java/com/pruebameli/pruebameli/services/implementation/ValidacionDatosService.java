package com.pruebameli.pruebameli.services.implementation;

import com.pruebameli.pruebameli.services.IValidacionDatosService;
import com.pruebameli.pruebameli.utilities.Constantes;
import com.pruebameli.pruebameli.utilities.exceptions.BussinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
@Slf4j
public class ValidacionDatosService implements IValidacionDatosService {

    /**
     * Metodo que valida que los datos ingresados correspondan a los permitidos (A,T,C,G)
     *
     * @param dna cadena de dna suministrada
     * @return true si son validos
     */
    @Override
    public char[][] validarBasesNitrogenadas(String[] dna) throws BussinessException {
        int lengthTable = dna.length;
        char[][] table = new char[lengthTable][lengthTable];
        for (int i = 0; i < lengthTable; i++) {
            if (dna[i].length() != lengthTable || dna[i].length() < 4)
                throw new BussinessException(Constantes.ERROR_DNA_LONGUITUD);

            char[] items = dna[i].toCharArray();
            for (char item : items) {
                if (Arrays.stream(Constantes.BASESNITROGENADAS).noneMatch(base -> base.equals(String.valueOf(item))))
                    throw new BussinessException(Constantes.ERROR_DNA_ERRONEO);
            }
            table[i] = items;
        }
        return table;
    }

    /**
     * Metodo que valida las secuencias en la matriz adn
     *
     * @param adn tabla adn generada con base a los dna ingresados
     * @return true si es mutante false si no lo es
     */
    @Override
    public boolean validarCoincidencias(char[][] adn) {
        int contadorSecuencias = 0;
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn.length; j++) {
                contadorSecuencias = contadorSecuencias + this.secuenciasHorizontales(adn, i, j);
                if (contadorSecuencias > 1)
                    return true;

                contadorSecuencias = contadorSecuencias + this.secuenciasVerticales(adn, i, j);
                if (contadorSecuencias > 1)
                    return true;

                contadorSecuencias = contadorSecuencias + this.secuenciasDiagonales(adn, i, j);
                if (contadorSecuencias > 1)
                    return true;

            }
        }
        return false;
    }


    /**
     * Metodo que valida si contiene una secuencias de manera horizontal
     *
     * @param adn cadena de adn
     * @param i   iterador
     * @param j   iterador
     * @return cantidad de secuencias encontradas
     */
    private int secuenciasHorizontales(char[][] adn, int i, int j) {
        int contadorSecuencias = 0;
        if (adn.length - j >= 4 &&
                adn[i][j] == adn[i][j + 1] &&
                adn[i][j] == adn[i][j + 2] &&
                adn[i][j] == adn[i][j + 3]) {
            log.info(String.format("validacion horizontal  %s %s %s %s", adn[i][j], adn[i][j + 1], adn[i][j + 2], adn[i][j + 3]));
            contadorSecuencias++;
        }
        return contadorSecuencias;
    }

    /**
     * Metodo que valida si contiene una secuencias de manera vertical
     *
     * @param adn cadena de adn
     * @param i   iterador
     * @param j   iterador
     * @return cantidad de secuencias encontradas
     */
    private int secuenciasVerticales(char[][] adn, int i, int j) {
        int contadorSecuencias = 0;
        if (adn.length - i >= 4 &&
                adn[i][j] == adn[i + 1][j] &&
                adn[i][j] == adn[i + 2][j] &&
                adn[i][j] == adn[i + 3][j]) {
            log.info(String.format("validacion vertical %s %s %s %s", adn[i][j], adn[i + 1][j], adn[i + 2][j], adn[i + 3][j]));
            contadorSecuencias++;
        }
        return contadorSecuencias;

    }

    /**
     * Metodo que valida si contiene una secuencias de manera diagonal
     * tanto derecha izquierda, como izquierda derecha
     *
     * @param adn cadena de adn
     * @param i   iterador
     * @param j   iterador
     * @return cantidad de secuencias encontradas
     */
    private int secuenciasDiagonales(char[][] adn, int i, int j) {
        int contadorSecuencias = 0;
        if (adn.length - i >= 4 && adn.length - j >= 4) {
            if (adn[i][j] == adn[i + 1][j + 1] &&
                    adn[i][j] == adn[i + 2][j + 2] &&
                    adn[i][j] == adn[i + 3][j + 3]
            ) {
                contadorSecuencias++;
                log.info(String.format("validacion diagonal izquierda derecha" +
                        " %s %s %s %s", adn[i][j], adn[i + 1][j + 1], adn[i + 2][j + 2], adn[i + 3][j + 3]));
            }
            int acumulado = adn.length - 1 - j;
            if (adn[i][acumulado] == adn[i + 1][acumulado - 1] &&
                    adn[i][acumulado] == adn[i + 2][acumulado - 2] &&
                    adn[i][acumulado] == adn[i + 3][acumulado - 3]
            ) {
                contadorSecuencias++;
                log.info(String.format("validacion diagonal derecha izquierda" +
                                " %s %s %s %s", adn[i][acumulado], adn[i + 1][acumulado - 1],
                        adn[i + 2][acumulado - 2], adn[i + 3][acumulado - 3]));
                if (contadorSecuencias > 1)
                    return contadorSecuencias;
            }

        }
        return contadorSecuencias;
    }

}
