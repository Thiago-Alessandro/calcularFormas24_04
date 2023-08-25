public class Equilatero extends Triangulo{

    public Equilatero(double valor1, double valor2,double valor3 ){

        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;

        setPerimetro(calcularPerimetro());
        setArea(calcularArea());

        this.tipo = "Equilátero";

        this.adicionarNasListas();
    }

    private double calcularArea(){
        return (Math.pow(this.valor1, 2)*Math.sqrt(3))/4;
    }

}
