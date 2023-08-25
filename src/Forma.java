import java.util.ArrayList;

public class Forma {

    private static ArrayList<Forma> formasLista = new ArrayList<>();

    private double area;
    private double perimetro;

    public static ArrayList<Forma> getFormasLista(){
        return formasLista;
    }

    public static void setFormasLista(Forma forma){
        formasLista.add(forma);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
}