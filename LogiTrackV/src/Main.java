import br.edu.logistica.modelo.*;
import br.edu.logistica.servico.GerenciadorFrota;

public class Main {
    public static void main(String[] args){
        System.out.println("=== SISTEMA LOGITRACK ===\n");

        GerenciadorFrota gerenciador = new GerenciadorFrota();

        Caminhao caminhao1 = new Caminhao("ABC-1234", 15000, TipoCombustivel.DIESEL, 3);
        Caminhao caminhao2 = new Caminhao("DEF-5678", 12000, TipoCombustivel.DIESEL, 2);
        Caminhao caminhao3 = new Caminhao("GHI-9990", 12200, TipoCombustivel.DIESEL, 4);

        Van van1 = new Van("AAB-9012", 2000, TipoCombustivel.GASOLINA, false);
        Van van2 = new Van("BCC-3456", 3000, TipoCombustivel.ELETRICO, true);

        gerenciador.adicionarVeiculo(caminhao1);
        gerenciador.adicionarVeiculo(caminhao2);
        gerenciador.adicionarVeiculo(caminhao3);
        gerenciador.adicionarVeiculo(van1);
        gerenciador.adicionarVeiculo(van2);

        System.out.println("\n--- ALTERANDO STATUS ---");
        gerenciador.alterarStatusVeiculo("DEF-5678", StatusVeiculo.EM_MANUTENCAO);
        gerenciador.alterarStatusVeiculo("BCC-3456", StatusVeiculo.EM_VIAGEM);

        gerenciador.listarVeiculosDisponiveis();
        gerenciador.gerarRelatorioAutonomia();

        System.out.println("\n=== BUSCA POR PLACA ===");
        Veiculo veiculoEncontrado = gerenciador.buscarPorPlaca("ABC-1234");
        if (veiculoEncontrado != null) {
            System.out.println("Veículo encontrado: " + veiculoEncontrado.getPlaca() +
                    " - " + veiculoEncontrado.getClass().getSimpleName());
        }

        System.out.println("\n--- Buscando placa inexistente ---");
        gerenciador.buscarPorPlaca("ZZZ-9999");

        gerenciador.listarTodosVeiculos();

        System.out.println("\n=== DEMONSTRAÇÃO DO MONITORAVEL ===");

        System.out.println("Testando monitoramento do Caminhão ABC-1234:");
        caminhao1.enviarCoordenadas();
        System.out.println("Localização atual: " + caminhao1.obterLocalizacaoAtual());

        System.out.println("\nVerificando se a Van AAB-9012 é monitorável:");
        System.out.println("Van é monitorável? " + (van1 instanceof Monitoravel));

        System.out.println("\n=== TESTANDO REMOÇÃO ===");
        gerenciador.removerVeiculo("AAB-9012");
        System.out.println("Total de veículos após remoção: " + gerenciador.getTamanhoFrota());

        System.out.println("\n=== QUESTÃO TEÓRICA ===");
        System.out.println("P: Por que usamos uma Interface para o monitoramento e uma Classe Abstrata para o veículo?");
        System.out.println("R: Porque nem todo veículo é monitorável. A interface permite que apenas os");
        System.out.println("   caminhões (que possuem rastreador) implementem o monitoramento, enquanto");
        System.out.println("   as vans não precisam ter esses métodos. A classe abstrata Veiculo define");
        System.out.println("   o que é comum a todos os veículos (placa, capacidade, combustível, etc).");

        System.out.println("\n=== SISTEMA LOGITRACK ENCERRADO ===");
    }
}