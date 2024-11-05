import models.SistemaReservas;
import java.util.Scanner;

public class Main {
    
    public static void mostrarMenu() {
        System.out.println("\n--- Sistema de Alquiler de Canchas ---");
        System.out.println("1. Reservar una cancha");
        System.out.println("2. Liberar una cancha");
        System.out.println("3. Ver todas las canchas");
        System.out.println("4. Salir");
    }

    public static void mostrarCanchas(SistemaReservas sistema) {
        System.out.println("\nCanchas disponibles y ocupadas:");
        for (var cancha : sistema.getCanchas()) {
            System.out.println(cancha);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaReservas sistema = new SistemaReservas();

        while (true) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingresa el horario de la reserva (HH:MM): ");
                    String horario = scanner.nextLine();
                    if (sistema.horarioValido(horario)) {
                        System.out.print("¿Por cuántas horas deseas reservar la cancha?: ");
                        int duracion = Integer.parseInt(scanner.nextLine());
                        mostrarCanchas(sistema);
                        System.out.print("\nIngresa el ID de la cancha que deseas reservar: ");
                        int idCancha = Integer.parseInt(scanner.nextLine());
                        System.out.print("¿Deseas alquilar la cancha con luz? (s/n): ");
                        boolean conLuz = scanner.nextLine().equalsIgnoreCase("s");
                        sistema.reservarCancha(idCancha, horario, duracion, conLuz);
                    } else {
                        System.out.println("Horario no válido. El predio está abierto de 13:00 a 02:00.");
                    }
                    break;
                case "2":
                    System.out.print("Ingresa el ID de la cancha a liberar: ");
                    int idCanchaLiberar = Integer.parseInt(scanner.nextLine());
                    sistema.liberarCancha(idCanchaLiberar);
                    break;
                case "3":
                    mostrarCanchas(sistema);
                    break;
                case "4":
                    System.out.println("Gracias por utilizar el sistema de reservas del Grupo n5!!!");
                    System.out.println("Hasta luego!!!");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

    }
}