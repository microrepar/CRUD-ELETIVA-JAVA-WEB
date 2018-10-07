package br.com.eletivaJavaWeb;

import java.util.Date;

class Hospedagem {
    private int id;
    private String tipo;
    private int numeroSuite;
    private String nome;
    private int capacidade;
    private String descAmenidade;
    private Date entrada;
    private Date saida;
    private double valorHospedagem;
    private double valorAdicionais;
    
    public Hospedagem() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroSuite() {
        return numeroSuite;
    }

    public void setNumeroSuite(int numeroSuite) {
        this.numeroSuite = numeroSuite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescAmenidade() {
        return descAmenidade;
    }

    public void setDescAmenidade(String descAmenidade) {
        this.descAmenidade = descAmenidade;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }

    public void setValorHospedagem(double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    public double getValorAdicionais() {
        return valorAdicionais;
    }

    public void setValorAdicionais(double valorAdicionais) {
        this.valorAdicionais = valorAdicionais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
//    public void reservar(String tipo){
//        if(tipo.equals("PE SUJO")){
//            this.capacidade = 2;
//            this.valorHospedagem = 10.00;
//        }else if(tipo.equals("SIMPLES")){
//            this.capacidade = 2;
//            this.valorHospedagem = 20.50;
//        }else if(tipo.equals("LUXO")){
//            this.capacidade = 2;
//            this.valorHospedagem = 50.00;
//        }else if(tipo.equals("MASTER")){
//            this.capacidade = 4;
//            this.valorHospedagem = 210.00;
//        }else if(tipo.equals("PRESIDENCIAL")){
//            this.capacidade = 10;
//            this.valorHospedagem = 1995.00;
//        }
//        
//    }
}
