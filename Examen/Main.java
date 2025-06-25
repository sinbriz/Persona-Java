import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese su nombre (o escriba 'Terminar' para salir): ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("Terminar")) {
                System.out.println("\nPrograma finalizado. Personas registradas: " + Persona.getNumPersonas());
                break;
            }

            Persona persona = new Persona();

            if (nombre.equalsIgnoreCase("JhonDoe")) {
                persona.setNombre("JhonDoe");
                persona.setEdad(25);
                persona.setSexo('H');
                persona.setPeso(78);
                persona.setAltura(170);
            } else {
                persona.setNombre(nombre);

                System.out.print("Ingrese su edad: ");
                persona.setEdad(scanner.nextInt());

                System.out.print("Ingrese su sexo (H/M): ");
                char sexo = scanner.next().charAt(0);
                persona.comprobarSexo(sexo);

                System.out.print("Ingrese su peso (kg): ");
                persona.setPeso(scanner.nextInt());

                System.out.print("Ingrese su altura (cm): ");
                persona.setAltura(scanner.nextInt());

                scanner.nextLine();
            }

            System.out.println("\n--- Información de la Persona ---");
            System.out.println("Nombre: " + persona.getNombre() + " ");
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Sexo: " + persona.getSexo());
            System.out.printf("IMC: %.2f\n", persona.calcularIMC());
            System.out.println("Clasificación IMC: " + persona.clasificarIMC());
            System.out.println("Es mayor de edad? " + (persona.esMayorDeEdad() ? "Sí" : "No"));
            System.out.println("Personas registradas: " + Persona.getNumPersonas());
            System.out.println("--------------------------------\n");
        }

        scanner.close();
    }
}
