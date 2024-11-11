package es.santander.ascender.proyecto04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

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


    // Si el test lo lanzamos con un valor negativo, fuera del rango de valores permitido [1-2000]
    /* Fue mi primer intento. Mejor no usar try and catch en los tests
    @Test
    public void testDevolverValorEnIndiceNegativo(){
        Arreglo cut = new Arreglo();
       
        try{
         float resultado = cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, -1);
         assertEquals(3.2f, resultado);
         fail("Me has pedido un índice negativo. Ya te vale.");
        } catch (Exception e){
         assertEquals("Me has pedido un índice negativo: -1", e.getMessage());
        }
    }
*/
    @Test
    public void testDevolverValorEnIndiceNegativo() throws Exception{
        // preparas, ejecutas y verificas
        Arreglo cut = new Arreglo();
       
assertThrows(Exception.class,()->cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, -1);
      // ()->  crea un objeto sobre la marcha. Lambda, se llama.  
    }

    /* Versión noobie
    @Test
    public void testDevolverValorEnIndiceMayorQue2000() {
        Arreglo cut = new Arreglo();
       
        try{
         float resultado = cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, 1);
         assertEquals(3.2f, resultado);
         fail("Me has pedido un índice > 2000.");
        } catch (Exception e){
         assertEquals("Me has pedido un índice negativo: -1", e.getMessage());
        }  
        
    }
    */

    @Test
    public void testDevolverValorEnIndiceMayorQue2000() throws Exception {
        Arreglo cut = new Arreglo();
        assertThrows(Exception.class,()->cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, >2000);

    }
       
    // Si el test lo lanzamos con un rango de valores permitido [1-2000]
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
     //   assertNotNull(resultado, "Ninguno de los valores recibidos puede ser nulo.");
        assertEquals((1.2d+5.2d-2.3d)/3,resultado,0.00001);

    }

}


/* Explicación uso lamba

    El código que compartes está utilizando una expresión lambda en Java para probar que se lanza una excepción cuando se llama al método `devolverValorEnIndice` con un índice negativo. 

Desglosémoslo:

```java
assertThrows(Exception.class, () -> cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, -1));
```

### Explicación:
- **`assertThrows(Exception.class, () -> cut.devolverValorEnIndice(...))`**: Esto es una aserción de prueba en el contexto de JUnit. Se espera que la ejecución de la lambda (el código dentro de `() -> {...}`) lance una excepción de tipo `Exception`. Si no se lanza esa excepción, la prueba fallará.

- **`() -> cut.devolverValorEnIndice(...)`**: Este es el formato de una expresión lambda, que en este caso está ejecutando el método `devolverValorEnIndice`. En lugar de llamar directamente a este método, la expresión lambda lo envuelve para que pueda ser evaluado por `assertThrows`.

- **`cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, -1)`**: Aquí, se está pasando un array de números flotantes y el índice `-1` al método `devolverValorEnIndice`. Es probable que este método esté diseñado para lanzar una excepción si el índice es negativo, por lo que esperamos que al pasar `-1`, se dispare una excepción (probablemente `IndexOutOfBoundsException` o alguna otra excepción personalizada dependiendo de la implementación).

### Detalles adicionales:

1. **Lambda (`() -> {...}`)**: En Java, una expresión lambda es una forma compacta de crear instancias de interfaces funcionales. En este caso, está creando una instancia de una función que puede ser evaluada por `assertThrows`. La lambda aquí no toma parámetros (`()`), y su cuerpo es simplemente el llamado al método que se quiere probar.

2. **`assertThrows`**: Esta es una función proporcionada por JUnit para probar que un bloque de código lanza una excepción específica. El primer argumento es la clase de la excepción esperada, y el segundo es la lambda o el bloque de código que se va a ejecutar.

### ¿Por qué usar una lambda aquí?

El uso de una lambda es útil porque permite pasar un bloque de código como argumento sin necesidad de crear una clase o método adicional para ello. En este caso, la lambda facilita escribir pruebas de manera concisa. Sin la lambda, tendrías que envolver el código en una clase o método adicional que implemente la interfaz `Executable` de JUnit, lo cual sería más verboso.

### Ejemplo de cómo se usaría sin la lambda:

Si no quisieras usar la lambda, podrías crear un objeto de la clase `Executable`:

```java
assertThrows(Exception.class, new Executable() {
    @Override
    public void execute() throws Throwable {
        cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, -1);
    }
});
```

Sin embargo, la versión con lambda es mucho más limpia y más fácil de entender.

### Resumen:
- La lambda `() -> cut.devolverValorEnIndice(new float[] {4.6f, 3.2F, -34.7f, 0.0f}, -1)` permite que JUnit ejecute el código y verifique si lanza la excepción esperada, que en este caso debería ser una excepción relacionada con el índice negativo.
*/
