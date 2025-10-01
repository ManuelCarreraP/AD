package PrimerTrimestre.P1_1_Ficheiros;

import java.io.File;
import java.io.IOException;

public class Parte1 {

    // 1) Método eDirectorio(cadea)
    public static String eDirectorio(String cadea) {
        File arquivo = new File(cadea);
        if (arquivo.isDirectory()) {
            return "é directorio";
        } else {
            return "non é directorio";
        }
    }

    // 2) Método eFicheiro(cadea)
    public static String eFicheiro(String cadea) {
        File arquivo = new File(cadea);
        if (arquivo.isFile()) {
            return "é ficheiro";
        } else {
            return "non é ficheiro";
        }
    }

    // 3) Método creaDirectorio(String)
    public static void creaDirectorio(String ruta) {
        File nuevoDirectorio = new File(ruta);
        if (!nuevoDirectorio.exists()) {
            if (nuevoDirectorio.mkdir()) {
                System.out.println("Directorio creado: " + ruta);
            } else {
                System.out.println("Erro ao crear o directorio: " + ruta);
            }
        } else {
            System.out.println("O directorio xa existe: " + ruta);
        }
    }

    // 4) Método creaFicheiro(dirName, fileName)
    public static void creaFicheiro(String dirName, String fileName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            System.out.println("O directorio non existe: " + dirName);
            return;
        }

