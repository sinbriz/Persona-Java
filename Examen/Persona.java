import java.util.Scanner;

public class Persona{
    private String nombre;
    private int edad;
    private char sexo;
    private int peso;
    private int altura;
    private static int numPersonas = 0;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = 'X';
        this.peso = 0;
        this.altura = 0;
        nuevaPersona();
    }

    public Persona(String nombre, String apellido, int edad, char sexo, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        nuevaPersona();
    }

    private static void nuevaPersona() {
        numPersonas++;
    }

    public static int getNumPersonas() { return numPersonas; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() {
        if (sexo == 'H') return "Hombre";
        else if (sexo == 'M') return "Mujer";
        else return "Desconocido";
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }

    public int getAltura() { return altura; }
    public void setAltura(int altura) { this.altura = altura; }

    public double calcularIMC() {
        double alturaMetros = altura / 100.0;
        if (alturaMetros <= 0) return -1;
        return peso / (alturaMetros * alturaMetros);
    }

    public String clasificarIMC() {
        double imc = calcularIMC();
        if (imc == -1) return "IMC inválido";
        if (imc < 18.5) return "Peso bajo";
        else if (imc <= 24.9) return "Peso ideal";
        else return "Sobrepeso";
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public void comprobarSexo(char sexo) {
        Scanner scanner = new Scanner(System.in);
        while (sexo != 'H' && sexo != 'M') {
            System.out.println("Sexo incorrecto. Debe ingresar 'H' para Hombre o 'M' para Mujer.");
            System.out.print("Ingrese su sexo (H/M): ");
            sexo = scanner.next().charAt(0);
        }
        setSexo(sexo);
    }
}