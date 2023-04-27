import java.util.ArrayList;

public class Triangulo extends Formas{

    ArrayList<Triangulo> triangulosLista = new ArrayList<>();

    public Triangulo(){
        triangulosLista.add(this);
        formasLista.add(this);
        this.area = calcularArea();
        this.perimetro = calcularPerimetro();
    }

    double valor1;
    double valor2;
    double valor3;

    String tipo;

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

    private double calcularDistancia(double a, double b){
        if(a - b > 0){
            return a-b;
        }else{
            return (a-b) * -1;
        }
    }

    public String validarEAdicionarMedidas(double a, double b, double c){

        if(a<=0 ){
            return a + " é um valor inválido, insira um número positivo maior que 0 ";
        }
        if(b<=0){
            return b + " é um valor inválido, insira um número positivo maior que 0 ";
        }
        if(c<=0){
            return c + " é um valor inválido, insira um número positivo maior que 0 ";
        }
        this.valor1 = a;
        this.valor2 = b;
        this.valor3 = c;
        this.tipo = verificarTipoTriangulo();
        return "Triângulo adicionado com sucesso! ";
    }

    public void listarTriangulos(){

        for (Triangulo triangulo: triangulosLista){
            System.out.println(triangulo);
        }
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "area=" + area +
                ", perimetro=" + perimetro +
                ", valor1=" + valor1 +
                ", valor2=" + valor2 +
                ", valor3=" + valor3 +
                ", tipo=" + tipo +
                '}';
    }

    private double calcularArea(){
        if(this.tipo == "Equilatero"){
            this.area = ((this.valor1*this.valor1)*Math.sqrt(13))/4;
        }else if(this.tipo == "Isósceceles"){

        }
    }

}
