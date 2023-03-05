package HDT6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        Factory factory = new Factory();
        Mapa gmapa = new Mapa();

        String menu = "Bienvenido al programa, elija la opcion de implementacion\n1. Hashmap\n2. Linked Hashmap\n3. Treemap";
        System.out.println(menu);
        int tipomapa = teclado.nextInt();
        teclado.nextLine();
        while(tipomapa>=1 && tipomapa<=3){
            System.out.println(menu);
            tipomapa = teclado.nextInt();
            teclado.nextLine();
        }
        
        Map<String, String> mapa = gmapa.newMap(tipomapa);

        System.out.println("Ingrese la direccion del archivo: ");
        String archivo = teclado.nextLine();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = reader.readLine();
            while(linea != null){
                Namer namer = factory.getNamer(linea);
                mapa.put(namer.getNombre(), namer.getTipoproducto());
                linea = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("No se ha encontrado la direccion del archivo.");
        }
        
    }
}
