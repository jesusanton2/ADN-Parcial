package parcialdesarrollo.ADN.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class MutanteServiceTest {


    @Test
    public void testRows() {
        char[][] dna = {
                {'A', 'A', 'A', 'A', 'G', 'T'},
                {'T', 'G', 'C', 'A', 'G', 'T'},
                {'G', 'C', 'T', 'T', 'C', 'C'},
                {'C', 'C', 'C', 'C', 'T', 'G'},
                {'G', 'T', 'A', 'G', 'T', 'C'},
                {'A', 'A', 'A', 'A', 'A', 'C'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }

    @Test
    public void testColumns() {
        char[][] dna = {
                {'A', 'G', 'A', 'A', 'T', 'G'},
                {'T', 'G', 'C', 'A', 'G', 'T'},
                {'G', 'C', 'T', 'T', 'C', 'C'},
                {'G', 'T', 'C', 'C', 'T', 'C'},
                {'G', 'T', 'A', 'G', 'T', 'C'},
                {'G', 'G', 'T', 'C', 'A', 'C'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }

    @Test
    public void testDiagonals() {
        char[][] dna = {
                {'A', 'G', 'C', 'T', 'A', 'G'},
                {'T', 'A', 'C', 'C', 'G', 'T'},
                {'G', 'A', 'A', 'C', 'C', 'C'},
                {'T', 'T', 'G', 'A', 'C', 'G'},
                {'G', 'A', 'C', 'C', 'T', 'C'},
                {'A', 'T', 'G', 'C', 'A', 'A'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }

    @Test
    public void testSecondaryLeftDiagonals() {
        char[][] dna = {
                {'A', 'T', 'A', 'A', 'T', 'G'},
                {'G', 'T', 'T', 'G', 'G', 'T'},
                {'G', 'T', 'G', 'G', 'A', 'G'},
                {'T', 'G', 'G', 'A', 'T', 'G'},
                {'G', 'T', 'A', 'G', 'T', 'C'},
                {'A', 'A', 'T', 'C', 'A', 'A'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }




    @Test
    public void testNonMutant() {
        char[][] dna = {
                {'A', 'T', 'G', 'A', 'T', 'G'},
                {'G', 'T', 'C', 'T', 'T', 'A'},
                {'A', 'A', 'T', 'G', 'G', 'A'},
                {'A', 'C', 'T', 'A', 'G', 'T'},
                {'G', 'G', 'A', 'T', 'C', 'C'},
                {'A', 'G', 'G', 'C', 'A', 'A'}
        };
        assertFalse(MutanteService.isMutant(dna));
    }


    @Test
    public void testMutant1() {
        char[][] dna = {
                {'A', 'A', 'A', 'A'},
                {'C', 'C', 'A', 'A'},
                {'T', 'C', 'A', 'G'},
                {'G', 'G', 'G', 'G'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }

    @Test
    public void testNonMutant1() {
        char[][] dna = {
                {'A', 'A', 'A', 'T'},
                {'T', 'A', 'C', 'C'},
                {'A', 'A', 'C', 'A'},
                {'C', 'G', 'G', 'G'}
        };
        assertFalse(MutanteService.isMutant(dna));
    }

    @Test
    public void testMutant2() {
        char[][] dna = {
                {'T', 'G', 'A', 'C'},
                {'A', 'G', 'C', 'C'},
                {'T', 'G', 'A', 'C'},
                {'G', 'G', 'T', 'C'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }

    @Test
    public void testMutant3() {
        char[][] dna = {
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'}
        };
        assertTrue(MutanteService.isMutant(dna));
    }

    @Test
    public void testNonMutant2() {
        char[][] dna = {
                {'T', 'G', 'A', 'C'},
                {'A', 'T', 'C', 'C'},
                {'T', 'A', 'A', 'G'},
                {'G', 'G', 'T', 'C'}
        };
        assertFalse(MutanteService.isMutant(dna));
    }

    @Test
    public void testMutant4() {
        char[][] dna = {
                {'T', 'C', 'G', 'G', 'G', 'T', 'A', 'T'},
                {'T', 'G', 'A', 'T', 'C', 'C', 'T', 'T'},
                {'A', 'A', 'C', 'G', 'A', 'G', 'T', 'G'},
                {'A', 'A', 'A', 'T', 'G', 'T', 'A', 'C'},
                {'A', 'C', 'G', 'A', 'C', 'T', 'G', 'C'},
                {'A', 'G', 'A', 'C', 'A', 'C', 'A', 'T'},
                {'G', 'A', 'A', 'T', 'T', 'C', 'C', 'A'},
                {'A', 'C', 'T', 'A', 'C', 'G', 'A', 'C'}


        };
        assertTrue(MutanteService.isMutant(dna));
    }
}
