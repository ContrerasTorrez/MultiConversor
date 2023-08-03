package com.contrerastorrez.views;

import com.contrerastorrez.entitys.Conversiones;
import com.contrerastorrez.entitys.Monedas;
import com.contrerastorrez.entitys.Temperatura;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.*;
import java.text.DecimalFormat;
public class MainFrame extends JFrame {
    private JComboBox cbConvertionType;
    private JComboBox cbFrom;
    private JComboBox cbTo;
    private JPanel mainPanel;
    private JTextField tfValue;
    private JTextField tfValueSecond;

    public MainFrame(){
        // FRAME
        this.setContentPane(mainPanel);
        this.setTitle("Bienvenido");
        this.setSize(420,145);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("src/main/resources/arrows.png").getImage());
        // JTEXTFIELD
        ((AbstractDocument) tfValue.getDocument()).setDocumentFilter(new DoubleOnlyFilter());
        ((AbstractDocument) tfValueSecond.getDocument()).setDocumentFilter(new DoubleOnlyFilter());
        // JCOMBOBOX
        this.addValuesToComboBox(cbConvertionType, Conversiones.TIPOS);
        this.addValuesToComboBox(cbFrom, Monedas.MONEDAS);
        this.addValuesToComboBox(cbTo, Monedas.MONEDAS);
        cbConvertionType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbConvertionType.getSelectedItem().equals("Temperatura")){
                    addValuesToComboBox(cbFrom, Conversiones.TEMPERATURA);
                    addValuesToComboBox(cbTo, Conversiones.TEMPERATURA);
                }
                else {
                    addValuesToComboBox(cbFrom, Monedas.MONEDAS);
                    addValuesToComboBox(cbTo, Monedas.MONEDAS);
                }
            }
        });


        tfValue.addKeyListener(new KeyAdapter() {
        });
        tfValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tfValue.getText());
            }
        });
        tfValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                String numText = tfValue.getText();
                double value = Double.parseDouble(numText);
                String newValue = "";
                try{
                    newValue += new Monedas().convertir(cbFrom.getSelectedItem().toString(),cbTo.getSelectedItem().toString(), value);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                tfValueSecond.setText(newValue);
            }
        });
        tfValueSecond.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String numText = tfValueSecond.getText();
                double value = Double.parseDouble(numText);
                String newValue = "";
                try{
                    newValue += new Monedas().convertir(cbTo.getSelectedItem().toString(),cbFrom.getSelectedItem().toString(), value);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                tfValue.setText(newValue);
            }
        });
    }

    public void addValuesToComboBox(JComboBox cb, String[] values){
        cb.setModel(new DefaultComboBoxModel<>(values));
    }
    public void convertirAction () {
        String typeConvertion = cbConvertionType.getSelectedItem().toString();
        String typeFrom = cbFrom.getSelectedItem().toString();
        String typeTo = cbTo.getSelectedItem().toString();
        double valueInserted = Double.parseDouble(tfValue.getText());
        double valueFrom = 0;
        double valueTo = 0;
        double result = 0;
        if(typeConvertion.equals("Monedas")){
//            result = new Monedas().convertir(typeFrom,typeTo, 10);
        }
        else if(typeConvertion.equals("Temperatura")){
            result = Temperatura.valueOf(typeFrom).to(typeTo, valueInserted) ;
        }


    }
}
class DoubleOnlyFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, text);

        if (isDouble(sb.toString())) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);

        if (isDouble(sb.toString())) {
            super.replace(fb, offset, length, text, attr);
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
