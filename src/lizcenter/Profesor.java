package lizcenter;

import java.util.ArrayList;
import java.util.Comparator;

public class Profesor extends Persona{
    private String asignatura;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Profesor(String nif) {
        super(nif);
    }
    //CONS COMPLETP
    /*public Profesor(String asignatura, String apellido1, String apellido2, String nombre, String nif, int edad) {
        super(apellido1, apellido2, nombre, nif, edad);
        this.asignatura = asignatura;
    }*/

    public Profesor(String nif, String apellido1, String apellido2, String nombre) {
        super(nif, apellido1, apellido2, nombre);
    }

    @Override
    public String toString() {
        return "Profesor{" + super.toString() + "asignatura=" + asignatura + '}';
    }
    //METODO LA MEDIA MAS MENOR:
    public void menorMedia(int notaTotal[][], ArrayList<Profesor> p){
        double media[]=new double [3]; //SACAR 3 MEDIAS
        double min=11;//xq notas son de 1 a 10
        int pos=0;
        String asig[]={"Fisica", "Quimica", "Filosofia"};//CARGAR ARRAY AL DECLARARLO
        for(int i=0; i<media.length;i++){//CARGAR ARRAY MEDIA DESPUES DE DECLARARLO
            media[i]=0;
        }
        for(int j=0; j<media.length; j++){//OBTENER POR CADA MEDIA(3) "la media de cada clase"
            for(int i=0; i<notaTotal.length; i++){//LA MEDIA DE CADA FILA EN NOTA TOTAL
                media[j]+=notaTotal[i][j];
            }
            media[j]=media[j]/notaTotal.length;//3 MEDIAS
        }System.out.println("");
        
        for(int i=0; i<media.length;i++){//VISUALIZAR LA MEDIA DE CADA CLASE
            System.out.printf("Media de %s: %.2f", asig[i], media[i]);
        }System.out.println("");
        
        for(int i=0; i<media.length;i++){//CALC LA MEDIA MINIMA
            if(media[i]<min){
                min=media[i];
                pos=i;
            }
        }
        System.out.println("La asignatura con menor media es: "+asig[pos]+ " ("+media[pos]+")");
        System.out.println("");
        
        for(Profesor i: p){//IMPRIMIR LA ASIG DE CADA OBJ SI ESTAN EN EL ARRAY ASIG
            if(i.getAsignatura().equals(asig[pos])){//Igualar cada asignatura por cada persona hasta que coincida para imprimirser
                System.out.println(i);
                break; //WHY
            }
        }System.out.println("");
    }
    
    public void ordenarProf(ArrayList<Profesor> personas){
        personas.sort(new Comparator<Profesor>(){
            @Override
           /* public int compare(Persona o1, Persona o2){
                String txt1 = String.format("%03d", o1.getEdad());
                String txt2 = String.format("%03d", o2.getEdad());
                return txt1.compareTo(txt2);
            }*/
            public int compare(Profesor o2, Profesor o1){
                String txt1= String.format("%s",o1.asignatura);
                String txt2= String.format("%s",o2.asignatura);
                return txt1.compareTo(txt2);
            }
            /*public int compare(Persona o1, Persona o2){
                String txt1= String.format("%-15s%-15s%03d",o1.apellido1, o1.apellido2,o1.edad);
                String txt2= String.format("%-15s%-15s%03d",o2.apellido1, o2.apellido2, o2.edad);//private en persona
                return txt1.compareTo(txt2);
            } */        
         });
           
    }
}
