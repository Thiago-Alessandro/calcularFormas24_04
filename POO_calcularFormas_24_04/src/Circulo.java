import java.util.ArrayList;

public class Circulo extends Forma{

    private static ArrayList<Circulo> circulosLista = new ArrayList<>();

    private double diametro;
    private double raio;

    public boolean construirCirculo(double raio){

        if(raio > 0) {
            this.raio = raio;
            this.diametro = 2 * raio;

            this.perimetro = calcularPerimetro();
            this.area = calcularArea();

            circulosLista.add(this);
            Forma.setFormasLista(this);

            return true;
        }
        return false;
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
        return "Circulo{" +
                "diametro=" + diametro +
                ", raio=" + raio +
                ", area=" + area +
                ", perimetro=" + perimetro +
                '}' + '\n'; //\n para pular linha ao imprimir o array
    }
}