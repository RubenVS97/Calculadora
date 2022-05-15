/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea4guiruben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author diabl
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    
    static double num1 = -1;
    static double num2 = -1;
    static double resultado = 0;
    static String signo = "";

    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1;
    }

    private void initComponents() {

        botonera = new PanelBotones();

        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        this.setLayout(new BorderLayout());
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object o = ae.getSource();

        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            areaTexto.setText(((JButton) o).getText());
            if (areaTexto.getText().equals("0") || areaTexto.getText().equals("1") || areaTexto.getText().equals("2") || areaTexto.getText().equals("3") || areaTexto.getText().equals("4") || areaTexto.getText().equals("5") || areaTexto.getText().equals("6") || areaTexto.getText().equals("7") || areaTexto.getText().equals("8") || areaTexto.getText().equals("9")) {
                if (num1 == -1) {
                    num1 = Double.parseDouble(areaTexto.getText());
                } else {
                    num2 = Double.parseDouble(areaTexto.getText());
                }

            }
            if (areaTexto.getText().equals("-")) {
                signo = "-";

            } else if (areaTexto.getText().equals("+")) {
                signo = "+";

            } else if (areaTexto.getText().equals("*")) {
                signo = "*";

            } else if (areaTexto.getText().equals("/")) {
                signo = "/";

            } else if (areaTexto.getText().equals("=")) {
                if (signo.equalsIgnoreCase("-")) {
                    resultado = num1 - num2;
                    System.out.println(resultado);
                    areaTexto.setText(String.valueOf(resultado));
                } else if (signo.equalsIgnoreCase("+")) {
                    resultado = num1 + num2;
                    System.out.println(resultado);
                    areaTexto.setText(String.valueOf(resultado));
                } else if (signo.equalsIgnoreCase("*")) {
                    resultado = num1 * num2;
                    System.out.println(resultado);
                    areaTexto.setText(String.valueOf(resultado));
                } else {
                    resultado = num1 / num2;
                    System.out.println(resultado);
                    areaTexto.setText(String.valueOf(resultado));
                }
            } else if (areaTexto.getText().equals("C")) {
                num1 = -1;
                num2 = -1;
                resultado = 0;
            }
        }

    }
}
