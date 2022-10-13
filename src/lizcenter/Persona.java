package lizcenter;

import java.util.*;

public abstract class Persona {
    private String apellido1;
   private String apellido2;
   private String nombre;
   private String nif;
   private int edad;

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(String nif) {
        this.nif = nif;
    }

    /*public Persona(String apellido1, String apellido2, String nombre, String nif, int edad) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.nif = nif;
        this.edad = ACenter2.alea(25,55);//Why add manually
    }*/
     public Persona(String nif, String apellido1, String apellido2, String nombre) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.nif = nif;
        this.edad = LizCenter.alea(25, 55);
}

    @Override
    public String toString() {
        return "Persona{" + "apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre + ", nif=" + nif + ", edad=" + edad + '}';
    }
    
    public void ordenar(ArrayList<Persona> p){
        p.sort(new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2){
                 String txt1= String.format("%-15s%-15s$03d",o1.getApellido1(),o1.getApellido2(),o1.edad);
                 String txt2= String.format("%-15s%-15s$03d",o2.getApellido1(),o2.getApellido2(),o2.edad);
                 return txt1.compareTo(txt2);
             }
            
            /*public int compare(Persona o1, Persona o2){
                String txt1= String.format("%03d", o1.getEdad());
                String txt2= String.format("%03d", o2.getEdad());
                return txt1.compareTo(txt2);
            }*/
            /*public int compare(Persona o1, Persona o2){
                 String txt1= String.format("%03d%s", o1.getEdad(),o1.getNombre());
                 String txt2= String.format("%03d%s", o2.getEdad(),o2.getNombre());
                 return txt1.compareTo(txt2);
             }*/
            
        });
    }
   
    public int minEdad(ArrayList<Persona> p){
        int min=200;
        int pos=0;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getEdad()<min){
                min = p.get(i).edad;
                pos=i;
            }
        }
        return min;
    }
    public double medEdad(ArrayList<Persona> p){
        double suma=0;
        for(Persona i: p){
            suma += i.edad;
        }
        return (suma/p.size());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.nif, other.nif);
    }
}
