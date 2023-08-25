import java.util.ArrayList;

public class Circulo extends Forma{

    private static ArrayList<Circulo> circulosLista = new ArrayList<>();

    private double diametro;
    private double raio;

    public Circulo(double raio){

        this.raio = raio;
        this.diametro = raio * 2;

        this.setPerimetro(calcularPerimetro());
        this.setArea(calcularArea());

        circulosLista.add(this);
        Forma.setFormasLista(this);
    }

    private double calcularPerimetro(){

        return Math.PI * diametro;
    }

    private double calcularArea(){

        return Math.PI * Math.pow(raio, 2);
    }

    public static ArrayList<Circulo> getCirculosLista() {
        return circulosLista;
    }

    @Override
    public String toString() {
        return '\n'+"Circulo{" +
                    "diametro=" + diametro +
                    ", raio=" + raio +
                    ", area=" + getArea() +
                    ", perimetro=" + getPerimetro() +
                    '}' + '\n';
    }
}