/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.eletivaJava;

/**
 *
 * @author Silvio
 */
public class RelatorioGravidadeDTO {
        
    private String gravidade;
    private int total;

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return getGravidade()+" total:"+ getTotal(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
