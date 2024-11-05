package models;

public class Cancha {
    private int idCancha;
    private String tipo;
    private boolean disponible;
    private boolean conLuz;
    private String horarioReservado;
    private int duracionReserva;

    public Cancha(int idCancha, String tipo) {
        this.idCancha = idCancha;
        this.tipo = tipo;
        this.disponible = true;
        this.conLuz = false;
        this.horarioReservado = null;
        this.duracionReserva = 1;
    }

    public String calcularHorarioFin() {
        if (horarioReservado != null) {
            int horaInicio = Integer.parseInt(horarioReservado.split(":")[0]);
            int horaFin = (horaInicio + duracionReserva) % 24;
            return String.format("%02d:00", horaFin);
        }
        return null;
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : String.format("Ocupado (Reservada de %s a %s)", horarioReservado, calcularHorarioFin());
        String luz = conLuz ? "con luz" : "";
        return String.format("Cancha %d: %s - %s %s", idCancha, tipo, estado, luz).trim();
    }

    // Getters y setters para los atributos
    public int getIdCancha() { return idCancha; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setConLuz(boolean conLuz) { this.conLuz = conLuz; }
    public void setHorarioReservado(String horarioReservado) { this.horarioReservado = horarioReservado; }
    public void setDuracionReserva(int duracionReserva) { this.duracionReserva = duracionReserva; }
}