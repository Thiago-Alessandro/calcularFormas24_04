import java.util.ArrayList;

public class Forma {

    private static ArrayList<Forma> formasLista = new ArrayList<>();

    double area;
    double perimetro;

    public static ArrayList<Forma> getFormasLista(){
        return formasLista;
    }

    public static void setFormasLista(Forma forma){
        formasLista.add(forma);
    }

}