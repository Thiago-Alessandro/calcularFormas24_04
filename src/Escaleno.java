public class Escaleno extends Triangulo{
    
    public Escaleno(double valor1, double valor2, double valor3){
        
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;

        setPerimetro(calcularPerimetro());
        setArea(calcularArea());

        this.tipo = "Escaleno";

        this.adicionarNasListas();
    }
    
    private double calcularArea(){
        double semiperimetro = ((getPerimetro())/2);
        return semiperimetro*((semiperimetro-this.valor1)*(semiperimetro-this.valor2)*(semiperimetro-this.valor3));
    }
    
}
