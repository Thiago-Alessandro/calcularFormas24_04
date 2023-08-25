import java.util.ArrayList;

public class Quadrado extends Forma{

    private static ArrayList<Quadrado> quadradosLista = new ArrayList<>();

    private double lado;

    public Quadrado (double lado){

        this.lado = lado;

        this.setArea(calcularArea());
        this.setPerimetro(calcularPerimetro());

        quadradosLista.add(this);
        Forma.setFormasLista(this);
    }

    private double calcularPerimetro(){

        return this.lado*4;
    }

    private double calcularArea(){

        return Math.pow(this.lado, 2);
    }

    public static ArrayList<Quadrado> getQuadradosLista(){
        return quadradosLista;
    }

    @Override
    public String toString() {
        return '\n'+"Quadrado{" +
                    "lado=" + lado +
                    ", area=" + getArea() +
                    ", perimetro=" + getPerimetro() +
                    '}' + '\n';
    }

}