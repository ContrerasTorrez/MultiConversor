package com.contrerastorrez.views;

import com.contrerastorrez.entitys.Conversion;
import com.contrerastorrez.entitys.MONEDAS;
import com.contrerastorrez.entitys.TEMPERATURA;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;


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
        this.setIconImage(new ImageIcon("src/main/resources/arrows.png").getImage());
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
//                else if (cbConvertionType.getSelectedItem().equals("LONGITUDES")){
//                    addValuesToComboBox(cbFrom, Conversion.LONGITUDES);
//                    addValuesToComboBox(cbTo, Conversion.LONGITUDES);
//                }
                else {
                    addValuesToComboBox(cbFrom, Conversion.MONEDAS);
                    addValuesToComboBox(cbTo, Conversion.MONEDAS);
                }
            }
        });
        btnConvertir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String typeConvertion = cbConvertionType.getSelectedItem().toString();
                String typeFrom = cbFrom.getSelectedItem().toString();
                String typeTo = cbTo.getSelectedItem().toString();
                double valueInserted = Double.parseDouble(tfValue.getText());
                double valueFrom = 0;
                double valueTo = 0;
                double result = 0;

                if(typeConvertion.equals("MONEDAS")){
                    valueFrom = MONEDAS.valueOf(typeFrom).getValue();
                    valueTo = MONEDAS.valueOf(typeTo).getValue();
                    result = MONEDAS.getResult(valueFrom, valueTo, valueInserted);
                }
                else if(typeConvertion.equals("TEMPERATURA")){
                    result = TEMPERATURA.valueOf(typeFrom).to(typeTo, valueInserted) ;
                }

                DecimalFormat df = new DecimalFormat("#,###.###");

                JOptionPane.showMessageDialog(null,typeFrom + " A " + typeTo
                        + " : " + df.format(result),"RESULTADO",1);

            }
        });
    }

    public void addValuesToComboBox(JComboBox cb, String[] values){
        cb.setModel(new DefaultComboBoxModel<>(values));
    }
}
