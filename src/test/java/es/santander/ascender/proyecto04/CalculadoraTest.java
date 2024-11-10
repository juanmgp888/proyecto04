package es.santander.ascender.proyecto04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testSumar(){
        int resultadoSumar = Calculadora.sumar(2,6);
        assertEquals(8, resultadoSumar );

        /* o bien
            clase       variable    = new instancia de la clase
         * Calculadora caluladorita = new Calculadora
         * int resultadoSumar = calculadorita.sumar(2,6);
         * assertEquals(8, resultadoSumar);
         * Al ser un método estático, no necesita instanciar la clase. La usa directamente.
         * Además, JUnit permite, a veces, no tener que instanciar.
         */
    }
    @Test 
    public void testRestar(){
        // Como el método restar no es estático en la clase Calculadora, esta vez sí tengo que
        // instanciar la clase.
        Calculadora calculadorita = new Calculadora();
        int resultadoRestar = calculadorita.restar(5,2);
        assertEquals(5-2, resultadoRestar);
    }
}
