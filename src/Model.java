import java.util.ArrayList;

/**
 * Clase encargada de manejar, almacenar y procesar los datos de la aplicacion.
 * Aplica la logica de negocio sobre la coleccion de coches.
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un objeto Coche y lo almacena directamente en el parking.
     */
    public Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche en el parking utilizando su matricula.
     */
    public Coche getCoche(String matricula) {
        Coche aux = null;
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche localizado por su matricula.
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        System.out.println(" LOG esta haciendose");
        return getCoche(matricula).velocidad;
    }

    /**
     * Devuelve la velocidad actual de un coche segun su matricula.
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    /**
     * Incrementa el contador de kilometros recorridos de un coche transformando los metros recibidos.
     */
    public double avanzarCoche(String matricula, double metros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.kilometrosRecorridos += (metros / 1000);
            return coche.kilometrosRecorridos;
        }
        return -1.0;
    }

    public int repostarCoche(String matricula, int litros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.gasolina += litros; // Sumamos la gasolina de forma segura
            return coche.gasolina;
        }
        return -1;
    }
}