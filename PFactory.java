package HDT6;

public class PFactory extends Namer{
    public PFactory(String s){
        int i = s.lastIndexOf("|");
            
        tipoproducto = s.substring(0, i-1).trim();
        nombre = s.substring(i+2);
    }
}
