import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static Professor professorLogado = null;

    private static Professor professor = new Professor("Romario Hornburg", "123");

    public static void main(String[] args) {

        do{

            do{

                if(login() == null){
                    System.exit(0);
                }

            }while(professorLogado == null);
            do{

                switch (menu()){
                    case 1:
                        cadastrarTriangulo();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
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

    private static Professor login(){

        for(int i = 2; i >= 0; i--){
            System.out.println("Insira sua senha: ");
            String senha = sc.next();
            if(professor.getSenha().equals(senha)){
                professorLogado = professor;
                System.out.println("ta certo");
                return professorLogado;
            } else{
                System.out.println("Senha errada! tentativas restantes: " + i);
            }
        }
        return null;
    }

    private static int menu(){

        System.out.println("""
                    MENU
                1 - Cadastrar Triangulo
                2 - Cadastrar Circulo
                3 - Cadastrar Quadrado
                4 - Cadastrar Retangulo
                5 - Mostrar formas
                0 - Fazer Logout    
                """);

        return sc.nextInt();
    }

    private static void logout(){
        professorLogado = null;
    }

    private static void cadastrarTriangulo(){

        double valor[] = new double[3];

        for(int i = 0; i < 3;i++) {

            System.out.println("Insira o valor do lado " + (i+1));
            valor[i] = sc.nextDouble();

        }

        Triangulo triangulo = new Triangulo();

        System.out.println(triangulo.validarEAdicionarMedidas(valor[0],valor[1],valor[2]));
    }

}
