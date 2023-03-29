/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ProDe;

/**
 *
 * @author Seba
 */
import java.io.*;

public class ProDe {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        /* Lectura de datos desde resultados.txt */
        FileInputStream results = new FileInputStream("resultados.txt");
        DataInputStream Datos = new DataInputStream(results);
        String resultados1=Datos.readLine();
        String resultados2=Datos.readLine();
        String resultados3=Datos.readLine();
        results.close();
        
        /* Lectura de datos desde pronostico.txt */
        FileInputStream pronostico = new FileInputStream("pronostico.txt");
        DataInputStream DatosP = new DataInputStream(pronostico);
        String pronostico1=DatosP.readLine();
        String pronostico2=DatosP.readLine();
        String pronostico3=DatosP.readLine();
        pronostico.close();
        
        /* Discriminacion de los datos necesarios */
        String resP1[]=resultados2.split(";");
        String resP2[]=resultados3.split(";");
        String proP1[]=pronostico2.split(";");
        String proP2[]=pronostico3.split(";");
        
        String eq_11=resP1[0], eq_12=resP1[3], eq_21=resP2[0], eq_22=resP2[3];
        String pr_11=proP1[1],pr_12=proP1[2],pr_13=proP1[3],pr_21=proP2[1],pr_22=proP2[2],pr_23=proP2[3];
        
        int gol_11=Integer.parseInt(resP1[1]);
        int gol_12=Integer.parseInt(resP1[2]);
        int gol_21=Integer.parseInt(resP2[1]);
        int gol_22=Integer.parseInt(resP2[2]);
        
        Partido juego1 = new Partido(new Equipo(eq_11),new Equipo(eq_12),gol_11,gol_12);
        Partido juego2 = new Partido(new Equipo(eq_21),new Equipo(eq_22),gol_21,gol_22);
        
        Pronostico pro1 = new Pronostico(juego1, pr_11, pr_12, pr_13);
        Pronostico pro2 = new Pronostico(juego2, pr_21, pr_22, pr_23);

        int puntaje;
        puntaje = pro1.puntos() + pro2.puntos();
        
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
    
    String resultadoJ () {
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
    public String loc, emp, vis;
    
    public Pronostico (Partido juego, String loc, String emp, String vis) {
        this.juego=juego;
        this.loc=loc;
        this.emp=emp;
        this.vis=vis;
    }

    int puntos () {
        if (this.loc.equals("X") && this.juego.resultadoJ().equals("local"))
            return 1;
        else
            if (this.emp.equals("X") && this.juego.resultadoJ().equals("empate"))
                return 1;
            else
                if (this.vis.equals("X") && this.juego.resultadoJ().equals("visita"))
                    return 1;
                else
                    return 0;
    }
}