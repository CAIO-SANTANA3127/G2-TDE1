public class Automovel {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;

    // Construtor
    public Automovel(String placa, String marca, String modelo, int ano, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    // Getters e Setters
    // toString() para exibir os dados
}


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

public static void salvar() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("automoveis.txt"))) {
        for (Automovel a : lista) {
            writer.println(a.getPlaca() + ";" + a.getMarca() + ";" + a.getModelo() + ";" + a.getAno() + ";" + a.getValor());
        }
        System.out.println("Dados salvos com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao salvar: " + e.getMessage());
    }
}

public static void carregarDados() {
    try (BufferedReader reader = new BufferedReader(new FileReader("automoveis.txt"))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            Automovel a = new Automovel(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]), Double.parseDouble(dados[4]));
            lista.add(a);
        }
    } catch (IOException e) {
        System.out.println("Arquivo não encontrado. Criando novo cadastro.");
    }
}
