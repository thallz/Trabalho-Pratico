package com.thalles;

public class Disciplina {

    private int codigoDisciplina;
    private String nome;
    private int cargaHorariaGeral;




    public int getCodigoDisciplina() { return codigoDisciplina; }

    public void setCodigoDisciplina(int codigoDisciplina) { this.codigoDisciplina = codigoDisciplina; }


    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }


    public int getCargaHorariaGeral() { return cargaHorariaGeral; }

    public void setCargaHorariaGeral(int cargaHorariaGeral) { this.cargaHorariaGeral = cargaHorariaGeral; }

    public Disciplina() {
        this.codigoDisciplina = 0;
        this.nome = "";
        this.cargaHorariaGeral = 0;

    }

    public Disciplina(int codigoDisciplina, String nome, int cargaHorariaGeral) {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
        this.cargaHorariaGeral = cargaHorariaGeral;

    }
}


