package PrimerTrimestre.P1_1_Ficheiros;

public class Parte2 {
    public static void main(String[] args) {

        //1) Crear directorio 'arquivosdir'
        String rutaBase = "arquivosdir"; // Directorio principal

        System.out.println("=== 1 - Crear directorio 'arquivosdir' ===");
        Parte1.creaDirectorio(rutaBase);
        System.out.println("Comprobando se é un directorio:");
        System.out.println("A ruta '" + rutaBase + "' " + Parte1.eDirectorio(rutaBase));

        //2) Crear arquivo Products1.txt en 'arquivosdir'
        System.out.println("\n=== 2 - Crear arquivo 'Products1.txt' ===");
        String arquivo1 = "Products1.txt";
        Parte1.creaFicheiro(rutaBase, arquivo1);
        System.out.println("Comprobando se é un ficheiro:");
        System.out.println("A ruta '" + rutaBase + "/" + arquivo1 + "' " + Parte1.eFicheiro(rutaBase + "/" + arquivo1));

        //3) Crear subdirectorio 'subdir' e arquivo Products2.txt dentro
        System.out.println("\n=== 3 - Crear subdirectorio 'subdir' e arquivo 'Products2.txt' ===");
        String subdir = rutaBase + "/subdir";
        Parte1.creaDirectorio(subdir);

        String arquivo2 = "Products2.txt";
        Parte1.creaFicheiro(subdir, arquivo2);

        //4) Amosar arquivos e subdirectorios de primeiro nivel
        System.out.println("\n=== 4 - Listar contido de 'arquivosdir' ===");
        Parte1.mContido(rutaBase);
        // Resultado esperado:
        // [FILE] Products1.txt
        // [DIR]  subdir

        //5) Información sobre Products1.txt
        System.out.println("\n=== 5 - Información sobre 'Products1.txt' ===");
        System.out.println("Permisos e lonxitude do arquivo:");
        Parte1.modoAcceso(rutaBase, arquivo1);
        Parte1.calculaLonxitude(rutaBase, arquivo1);

        System.out.println("\n>> Agora edita manualmente o arquivo 'Products1.txt' "
                + "e engade a palabra 'ola', despois garda os cambios <<");

        System.out.println("\nLonxitude despois de engadir texto:");
        Parte1.calculaLonxitude(rutaBase, arquivo1);

        //6) Facer que o arquivo sexa só lectura
        System.out.println("\n=== 6 - Facer 'Products1.txt' de só lectura ===");
        Parte1.mLectura(rutaBase, arquivo1);
        Parte1.modoAcceso(rutaBase, arquivo1);

        System.out.println(">> Comproba manualmente que non podes escribir no arquivo agora <<");

        //7) Volver permitir escritura no arquivo
        System.out.println("\n=== 7 - Volver permitir escritura en 'Products1.txt' ===");
        Parte1.mEscritura(rutaBase, arquivo1);
        Parte1.modoAcceso(rutaBase, arquivo1);

        System.out.println(">> Comproba manualmente que agora podes escribir no arquivo de novo <<");

        //8) Borrar o arquivo Products1.txt
        System.out.println("\n=== 8 - Borrar 'Products1.txt' ===");
        Parte1.borraFicheiro(rutaBase, arquivo1);

        System.out.println(">> Comproba manualmente que o arquivo foi borrado <<");

        //9) Borrar resto de arquivos e directorios creados
        System.out.println("\n=== 9 - Borrar resto de arquivos e directorios ===");
        Parte1.borraFicheiro(subdir, arquivo2); // borrar Products2.txt
        Parte1.borraDirectorio(subdir);         // borrar subdir
        Parte1.borraDirectorio(rutaBase);       // borrar arquivosdir

        System.out.println(">> Comproba manualmente que todo foi borrado correctamente <<");
    }
}

