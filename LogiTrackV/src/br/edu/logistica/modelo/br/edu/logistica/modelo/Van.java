package br.edu.logistica.modelo;

public class Van extends Veiculo {
    private boolean possuiRefrigeracao;

    public Van(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel, boolean possuiRefrigeracao){
        super(placa, capacidadeCarga, tipoCombustivel);
        this.possuiRefrigeracao = possuiRefrigeracao;
    }

    @Override
    public double calcularAutonomia(){
        double autonomia = capacidadeCarga * tipoCombustivel.getFator();
        if(possuiRefrigeracao){
            autonomia *= 0.8;
        }
        return autonomia;
    }

    public boolean isPossuiRefrigeracao(){ return possuiRefrigeracao;}
    public void setPossuiRefrigeracao(boolean possuiRefrigeracao){ this.possuiRefrigeracao = possuiRefrigeracao;}

}
