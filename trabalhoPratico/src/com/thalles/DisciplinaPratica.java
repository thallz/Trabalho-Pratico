package com.thalles;

class DisciplinaPratica extends Disciplina {

    private int cargaHorariaPratica;

    public int getCargaHorariaPratica() { return cargaHorariaPratica; }

    public void setCargaHorariaPratica(int cargaHorariaPratica) { this.cargaHorariaPratica = cargaHorariaPratica; }

    public DisciplinaPratica(){
        this.cargaHorariaPratica = 0;

    }

    public DisciplinaPratica( int cargaHorariaPratica){
        this.cargaHorariaPratica = cargaHorariaPratica;
    }
}
