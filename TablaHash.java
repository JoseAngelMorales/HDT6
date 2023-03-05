package HDT6;
public class TablaHash<L, V> {
    
    L llave;
    V valor;
    final int hashCode;

    TablaHash<L, V> next;
   
public TablaHash(L llave, V valor, int hashCode){
    this.valor = valor;
    this.llave = llave;
    this.hashCode = hashCode;
}

}