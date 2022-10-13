package lizcenter;
import java.util.*;

public class LizCenter {
 static Scanner liz= new Scanner(System.in);
static int [][] notaTotal = new int [4][3];
 static Alumno [] a = new Alumno [4]; //objetoAlumno con Array
 static Profesor [] p = new Profesor [3]; //objetoProfesor
 static ArrayList<Profesor> profesorOrd = new ArrayList<>();
 
 public static void notasAsig(){//CARGAR ARRAY BIDIMENSIONAL 'notaTotal'
     for(int i=0; i<4; i++){
         for (int j=0; j<3; j++){//ASIGNAR las 3 diferenttes notas alea a cada col
             notaTotal[i][j]=a[i].getNotas()[j];
         }
     }
     System.out.println("\nNOTAS DE LOS ALUMNOS: ");
     System.out.println("\tFísica\tQuímica\tFilosofía");
     for(int i=0; i<4; i++){
         for(int j=0; j<3; j++){//VISUALIZARlas
             System.out.println("\t"+notaTotal[i][j]);
         }System.out.println("");
     }System.out.println("");
 }   
 
 public static void notasAsignaturas(){//CARGAR ARRAY BIDIMENSIONAL 'notaTotal'
        for(int i=0;i<4;i++){
            for (int j=0;j<3;j++){//ASIGNAR las 3 diferenttes notas
                notaTotal[i][j]=a[i].getNotas()[j];
            }
        }
        System.out.println("\nNOTAS DE LOS ALUMNOS: ");
        System.out.println("\tFísica\tQuímica\tFilosofía");
            for(int i=0; i<4; i++){
                for(int j=0; j<3; j++){//VISUALIZARlas
                System.out.println("\t"+notaTotal[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
      }
 
    public static void menu(){
        int opcion=-1;
          boolean sw12=false;//variables para obligar a seguir unn orden en el menú
          boolean sw3=false;
          boolean sw5=false;
          int salirExcepcion;
          ArrayList<Persona> profesores= new ArrayList<>();
          while(opcion!=0){
              System.out.println("CENTRO DE ESTUDIOS");
              System.out.println("==================");
              System.out.printf("1.- Profesor Manual\n");
              System.out.printf("2.- Profesor Automático\n");
              System.out.printf("3.- ArrayList Profesores\n");
              System.out.printf("4.- Edad media Profesores y Profesor menor edad\n");
              System.out.printf("5.- Alumnos automático\n");
              System.out.printf("6.- ArrayList Alumnos ordenados\n");
              System.out.printf("7.- Nota media por Alumno y número suspensos Química\n");
              System.out.printf("8.- Profesor con menos Alumnos aprobados\n");
              System.out.printf("9.- Profesor con nota media más baja\n");
              System.out.printf("10.- Introduzca un profesor con el mismo NIF\n");
              System.out.printf("0.- SALIR\n");
              System.out.printf("\n\tSeleccione una de las siguientes opciones: ");
              opcion= liz.nextInt();
              
              switch(opcion){
                  case 1:
                      System.out.println("\t\t\t\t\t\t\t1.INTRODUCIR PROFESORES ");
                      sw12=true;
                      for(int i=0; i<p.length; i++){//3 profes
                          System.out.println("Introduzca el DNI: ");
                          liz.nextLine();
                          p[i]= new Profesor(liz.nextLine());//Llenar el campo del objeto corresp 
                          while(i==1){//ASEGURAR DNI
                              if(p[i].getNif().equalsIgnoreCase(p[i-1].getNif())){
                                  System.out.println("Introduzca otro DNI: ");
                                  p[i].setNif(liz.nextLine());//set el nuevo valor
                              }else{
                                  break; //SALIR??
                              } 
                          }
                          while(i==2){
                               if(p[i].getNif().equalsIgnoreCase(p[i-1].getNif()) || p[i].getNif().equalsIgnoreCase(p[i-2].getNif())){
                                     System.out.println("Introduzca otro DNI: ");
                                     p[i].setNif(liz.nextLine());  
                               }else{
                                     break;
                               }
                          }
                          System.out.println("Introduzca el Apellido 1º: ");
                          p[i].setApellido1(liz.nextLine());
                          System.out.println("Introduzca el Apellido 2º: ");
                          p[i].setApellido2(liz.nextLine());
                          System.out.println("Introduzca el Nombre: ");
                          p[i].setNombre(liz.nextLine());    //EL OTRO CAMPO PROPIO DE LA CLASE SE LLENA EN CASE 3
                          salirExcepcion=1;
                          do{
                              try{
                                  System.out.println("Introduzca la edad: ");
                                  p[i].setEdad(liz.nextInt());
                                  salirExcepcion=0;
                              }catch (java.util.InputMismatchException error){ //ERR: STRN O CARAC != INT
                                  System.out.println("Has introducido un carácter, introduce un número");
                                  liz.nextLine();
                              }
                          }
                          while (salirExcepcion==1);
                      }
                      break;
                  case 2:
                      System.out.println("\t\t\t\t\t\t\tEj.2 PROFESOR AUTOMATICO ");
                      sw12=true;
                      p[0]=new Profesor("500012365K","Garcia","Perez","Antonio");
                      System.out.println(p[0]);
                      p[1]=new Profesor("500012365K","Lopez","Diaz","Susana");
                      System.out.println(p[1]);
                      p[2]=new Profesor("500012365K","Ruiz","Gomez","Carmen");
                      System.out.println(p[2]);                      
                      for(Profesor i: p){//visualizar array uni de objetos 
                          System.out.println(i);
                      }
                      break;
                  case 3://HAY QUE CREAR UN OBJETO PERSONA QUE SE LLAME PROFESOR
                      System.out.println("\t\t\t\t\t\t\tEj.3 VISUALIZAR ARRAYLIST DE PROFESORES");
                    if(sw12==true){
                      sw3=true;
                      profesores.clear();//LIMPIRARLA PORQ ESTAS ESTAN SOLO CON DATOS DE PERSONA DEBIDO AL CONSTRUCTOR
                      profesorOrd.clear();
                      //AÑADIR EL CAMPO PROPIO DE CLASE PROFESOR :ASIGNATURAS A ARRAY ¡P¡
                      p[0].setAsignatura("Física");
                      p[1].setAsignatura("Química");
                      p[2].setAsignatura("Filosofía");
                      profesores.add(p[0]);//Y VOLVER AÑADIR CADA OBJETO A LAS COLECCIONES DE ARRAYLIST
                      profesores.add(p[1]);
                      profesores.add(p[2]);//array de la clase persona
                      profesorOrd.add(p[0]);//array de la clase profesor
                      profesorOrd.add(p[1]);
                      profesorOrd.add(p[2]);
                      
                      p[0].ordenarProf(profesorOrd);//luego de ordenar hay que visualizar con listiteraor o x
                      System.out.println("Visualizar profesores con LISTITERATOR");
                          ListIterator<Profesor> itr= profesorOrd.listIterator();
                          while(itr.hasNext()){
                              Profesor var= itr.next();
                              System.out.println("\t"+var);
                          }
                    }else{
                      System.out.println("\n\tTiene que introducir algún profesor\n\n"); 
                    }   
                      break;
                  case 4:
                      System.out.println("\t\t\t\t\t\t\tEj.4 EDAD MEDIA DE PROFESORES Y EL DE MENOR EDAD.");
                      if(sw3==true){//si se visualizo arraylist de prof case3 si se puede ver este
                          //System.out.println("\nLa edad media de los profesores es: %.2f\n\n");//hhhhhhh
                          System.out.println("La edad minima es la de "+
                                  profesores.get(p[0].minEdad(profesores)));
                      }else{
                          System.out.println("\n\nTiene que crear ArrayList de Profesor\n\n");
                      }
                      break;
                  case 5:
                      System.out.println("\t\t\t\t\t\t\tEj.5 CREAR ALUMNOS MANUALMENTE");
                      sw5=true;//NOTAS SE ALADIRA DESPUES, AHORA SOLO LO DE P
                      a[0]= new Alumno("50004","Sanchez","Pascual","Luis");
                      a[0].setEdad(alea(10,14));
                      System.out.println(a[0]);
                      a[1]= new Alumno("5888","Viesco","Prieto","Ana");
                      a[1].setEdad(alea(10,14));
                      System.out.println(a[1]);
                      a [2] = new Alumno("50069541T","Bueno","Marquez","Rodrigo");
                      a[2].setEdad(alea(10,14));
                      System.out.println(a[2]);
                      a [3] = new Alumno("50032658S","Bueno","Marquez","Maria");
                      a[3].setEdad(alea(10,14));
                      System.out.println(a[3]);
                      break;
                  case 6:                      
                      System.out.println("\t\t\t\t\t\t\tEj.6 VISUALIZAR ARRAYLIST DE ALUMNOS ORDENADOS");
                    if(sw5==true){//si ya se ha creado alumnos en case5
                       ArrayList<Persona> alumnos = new ArrayList<>();
                         for(int i=0; i<a.length; i++){//Para cada alumno en el array uni 'a'
                            alumnos.add(a[i]);//anadir ese alumno a la coleccion list 'alumnos'
                       }
                      a[0].ordenar(alumnos);//ord y vis
                      System.out.println("Visualizar la colección con LISTITERATOS");
                      ListIterator<Persona>itr2= alumnos.listIterator();
                        while(itr2.hasNext()){
                          Persona var= itr2.next();
                          System.out.println("\t"+var);
                       }                        
                    }else{
                      System.out.println("\n\nTiene que crear algún Alumno\n\n");
                    }
                      break;
                  case 7:
                      System.out.println("\t\t\t\t\t\t\tEj.7 NOTA MEDIA POR ALUMNO Y SUSPENSOS DE QUIMICA");
                    if(sw5==true){
                      ArrayList<Alumno> alumnosSus = new ArrayList<>();
                      alumnosSus.clear();
                      for(int i=0; i<a.length; i++){
                          alumnosSus.add(a[i]);
                      }for(int i=0; i<alumnosSus.size(); i++){
                          System.out.println("\nLa nota media de "+a[i]+" es: "+a[i]);//DEBERIA ADD MEDEDDAD METODO
                      }System.out.println("El numero de suspensos de Quimica es: "+a[0].suspensosQuimica(alumnosSus));
                    }else{
                      System.out.println("\n\nTiene que crear ArrayList de Profesores"
                          +" y Alumnos\n\n");
                    }
                      break;
                  case 8: 
                      System.out.println("\t\t\t\t\t\t\tEj.8 PROFESOR CON MENOS ALUMNOS APROBADOS");
                    if(sw3==true && sw5==true){
                      notasAsignaturas();  
                      a[0].menosAprobados(notaTotal, profesorOrd);
                    }else{
                      System.out.println("\n\nTiene que crear ArrayList de Profesores"
                          +" y Alumnos\n\n");
                    }
                      break;
                  case 9:
                      System.out.println("\t\t\t\t\t\t\tEj.8 PROFESOR CON NOTA MEDIA MAS BAJA");
                    if(sw3==true && sw5==true){
                      notasAsignaturas();  
                      p[0].menorMedia(notaTotal, profesorOrd);
                    }else{
                      System.out.println("\n\nTiene que crear ArrayList de Profesores"
                          +" y Alumnos\n\n");
                    }
                      break;
                  case 10:
                      System.out.println("\t\t\t\t\t\t\tEj.10 INTRODUCIR UN PROFESOR CON EL MISMO NIF");
                    if(sw3==true){
                        System.out.println("Introduzca el DNI");  
                        liz.nextLine();
                        Profesor p= new Profesor(liz.nextLine());//anadir ese dni al array uni 'p'
                        while(profesorOrd.contains(p)){//!=
                            System.out.println("\nIntroduzca otro DNI: ");
                            p= new Profesor(liz.nextLine());
                        }
                        System.out.println("\nYa podría introducir el resto de datos");
                        System.out.println("\nPulse ENTER para continuar");
                    }else{
                        System.out.println("\n\nTiene que crear ArrayList de Profesores\n\n");
                    }
                      break;
                  case 0:
                     System.out.println("\n\nGracias por usar la aplicación\n");
                      break;
                  default:
                      System.out.println("\nElija entre 0 y 10\n\n");
                      break;   
              }
              liz.nextInt();
    }
    }
    
    
     public static void main(String[] args) {
        menu();
    }
    
    public static int alea(int li, int ls){//función de JAVA
        return (int)((Math.round(Math.random()*(ls-li))+li));
    }
}
