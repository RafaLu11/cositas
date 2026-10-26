import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Pasajero {
    private final String nombre;
    private final int numeroAsiento;
    private final String tipoAsiento;
    private boolean checkin;
    private final LocalDateTime horaRegistro;
    private LocalDateTime horaCheckin;


    public Pasajero(String nombre, int numeroAsiento, String tipoAsiento) {
        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
        this.tipoAsiento = tipoAsiento;
        checkin = false;
        this.horaRegistro = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getHoraRegistro() {
        return horaRegistro;
    }

    public LocalDateTime getHoraCheckin() {
        return horaCheckin;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String texto = nombre + " | Asiento: " + numeroAsiento
                + " | " + tipoAsiento
                + " | Registro: " + horaRegistro.format(f);
        if (horaCheckin != null) {
            texto += " | Check-in: " + horaCheckin.format(f);
        } else {
            texto += " | Check-in: pendiente";
        }
        return texto;
    }
}
