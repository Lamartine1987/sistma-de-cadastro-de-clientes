import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Scanner scan_pass = new Scanner(System.in);

        List<String> cadastro_name = new ArrayList<>();
        List<Integer> list_password = new ArrayList<>();

        int option = 0, position, pass =0, pass_confirm;
        String name, new_name;

        while(option != 5){
            System.out.println("\n*** Bem vindo ao sistema do Lamartine ***\n");
            System.out.println("O que deseja fazer:\n1 - Cadastrar Usuário\n2 - Consultar Usuário\n3 - Alterar Usuário\n4 - Deletar Usuário\n5 - Sair");
            System.out.println("\nEscolha a opção: ");
            option = scan.nextInt();
            switch(option){
                case 1: {
                    System.out.println("\nDigite seu nome: ");
                    name = scan.next();
                    if (!(cadastro_name.contains(name))) {
                        cadastro_name.add(name);
                        System.out.println("Digite uma senha: ");
                        pass = scan_pass.nextInt();
                        do{
                            System.out.println("Confirme sua senha: ");
                            pass_confirm = scan_pass.nextInt();
                            if(pass_confirm != pass)System.out.println("\nSua senha está diferente.");
                        }while (pass_confirm != pass);
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
                    if(!(cadastro_name.contains(name)) | cadastro_name.isEmpty())System.out.println("\nUsuário não cadastrado ou lista vazia.");
                    else{
                        pass = 0;
                        while(pass != list_password.get(position)){
                            if(pass != 0)System.out.println("\nAs senhas não conferem.");
                            System.out.println("\nDigite a senha: ");
                            pass = scan_pass.nextInt();
                        }
                        System.out.println("\nConsulta realizada!");
                        System.out.println("Usuário: " + cadastro_name.get(position));
                        System.out.println("Senha: " + list_password.get(position));
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome do usuário que deseja alterar: ");
                    name = scan.next();
                    position = cadastro_name.indexOf(name);
                    if(!(cadastro_name.contains(name)))System.out.println("\nUsuário não encontrado.");
                    else{
                        System.out.println("Digite o novo nome do usuário: ");
                        new_name = scan.next();
                        do{
                            System.out.println("Digite a senha: ");
                            pass = scan_pass.nextInt();
                            if(pass != list_password.get(position))System.out.println("\nA senha não confere.");
                        }while(pass != list_password.get(position));
                        cadastro_name.add(position, new_name);
                        System.out.println("\nUsuário alterado!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Digite o nome do usuário que deseja excluir: ");
                    name = scan.next();
                    position = cadastro_name.indexOf(name);
                    if(!(cadastro_name.contains(name)))System.out.println("Usuário não encontrado.");
                    else {
                        cadastro_name.remove(position);
                        list_password.remove(position);
                    }
                }

            }
        }
        if(cadastro_name == null || cadastro_name.isEmpty()){
            System.out.println("\nA lista não possui nenhum dado.");
        }
        System.out.println("\nSaiu do sistema!");
    }
}
