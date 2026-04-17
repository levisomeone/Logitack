package br.edu.logistica.servico;

import br.edu.logistica.modelo.StatusVeiculo;
import br.edu.logistica.modelo.Veiculo;
import java.util.*;

public class GerenciadorFrota {
    private List<Veiculo> frota;
    private Map<String, Veiculo> mapaVeiculos;

    public GerenciadorFrota(){
        this.frota = new ArrayList<>();
        this.mapaVeiculos = new HashMap<>();
    }

    public void adicionarVeiculo(Veiculo v){
        if(v != null){
            frota.add(v);
            mapaVeiculos.put(v.getPlaca(), v);
            System.out.println("Veículo " + v.getPlaca() + " adicionado a lista!");
        }
    }

    public void listarVeiculosDisponiveis(){
        System.out.println("\n===== VEÍCULOS DISPONÍVEIS =====");
        boolean encontrou = false;
        for(Veiculo v : frota){
            if(v.getStatus() == StatusVeiculo.DISPONIVEL){
                System.out.println("Placa: " + v.getPlaca() + " / Tipo: " + v.getClass().getSimpleName());
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhum veículo disponível no momento.");
        }
    }

    public void gerarRelatorioAutonomia(){
        System.out.println("\n===== RELATÓRIO DE AUTONOMIA =====");
        for(Veiculo v : frota){
            System.out.printf("Placa: %s / Autonomia: %.2f km%n", v.getPlaca(), v.calcularAutonomia());
        }
    }

    public Veiculo buscarPorPlaca(String placa){
        Veiculo veiculo = mapaVeiculos.get(placa);
        if (veiculo == null){
           System.out.println("Veiculo com placa " + placa + " não encontrado.");
        }
        return veiculo;
    }
    public void listarTodosVeiculos() {
        System.out.println("\n=== TODOS OS VEÍCULOS DA FROTA ===");
        for (Veiculo v : frota) {
            System.out.println("Placa: " + v.getPlaca() +
                    " | Tipo: " + v.getClass().getSimpleName() +
                    " | Status: " + v.getStatus() +
                    " | Autonomia: " + String.format("%.2f", v.calcularAutonomia()) + " km");
        }
    }

    public void alterarStatusVeiculo(String placa, StatusVeiculo novoStatus) {
        Veiculo v = buscarPorPlaca(placa);
        if (v != null) {
            v.setStatus(novoStatus);
            System.out.println("Status do veículo " + placa + " alterado para " + novoStatus);
        }
    }

    public void removerVeiculo(String placa) {
        Veiculo v = buscarPorPlaca(placa);
        if (v != null) {
            frota.remove(v);
            mapaVeiculos.remove(placa);
            System.out.println("Veículo " + placa + " removido da frota.");
        }
    }

    public int getTamanhoFrota() {
        return frota.size();
    }
}
