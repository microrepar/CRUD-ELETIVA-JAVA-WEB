package br.com.eletivaJavaWeb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospedagemDTO {

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

    public static HospedagemDTO de(Hospedagem Hospedagem) {
        HospedagemDTO dto = new HospedagemDTO();
        dto.setId(Hospedagem.getId());
        dto.setTipo(Hospedagem.getTipo());
        dto.setNumeroSuite(Hospedagem.getNumeroSuite());
        dto.setNome(Hospedagem.getNome());
        dto.setCapacidade(Hospedagem.getCapacidade());
        dto.setDescAmenidade(Hospedagem.getDescAmenidade());
        dto.setEntrada(Hospedagem.getEntrada());
        dto.setSaida(Hospedagem.getSaida());
        dto.setValorHospedagem(Hospedagem.getValorHospedagem());
        dto.setValorAdicionais(Hospedagem.getValorAdicionais());

        return dto;
    }

    public static List<HospedagemDTO> listaDe(List<Hospedagem> Hospedagems) {

        List<HospedagemDTO> dtos = new ArrayList<>();
        Hospedagems.forEach(Hospedagem -> dtos.add(HospedagemDTO.de(Hospedagem)));

        return dtos;
    }

}