        File file = new File(dir, fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Ficheiro creado: " + file.getAbsolutePath());
                } else {
                    System.out.println("Erro ao crear ficheiro: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("Erro de E/S ao crear o ficheiro: " + e.getMessage());
            }
        } else {
            System.out.println("O ficheiro xa existe: " + file.getAbsolutePath());
        }
    }

    // 5) Método modoAcceso(dirName, fileName)
    public static void modoAcceso(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (!file.exists()) {
            System.out.println("O ficheiro non existe: " + file.getAbsolutePath());
            return;
        }

        // Comprobar permisos de escritura
        if (file.canWrite()) {
            System.out.println("escritura si");
        } else {
            System.out.println("escritura non");
        }

        // Comprobar permisos de lectura
        if (file.canRead()) {
            System.out.println("lectura si");
        } else {
            System.out.println("lectura non");
        }
    }

    // 6) Método calculaLonxitude(dirName, fileName)
    public static void calculaLonxitude(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (!file.exists()) {
            System.out.println("O ficheiro non existe: " + file.getAbsolutePath());
            return;
        }

        if (!file.isFile()) {
            System.out.println("A ruta non corresponde a un ficheiro: " + file.getAbsolutePath());
            return;
        }

        long lonxitude = file.length();
        System.out.println("Lonxitude do ficheiro '" + fileName + "': " + lonxitude + " bytes");
    }

    // 7) Método mLectura (dirName, fileName)
    public static void mLectura(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (!file.exists()) {
            System.out.println("O ficheiro non existe: " + file.getAbsolutePath());
            return;
        }

        if (file.setReadOnly()) {
            System.out.println("O ficheiro agora é de só lectura: " + file.getAbsolutePath());
        } else {
            System.out.println("Erro ao cambiar permisos a só lectura: " + file.getAbsolutePath());
        }
    }

    // 8) Método mEscritura (dirName, fileName)
    public static void mEscritura(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (!file.exists()) {
            System.out.println("O ficheiro non existe: " + file.getAbsolutePath());
            return;
        }

        if (file.setWritable(true)) {
            System.out.println("O ficheiro agora pódese escribir: " + file.getAbsolutePath());
        } else {
            System.out.println("Erro ao cambiar permisos para escritura: " + file.getAbsolutePath());
        }
    }

    // 9) Método borraFicheiro(dirName, fileName)
    public static void borraFicheiro(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (!file.exists()) {
            System.out.println("Ficheiro inexistente: " + file.getAbsolutePath());
            return;
        }

        if (file.delete()) {
            System.out.println("Ficheiro eliminado: " + file.getAbsolutePath());
        } else {
            System.out.println("Erro ao eliminar o ficheiro: " + file.getAbsolutePath());
        }
    }

    // 10) Método borraDirectorio(dirName)
    public static void borraDirectorio(String dirName) {
        File dir = new File(dirName);

        if (!dir.exists()) {
            System.out.println("Ruta inexistente: " + dir.getAbsolutePath());
            return;
        }

        if (dir.isDirectory() && dir.list().length == 0) {
            if (dir.delete()) {
                System.out.println("Directorio eliminado: " + dir.getAbsolutePath());
            } else {
                System.out.println("Erro ao eliminar o directorio: " + dir.getAbsolutePath());
            }
        } else {
            System.out.println("Ruta inexistente ou con descendencia: " + dir.getAbsolutePath());
        }
    }

    // 11) Método mContido(dirName)
    public static void mContido(String dirName) {
        File dir = new File(dirName);

        if (!dir.exists()) {
            System.out.println("A ruta non existe: " + dir.getAbsolutePath());
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("A ruta non é un directorio: " + dir.getAbsolutePath());
            return;
        }

        String[] contido = dir.list();
        if (contido == null || contido.length == 0) {
            System.out.println("O directorio está baleiro: " + dir.getAbsolutePath());
        } else {
            System.out.println("Contido do directorio '" + dir.getAbsolutePath() + "':");
            for (String elemento : contido) {
                File elementoFile = new File(dir, elemento);
                if (elementoFile.isDirectory()) {
                    System.out.println("[DIR]  " + elemento);
                } else {
                    System.out.println("[FILE] " + elemento);
                }
            }
        }
    }



    public static void main(String[] args) {
        // Pruebas de los métodos

        // 1) Test eDirectorio
        System.out.println("=== 1 - Probando eDirectorio ===");
        String ruta1 = "/home";
        System.out.println("A ruta '" + ruta1 + "' " + eDirectorio(ruta1));

        String ruta2 = "/RUTA_INEXISTENTE";
        System.out.println("A ruta '" + ruta2 + "' " + eDirectorio(ruta2));

        // 2) Test eFicheiro
        System.out.println("\n=== 2 - Probando eFicheiro ===");
        String archivo1 = "/etc/hosts";
        System.out.println("A ruta '" + archivo1 + "' " + eFicheiro(archivo1));

        String archivo2 = "/archivo_inexistente.txt";
        System.out.println("A ruta '" + archivo2 + "' " + eFicheiro(archivo2));

        // 3) Test creaDirectorio
        System.out.println("\n=== 3 - Probando creaDirectorio ===");
        String nuevoDir = "meuDirectorio";
        creaDirectorio(nuevoDir);
        creaDirectorio(nuevoDir);
        
        // 4) Test creaFicheiro
        System.out.println("\n=== 4 - Probando creaFicheiro ===");
        creaFicheiro(nuevoDir, "meuArquivo.txt");
        creaFicheiro(nuevoDir, "meuArquivo.txt");

        // Verificar que se creó correctamente
        System.out.println("Comprobación: " + eFicheiro(nuevoDir + "/meuArquivo.txt"));

        // 5) Test modoAcceso
        System.out.println("\n=== 5 - Probando modoAcceso ===");
        System.out.println("Permisos do ficheiro creado:");
        modoAcceso(nuevoDir, "meuArquivo.txt");

        System.out.println("\nProbando con ficheiro inexistente:");
        modoAcceso(nuevoDir, "arquivo_inexistente.txt");

        // 6) Test calculaLonxitude
        System.out.println("\n=== 6 - Probando calculaLonxitude ===");
        System.out.println("Lonxitude do ficheiro creado:");
        calculaLonxitude(nuevoDir, "meuArquivo.txt");

        System.out.println("\nProbando con ficheiro inexistente:");
        calculaLonxitude(nuevoDir, "arquivo_inexistente.txt");

        // Probando con un archivo del sistema
        System.out.println("\nProbando con /etc/hosts:");
        calculaLonxitude("/etc", "hosts");

        // Crear y probar con un archivo con contenido
        System.out.println("\n=== Probando con archivo con contenido ===");
        creaFicheiro(nuevoDir, "arquivoConContido.txt");
        // Podrías añadir contenido al archivo aquí si quisieras probar con tamaño > 0
        calculaLonxitude(nuevoDir, "arquivoConContido.txt");

        // 7) Test mLectura
        System.out.println("\n=== 7 - Probando mLectura ===");
        mLectura(nuevoDir, "meuArquivo.txt");
        modoAcceso(nuevoDir, "meuArquivo.txt");

        // 8) Test mEscritura
        System.out.println("\n=== 8 - Probando mEscritura ===");
        mEscritura(nuevoDir, "meuArquivo.txt");
        modoAcceso(nuevoDir, "meuArquivo.txt");

        // 9) Test borraFicheiro
        System.out.println("\n=== 9 - Probando borraFicheiro ===");
        borraFicheiro(nuevoDir, "meuArquivo.txt");
        borraFicheiro(nuevoDir, "arquivo_inexistente.txt");

        // 10) Test borraDirectorio
        System.out.println("\n=== 10 - Probando borraDirectorio ===");
        borraDirectorio(nuevoDir); // Fallará si tiene contenido
        borraFicheiro(nuevoDir, "arquivoConContido.txt");
        borraDirectorio(nuevoDir); // Ahora debería eliminarse

        // 11) Test mContido
        System.out.println("\n=== 11 - Probando mContido ===");
        mContido("/etc");

    }
}