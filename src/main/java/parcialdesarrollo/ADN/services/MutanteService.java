package parcialdesarrollo.ADN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcialdesarrollo.ADN.entities.Mutante;
import parcialdesarrollo.ADN.repositories.MutanteRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MutanteService {


    private final MutanteRepository mutanteRepository;

    @Autowired
    public MutanteService(MutanteRepository mutanteRepository){
        this.mutanteRepository = mutanteRepository;
    }


    public boolean analyzeDna(String[] dna){
        String dnaString = String.join(",", dna);

        Optional<Mutante> existByDna = mutanteRepository.findByDna(dnaString);
            if(existByDna.isPresent()){
                return existByDna.get().isMutante();
            }

      char[][]  dnaMatriz = convertToChar(dna);

            boolean isMutant = isMutant(dnaMatriz);
         Mutante mutanteEntity = Mutante.builder()
                 .dna(dnaString)
                 .isMutante(isMutant)
                 .build();
         mutanteRepository.save(mutanteEntity);
         System.out.println("EntidadGuardada");
        return isMutant(dnaMatriz);
    }

    public Map<String, Object> getStats() {
        long countMutantDna = mutanteRepository.countByIsMutante(true);
        long countHumanDna = mutanteRepository.countByIsMutante(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;

        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", countMutantDna);
        stats.put("count_human_dna", countHumanDna);
        stats.put("ratio", ratio);

        return stats;
    }



    public static boolean isMutant(char[][] dnaAux){


        int N = dnaAux.length;
        int countSequence = 0;
        String fila , columna , diagonalAscDer , diagonalAscIzq ;

        for(int i = 0; i < N ; i++){
            fila = convertRowToText(dnaAux, i);
            countSequence = countSequence + search(fila);
            if(countSequence > 1){
                System.out.println("Mutante");
                return true;
            }
        }

        for(int j = 0; j < N ; j++){
            columna = convertColumnToText(dnaAux, j);
            countSequence = countSequence +  search(columna);
            if(countSequence > 1){

                System.out.println("Mutante");
                return true;
            }
        }

        for (int i = 0; i < N; i++) {
            diagonalAscDer = convertDiagonalAscRightToText(dnaAux, i, 0);  // Diagonales hacia la derecha desde la primera columna
            countSequence += search(diagonalAscDer);
            if (countSequence > 1) {
                System.out.println("Mutante");
                return true;
            }

            if (i != 0) {  // Evitamos duplicar la diagonal desde la esquina superior izquierda
                diagonalAscIzq = convertDiagonalAscLeftToText(dnaAux, i, N - 1);  // Diagonales hacia la izquierda desde la última columna
                countSequence += search(diagonalAscIzq);
                if (countSequence > 1) {
                    System.out.println("Mutante");
                    return true;
                }
            }
        }

        System.out.println("No Mutante");
        return false;
    }

    public static int search(String text){
        int i = 0 , j =0;
        char letra = text.charAt(i);
        int count = 1,sequence = 0;
        i++;
        while(i < text.length() && sequence < 2){


            if(text.charAt(i ) == letra){
                count++;
                if(count == 4){
                    sequence++;
                    count = 0;

                }
            }else if(text.charAt(i) != letra){
                letra = text.charAt(i);
                count = 1 ;
            }
            i++;
        }

        return sequence;
    }

    public static String convertRowToText(char[][] dnaAux, int fila){
        return new String(dnaAux[fila]);
    }


    public static String convertColumnToText(char[][] dnaAux, int col) {
        StringBuilder columna = new StringBuilder();
        for (int i = 0; i < dnaAux.length; i++) {
            columna.append(dnaAux[i][col]);
        }
        return columna.toString();
    }

    public static String convertDiagonalAscRightToText(char[][] dnaAux, int fila, int columna) {
        StringBuilder diagonal = new StringBuilder();

        for (int i = fila, j = columna; i >= 0 && j < dnaAux.length; i--, j++) {
            diagonal.append(dnaAux[i][j]);
        }

        return diagonal.toString();
    }
    public static String convertDiagonalAscLeftToText(char[][] dnaAux, int fila, int columna) {
        StringBuilder diagonal = new StringBuilder();

        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            diagonal.append(dnaAux[i][j]);
        }

        return diagonal.toString();
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
