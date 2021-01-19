package Practica1.src;
// cuando ponemos una clase y la declaramos, arriba, el package , tenemos que poner el nombre del paquete en el que esta incluido. va relacionado con la propia clase, En la calse que declaramos hay que poner el nombre del paquete. La clase de identifica tanto por si misma como por el paquete donde está incluida.
// Hay que poner el nombre del paquete en el que está incluida.
// si le cambias el nombre, java te va a protestar
import java.util.Scanner;


public class App {
    // static Scanner lector = new Scanner(System.in);
    // tambien se puede declarar el scanner fuera del main
    public static void main(String[] args) throws Exception {
        Scanner lector = new Scanner(System.in);
        System.out.println("Escribe la opción que quieras:" + "\n" + " A" + "\n" + " B" + "\n" + " C" + "\n" + " D" + "\n" + " E" + "\n" + " F" + "\n" + " G" + "\n" + " H" + "\n" + " I");
        String opcionUsuario = lector.nextLine();
        System.out.println("La opción del usuario es " + opcionUsuario);
        
        switch(opcionUsuario){
            case "A":
                System.out.println("Leer 5 números (con bucle por favor, no pongáis 5 scanner consecutivos) y mostrarlos en el mismo orden introducido. Los 5 números se deben almacenar en un array.");
                mostrarNumerosEnOrden(lector);
                break;

            case "B":
                System.out.println("Leer 5 números y mostrarlos en orden inverso al introducido");
                mostrarNumerosAlReves(lector);
                break;

            case "C":
                System.out.println("Leer 5 números por teclado y a continuación realizar la media de los números positivos, la media de los negativos y contar el número de ceros que se han introducido por teclado");
                calcularMediasYCeros(lector);
                break;

            case "D":
                System.out.println("Reciba como parámetro un texto y devuelva la cantidad de caracteres que incorpora el texto");
                System.out.println("Escribe un texto");
                String frase = lector.nextLine();
                int caracteres = contarCaracteresTexto(frase);
                System.out.println("Hay " +caracteres + " caracteres en el texto");
                break;

            case "E":
                System.out.println("Reciba como parámetro un texto y devuelva el texto invertido");
                System.out.println("Escribe un texto");
                String frase2 = lector.nextLine();
                String fraseReves = invertirTexto(frase2);
                System.out.println(fraseReves);
                break;

            case "F":
                System.out.println("Reciba como parámetro un texto y lo devuelva sin espacios en blanco");
                System.out.println("Escribe un texto");
                String frase3 = lector.nextLine();
                String fraseSinEspacios = quitarEspaciosTexto(frase3);
                System.out.println(fraseSinEspacios);
                break;
            case "G":
                System.out.println("Reciba como parámetro dos cadenas y las devuelva concatenadas");
                System.out.println("Escribe una cadena");
                String cadena1 = lector.nextLine();
                System.out.println("Escribe otra cadena");
                String cadena2 = lector.nextLine();
                String cadenasConcatenadas = concatenarDosCadenas(cadena1, cadena2);
                System.out.println(cadenasConcatenadas);
                break;
            case "H":
                System.out.println("Reciba como parámetro una cadena y una vocal, el método sustituye todas las vocales de la cadena por la vocal que se ha pasado como parámetro (no devuelve nada)");
                System.out.println("Escribe una cadena");
                String cadenaH = lector.nextLine();
                System.out.println("Escribe una vocal");
                char vocal = lector.nextLine().charAt(0);
                sustituirVocales(cadenaH, vocal);
                break;
            case "I":
                System.out.println("Reciba como parámetro una cadena, y muestre el código ASCII de cada uno de los caracteres de la cadena (no devuelve nada el método)");
                System.out.println("Escribe una cadena");
                String cadenaAscii = lector.nextLine();
                mostrarASCIIDeCadena(cadenaAscii);
                break;
            default:
                System.out.println("Esa opción es incorrecta");
        }
        lector.close();
    }

    //CASE A
    public static void mostrarNumerosEnOrden(Scanner lector){
        // String strings[] = new String[5];
        // int tamano = strings.length;
        int numeros[] = new int[3];
        for (int i = 0; i < 3; i++){
            System.out.println("Escribe un número");
            int numero = lector.nextInt();
            numeros[i] = numero;
        }
        lector.close();
        System.out.print("Tus números son: ");
        for (int i = 0 ; i < numeros.length ; i++){
            System.out.print(numeros[i]+ " ");
        }
    }

    // CASE B
    public static void mostrarNumerosAlReves(Scanner lector){
        int numeros[] = new int[3];
        for (int i = 0; i < 3; i++){
            System.out.println("Escribe un número");
            int numero = lector.nextInt();
            numeros[i] = numero;
        }
        lector.close();
        System.out.print("Tus números son: ");
        for (int i = numeros.length -1 ; i >= 0 ; i--){
            System.out.print(numeros[i]+ " ");
        }
    }

