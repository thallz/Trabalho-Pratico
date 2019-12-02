package com.thalles;

import java.util.Scanner;
import com.thalles.Disciplina;
import com.thalles.Matricula;
import com.thalles.Aluno;
import com.thalles.DisciplinaPratica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;




public class Main {

    static private final int MAX_DISCIPLINA = 5;
    static private final int MAX_ALUNO = 10;
    static private final int MAX_MATRICULA = 30;


    Aluno aluno = new Aluno();
    Disciplina disciplina = new Disciplina();
    DisciplinaPratica disciplinaPratica = new DisciplinaPratica();
    Matricula matricula = new Matricula();


    static Scanner entrada = new Scanner(System.in);

    static Disciplina[] vetorDisciplina = new Disciplina[MAX_DISCIPLINA];
    static Aluno[] vetorAluno = new Aluno[MAX_ALUNO];
    static Matricula[] vetorMatricula = new Matricula[MAX_MATRICULA];

    static int pDisc = 0;
    static int pAluno = 0;
    static int pMatricula = 0;

    static void menu(){

        int opcao = 1 ;

        Scanner entrada = new Scanner(System.in);



        while(opcao != 0){
            System.out.print("============== Secretaria ============== ");
            System.out.print("\n 1- Cadastrar as disciplinas oferecidas na escola \n 2- Cadastrar alunos \n 3- Matricular aluno em uma disciplina qualquer \n 4- Lançar notas de um aluno \n 5- Mostrar Boletim do aluno \n 0- Encerrar Programa \nDigite:  ");

            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    cadDisciplina();
                    break;


                case 2:
                    cadAluno();
                    break;


                case 3:
                    matriculaAluno();
                    break;

                case 4:
                    cadNotas();
                    break;

                case 5:
                    mostrarBoletim();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção Invalida!!");

            }
        break;
        }
    }

    static void cadDisciplina(){



        int tipoDisciplina;
        int opcao1 = 0;

        System.out.println("\n============== Cadastro de Disciplina ============== ");
        System.out.println("Qual o tipo da disciplina? ");
        System.out.println(" 0- Disciplina \n 1- Disciplina Pratica ");
        System.out.print("Digite: ");

        tipoDisciplina = entrada.nextInt();


        if (tipoDisciplina == 0){

            vetorDisciplina[pDisc] = new Disciplina();

            System.out.println("Digite o nome da Disciplina: ");
            vetorDisciplina[pDisc].setNome(entrada.next());

            System.out.println("Digite a carga horaria geral da Disciplina: ");
            vetorDisciplina[pDisc].setCargaHorariaGeral(entrada.nextInt());


            vetorDisciplina[pDisc].setCodigoDisciplina(pDisc);

            pDisc ++;

            System.out.print("Deseja cadastrar mais uma disciplina? 1- Sim 2- Não: ");
            opcao1 = entrada.nextInt();

        }
        else if(tipoDisciplina == 1){

            vetorDisciplina[pDisc] = new DisciplinaPratica();

            System.out.println("Digite o nome da Disciplina: ");
            vetorDisciplina[pDisc].setNome(entrada.next());

            System.out.println("Digite a carga horaria geral da Disciplina: ");
            vetorDisciplina[pDisc].setCargaHorariaGeral(entrada.nextInt());

            System.out.println("Digite a carga horaria pratica da Disciplina: ");
            ((DisciplinaPratica)vetorDisciplina[pDisc]).setCargaHorariaPratica(entrada.nextInt());


            vetorDisciplina[pDisc].setCodigoDisciplina(pDisc);


            pDisc ++;

            System.out.print("Deseja cadastrar mais uma disciplina? 1- Sim 2- Não: ");
            opcao1 = entrada.nextInt();

        }while (opcao1 == 1);

        Main.menu();
    }

    static void cadAluno(){



        int opcao2 = 0;


        do {

            vetorAluno[pAluno] = new Aluno();

            System.out.println("Digite o nome do Aluno: ");
            vetorAluno[pAluno].setNome(entrada.next());

            System.out.println("Digite o sobrenome do Aluno: ");
            vetorAluno[pAluno].setSobrenome(entrada.next());

            System.out.println("Digite o sexo do Aluno: ");
            vetorAluno[pAluno].setSexo(entrada.next().charAt(0));

            System.out.println("Digite a data de nascimento [dd/MM/yyyy]:");
            Calendar data = dataNascimento(entrada.next());
            vetorAluno[pAluno].setDataNascimento(data);

            vetorAluno[pAluno].setIdAluno(pAluno);

             pAluno++;

            System.out.print("Deseja cadastrar mais um aluno? 1- Sim 2- Não: ");
            opcao2 = entrada.nextInt();

        }while (opcao2 == 1);

        Main.menu();

    }

    static Calendar dataNascimento(String dataNasc){

        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascFormatoCalendar = null;

        try {
            dataNascFormatoCalendar = formatoData.parse(dataNasc);

            Calendar dateOfBirth = new GregorianCalendar();
            dateOfBirth.setTime(dataNascFormatoCalendar);

            return dateOfBirth;
        }
        catch (Exception e) {

        }
        return null;
    }


    static void matriculaAluno(){

        int opcao3 = 0;

        do {

            vetorMatricula[pMatricula] = new Matricula();

            System.out.println("Digite o ano letivo: ");
            vetorMatricula[pMatricula].setAnoLetivo(entrada.nextShort());

            System.out.println("Digite a serie: ");
            vetorMatricula[pMatricula].setSerie(entrada.nextByte());


            vetorMatricula[pMatricula].setNotaPrimeiroBimestre(0.0f);
            vetorMatricula[pMatricula].setNotaSegundoBimestre(0.0f);
            vetorMatricula[pMatricula].setNotaTerceiroBimestre(0.0f);
            vetorMatricula[pMatricula].setNotaQuartoBimestre(0.0f);


            System.out.println("Digite o id do Aluno: ");
            int idAl = entrada.nextInt();
            if (vetorAluno[idAl] == null) {

                System.out.println("Aluno não cadastrado!!! ");

            }
                else{
                vetorMatricula[pMatricula].setAluno(vetorAluno[idAl].getIdAluno());
                }


            System.out.println("Digite o id da Disciplina: ");
            int idDisciplina = entrada.nextInt();
            if (vetorDisciplina[idDisciplina] == null) {

                System.out.println("Disciplina não cadastrada!!! ");

            }
            else{
                vetorMatricula[pMatricula].setDisciplina(vetorDisciplina[idDisciplina].getCodigoDisciplina ());;
            }

            System.out.print ("Este é o id da sua matricula: " + pMatricula + "\n");

            pMatricula++;

            System.out.print("Deseja fazer mais uma matricula? 1- Sim 2- Não: ");
            opcao3 = entrada.nextInt();

        }while (opcao3 == 1);

        Main.menu();
    }

    static void cadNotas(){



            System.out.print("Informe o id da matricula: ");
            int idMatricula = entrada.nextInt();

            if (vetorMatricula[idMatricula] != null) {
                System.out.print ("Informe a nota do 1° Bimestre(Digite ela em decimal EX: 10 = 10,0) :  ");
                vetorMatricula[idMatricula].setNotaPrimeiroBimestre (entrada.nextFloat ());

                System.out.print ("Informe a nota do 2° Bimestre(Digite ela em decimal EX: 10 = 10,0) : ");
                vetorMatricula[idMatricula].setNotaSegundoBimestre (entrada.nextFloat ());

                System.out.print ("Informe a nota do 3° Bimestre(Digite ela em decimal EX: 10 = 10,0) : ");
                vetorMatricula[idMatricula].setNotaTerceiroBimestre (entrada.nextFloat ());

                System.out.print ("Informe a nota do 4° Bimestre(Digite ela em decimal EX: 10 = 10,0) : ");
                vetorMatricula[idMatricula].setNotaQuartoBimestre (entrada.nextFloat ());

            }


        Main.menu ();

    }

    static void mostrarBoletim(){

        System.out.print("Informe o id do aluno: ");
        int idAl = entrada.nextInt ();

        System.out.print("Informe o id da matricula deste aluno: ");
        int idMatricula = entrada.nextInt ();

            vetorMatricula[idMatricula].media ();
            vetorMatricula[idMatricula].verificaNotas ();

            System.out.print("Aluno \t\t 1° Bim. \t 2° Bim. \t 3° Bim. \t 4° Bim. \t Média \t Situação\n");
            System.out.print(vetorAluno[idAl].getNome() + "\t\t " + vetorMatricula[idMatricula].getNotaPrimeiroBimestre() + "\t\t " +
                    vetorMatricula[idMatricula].getNotaSegundoBimestre() + "\t\t " + vetorMatricula[idMatricula].getNotaTerceiroBimestre() + "\t\t " +
                    vetorMatricula[idMatricula].getNotaQuartoBimestre () + "\t\t" + vetorMatricula[idMatricula].getMedia () + "\t " + vetorMatricula[idMatricula].isAprovado() + "\n") ;

            Main.menu ();

    }

    public static void main(String[] args) {
menu ();

    }
}
