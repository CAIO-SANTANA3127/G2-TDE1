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
