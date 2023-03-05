package HDT6;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Objects;

import junit.framework.Test;

public class Mapa<L, V>{

private ArrayList<TablaHash<L, V>> arrayhash;
private int capacidad;
private int tamano;

public Mapa(){
    arrayhash = new ArrayList<>();
    capacidad = 2;
    tamano = 0;
    for (int i = 0; i < capacidad; i++){
        arrayhash.add(null);
    }
}

private final int hashCode(L llave){
    return Objects.hashCode(llave);
}

private int buscarindice(L llave){
    int hashCode = hashCode(llave);
    int indice = hashCode % capacidad;
    if(indice<0){
        indice = indice * -1;
    }
    return indice;
}

public V quitar(L llave){
    int indice = buscarindice(llave);
    int hashCode = hashCode(llave);
    TablaHash<L, V> primer = arrayhash.get(indice);

    TablaHash<L, V> ant = null;
    while(primer != null){
        if(primer.llave.equals(llave) && hashCode == primer.hashCode){
            break;
        }
        ant = primer;
        primer = primer.next;
    }

    if(primer == null){
        return null;
    }

    tamano--;

    if(ant != null){
        ant.next = primer.next;
    }
    else {
        arrayhash.set(indice, primer.next);
    }
    return primer.valor;
}

public V get(L llave){
    int indice = buscarindice(llave);
    int hashCode = hashCode(llave);
 
    TablaHash<L, V> primer = arrayhash.get(indice);

    while (primer != null) {
        if (primer.llave.equals(llave) && primer.hashCode == hashCode){
            return primer.valor;
        }
    primer = primer.next;
  }
  return null;
}

public void agregar(L llave, V valor){
    int indice = buscarindice(llave);
    int hashCode = hashCode(llave);
    TablaHash<L, V> primer = arrayhash.get(indice);
    while(primer != null){
        if(primer.llave.equals(llave) && primer.hashCode == hashCode){
            primer.valor = valor;
            return;
        }
        primer = primer.next;
    }

    tamano++;
    primer = arrayhash.get(indice);
    TablaHash<L, V> nuevo = new TablaHash<L, V>(llave, valor, hashCode);
    nuevo.next = primer;
    arrayhash.set(indice, nuevo);

}

public int TamanoHash(){
    return tamano;
}

@org.junit.Test
public void pruebaHash(){

    int valor;
    Mapa<Integer, Integer> mapa = new Mapa<>();
    mapa.agregar(1, 10);
    mapa.agregar(2, 20);
    mapa.agregar(3, 30);
    assertEquals(3, mapa.TamanoHash()); //El tamano de la tabla es de 2
    valor = mapa.get(1);
    assertEquals(10, valor); //La primera entrada corresponde al valor 10
    mapa.quitar(1);
    assertEquals(2, mapa.TamanoHash()); //Se removio la entrada 1 asi que ahora solo queda 1 entrada
    }
}

