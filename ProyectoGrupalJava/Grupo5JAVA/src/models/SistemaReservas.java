package models;

import java.util.ArrayList;

public class SistemaReservas {
    private ArrayList<Cancha> canchas;

    public SistemaReservas() {
        canchas = new ArrayList<>();
        canchas.add(new Cancha(1, "Básquet"));
        canchas.add(new Cancha(2, "Básquet"));
        // Agrega las demás canchas según el archivo original
    }

    public ArrayList<Cancha> getCanchas() {
        return canchas;
    }

    public boolean horarioValido(String horario) {
        try {
            int hora = Integer.parseInt(horario.split(":")[0]);
            return (hora >= 13 && hora < 24) || (hora >= 0 && hora <= 2);
        } catch (Exception e) {
            return false;
        }
    }

    public void reservarCancha(int idCancha, String horario, int duracion, boolean conLuz) {
        Cancha cancha = buscarCancha(idCancha);
        if (cancha != null && cancha.isDisponible()) {
            cancha.setDisponible(false);
            cancha.setConLuz(conLuz);
            cancha.setHorarioReservado(horario);
            cancha.setDuracionReserva(duracion);
            System.out.println("Reserva exitosa para la cancha " + idCancha);
        } else {
            System.out.println("Cancha no disponible o inexistente.");
        }
    }

    public void liberarCancha(int idCancha) {
        Cancha cancha = buscarCancha(idCancha);
        if (cancha != null && !cancha.isDisponible()) {
            cancha.setDisponible(true);
            cancha.setConLuz(false);
            cancha.setHorarioReservado(null);
            cancha.setDuracionReserva(1);
            System.out.println("La cancha " + idCancha + " ha sido liberada.");
        } else {
            System.out.println("Cancha ya está disponible o no existe.");
        }
    }

    private Cancha buscarCancha(int idCancha) {
        for (Cancha cancha : canchas) {
            if (cancha.getIdCancha() == idCancha) {
                return cancha;
            }
        }
        return null;
    }
}
