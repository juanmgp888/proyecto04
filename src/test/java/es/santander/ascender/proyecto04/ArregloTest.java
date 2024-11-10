package es.santander.ascender.proyecto04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


public class ArregloTest {
    private static final int TAMANO_REQUERIDO = 100;

    @Test
    public void testCrearCienPrimeros() {
        // Como el método al que vamos a llamar no es static, creamos una instancia
        Arreglo arreglo = new Arreglo();

        // Creamos un arreglo donde volcar el resultado fruto de la llamada al método, para poder comparar
        // y ver si ese método rellena el arreglo con los números del 0-99
        int[] resultado = arreglo.crearCienPrimeros();

        assertNotNull(resultado, "El array recibido de la creación no debe ser nulo");
        assertEquals(TAMANO_REQUERIDO, resultado.length, "Esperaba que arreglo fuera de tamaño 100");
        for (int i = 0 ; i < TAMANO_REQUERIDO; i++) {
            assertEquals(i, resultado[i]);
        }
    }

    @Test
    public void testCrearInvirtiendoOrden() {

        Arreglo cut = new Arreglo();
        int[] origenParaLaPrueba = new int[] {3, 6, -1, 0, 7} ;
        
        int[] resultadoDeLaPrueba = cut.crearInvirtiendoOrden(origenParaLaPrueba);
        assertArrayEquals(new int[]{7, 0, -1, 6, 3}, resultadoDeLaPrueba);
    }


    @Test
    public void testDevolverValorEnIndice() throws Exception {
        Arreglo cut = new Arreglo();

        

        float resultado = cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, 1);

        assertEquals(3.2f, resultado);

    }

    @Test
    public void testSumarValores(){
        // El método SumarValores en Arreglo.java tiene return. Debemos crear una instancia.
        Arreglo cut = new Arreglo();
        double resultado = cut.sumarValores(new double[] {2.1d,4.3d,-6.7d});
        assertEquals(-0.3,resultado,0.000001); //Con campos double hay que permitir cierta pérdida de precisión

    }

    @Test
    public void testCalcularMediaValores(){
        // Hacemos la prueba sobre una nueva instancia pero con los métodos del Arreglo original
        Arreglo cut = new Arreglo();
        double resultado = cut.calcularMediaValores(new double[] {1.2d,5.2d,-2.3d});
        assertEquals((1.2d+5.2d-2.3d)/3,resultado,0.00001);

    }

}
