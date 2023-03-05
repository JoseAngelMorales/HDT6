package HDT6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Factory factory = new Factory();
        Mapa<String, String> mapa = new Mapa<>();

        System.out.println("Ingrese la direccion del archivo: ");
        String archivo = teclado.nextLine();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = reader.readLine();
            while(linea != null){
                Namer namer = factory.getNamer(linea);
                mapa.agregar(namer.getNombre(), namer.getTipoproducto());
                linea = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("No se ha encontrado la direccion del archivo.");
        }
        
    }
}
