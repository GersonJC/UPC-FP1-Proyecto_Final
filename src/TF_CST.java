import java.util.Scanner;

public class TF_CST {
    public static void main(String[] args) {
        int opcion;
        int contadorRegistros = 0;

        String[] dni = new String[100];
        String[] nombre = new String[100];
        String[] apellidoPaterno = new String[100];
        String[] apellidoMaterno = new String[100];
        int[] tipoHorario = new int[100];
        String[] horaSalidaReal = new String[100];
        String[] fechaRegistro = new String[100];
        String[] dniVirtual = new String[100];

    }

    static void registrarDatos(
            String[] dni,
            String[] nombre,
            String[] apellidoPaterno,
            String[] apellidoMaterno,
            int[] tipoHorario,
            String[] horaSalidaReal,
            String[] fechaRegistro,
            int contadorRegistros,
            String[] dniVirtual
    ) {
        Scanner scanner = new Scanner(System.in);
        String dniIngresado, respuesta;
        System.out.print("Ingrese DNI: ");
        dniIngresado = scanner.nextLine();
        dni[contadorRegistros] = dniIngresado;
        System.out.print("Ingrese Nombre: ");
        nombre[contadorRegistros] = scanner.nextLine();
        System.out.print("Ingrese Apellido Paterno: ");
        apellidoPaterno[contadorRegistros] = scanner.nextLine();
        System.out.print("Ingrese Apellido Materno: ");
        apellidoMaterno[contadorRegistros] = scanner.nextLine();
        System.out.print("Ingrese Tipo de Horario (1, 2, o 3): ");
        tipoHorario[contadorRegistros] = scanner.nextInt();
        System.out.print("Ingrese Hora de Salida Real (Formato 24h / 00:00): ");
        horaSalidaReal[contadorRegistros] = scanner.next();
        //scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese Fecha de Registro (AAAA-MM-DD): ");
        fechaRegistro[contadorRegistros] = scanner.next();
    }


}
