import java.util.ArrayList;

public class Quadrado extends Forma{

    private static ArrayList<Quadrado> quadradosLista = new ArrayList<>();

    private double lado;

    public boolean construirQuadrado(double lado){

        if(lado > 0){

            this.lado = lado;

            this.perimetro = calcularPerimetro();
            this.area = calcularArea();

            quadradosLista.add(this);
            Forma.setFormasLista(this);

            return true;
        }

        return false;
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
        return "Quadrado{" +
                "lado=" + lado +
                ", area=" + area +
                ", perimetro=" + perimetro +
                '}' + '\n';
    }

}