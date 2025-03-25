import com.formacom.Fichajes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        String opcionSeleccionada="";
        final String MENU_ADMINISTRADOR= """
                1. Nuevo Alumno
                2. Seleccionar Modo
                3. Ver Informes
                4. Salir
                """;
        final String MENU_ALUMNO= """
                1. Fichar
                2. Salir
                """;
        final String MENU_INFORME= """
                1. Fichajes por dia
                2. Fichajes por alumno
                3. Volver
                """;
        do {
            System.out.println(MENU_ADMINISTRADOR);
            opcionSeleccionada=leer.nextLine();
            switch (opcionSeleccionada){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        }while (! opcionSeleccionada.equals("4"));

    }
}
