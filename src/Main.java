import com.formacom.Fichajes;
import com.formacom.Registro;

import java.util.List;
import java.util.Scanner;

public class Main {
    final static String MENU_ALUMNO = """
                1. Fichar
                2. Salir
                """;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Fichajes fichajes = new Fichajes();
        String opcionSeleccionada = "";

        // Credenciales para el login
        final String usuarioValido = "admin";
        final String contrasenaValida = "1234";

        // Inicio de sesión
        System.out.println("Ingrese su usuario:");
        String usuario = leer.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = leer.nextLine();

        if (usuario.equals(usuarioValido) && contrasena.equals(contrasenaValida)) {
            System.out.println("Acceso concedido. Bienvenido a fichajes Formacom.");

            final String MENU_ADMINISTRADOR = """
                    1. Nuevo Alumno
                    2. Seleccionar Modo
                    3. Ver Informes
                    4. Salir
                    """;

            final String MENU_INFORME = """
                    1. Fichajes por dia
                    2. Fichajes por alumno
                    3. Volver
                    """;

            do {
                System.out.println(MENU_ADMINISTRADOR);
                opcionSeleccionada = leer.nextLine();
                switch (opcionSeleccionada) {
                    case "1":
                        System.out.println("Nombre del alumn@:");
                        String nombre = leer.nextLine();
                        System.out.println("DNI del alumn@:");
                        String dni = leer.nextLine();
                        System.out.println(fichajes.alta_alumno(dni, nombre));
                        break;
                    case "2":
                        funcionMenu2(opcionSeleccionada, leer, fichajes);
                        break;
                    case "3":
                        System.out.println(MENU_INFORME);
                        opcionSeleccionada = leer.nextLine();
                        switch (opcionSeleccionada) {
                            case "1":
                                // Código para fichajes por día
                                break;
                            case "2":
                                System.out.println("DNI Alumn@:");
                                dni = leer.nextLine();
                                mostrarRegistros(fichajes.informe_por_alumno(dni));
                                break;
                            case "3":
                                System.out.println("Volviendo...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                        break;
                    case "4":
                        System.out.println("Hasta la próxima");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            } while (!opcionSeleccionada.equals("4"));

        } else {
            System.out.println("Usuario o contraseña incorrectos. Programa finalizado.");
        }
    }

    private static void mostrarRegistros(List<Registro> registros) {
        System.out.println(registros);
    }

    static void funcionMenu2(String opcionSeleccionada, Scanner leer, Fichajes fichajes) {
        System.out.println("""
                              1. Modo Entrada
                              2. Modo Salida
                            """);
        opcionSeleccionada = leer.nextLine();
        if (opcionSeleccionada.equals("1")) {
            System.out.println(fichajes.cambiar_modo("Entrada"));
        } else {
            System.out.println(fichajes.cambiar_modo("Salida"));
        }
        System.out.println("Activar modo alumn@ s/n");
        opcionSeleccionada = leer.nextLine();
        if (opcionSeleccionada.equals("s")) {
            // Activamos modo alumno
            do {
                System.out.println(MENU_ALUMNO);
                opcionSeleccionada = leer.nextLine();
                switch (opcionSeleccionada) {
                    case "1":
                        System.out.println("Introduce DNI: ");
                        String dni = leer.nextLine();
                        System.out.println(fichajes.fichar(dni));
                        break;
                    case "2":
                        System.out.println("Password Administrador:");
                        String pass = leer.nextLine();
                        if (fichajes.login("admin", pass)) {
                            System.out.println("Saliendo....");
                        } else {
                            opcionSeleccionada = "dddd"; // Fuerza el bucle si el login falla
                        }
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            } while (!opcionSeleccionada.equals("2"));
        }
    }
}

