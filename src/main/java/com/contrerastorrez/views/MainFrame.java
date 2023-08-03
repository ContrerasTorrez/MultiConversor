package com.contrerastorrez.views;
import com.contrerastorrez.entitys.Monedas;
import com.contrerastorrez.entitys.Temperatura;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public static final String [] TIPOS = {"MONEDA","TEMPERATURA"};
    private JComboBox cbConvertionType;
    private JComboBox cb1;
    private JComboBox cb2;
    private JPanel mainPanel;
    private JTextField tfValue;
    private JTextField tfValueSecond;

    public MainFrame(){
        // FRAME
        this.setContentPane(mainPanel);
        this.setTitle("Bienvenido");
        this.setSize(420,145);
//        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("assets/arrows.png").getImage());
        // JTEXTFIELD
        ((AbstractDocument) tfValue.getDocument()).setDocumentFilter(new DoubleOnlyFilter());
        ((AbstractDocument) tfValueSecond.getDocument()).setDocumentFilter(new DoubleOnlyFilter());
        // JCOMBOBOX
        this.addValuesToComboBox(cbConvertionType, TIPOS);
        this.addValuesToComboBox(cb1, Monedas.MONEDAS);
        this.addValuesToComboBox(cb2, Monedas.MONEDAS);
        cbConvertionType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbConvertionType.getSelectedItem().equals("TEMPERATURA")){
                    addValuesToComboBox(cb1, Temperatura.TEMPERATURA);
                    addValuesToComboBox(cb2, Temperatura.TEMPERATURA);
                }
                else {
                    addValuesToComboBox(cb1, Monedas.MONEDAS);
                    addValuesToComboBox(cb2, Monedas.MONEDAS);
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

                double doubleText = Double.parseDouble( tfValue.getText());
                String from = cb1.getSelectedItem().toString();

                String to = cb2.getSelectedItem().toString();

                String newValue = "";

                if(cbConvertionType.getSelectedItem().toString().equals("MONEDA")) {
                    try{
                        newValue += new Monedas().convertir(from, to, doubleText);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }else{
                    if(from.equals("C")){
                        newValue +=  new Temperatura().convertCelsius(to,doubleText);
                    } else if (from.equals("F")) {
                        newValue += new Temperatura().convertFahrenheit(to,doubleText);
                    }else {
                        newValue += new Temperatura().convertKelvin(to,doubleText);
                    }
                }
                tfValueSecond.setText(newValue);
            }
        });
        tfValueSecond.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                double doubleText = Double.parseDouble( tfValueSecond.getText());
                String from = cb2.getSelectedItem().toString();
                String to = cb1.getSelectedItem().toString();
                String newValue = "";

                if(cbConvertionType.getSelectedItem().toString().equals("MONEDA")) {
                    try{
                        newValue += new Monedas().convertir(from, to, doubleText);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }else{
                    if(from.equals("C")){
                        newValue +=  new Temperatura().convertCelsius(to,doubleText);
                    } else if (from.equals("F")) {
                        newValue += new Temperatura().convertFahrenheit(to,doubleText);
                    }else {
                        newValue += new Temperatura().convertKelvin(to,doubleText);
                    }
                }
                tfValue.setText(newValue);

            }
        });
    }

    public void addValuesToComboBox(JComboBox cb, String[] values){
        cb.setModel(new DefaultComboBoxModel<>(values));
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
