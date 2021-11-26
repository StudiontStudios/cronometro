/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2Cronometro;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guiller
 */
public class VistaCronometro extends JFrame {

    private JButton JBComenzar;
    private JLabel crono;
    private JPanel panel1;
    private FlowLayout fl;

    public VistaCronometro() {
        instanciar();
        generarVista();

    }

    private void instanciar() {
        JBComenzar = new JButton("Comenzar");
        crono = new JLabel("00:00:00");
        panel1 = new JPanel();
        fl = new FlowLayout();
        VistaCronometro a = this;
        JBComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empezarCronometro(a);
                
            }

        });

    }

    private void empezarCronometro(VistaCronometro a) {
        //uhn solo hilo se encarga de todo
        Hilos h = new Hilos(a);
        Thread t = new Thread(h);
        t.start();
    }

    private void generarVista() {
        panel1.setLayout(fl);
        panel1.add(crono);
        panel1.add(JBComenzar);
        getContentPane().add(panel1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 100);
        setVisible(true);

    }

    public static void main(String[] args) {
        VistaCronometro a = new VistaCronometro();
    }

    void setCron(String string) {
        crono.setText(string);
    }

}
