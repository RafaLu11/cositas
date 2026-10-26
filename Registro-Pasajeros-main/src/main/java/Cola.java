import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
//jijijijijijij
//cojuda gei gei cojuda
/si funciono apy l acabra 
public class Cola {
    private final Queue<Pasajero> coleccion;

    public Cola() {
        coleccion = new LinkedList<>();
    }

    public static boolean esAlfanumerico(String texto) {
        // Permite solo letras (mayúsculas/minúsculas) y números (0-9)
        return texto.matches("^[a-zA-Z]+$");
    }

    public void agregar(Pasajero p) {
        if (p == null) {
            throw new IllegalArgumentException("El pasajero no puede ser nulo");
        }

        // TODO R1: validar nombre, asiento entre 1 y 30 y asiento no repetido.
        // Validar ANTES de modificar la colección.



        if(p.getNombre() == null || p.getNombre().trim().isEmpty() || (!esAlfanumerico(p.getNombre()))) {
            throw new IllegalArgumentException("El nombre del pasajero no puede estar vacio o tener caracteres especiales.");
        }

        int asiento = p.getNumeroAsiento();
        if(asiento <1 || asiento >30){
            throw new IllegalArgumentException("El numero del asiento debe estar entre 1 y 30");
        }

        // Asiento repetido: se recorre la fila antes de agregar
        for (Pasajero otro : coleccion) {
            if (otro.getNumeroAsiento() == asiento) {
                throw new IllegalArgumentException(
                        "El asiento " + asiento + " ya esta ocupado");
            }
        }

        coleccion.offer(p);
    }

    public Pasajero extraer() {
        if (coleccion.isEmpty()) {
            throw new NoSuchElementException("Cola sin elementos");
        }
        return coleccion.poll();
    }

    public Pasajero frente() {
        if (coleccion.isEmpty()) {
            throw new NoSuchElementException("Cola sin elementos");
        }
        return coleccion.peek();
    }

    public int size() {
        return coleccion.size();
    }

    public boolean estaVacia() {
        return coleccion.isEmpty();
    }

    public List<Pasajero> obtenerPendientes() {
        return Collections.unmodifiableList(new ArrayList<>(coleccion));
    }

    public Pasajero buscarPorAsiento(int asiento) {
        // TODO R2: validar rango y buscar sin retirar pasajeros.
        if(asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30");
        }
        for(Pasajero p: coleccion) {
            if(p.getNumeroAsiento() == asiento) {
                return p;
            }
        }

        return null;
    }

    public int posicionPorAsiento(int asiento) {
        // TODO R2: posiciones desde 1; devolver -1 si no está en la fila.
        if (asiento < 1 || asiento > 30){
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30");
        }

        int posicion = 1;
        for (Pasajero p : coleccion) {
            if (p.getNumeroAsiento() == asiento) {
                return posicion;
            }
            posicion++;
        }
        return -1; // Si no se encuentra el pasajero con el asiento especificado
    }

    public Pasajero cancelarPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException(
                    "El asiento debe estar entre 1 y 30");
        }

        Pasajero pasajeroEncontrado = null;
        for (Pasajero p : coleccion) {
            if (p.getNumeroAsiento() == asiento) {
                pasajeroEncontrado = p;
                break;
            }
        }

        if (pasajeroEncontrado == null) {
            throw new NoSuchElementException(
                    "No existe un pasajero con el asiento " + asiento);
        }

        coleccion.remove(pasajeroEncontrado);
        return pasajeroEncontrado;
    }

    @Override
    public String toString() {
        if (coleccion.isEmpty()) {
            return "Cola sin elementos";
        }
        StringBuilder sb = new StringBuilder();
        int posicion = 1;
        for (Pasajero p : coleccion) {
            sb.append(posicion++).append(". ").append(p).append("\n");
        }
        return sb.toString();
    }
}
