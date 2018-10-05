/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.eletivaJava;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FATEC
 */
public class FichaPacienteDTO {

    private int id;
    private String cpf;
    private String nome;
    private String especialidade;
    private String gravidade;
    private String descSintomas;
    private Date dataHora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getDescSintomas() {
        return descSintomas;
    }

    public void setDescSintomas(String descSintomas) {
        this.descSintomas = descSintomas;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public static FichaPacienteDTO de(FichaPaciente ficha) {
        FichaPacienteDTO dto = new FichaPacienteDTO();
        dto.setId(ficha.getId());
        dto.setCpf(ficha.getCpf());
        dto.setNome(ficha.getNome());
        dto.setEspecialidade(ficha.getEspecialidade());
        dto.setGravidade(ficha.getGravidade());
        dto.setDescSintomas(ficha.getDescSintomas());
        dto.setDataHora(ficha.getDataHora());

        return dto;
    }
    
    public static List<FichaPacienteDTO> listaDe(List<FichaPaciente> fichas){
        List<FichaPacienteDTO> dtos = new ArrayList<>();
        fichas.forEach(ficha -> dtos.add(FichaPacienteDTO.de(ficha)));
        return dtos;
    }
}
