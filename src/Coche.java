/**
 * Clase que representa a la entidad Coche dentro del sistema de gestion.
 * Define el estado, los atributos estructurales y el constructor base de los vehiculos.
 * * @author Tu Nombre
 * @version 1.0 (Mayo 2026)
 */
public class Coche {
    /**
     * La matricula alfanumerica unica que identifica al vehiculo.
     */
    String matricula;

    /**
     * El modelo o marca comercial del automovil (ej. "Aston Martin").
     */
    String modelo;

    /**
     * La velocidad actual del coche medida en kilometros por hora (km/h).
     */
    Integer velocidad;

    /**
     * El contador acumulado de la distancia recorrida por el vehiculo en kilometros.
     */
    Double kilometrosRecorridos;

    /**
     * La cantidad actual de combustible almacenada en el tanque del coche medida en litros.
     */
    Integer gasolina;

    /**
     * Constructor completo para instanciar un nuevo objeto Coche.
     * Inicializa la velocidad en 0 km/h, los kilometros recorridos en 0.0 y el tanque de gasolina vacio.
     * * @param modelo    El nombre del modelo o marca que se le asignara al vehiculo.
     * @param matricula El identificador alfanumerico unico que se le asignara al vehiculo.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometrosRecorridos = 0.0;
        this.gasolina = 0;
    }
}