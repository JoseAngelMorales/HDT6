package HDT6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        Factory factory = new Factory();
        Mapa gmapa = new Mapa();

        String menu1 = "Bienvenido al programa, elija la opcion de implementacion\n1. Hashmap\n2. Linked Hashmap\n3. Treemap";
        System.out.println(menu1);
        int tipomapa = teclado.nextInt();
        teclado.nextLine();
        while(tipomapa < 1 || tipomapa > 3){
            System.out.println(menu1);
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
        
        ArrayList<String> coleccion = new ArrayList<String>();
        String menu2 = "\nElija una de las siguientes opciones\n1. Agregar un producto\n2. Ver categoria de un producto\n3. Mostrar productos en inventario\n4. Mostrar productos en inventario por tipo\n5. Mostrar productos\n6. Mostrar productos ordenados por tipo\n7. Cerrar el programa\nIngrese su opcion: ";
        int opcion = 1;
        System.out.println(menu2);
        opcion = teclado.nextInt();
        teclado.nextLine();
        while(opcion >= 1 && opcion < 7){
            switch(opcion){
                case 1: {
                    System.out.println("Ingrese el nombre del producto: ");
                    String opc1 = teclado.nextLine();
                    if(mapa.containsKey(opc1) == true){
                        coleccion.add(opc1);
                        System.out.println("Se ha agregado el producto "+opc1+" a su coleccion.");
                        System.out.println(menu2);
                        opcion = teclado.nextInt();
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No existe un producto con ese nombre");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el nombre del producto: ");
                    String opc2 = teclado.nextLine();
                    if(mapa.containsKey(opc2) == true){
                        System.out.println("La categoria del producto es: "+mapa.get(opc2));
                        System.out.println(menu2);
                        opcion = teclado.nextInt();
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No existe un producto con ese nombre");
                    }
                    break;
                }
                case 3:{
                    
                }
            }
        }
    }
}
