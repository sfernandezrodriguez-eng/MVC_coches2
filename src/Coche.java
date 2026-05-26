
    /**
     * Clase que representa a un objeto Coche dentro del sistema.
     * Define sus atributos basicos y su constructor.
     */
    public class Coche {
        String matricula;
        String modelo;
        Integer velocidad;
        Double kilometrosRecorridos;
        Integer gasolina;

        /**
         * Constructor para instanciar un nuevo Coche con velocidad y kilometros en cero.
         */
        public Coche(String modelo, String matricula) {
            this.modelo = modelo;
            this.matricula = matricula;
            this.velocidad = 0;
            this.kilometrosRecorridos = 0.0;
            this.gasolina = 0;
        }
    }
