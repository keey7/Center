package lizcenter;

import java.util.ArrayList;

public class Alumno extends Persona{
    int notas[]= new int[3];//Unidimensional
     public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public Alumno(String nif) {
        super(nif);
    }

    public Alumno(String nif, String apellido1, String apellido2, String nombre) {
        super(nif, apellido1, apellido2, nombre);
        this.notas[0] = LizCenter.alea(0, 10);//CARGAR EL ARRAY
        this.notas[1] = LizCenter.alea(0, 10);
        this.notas[2] = LizCenter.alea(0, 10);
    }

    @Override
    public String toString() {
        return "Alumno. " +super.toString()+ ", notas=" + notas ;
    }
    
    public void menosAprobados(int notaTotal[][],ArrayList<Profesor> p ){
        int cont[] = new int[3], max=-1, pos=0; //Array de 3 asig
        String asig[]={"Física","Química","Filosofía"};//DECLARAR Y CARGAR ARRAY
        for(int i=0; i<cont.length;i++){
            cont[i]=0;//Cargar contador
        }
        //CALCULAR CUANTOS SUSPENDIDOS HAY
        for(int j=0; j<notaTotal.length; j++){
            for(int i=0; i<notaTotal.length; i++){//Recorrido x col  BUT WHY NOT [0]
                if(notaTotal[i][j]<5){//del array de notaTotal por cada fila(i), check cada columna(j) es menor que 5
                    cont[j]++;//...contar esa columna para saber cuantos sus hay
                }
            }
        }System.out.println("");
        //VISUALIZAR SUSPENSOS
        for(int i=0;i<cont.length;i++){
            System.out.println("Suspensos de "+asig[i]+": "+cont[i]);
        }System.out.println("");
        
        //CALCULAR MAXIMO
        for(int i=0; i<cont.length; i++){
            if(cont[i]>max){
                max=cont[i];
                pos=i;
            }
        }//PROFESOR CON MAS SUSPENSOS EN X ASIGNATURAS:
        if(cont[0]>0|| cont[1]>0 || cont[2]>0){//osea si cont tiene x suspensos: mostrarlos segun cada asig
            System.out.println("La asignatura con más suspensos es: "+asig[pos]+ " ("+cont[pos]+")" );
            System.out.println("");
            for(Profesor i: p){
                if(i.getAsignatura().equalsIgnoreCase(asig[pos])){
                System.out.println(i);
                break; //Para que checkee las 3 asignatuas, hasta que encuentra una igual =
                }
            }
        }else{
            System.out.println("Ningun alumno ha suspendido asignaturas");
        }System.out.println("");
        
        
    }
    
    public int suspensosQuimica(ArrayList<Alumno> a){
        int cont=0;
        for(Alumno i: a){
            if(i.notas[1]<5){//Quimica es la segunda clase en el array y 5 es lo min
                cont++;
            }
        }
        return cont;
    }
    
    public double medNota(){
        double suma=0;
        suma += notas[0]+notas[1]+notas[2];//COGIENDO EL VALOR DE CADA ELEMENTO DEL ARRAY
        return (suma/3);
    }
}
