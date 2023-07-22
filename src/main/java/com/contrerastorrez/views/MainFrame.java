package com.contrerastorrez.views;

import com.contrerastorrez.entitys.Conversion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MainFrame extends JFrame {
    private JComboBox cbConvertionType;
    private JComboBox cbFrom;
    private JComboBox cbTo;
    private JPanel mainPanel;
    private JLabel lblTo;
    private JTextField tfValue;
    private JButton btnConvertir;

    public MainFrame(){
        // FRAME
        this.setContentPane(mainPanel);
        this.setTitle("Bienvenido");
        this.setSize(505,145);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TEXTFIELD
        tfValue.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = tfValue.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    tfValue.setEditable(true);
                } else {
                    tfValue.setEditable(false);
                }
            }
        });

        // COMBOBOX

        this.addValuesToComboBox(cbConvertionType, Conversion.TIPOS);
        this.addValuesToComboBox(cbFrom, Conversion.MONEDAS);// MONEDA ES EL VALOR POR DEFECTO
        this.addValuesToComboBox(cbTo, Conversion.MONEDAS);
        cbConvertionType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbConvertionType.getSelectedItem().equals("TEMPERATURA")){
                    addValuesToComboBox(cbFrom, Conversion.TEMPERATURA);
                    addValuesToComboBox(cbTo, Conversion.TEMPERATURA);
                }
                else if (cbConvertionType.getSelectedItem().equals("LONGITUDES")){
                    addValuesToComboBox(cbFrom, Conversion.LONGITUDES);
                    addValuesToComboBox(cbTo, Conversion.LONGITUDES);
                }
                else {
                    addValuesToComboBox(cbFrom, Conversion.MONEDAS);
                    addValuesToComboBox(cbTo, Conversion.MONEDAS);
                }
            }
        });
    }

    public void addValuesToComboBox(JComboBox cb, String[] values){
        cb.setModel(new DefaultComboBoxModel<>(values));
    }
}
