/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2Cronometro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guiller
 */
public class Hilos implements Runnable{
    private int segundos,minutos,horas;
    private String seg,min,h;    
    private VistaCronometro v1;
    
    
    public Hilos(VistaCronometro v){
        horas=minutos=segundos=0;
        seg="00";
        min="00";
        h="00";
        v1=v;
    }
    @Override
    public void run() {
        segundos();
        
    }

    private void segundos() {
        for(int i =0;;i++){
            segundos=i;
            setSegundos(segundos);
            v1.setCron(h+":"+min+":"+seg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(segundos==59){
                i=-1;
                minutos();
                
            }
        }
            
        
    }

    private void minutos() {
      minutos++;
      setMinutos(minutos);
      if(minutos==59){
          minutos=-1;
          horas();
      }
    }

    private void horas() {
    horas++;
    setHoras(horas);
    
    }

    void setMinutos(int minutos) {
        
        if(minutos<10){
            min="0"+minutos+"";
        }else min=minutos+"";
    }

    void setHoras(int horas) {
        
        if(horas<10){
            h="0"+horas;
        }else h=horas+"";
    }

    void setSegundos(int segundos) {
        
        if(segundos<10){
            seg="0"+segundos;
        }else seg=segundos+"";
    }
    
}
