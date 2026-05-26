import java.util.Scanner;

/**
 * Clase encargada de la interaccion directa con el usuario por medio de la consola.
 * Gestiona la captura de datos de entrada y la representacion visual de los resultados.
 * * @author Tu Nombre
 * @version 1.0 (Mayo 2026)
 */
public class View {

    /**
     * Muestra el menu principal del gestor de coches en un bucle interactivo.
     * Captura las opciones e inputs del usuario por consola y delega las acciones
     * correspondientes en los metodos del Controlador.
     */
    public void menu() {
        Controller c = new Controller();
        int opcion = 0;
        do {
            System.out.println("\n--- XESTOR COCHES ---");
            System.out.println("1. Engadir Coche");
            System.out.println("2. Cambiar velocidad");
            System.out.println("3. Avanzar coche");
            System.out.println("4. Añadir gasolina");
            System.out.println("5. Salir");
            System.out.print("Selecciona unha opción: ");

            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Modelo: ");
                    String modelo = new Scanner(System.in).next();
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    boolean a = c.añadirCoche(modelo, matricula);
                    if (a) {
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Algo ha fallado");
                    }
                }

                case 2 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Nueva velocidad: ");
                    int velocidad = new Scanner(System.in).nextInt();
                    boolean a = c.newVelocidad(matricula, velocidad);
                    if (a) {
                        System.out.println("Se ha cambiado correctamente");
                    } else {
                        System.out.println("Algo ha fallado");
                    }
                }

                case 3 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Metros a avanzar: ");
                    double metros = new Scanner(System.in).nextDouble(); // Corregido a nextDouble() para evitar desajustes de tipo con tu variable double
                    boolean a = c.avanzar(matricula, metros);
                    if (!a) {
                        System.out.println("Error: No se pudo hacer avanzar el coche (¿Matrícula incorrecta?)");
                    }
                }

                case 4 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Litros a repostar: ");
                    int litros = new Scanner(System.in).nextInt();
                    boolean a = c.ponerGasolina(matricula, litros);
                    if (!a) {
                        System.out.println("Error: No se pudo poner gasolina (¿Matrícula incorrecta?)");
                    }
                }

                case 5 -> {
                    System.out.println("Chao hasta luego....");
                }
            }
        } while (opcion != 5);
    }

/**
 * Imprime en pantalla la velocidad actual de un vehiculo con su formato de unidad.
 * * @param matricula El identificador unico del coche.
 * @param v         La velocidad en formato Integer a representar.
 * @return true de manera invariable para confirmar que la salida por consola se ha efectuado.
 */