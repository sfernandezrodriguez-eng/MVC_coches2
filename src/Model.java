import java.util.ArrayList;

/**
 * Clase encargada de manejar, almacenar y procesar los datos de la aplicacion.
 * Aplica la logica de negocio central sobre la coleccion de objetos Coche (parking).
 * * @author Tu Nombre
 * @version 1.0 (Mayo 2026)
 */
public class Model {
    /**
     * Lista dinamica que simula el parking donde se almacenan todos los coches del sistema.
     */
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un objeto Coche con los datos proporcionados y lo almacena directamente en el parking.
     * * @param modelo    El nombre del modelo o marca del coche a registrar.
     * @param matricula La matricula unica alfanumerica que identificara al coche.
     * @return El objeto {@link Coche} que ha sido instanciado e introducido en la lista.
     */
    public Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche especifico dentro del parking utilizando su matricula como criterio de coincidencia.
     * * @param matricula La matricula del coche que se desea localizar.
     * @return El objeto {@link Coche} si se encuentra en el listado; null en caso de no existir coincidencia.
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
     * Cambia la velocidad de un coche localizado mediante su matricula.
     * * @param matricula La matricula del coche al que se le desea alterar la velocidad.
     * @param v         La nueva velocidad asignada en formato de objeto Integer.
     * @return El valor entero de la nueva velocidad ya registrada en el vehiculo.
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        System.out.println(" LOG esta haciendose");
        return getCoche(matricula).velocidad;
    }

    /**
     * Devuelve la velocidad actual registrada de un coche segun su matricula.
     * * @param matricula La matricula del coche a consultar.
     * @return La velocidad actual del vehiculo expresada como un numero entero.
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    /**
     * Incrementa el contador de kilometros recorridos de un coche transformando los metros recibidos a kilometros.
     * * @param matricula La matricula del vehiculo que realiza el desplazamiento.
     * @param metros    La cantidad de metros de distancia que avanza el coche.
     * @return El total acumulado de kilometros recorridos por el coche (double), o -1.0 si el vehiculo no existe.
     */
    public double avanzarCoche(String matricula, double metros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.kilometrosRecorridos += (metros / 1000);
            return coche.kilometrosRecorridos;
        }
        return -1.0;
    }

    /**
     * Suministra combustible al tanque de un coche localizado por su matricula, sumando los nuevos litros.
     * * @param matricula La matricula del coche que se va a repostar.
     * @param litros    La cantidad de litros de gasolina que se van a añadir al tanque.
     * @return El total de litros de gasolina actuales en el vehiculo tras el repostaje, o -1 si el coche no existe.
     */
    public int repostarCoche(String matricula, int litros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.gasolina += litros; // Sumamos la gasolina de forma segura
            return coche.gasolina;
        }
        return -1;
    }
}