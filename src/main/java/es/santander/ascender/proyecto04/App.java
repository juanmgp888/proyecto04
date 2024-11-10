package es.santander.ascender.proyecto04;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int resultado = Calculadora.sumar(4, 5); // Como es un método estático (ver archivo Calculadora.java),
                                                        // no necesita un constructor. new...

        Calculadora variableCalculadora = new Calculadora();

        int resultadoResta = variableCalculadora.restar(4, 3);
        int resultadoSuma = variableCalculadora.sumar(4, 5);  // Como se ha visto antes, en realidad no necesita constructor
    }
}
