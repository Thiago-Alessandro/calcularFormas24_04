import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static Professor professorLogado = null;

    private static Professor professor = new Professor("Romario Hornburg", "123");

    public static void main(String[] args) {

        do{

            do{
                switch (telaInicial()){
                    case 1:
                        if(!login()){
                            System.exit(0);
                        }
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcao inválida!");
                }

            }while(professorLogado == null);

            do{
                switch (menu()){

                    case 1:
                        int opcao;
                        do {
                            opcao = mostrarFormasMenu();

                            switch (opcao) {

                                case 1:
                                    System.out.println(Forma.getFormasLista());
                                    break;
                                case 2:
                                    System.out.println(Circulo.getCirculosLista());
                                    break;
                                case 3:
                                    System.out.println(Quadrado.getQuadradosLista());
                                    break;
                                case 4:
                                    System.out.println(Retangulo.getRetangulosLista());
                                    break;
                                case 5:
                                    System.out.println(Triangulo.getTriangulosLista());
                                    break;
                                default:
                                    System.out.println("Opcao inválida!");
                                    break;
                            }

                        } while(opcao!=0);

                        break;
                    case 2:
                        System.out.println(cadastrarCirculo());
                        break;
                    case 3:
                        System.out.println(cadastrarQuadrado());
                        break;
                    case 4:
                        System.out.println(cadastrarRetangulo());
                        break;
                    case 5:
                        System.out.println(cadastrarTriangulo());
                        break;
                    case 0:
                        logout();
                        break;
                    default:
                        break;
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
            String senha = sc.next();

            if(verificarSenha(senha)){
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
        if(professor.getSenha().equals(senha)){
            return true;
        }
        return false;
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

    private static String cadastrarCirculo(){

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

                case 1:
                    System.out.println("Insira o valor do raio: ");
                    raio = sc.nextDouble();
                    break;
                case 2:
                    System.out.println("Insira o valor do diametro: ");
                    raio = (sc.nextDouble() / 2);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 1 && opcao != 2);

        Circulo circulo = new Circulo();

        if(circulo.construirCirculo(raio)){
            return "Circulo cadastrado com sucesso!";

        }else{
            return escreverMensagemErro();
        }

    }

    private static String cadastrarQuadrado(){

        System.out.println("Insira o valor do lado do quadrado: ");
        double lado = sc.nextDouble();

        Quadrado quadrado = new Quadrado();

        if(quadrado.construirQuadrado(lado)){
            return "Quadrado cadastrado com sucesso!";

        }else{
            return escreverMensagemErro();
        }

    }

    private static String cadastrarRetangulo(){

        System.out.println("Insira o valor do lado 1 do retangulo: ");
        double lado1 = sc.nextDouble();

        System.out.println("Insira o valor do lado 2 do retângulo: ");
        double lado2 = sc.nextDouble();

        Retangulo retangulo = new Retangulo();

        if(retangulo.construirRetangulo(lado1, lado2)){
            return "Retângulo cadastrado com sucesso!";

        }else {
            return escreverMensagemErro() + " e lados com valores distintos";
        }

    }

    private static String cadastrarTriangulo(){

        double valor[] = new double[3];

        for(int i = 0; i < 3;i++) {

            System.out.println("Insira o valor do lado " + (i+1));
            valor[i] = sc.nextDouble();

        }

        Triangulo triangulo = new Triangulo();

        if(triangulo.construirTriangulo(valor[0],valor[1],valor[2])){
            return "Triângulo cadastrado com sucesso!";
        }else{
            return escreverMensagemErro() + " que caracterizem um triângulo";
        }
    }

    private static String escreverMensagemErro(){
        return "Valor(es) inválido(s)! Insira apenas valores maiores que 0";
    }

}
