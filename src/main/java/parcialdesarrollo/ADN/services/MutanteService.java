package parcialdesarrollo.ADN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcialdesarrollo.ADN.repositories.MutanteRepository;

@Service
public class MutanteService {


    private final MutanteRepository mutanteRepository;

    @Autowired
    public MutanteService(MutanteRepository mutanteRepository){
        this.mutanteRepository = mutanteRepository;
    }


    public boolean analyzeDna(String[] dna){

        boolean isMutantAN = isMutant(dna);

        return isMutantAN;
    }

    public static boolean isMutant(String[] dna){

        int contador = 0;
        char[][] dnaAux = convertToChar(dna);

        boolean[][] visited = new boolean[dnaAux.length][dnaAux.length];



        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                if (!visited[i][j]) {
                    if (searchHorizontal(i, j, dnaAux, visited)) {
                        contador++;
                    }
                    if (searchVertical(i, j, dnaAux, visited)) {
                        contador++;
                    }
                    if (searchDiagonal(i, j, dnaAux, visited)) {
                        contador++;
                    }
                    if (searchDiagonalInversa(i, j, dnaAux, visited)) {
                        contador++;
                    }
                }
            }
        }

        if (contador >= 2) {
            return true;
        } else {
            return false;
        }
    }






    public static boolean searchHorizontal(int fila, int columna, char[][] dnaAux, boolean[][] visited) {
        int N = dnaAux.length;
        char x = dnaAux[fila][columna];

        if (columna + 3 >= N) {  // Verifica si hay espacio suficiente
            return false;
        }

        for (int i = columna; i < columna + 4; i++) {
            if (dnaAux[fila][i] != x || visited[fila][i]) {
                return false;
            }
        }

        // Marca las celdas como visitadas
        for (int i = columna; i < columna + 4; i++) {
            visited[fila][i] = true;
        }
        return true;
    }

    // Búsqueda vertical con marcado de visitadas
    public static boolean searchVertical(int fila, int columna, char[][] dnaAux, boolean[][] visited) {
        int N = dnaAux.length;
        char y = dnaAux[fila][columna];

        if (fila + 3 >= N) {  // Verifica si hay espacio suficiente
            return false;
        }

        for (int i = fila; i < fila + 4; i++) {
            if (dnaAux[i][columna] != y || visited[i][columna]) {
                return false;
            }
        }

        // Marca las celdas como visitadas
        for (int i = fila; i < fila + 4; i++) {
            visited[i][columna] = true;
        }
        return true;
    }

    // Búsqueda diagonal hacia abajo con marcado de visitadas
    public static boolean searchDiagonal(int fila, int columna, char[][] dnaAux, boolean[][] visited) {
        int N = dnaAux.length;
        char xy = dnaAux[fila][columna];

        if (fila + 3 >= N || columna + 3 >= N) {  // Verifica si hay espacio suficiente
            return false;
        }

        for (int k = 0; k < 4; k++) {
            if (dnaAux[fila + k][columna + k] != xy || visited[fila + k][columna + k]) {
                return false;
            }
        }

        // Marca las celdas como visitadas
        for (int k = 0; k < 4; k++) {
            visited[fila + k][columna + k] = true;
        }
        return true;
    }

    // Búsqueda diagonal inversa hacia arriba con marcado de visitadas
    public static boolean searchDiagonalInversa(int fila, int columna, char[][] dnaAux, boolean[][] visited) {
        int N = dnaAux.length;
        char xy = dnaAux[fila][columna];

        if (fila - 3 < 0 || columna + 3 >= N) {  // Verifica si hay espacio suficiente
            return false;
        }

        for (int k = 0; k < 4; k++) {
            if (dnaAux[fila - k][columna + k] != xy || visited[fila - k][columna + k]) {
                return false;
            }
        }

        // Marca las celdas como visitadas
        for (int k = 0; k < 4; k++) {
            visited[fila - k][columna + k] = true;
        }
        return true;
    }





    public  static char[][] convertToChar(String[] dna){

        int N = dna.length;

        char[][] dnaChar = new char[N][N];

        for(int i=0; i< N;i ++){
            dnaChar[i] = dna[i].toCharArray();
        }
        return dnaChar;
    }



}
