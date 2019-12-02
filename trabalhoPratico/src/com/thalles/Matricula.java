package com.thalles;

public class Matricula {

    private short anoLetivo;
    private byte serie;
    private float notaPrimeiroBimestre;
    private float notaSegundoBimestre;
    private float notaTerceiroBimestre;
    private float notaQuartoBimestre;
    private boolean aprovado;
    private float media;
    Aluno aluno = new Aluno();
    Disciplina disciplina =  new Disciplina();


    public short getAnoLetivo() { return anoLetivo; }

    public void setAnoLetivo(short anoLetivo) { this.anoLetivo = anoLetivo; }


    public byte getSerie() { return serie; }

    public void setSerie(byte serie) { this.serie = serie; }


    public float getNotaPrimeiroBimestre() { return notaPrimeiroBimestre; }

    public void setNotaPrimeiroBimestre(float notaPrimeiroBimestre) { this.notaPrimeiroBimestre = notaPrimeiroBimestre; }

    public float getNotaSegundoBimestre() { return notaSegundoBimestre; }

    public void setNotaSegundoBimestre(float notaSegundoBimestre) { this.notaSegundoBimestre = notaSegundoBimestre; }


    public float getNotaTerceiroBimestre() { return notaTerceiroBimestre; }

    public void setNotaTerceiroBimestre(float notaTerceiroBimestre) { this.notaTerceiroBimestre = notaTerceiroBimestre; }


    public float getNotaQuartoBimestre() { return notaQuartoBimestre; }

    public void setNotaQuartoBimestre(float notaQuartoBimestre) { this.notaQuartoBimestre = notaQuartoBimestre; }


    public boolean isAprovado() { return aprovado; }

    public void setAprovado(boolean aprovado) { this.aprovado = aprovado; }


    public float getMedia() { return media; }

    public void setMedia(float media) { this.media = media; }

    public Aluno getAluno() { return aluno; }

    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Disciplina getDisciplina() { return disciplina; }

    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }


    public Matricula(){
        this.anoLetivo = 0;
        this.serie = 0;
        this.notaPrimeiroBimestre = 0.0f;
        this.notaSegundoBimestre = 0.0f;
        this.notaTerceiroBimestre = 0.0f;
        this.notaQuartoBimestre = 0.0f;
        this.aprovado = false;
        this.media = 0;

    }


    public Matricula(short anoLetivo, byte serie, float notaPrimeiroBimestre, float notaSegundoBimestre, float notaTerceiroBimestre, float notaQuartoBimestre, boolean aprovado, float media) {
        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
        this.notaSegundoBimestre = notaSegundoBimestre;
        this.notaTerceiroBimestre = notaTerceiroBimestre;
        this.notaQuartoBimestre = notaQuartoBimestre;
        this.aprovado = aprovado;
        this.media = media;
    }

    public float maiorNota() {

        float maior = 0.0f;

        if (notaPrimeiroBimestre > notaSegundoBimestre && notaPrimeiroBimestre > notaTerceiroBimestre && notaPrimeiroBimestre > notaQuartoBimestre) {

            maior = notaPrimeiroBimestre;

        } else if (notaSegundoBimestre > notaPrimeiroBimestre && notaSegundoBimestre > notaTerceiroBimestre && notaSegundoBimestre > notaQuartoBimestre) {

            maior = notaSegundoBimestre;

        } else if (notaTerceiroBimestre > notaPrimeiroBimestre && notaTerceiroBimestre > notaSegundoBimestre && notaTerceiroBimestre > notaQuartoBimestre) {

            maior = notaTerceiroBimestre;

        } else {

            maior = notaQuartoBimestre;

        }

        return maior;
    }

    public float menorNota() {

        float menor = 0.0f;

        if (notaPrimeiroBimestre < notaSegundoBimestre && notaPrimeiroBimestre < notaTerceiroBimestre && notaPrimeiroBimestre < notaQuartoBimestre) {

            menor = notaPrimeiroBimestre;

        } else if (notaSegundoBimestre < notaPrimeiroBimestre && notaSegundoBimestre < notaTerceiroBimestre && notaSegundoBimestre < notaQuartoBimestre) {

            menor = notaSegundoBimestre;

        } else if (notaTerceiroBimestre < notaPrimeiroBimestre && notaTerceiroBimestre < notaSegundoBimestre && notaTerceiroBimestre < notaQuartoBimestre) {

            menor = notaTerceiroBimestre;

        } else {

            menor = notaQuartoBimestre;

        }

        return menor;
    }

    public  float media() {


            float notas[] = new float[4];

            notas[0] = notaPrimeiroBimestre;
            notas[1] = notaSegundoBimestre;
            notas[2] = notaTerceiroBimestre;
            notas[3] = notaQuartoBimestre;

            media = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;

            return media;


    }

    public float mediaPonderada(){

        float notas[] = new float[4];

        notas[0] = notaPrimeiroBimestre;
        notas[1] = notaSegundoBimestre;
        notas[2] = notaTerceiroBimestre;
        notas[3] = notaQuartoBimestre;

        int peso[] = new int[4];

        peso[0] = 1;
        peso[0] = 2;
        peso[0] = 1;
        peso[0] = 2;


        media = peso[0] * notas[0] + peso[1] * notas[1] + peso[2] * notas[2] + peso[3] * notas[3] / peso[0] + peso[1] + peso[2] + peso[3] ;

        return media;
    }

    public void verificaNotas(){

        if (media > 7){

            aprovado = true;

        }
        else{

            aprovado = false;

        }
    }


    public void setAluno(int idAluno) {
    }

    public void setDisciplina(int codigoDisciplina) {
    }


}
