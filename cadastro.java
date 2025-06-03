public class CadastroAutomoveis {

    private static ArrayList<Automovel> lista = new ArrayList<>();

    public static void main(String[] args) {
        // Carregar os dados do arquivo no início (opcional)
        carregarDados();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Incluir automóvel");
            System.out.println("2 - Excluir automóvel");
            System.out.println("3 - Alterar dados");
            System.out.println("4 - Consultar automóvel");
            System.out.println("5 - Listar ordenado");
            System.out.println("6 - Salvar dados");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: incluir(); break;
                case 2: excluir(); break;
                case 3: alterar(); break;
                case 4: consultar(); break;
                case 5: listarOrdenado(); break;
                case 6: salvar(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Implementar os métodos: incluir, excluir, alterar, consultar, listarOrdenado, salvar, carregarDados
}