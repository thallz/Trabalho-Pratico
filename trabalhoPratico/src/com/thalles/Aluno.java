package com.thalles;

import java.util.Calendar;


public class Aluno {

    private int idAluno = 0;
    private String nome;
    private String sobrenome;
    private char sexo;
    private Calendar dataNascimento;
    private int idade;


    public int getIdAluno() { return idAluno; }

    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }


    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }


    public String getSobrenome() { return sobrenome; }

    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }


    public char getSexo() { return sexo; }

    public void setSexo(char sexo) { this.sexo = sexo; }


    public Calendar getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(Calendar dataNascimento) {
        if(dataNascimento != null){
            this.dataNascimento = dataNascimento;
            calculaIdade();
        }
    }

    private int calculaIdade(){

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int idade = today.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        dataNascimento.add(Calendar.YEAR, idade);

        //Se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dataNascimento)) {
            idade--;
        }
        this.idade = idade;
        return this.idade;
    }


    public int getIdade() { return idade; }

    public void setIdade(int idade) { this.idade = idade; }

    public Aluno() {
        this.idAluno = 0;
        this.nome = "";
        this.sobrenome = "";
        this.sexo = '\u0000';
        this.idade = 0;
    }

    public Aluno(int idAluno, String nome, String sobrenome, char sexo, Calendar dataNascimento, int idade) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }
}
