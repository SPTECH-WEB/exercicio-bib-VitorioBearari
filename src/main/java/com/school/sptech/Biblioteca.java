package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;


    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }


    // métodos
    public Biblioteca(String nome, Double multaDiaria) {
        qtdLivros = 0;
        ativa = true;
        this.multaDiaria = multaDiaria;
    }

    public void registrarLivro(Integer quantidade){
        if(getAtiva() && quantidade != null && quantidade > 0){
            qtdLivros = qtdLivros + quantidade;
        }
    }


    public Integer emprestar(Integer quantidade){
        if(quantidade != null && ativa && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade){
        if(quantidade != null && ativa && quantidade > 0){
            return qtdLivros += quantidade;
        } else {
            return null;
        }
    }

    public Integer desativar(){
        if (ativa){
            ativa = false;
            Integer qtdFinalLivros = qtdLivros;
            qtdLivros = 0;
            return qtdFinalLivros;
        } else {
            return null;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(quantidade != null && ativa && destino.ativa && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0){
            multaDiaria *= (1.0+percentual);
            return true;
        } else {
            return false;
        }
    }


}