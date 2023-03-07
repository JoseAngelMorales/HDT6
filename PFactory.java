package HDT6;

public class PFactory extends Namer{
    public PFactory(String s){
        //Busca el simboolo | que separa el producto y su tipo
        int i = s.lastIndexOf("|");
        
        //Del inicio a un espacio antes del | es el tipo de producto y de 2 espacios despues al final es el nombre del producto
        tipoproducto = s.substring(0, i-1).trim();
        nombre = s.substring(i+2);
    }
}
