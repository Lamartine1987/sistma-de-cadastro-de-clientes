import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Scanner scan_pass = new Scanner(System.in);

        List<String> cadastro_name = new ArrayList<>();
        List<Integer> list_password = new ArrayList<>();

        int option = 0, position, pass =0;
        String name;

        cadastro_name.add("Lamartine");
        list_password.add(1234);

        while(option != 5){
            System.out.println("\n*** Bem vindo ao sistema do Lamartine ***\n");
            System.out.println("O que deseja fazer:\n1 - Cadastrar Usuário\n2 - Consultar Usuário\n3 - Alterar Usuário\n4 - Deletar Usuário\n5 - Sair");
            System.out.println("\nEscolha a opção: ");
            option = scan.nextInt();
            switch(option){
                case 1: {
                    System.out.println("\nNome completo: ");
                    name = scan.next();
                    if (!(cadastro_name.contains(name))) {
                        cadastro_name.add(name);
                        System.out.println("Digite uma senha: ");
                        pass = scan_pass.nextInt();
                        list_password.add(pass);
                    }else {
                        System.out.println("\nO usuário já existe.");
                        continue;
                    }
                    System.out.println("\nUsuário cadastrado!");break;
                }
                case 2: {
                    System.out.println("Digite o nome do usuário que deseja consultar: ");
                    name = scan.next();
                    position = cadastro_name.indexOf(name);
                    if(!(cadastro_name.contains(name)))System.out.println("\nUsuário não cadastrado.");
                    else{
                        pass = 0;
                        while(pass != list_password.get(position)){
                            if(pass != 0)System.out.println("\nAs senhas não conferem.");
                            System.out.println("\nDigite a senha: ");
                            pass = scan_pass.nextInt();
                        }
                        System.out.println("\nLogin efetuado!");
                    }
                }

            }
        }
        System.out.println("\nSaiu do sistema!");
        System.out.println(cadastro_name.get(0) + list_password.get(0));
    }
}