    //CASE C
    public static void calcularMediasYCeros(Scanner lector){
        // "Leer 5 números por teclado y a continuación realizar la media de los números positivos, la media de los negativos y contar el número de ceros que se han introducido por teclado"
        int numeros[] = new int[5];
        for (int i = 0; i < 5; i++){
            System.out.println("Escribe un número");
            int numero = lector.nextInt();
            numeros[i] = numero;
        }
        lector.close();
        int contadorPositivos = 0;
        int valorPositivos = 0;
        int contadorNegativos = 0;
        int valorNegativos = 0;
        int contadorCeros = 0;
        for (int i = 0 ; i < numeros.length ; i++){ // atributo
            if(numeros[i] > 0){
                contadorPositivos = contadorPositivos + 1;
                valorPositivos = valorPositivos + numeros[i];
            }else if (numeros[i]< 0){
                contadorNegativos = contadorNegativos +1;
                valorNegativos = valorNegativos + numeros[i];

            }else {
                contadorCeros = contadorCeros +1;
            }
        }

        double mediaPositivos;
        if(contadorPositivos > 0){
            mediaPositivos = (double) valorPositivos / contadorPositivos;
        } else {
            mediaPositivos = (double) valorPositivos / (contadorPositivos + 1);
        }

        double mediaNegativos; 
        if(contadorNegativos > 0){
            mediaNegativos = (double) valorNegativos / contadorNegativos;
        } else {
            mediaNegativos = (double) valorNegativos / (contadorNegativos + 1);
        }
        
        System.out.println("La media de los positivos es " + mediaPositivos);
        System.out.println("La media de los negativos es "+ mediaNegativos);
        System.out.println("Hay "+ contadorCeros + " ceros");
    }

    // CASE D
    public static int contarCaracteresTexto(String frase){
        // "Reciba como parámetro un texto y devuelva la cantidad de caracteres que incorpora el texto"
        int caracteres = 0;
        for(int i = 0; i < frase.length(); i++) {    
            if(frase.charAt(i) != ' ')    
                caracteres++;    
        }
        return caracteres;
    }

    //CASE E
    public static String invertirTexto( String frase){
        // Reciba como parámetro un texto y devuelva el texto invertido"
        // String textoInvertido;
        String fraseReves = "";
        for (int i = frase.length() -1 ; i >= 0 ; i--){ //metodo
            // System.out.print(frase.charAt(i));
            fraseReves = fraseReves +  frase.charAt(i);
        }
        // CharSequence frase3 = frase.subSequence( frase.length()-1, 0);
        // System.out.println(frase3);
        return fraseReves;
    }

    //CASE F
    public static String quitarEspaciosTexto(String frase){
        // "Reciba como parámetro un texto y lo devuelva sin espacios en blanco"
        String fraseSinEspacios = "";
        for (int i = 0; i < frase.length(); i++){
            // System.out.println("este es el caracter" + frase.charAt(i)+"-");
            if(frase.charAt(i) != ' '){
                fraseSinEspacios = fraseSinEspacios + frase.charAt(i);
            }
        }
        return fraseSinEspacios;
    }

    //CASE G
    public static String concatenarDosCadenas(String cadena1, String cadena2){
        // "Reciba como parámetro dos cadenas y las devuelva concatenadas"
        // String cadenasConcatenadas = cadena1 + ' '+cadena2;
        String cadenasConcatenadas2 = cadena1.concat(cadena2);
        return cadenasConcatenadas2;
    }

    //CASE H
    public static void sustituirVocales(String cadena, char vocal){
        // "Reciba como parámetro una cadena y una vocal, el método sustituye todas las vocales de la cadena por la vocal que se ha pasado como parámetro (no devuelve nada)"
        // System.out.println("la vocal es" + vocal);
        char[] listaVocales = new char[5];
        listaVocales[0] = 'a';
        listaVocales[1] = 'e';
        listaVocales[2] = 'i';
        listaVocales[3] = 'o';
        listaVocales[4] = 'u';
        for(int i = 0; i < cadena.length(); i++){
            boolean vocalAusente = true;
            // System.out.println("el caracter  es" + cadena.charAt(i));
            for(int j = 0; j< listaVocales.length; j++){
                if(cadena.charAt(i) == listaVocales[j] && vocalAusente){
                    vocalAusente = false;
                }
            }
            if(vocalAusente){
                System.out.print(cadena.charAt(i));
            }else{
                System.out.print(vocal);
            } 
        }
    }

    //CASE I
    public static void mostrarASCIIDeCadena(String cadena){
        // Reciba como parámetro una cadena, y muestre el código ASCII de cada uno de los caracteres de la cadena (no devuelve nada el método)
        for(int i = 0; i < cadena.length(); i++){
            char character = cadena.charAt(i);    
            int ascii = (int) character;
            System.out.print(ascii);
        }
    }
}