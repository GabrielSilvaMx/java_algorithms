import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BusquedaBinaria {

    /*
    Search a valur from array and return this value founded or -1 if not found
     */
    public static int busqueda(int[] datos, int clave) {
        int posicion = datos.length == 1 ? datos.length - 1 : (datos.length / 2);

        if (datos[posicion]==clave) // si el valor es el buscado, salir
            return clave;
        else if (posicion == 0) // si llegó al último elemento pero no es el encontrado regresa -1
            return -1;
        // si es mayor: obten de la pos. de enmedio hasta el final, sino pos de enmedio al principio
        datos = clave > datos[posicion] ?  Arrays.copyOfRange(datos,posicion+1,datos.length) : Arrays.copyOfRange(datos,0,posicion);
        // loop vuelve a revisar si el de enmedio es el buscado
            posicion = busqueda(datos, clave);
        // sigue hasta que solo quede un solo dato en el array: datos[0]
        // vuelve a revisar si este elemento es el buscado
        // si este ultimo no es: regresa -1

        return posicion;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SecureRandom generador = new SecureRandom();
        int[] datos = new int[9];
        int posicion;
        
        for (int i = 0; i < datos.length; i++)
            datos[i] = 10 + generador.nextInt(90);

        Arrays.sort(datos); 
        System.out.println( );
        System.out.printf("%s - Pos Inicial: %s%n%n--------%n", Arrays.toString(datos), (datos.length / 2)); 

        System.out.print("Escriba un valor entero (-1 para salir): ");
        int enteroABuscar = entrada.nextInt();

        posicion = busqueda(datos, enteroABuscar);
        
        System.out.println("Posición en el array:" + posicion);
    }
}
