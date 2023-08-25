import java.util.Scanner;

public class Main {

    private final static Scanner sc = new Scanner(System.in);

    private static Professor professorLogado = null;

    private final static Professor professor = new Professor("Romario Hornburg", "123");

    public static void main(String[] args) {

        do{

            do{
                switch (telaInicial()){

                    case 1 -> { if(!login()){ System.exit(0);} }
                    case 2 -> System.exit(0);
                    default -> System.out.println("Opcao inválida!");
                }
            } while(professorLogado == null);

            do{
                switch (menu()){

                    case 1 -> mostrarFormas();
                    case 2 -> cadastrarCirculo();
                    case 3 -> cadastrarQuadrado();
                    case 4 -> cadastrarRetangulo();
                    case 5 -> cadastrarTriangulo();
                    case 0 -> logout();
                    default -> System.out.println("Opcao inválida!");
                }
            }while(professorLogado != null);

        }while(true);
    }

    private static int telaInicial(){

        System.out.println("""
                    TELA INICIAL
                    
                1 - Fazer login
                0 - Fechar programa
                """);
        return sc.nextInt();
    }

    private static boolean login(){

        for(int i = 2; i >= 0; i--){

            System.out.println("Insira sua senha: ");

            if(verificarSenha(sc.next())){
                professorLogado = professor;
                System.out.println("Login efetuado com sucesso!");
                return true;
            } else{
                System.out.println("Senha errada! tentativas restantes: " + i);
            }
        }
        return false;
    }

    private static boolean verificarSenha(String senha){
        return professor.getSenha().equals(senha);
    }

    private static int menu(){

        System.out.println("""
                        MENU
                    
                1 - Mostrar formas
                2 - Cadastrar Circulo
                3 - Cadastrar Quadrado
                4 - Cadastrar Retangulo
                5 - Cadastrar Triangulo
                0 - Fazer Logout
                """);

        return sc.nextInt();
    }

    private static void logout(){

        for(int i = 2; i >= 0; i--){

            System.out.println("Insira sua senha: ");
            String senha = sc.next();

            if(verificarSenha(senha)){
                professorLogado = null;
                break;
            } else{
                System.out.println("Senha errada! tentativas restantes: " + i);
            }
        }

    }

    private static int mostrarFormasMenu(){
        System.out.println("""
                    MOSTRAR FORMAS
                    
                1 - Listar Todas
                2 - Listar Circulos
                3 - Listar Quarados
                4 - Listar Retangulos
                5 - Listar Triangulos
                0 - sair
                """);
        return sc.nextInt();
    }

    private static void cadastrarCirculo(){

        double raio = 0;
        int opcao;

        do {
            System.out.println("""
                Qual valor deseja cadastrar?
                
                1 - Raio
                2 - Diametro
                """);

            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Insira o valor do raio: ");
                    raio = sc.nextDouble();
                }
                case 2 -> {
                    System.out.println("Insira o valor do diametro: ");
                    raio = (sc.nextDouble() / 2);
                }
                default -> System.out.println("Opção inválida!");
            }
            if(raio<=0){
                System.out.println(mensagemErro());
            }
        }while(raio <= 0);

        new Circulo(raio);
        System.out.println("Circulo cadastrado com sucesso!");
    }


    private static void cadastrarQuadrado(){
        double lado;
        do {
            System.out.println("Insira o valor do lado do quadrado: ");
            lado = sc.nextDouble();

            if(lado <=0){
                System.out.println(mensagemErro());
            }
        } while(lado <= 0);

        new Quadrado(lado);
        System.out.println("Quadrado cadastrado com sucesso!");
    }

    private static void cadastrarRetangulo(){
        double lado1;
        double lado2;
        do {
            System.out.println("Insira o valor do lado 1 do retangulo: ");
            lado1 = sc.nextDouble();

            System.out.println("Insira o valor do lado 2 do retângulo: ");
            lado2 = sc.nextDouble();

            if(lado1 <= 0 || lado2 <=0 ){
                System.out.println(mensagemErro() + " e lados com valores distintos");
            }
        }while(lado1 <= 0 || lado2 <= 0);

        new Retangulo(lado1, lado2);
        System.out.println("Retângulo cadastrado com sucesso!");
    }

    private static void cadastrarTriangulo(){

        double[] valor = new double[3];

        do {
            for (int i = 0; i < 3; i++) {

                System.out.println("Insira o valor do lado " + (i + 1));
                valor[i] = sc.nextDouble();
            }

            if(Triangulo.validaTriangulo(valor[0], valor[1], valor[2]) ){
                System.out.println(mensagemErro() + " que caracterizem um triângulo");
            }

        }while(Triangulo.validaTriangulo(valor[0], valor[1], valor[2]) );

        if(valor[0] == valor[1] && valor[1] == valor[2]){
           new Equilatero(valor[0], valor[1], valor[2]);
        }else if (valor[1] == valor[2] || valor[2] == valor[0] || valor[0] == valor[1]){
            new Isosceles(valor[0], valor[1], valor[2]);
        }else {
            new Escaleno(valor[0], valor[1], valor[2]);
        }

        System.out.println("Triângulo cadastrado com sucesso!");
    }

    private static String mensagemErro(){
        return "Valor(es) inválido(s)! Insira apenas valores maiores que 0";
    }

    private static void mostrarFormas(){
        int opcao;
        do {
            opcao = mostrarFormasMenu();

            switch (opcao) {

                case 1 -> System.out.println(Forma.getFormasLista());
                case 2 -> System.out.println(Circulo.getCirculosLista());
                case 3 -> System.out.println(Quadrado.getQuadradosLista());
                case 4 -> System.out.println(Retangulo.getRetangulosLista());
                case 5 -> System.out.println(Triangulo.getTriangulosLista());
                case 0 -> {}
                default -> System.out.println("Opcao inválida!");
            }
        } while (opcao != 0);
    }
}