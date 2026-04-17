package br.edu.logistica.modelo;

public abstract class Veiculo {
    protected String placa;
    protected double capacidadeCarga;
    protected StatusVeiculo status;
    protected TipoCombustivel tipoCombustivel;

    public Veiculo(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel, StatusVeiculo status){
        this.placa = placa;
        this.capacidadeCarga = capacidadeCarga;
        this.tipoCombustivel = tipoCombustivel;
        this.status = status;
    }

    public Veiculo(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel){
        this(placa, capacidadeCarga, tipoCombustivel, StatusVeiculo.DISPONIVEL);
    }

    public Veiculo(String placa){
        this(placa, 0, TipoCombustivel.DIESEL, StatusVeiculo.DISPONIVEL);
    }

    public abstract double calcularAutonomia();

    public String getPlaca(){ return placa;}
    public double getCapacidadeCarga() { return capacidadeCarga;}
    public StatusVeiculo getStatus() { return status;}
    public TipoCombustivel getTipoCombustivel() { return tipoCombustivel;}

    public void setPlaca(String placa) { this.placa = placa;}
    public void setCapacidadeCarga(double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga;}
    public void setStatus(StatusVeiculo status) { this.status = status;}
    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) { this.tipoCombustivel = tipoCombustivel;}


}
