import java.util.ArrayList;

public class Retangulo extends Forma{

    private static ArrayList<Retangulo> retangulosLista = new ArrayList<>();

    private double lado1;
    private double lado2;

    public boolean construirRetangulo(double lado1, double lado2){

        if(lado1 > 0 && lado2 > 0 && lado1!=lado2){

            this.lado1 = lado1;
            this.lado2 = lado2;

            this.perimetro = calcularPerimetro();
            this.area = calcularArea();

            retangulosLista.add(this);
            Forma.setFormasLista(this);

            return true;
        }
        return  false;
    }

    private double calcularPerimetro(){

        return 2*(this.lado1 + this.lado2);
    }

    private double calcularArea(){

        return lado1*lado2;
    }

    public static ArrayList<Retangulo> getRetangulosLista(){
        return retangulosLista;
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                "lado1=" + lado1 +
                ", lado2=" + lado2 +
                ", area=" + area +
                ", perimetro=" + perimetro +
                '}' + '\n';
    }

}