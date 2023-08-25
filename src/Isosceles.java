public class Isosceles extends Triangulo{
    
    public Isosceles(double valor1, double valor2, double valor3){

        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;

        setPerimetro(calcularPerimetro());
        setArea(calcularArea());

        this.tipo = "Isósceles";

        this.adicionarNasListas();
    }

    private double calcularArea(){

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
            
    }
    
}
