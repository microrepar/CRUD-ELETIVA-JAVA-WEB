/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.microrepar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.c.silva
 */
public class RequisitoDTO {

    private String sigla;
    private String nome;
    private String escopo;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscopo() {
        return escopo;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public static RequisitoDTO de(Requisito requisito) {
        RequisitoDTO dto = new RequisitoDTO();
        dto.setSigla(requisito.getSigla());
        dto.setNome(requisito.getNome());
        dto.setEscopo(requisito.getEscopo());
        return dto;
    }

    public static List<RequisitoDTO> listaDe(List<Requisito> requisitos) {
        List<RequisitoDTO> dtos = new ArrayList<>();
        requisitos.forEach(requisito -> dtos.add(RequisitoDTO.de(requisito)));
        return dtos;
    }
}
