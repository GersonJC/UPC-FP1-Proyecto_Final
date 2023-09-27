import java.util.Scanner;

public class TF_CST {
    public static void main(String[] args) {
        int opcion;
        int contadorRegistros = 0;
        Scanner scanner = new Scanner(System.in);
        String[] dni = new String[100];
        String[] nombre = new String[100];
        String[] apellidoPaterno = new String[100];
        String[] apellidoMaterno = new String[100];
        int[] tipoHorario = new int[100];
        String[] horaSalidaReal = new String[100];
        String[] fechaRegistro = new String[100];
        String[] dniVirtual = new String[100];

        do {
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarDatos(dni, nombre, apellidoPaterno, apellidoMaterno,
                            tipoHorario, horaSalidaReal, fechaRegistro,
                            contadorRegistros, dniVirtual);
                    contadorRegistros++;
                    break;

                case 2:
                    consultarDatos(dni, nombre, apellidoPaterno, apellidoMaterno,
                            tipoHorario, horaSalidaReal, fechaRegistro,
                            contadorRegistros);
                    break;
                case 3:
                    consolidarSobretiempo(dni, nombre, apellidoPaterno, apellidoMaterno,
                            tipoHorario, horaSalidaReal, fechaRegistro,
                            contadorRegistros);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

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
        int intentosF = 0;
        String dniIngresado, respuesta;
        System.out.print("Ingrese DNI: ");
        dniIngresado = scanner.nextLine();
        //System.out.printf("Arreglo DNIVirtual %s \n", Arrays.toString(dniVirtual) );
        //System.out.print("Resultado "+ validarModalidad(dniVirtual,dniIngresado));

        while (!validarModalidad(dniVirtual,dniIngresado)){
            System.out.println("DNI no cumple con la modalidad 'presencial'.");
            System.out.print("Desea continuar (s/n): ");
            respuesta = scanner.nextLine();
            if (respuesta.equals("s")){
                System.out.print("Ingrese DNI: ");
                dniIngresado = scanner.nextLine();
            } else if (respuesta.equals("n")) {
                return;
            }
            intentosF ++;
        };

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

    static boolean validarModalidad(String[] dniVirtual, String dni) {
        for (int i=0; i< dniVirtual.length; i++) {
            if(dniVirtual[i].equals(dni)) {
                return true;
            }
        }
        return false;
    }


    static void consultarDatos(
            String[] dni,
            String[] nombre,
            String[] apellidoPaterno,
            String[] apellidoMaterno,
            int[] tipoHorario,
            String[] horaSalidaReal,
            String[] fechaRegistro,
            int contadorRegistros
    ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese DNI a consultar: ");
        String dniConsulta = scanner.next();

        // Crear un arreglo para almacenar los índices de registros encontrados
        int[] registrosEncontrados = new int[contadorRegistros];
        int contadorEncontrados = 0;

        for (int i = 0; i < contadorRegistros; i++) {
            if (dni[i].equals(dniConsulta)) {
                registrosEncontrados[contadorEncontrados] = i;
                contadorEncontrados++;
            }
        }

        if (contadorEncontrados > 0) {
            System.out.println("Registros encontrados:");
            for (int j = 0; j < contadorEncontrados; j++) {
                int indice = registrosEncontrados[j];
                System.out.println("DNI: " + dni[indice]);
                System.out.println("Nombre: " + nombre[indice]);
                System.out.println("Apellido Paterno: " + apellidoPaterno[indice]);
                System.out.println("Apellido Materno: " + apellidoMaterno[indice]);
                System.out.println("Fecha de Registro: " + fechaRegistro[indice]);
            }
        } else {
            System.out.println("No se encontraron registros para el DNI.");
        }
    }



    static void consolidarSobretiempo(
            String[] dni,
            String[] nombre,
            String[] apellidoPaterno,
            String[] apellidoMaterno,
            int[] tipoHorario,
            String[] horaSalidaReal,
            String[] fechaRegistro,
            int contadorRegistros
    ) {
        System.out.println("Se ha consolidado la informacion.");
    }


}
