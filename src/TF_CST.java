import java.util.Scanner;

public class TF_CST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int contadorSeleccionRegistrar = 0;
        int contadorSeleccionConsultar = 0;
        int contadorSeleccionConsolidar = 0;
        //int contadorSeleccionSalir = 0;
        int contadorRegistros = 0;
        String respuesta;

        String[] dni = new String[100];
        String[] nombre = new String[100];
        String[] apellidoPaterno = new String[100];
        String[] apellidoMaterno = new String[100];
        int[] tipoHorario = new int[100];
        String[] horaSalidaReal = new String[100];
        String[] fechaRegistro = new String[100];
        String[] presencial = {"71642745","71642747","70097911","70373270"};

        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Consolidar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" ");
                    System.out.println("-------------------------------");
                    System.out.println("---------- Registrar ----------");
                    System.out.println("-------------------------------");
                    contadorSeleccionRegistrar++;
                    registrarDatos(dni, nombre, apellidoPaterno, apellidoMaterno, tipoHorario, horaSalidaReal, fechaRegistro, contadorRegistros, presencial);
                    contadorRegistros++;
                    //System.out.println("Lo registraso"+ Arrays.toString(dni));
                    //System.out.println("Lo registraso"+ Arrays.toString(nombre));
                    //System.out.println("Lo registraso"+ Arrays.toString(fechaRegistro));

                    //System.out.println("Registrado Exitosamente.");
                    System.out.print("Desea retornar al menu principal (s/n): ");
                    respuesta = scanner.next();
                    if (respuesta.equals("n")){
                        System.out.println();
                        System.out.println("------------------------------");
                        System.out.println("---------- Saliendo ----------");
                        System.out.println("------------------------------");
                        return;
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("---------- Consultar ----------");
                    System.out.println("-------------------------------");
                    contadorSeleccionConsultar++;
                    consultarDatos(dni, nombre, apellidoPaterno, apellidoMaterno, tipoHorario, horaSalidaReal, fechaRegistro, contadorRegistros);
                    System.out.println("-------------------------------");
                    System.out.print("Desea retornar al menu principal (s/n): ");
                    respuesta = scanner.next();
                    if (respuesta.equals("n")){
                        System.out.println();
                        System.out.println("------------------------------");
                        System.out.println("---------- Saliendo ----------");
                        System.out.println("------------------------------");
                        return;
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("---------- Consolidar ----------");
                    System.out.println("--------------------------------");
                    contadorSeleccionConsolidar++;
                    consolidarSobretiempo(dni, nombre, apellidoPaterno, apellidoMaterno, tipoHorario, horaSalidaReal, fechaRegistro, contadorRegistros);
                    System.out.println("-------------------------------");
                    System.out.print("Desea retornar al menu principal (s/n): ");
                    respuesta = scanner.next();
                    if (respuesta.equals("n")){
                        System.out.println();
                        System.out.println("------------------------------");
                        System.out.println("---------- Saliendo ----------");
                        System.out.println("------------------------------");
                        return;
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.println("( ͡❛ ͜ʖ ͡❛)✌ EL TRABAJO MERECE UN 20!!! ( ͡❛ ͜ʖ ͡❛)✌");
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.print("Desea retornar al menu principal (s/n): ");
                    respuesta = scanner.next();
                    if (respuesta.equals("n")){
                        System.out.println();
                        System.out.println("------------------------------");
                        System.out.println("---------- Saliendo ----------");
                        System.out.println("------------------------------");
                        return;
                    }
                    break;


                case 5:
                    //contadorSeleccionSalir++;
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("---------- Saliendo ----------");
                    System.out.println("------------------------------");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("---------- Resumen ----------");
        System.out.println("-----------------------------");
        System.out.println("Veces seleccionado Registrar: " + contadorSeleccionRegistrar);
        System.out.println("Veces seleccionado Consultar: " + contadorSeleccionConsultar);
        System.out.println("Veces seleccionado Consolidar: " + contadorSeleccionConsolidar);
        //System.out.println("Veces seleccionado Salir: " + contadorSeleccionSalir);

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
        int intentosF = 0, thIng;
        String dniIngresado, nombreIng, apIng, amIng, hsrIng, frIng, respuesta;
        System.out.print("Ingrese DNI: ");
        dniIngresado = scanner.nextLine();
        //System.out.printf("Arreglo DNIVirtual %s \n", Arrays.toString(dniVirtual) );
        //System.out.print("Resultado "+ validarModalidad(dniVirtual,dniIngresado));

        while (!validarModalidad(dniVirtual,dniIngresado)){
            System.out.println("DNI no cumple con la modalidad 'presencial'.");
            System.out.print("Desea continuar (s/n): ");
            respuesta = scanner.next();
            if (respuesta.equals("s")){
                System.out.print("Ingrese DNI: ");
                dniIngresado = scanner.next();
            } else if (respuesta.equals("n")) {
                return;
            }
            intentosF ++;
        };

        // almacenando valores individuales
        System.out.print("Ingrese Nombre: ");
        nombreIng = scanner.nextLine();
        System.out.print("Ingrese Apellido Paterno: ");
        apIng = scanner.nextLine();
        System.out.print("Ingrese Apellido Materno: ");
        amIng = scanner.nextLine();
        System.out.print("Ingrese Tipo de Horario (1, 2, o 3): ");
        thIng = scanner.nextInt();
        System.out.print("Ingrese Hora de Salida Real (Formato 24h / 00:00): ");
        hsrIng = scanner.next();
        System.out.print("Ingrese Fecha de Registro (AAAA-MM-DD): ");
        frIng = scanner.next();

        for (int i = 0; i < contadorRegistros; i++){
            if (fechaRegistro[i].equals(frIng)){
                System.out.println("Se encontro registro para la fecha ingresada.");
                return;
            }
        }

        //insertando valores a los arreglos
        dni[contadorRegistros] = dniIngresado;
        nombre[contadorRegistros] = nombreIng;
        apellidoPaterno[contadorRegistros] = apIng;
        apellidoMaterno[contadorRegistros] = amIng;
        tipoHorario[contadorRegistros] = thIng;
        horaSalidaReal[contadorRegistros] = hsrIng;
        fechaRegistro[contadorRegistros] = frIng;

        System.out.println("-------------------------------");
        System.out.println("    Registrado Exitosamente.   ");
        System.out.println("-------------------------------");
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
        System.out.print("Ingrese la fecha a consultar (AAAA-MM-DD): ");
        String fechaConsulta = scanner.next();

        // Crear un arreglo para almacenar los índices de registros encontrados
        int[] registrosEncontrados = new int[contadorRegistros];
        int contadorEncontrados = 0;

        for (int i = 0; i < contadorRegistros; i++) {
            if (dni[i].equals(dniConsulta) && fechaRegistro[i].equals(fechaConsulta)) {
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

                int sobretiempo = calcularSobretiempo(tipoHorario[indice], horaSalidaReal[indice]);
                if (sobretiempo > 0) {
                    System.out.println("Sobretiempo (minutos): " + sobretiempo);
                } else {
                    System.out.println("No hay sobretiempo.");
                }

                System.out.println();
            }
        } else {
            System.out.println("No se encontraron registros para el DNI y la fecha proporcionados.");
        }
    }


    static int calcularSobretiempo(int tipoHorario, String horaSalidaReal) {
        int horaSalidaTeorica = 0;
        switch (tipoHorario) {
            case 1:
                horaSalidaTeorica = 16 * 60 + 45; // 16:30
                break;
            case 2:
                horaSalidaTeorica = 17 * 60 + 45; // 17:30
                break;
            case 3:
                horaSalidaTeorica = 18 * 60 + 45; // 18:30
                break;
        }
        int hora = Integer.parseInt(horaSalidaReal.substring(0,2));
        int minutos = Integer.parseInt(horaSalidaReal.substring(3,5));
        int horareal = hora * 60 + minutos;

        //int horareal = (Integer.parseInt(horaSalidaReal.substring(0,2)) * 60 ) + Integer.parseInt(horaSalidaReal.substring(3,5));

        if (horareal > horaSalidaTeorica) {
            return horareal - horaSalidaTeorica;
        } else {
            return 0;
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese DNI a consultar: ");
        String dniConsulta = scanner.next();
        System.out.print("Ingrese el mes (MM) a consolidar: ");
        String mesConsolidar = scanner.next();
        int totalSobretiempo = 0;
        String nombreCompleto = "" ;
        for (int i = 0; i < contadorRegistros; i++) {
            String mesRegistro = fechaRegistro[i].substring(5, 7);
            if (mesRegistro.equals(mesConsolidar) && dni[i].equals(dniConsulta)) {
                int sobretiempo = calcularSobretiempo(tipoHorario[i], horaSalidaReal[i]);
                if (sobretiempo > 0) {
                    nombreCompleto = apellidoPaterno[i]+" "+apellidoMaterno[i]+","+nombre[i];
                    totalSobretiempo += sobretiempo;
                }
            }
        }
        System.out.println("Se ha consolidado la informacion para: ");
        System.out.println(nombreCompleto);
        System.out.println("Total de sobretiempo en el mes " + mesConsolidar + ": " + totalSobretiempo);
    }



}
