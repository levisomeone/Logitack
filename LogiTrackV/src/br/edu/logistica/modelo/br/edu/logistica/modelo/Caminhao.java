package br.edu.logistica.modelo;

public class Caminhao extends Veiculo implements Monitoravel{
    private int quantidadeEixos;

    public Caminhao(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel, int quantidadeEixos){
        super(placa, capacidadeCarga, tipoCombustivel);
        this.quantidadeEixos = quantidadeEixos;
    }

    @Override
    public double calcularAutonomia(){
        return (capacidadeCarga * tipoCombustivel.getFator()) / (quantidadeEixos * 0.75);
    }

    @Override
    public void enviarCoordenadas(){
        System.out.println("Coordenadas via Satélite R2 - Caminhão" + placa);
    }

    @Override
    public String obterLocalizacaoAtual(){
        return "Lt: -23.5505, Ln: -46.6333 - Caminhão" + placa;
    }

    public int getQuantidadeEixos(){ return quantidadeEixos;}
    public void setQuantidadeEixos(int quantidadeEixos){ this.quantidadeEixos = quantidadeEixos;}

}
