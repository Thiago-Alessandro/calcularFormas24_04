import java.util.ArrayList;

public class Triangulo extends Forma{

    private static ArrayList<Triangulo> triangulosLista = new ArrayList<>();

     double valor1;
     double valor2;
     double valor3;

    String tipo;

    public static boolean validaTriangulo(double a, double b, double c) {

        if(a<=0 || a < calcularDistancia(b,c) || a > (b+c)){
            return false;
        }
        if(b<=0 || b < calcularDistancia(a,c) || b > (a+c)){
            return false;
        }
        return !(c<=0 || c < calcularDistancia(a,b) || c > (a+b));
    }

    public double calcularPerimetro() {
        return this.valor1 + this.valor2 + this.valor3;
    }

    private static double calcularDistancia(double a, double b){
        if(a - b > 0){
            return a-b;
        }else{
            return (a-b) * -1;
        }
    }

    public static ArrayList<Triangulo> getTriangulosLista(){
        return triangulosLista;
    }

    public void adicionarNasListas(){
        triangulosLista.add(this);
        Forma.setFormasLista(this);
    }

    @Override
    public String toString() {
        return '\n'+"Triangulo{" +
                    "area=" + getArea() +
                    ", perimetro=" + getPerimetro() +
                    ", valor1=" + valor1 +
                    ", valor2=" + valor2 +
                    ", valor3=" + valor3 +
                    ", tipo='" + tipo + '\'' +
                    '}' + '\n';
    }
}