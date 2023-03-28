/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ProDe;

/**
 *
 * @author Seba
 */
public class ProDe {

    public static void main(String[] args) {
        
        Partido juego1 = new Partido(new Equipo("Argentina"),new Equipo("Arabia Saudita"),1,2);
        Partido juego2 = new Partido(new Equipo("Polonia"),new Equipo("Méjico"),0,0);
        
        Pronostico pro1 = new Pronostico(juego1,"X"," "," ");
        Pronostico pro2 = new Pronostico(juego2," ","X"," ");
        
        int puntaje = pro1.puntos + pro2.puntos;
        
        System.out.println("Puntos logrados: " + puntaje);
    }
}    

class Equipo {
    public String nombre;
    public String descripcion;

    public Equipo (String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
    }
}

class Partido {
    public Equipo eq1;
    public Equipo eq2;
    public int gol1;
    public int gol2;
    
    public Partido (Equipo eq1, Equipo eq2, int gol1, int gol2) {
        this.eq1=eq1;
        this.eq2=eq2;
        this.gol1=gol1;
        this.gol2=gol2;
    }
    
    String resultado () {
        if (this.gol1 > this.gol2)
            return "local";
        else
            if (this.gol1==this.gol2)
                return "empate";
            else
                return "visita";
    }
}

class Pronostico {
    public Partido juego;
    public String loc, emp, vis, resultado;
    public int puntos;
    
    public Pronostico (Partido juego, String loc, String emp, String vis) {
        this.juego=juego;
        this.loc=loc;
        this.emp=emp;
        this.vis=vis;
        this.puntos=this.resultado();
    }
    
    int resultado () {
        if (this.loc == "X")
            this.resultado="local";
        else
            if (this.emp == "X")
                this.resultado="empate";
            else
                this.resultado="visita";
        
        if (this.juego.resultado()==this.resultado)
            return 1;
        else
            return 0;
    }
    
}