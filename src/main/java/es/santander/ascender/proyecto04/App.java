package es.santander.ascender.proyecto04;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int resultado = Calculadora.sumar(4, 5);

        Calculadora variableCalculadora = new Calculadora();

        int resultadoResta = variableCalculadora.restar(4, 3);
        int resultadoSuma = variableCalculadora.sumar(4, 5);
    }
}
