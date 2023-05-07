import java.util.ArrayList;

public class Triangulo extends Forma{

    private static ArrayList<Triangulo> triangulosLista = new ArrayList<>();

    private double valor1;
    private double valor2;
    private double valor3;

    String tipo;

    public boolean construirTriangulo(double a, double b, double c){

        if(a<=0 || a < calcularDistancia(b,c) || a > (b+c)){
            return false;
        }
        if(b<=0 || b < calcularDistancia(a,c) || b > (a+c)){
            return false;
        }
        if(c<=0 || c < calcularDistancia(a,b) || c > (a+b)){
            return false;
        }
        this.valor1 = a;
        this.valor2 = b;
        this.valor3 = c;
        this.tipo = verificarTipoTriangulo();

        this.perimetro = calcularPerimetro();
        this.area = calcularArea();

        triangulosLista.add(this);
        Forma.setFormasLista(this);

        return true;
    }

    private String verificarTipoTriangulo() {

        double a = this.valor1;
        double b = this.valor2;
        double c = this.valor3;

        if(a == b && b == c){
            return "Equilátero";
        }else if (b == c || c == a || a == b){
            return "Isósceles";
        }else {
            return "Escaleno";
        }

    }

    private double calcularPerimetro() {
        return this.valor1 + this.valor2 + this.valor3;
    }

    private double calcularArea(){

        if(this.tipo == "Equilatero"){

            return (Math.pow(valor1, 2)*Math.sqrt(3))/4;

        }else if(this.tipo == "Isósceles"){

            double altura;
            double ladoDiferente;
            double ladoRepetido;

            if(this.valor1 == this.valor2){
                ladoRepetido = this.valor1;
                ladoDiferente = this.valor3;
            } else if (this.valor1 == this.valor3) {
                ladoRepetido = this.valor1;
                ladoDiferente = this.valor2;
            } else {
                ladoRepetido = this.valor2;//igual a valor3
                ladoDiferente = this.valor1;
            }

            altura = Math.sqrt(Math.pow(ladoRepetido, 2) - Math.pow(ladoDiferente, 2)/4);

            return ((ladoDiferente*altura)/2);

        } else{
            double semiperimetro = ((this.perimetro)/2);
            return semiperimetro*((semiperimetro-valor1)*(semiperimetro-valor2)*(semiperimetro-valor3));
        }
    }

    private double calcularDistancia(double a, double b){
        if(a - b > 0){
            return a-b;
        }else{
            return (a-b) * -1;
        }
    }

    public static ArrayList<Triangulo> getTriangulosLista(){
        return triangulosLista;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "area=" + this.area +
                ", perimetro=" + this.perimetro +
                ", valor1=" + valor1 +
                ", valor2=" + valor2 +
                ", valor3=" + valor3 +
                ", tipo='" + tipo + '\'' +
                '}' + '\n';
    }

}