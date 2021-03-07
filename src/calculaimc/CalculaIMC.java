package calculaimc;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculaIMC {

    public static void main(String[] args) {
        
        JFrame janela = new JFrame("Calcular IMC");
        
        JPanel altura = new JPanel();
        altura.setLayout(new FlowLayout());
        altura.add(new JLabel("Altura (m):"));
        JTextField txtAltura = new JTextField(4);
        altura.add(txtAltura);
        
        JPanel peso = new JPanel();
        peso.setLayout(new FlowLayout());
        peso.add(new JLabel("Peso (kg):"));
        JTextField txtPeso = new JTextField(4);
        peso.add(txtPeso);
        
        JPanel imc = new JPanel();
        imc.setLayout(new FlowLayout());
        imc.add(new JLabel("IMC:"));
        JLabel resultadoImc = new JLabel();
        imc.add(resultadoImc);
        
        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        JButton btnCalcularImc = new JButton("Calcular IMC");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");        
        botoes.add(btnSair);
        botoes.add(btnLimpar);
        botoes.add(btnCalcularImc);
        
        btnCalcularImc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    resultadoImc.setText("" + (new DecimalFormat("0.00000")).format(Double.parseDouble(txtPeso.getText())/(Double.parseDouble(txtAltura.getText()) * Double.parseDouble(txtAltura.getText()))));
                }catch(NumberFormatException e){
                    if(e.toString().equals("java.lang.NumberFormatException: empty String")){
                        JOptionPane.showMessageDialog(null, "Algum campo está vazio!", "Erro!", 2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Digite somente valores numéricos! (Sepere valores decimais com '.')", "Erro!", 2);
                    }
                }   
            }
            
        });
        
        btnLimpar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtPeso.setText("");
                txtAltura.setText("");
                resultadoImc.setText("");
            }
        
        });
        
        btnSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        //Painel para organizar Layout
        JPanel campos = new JPanel();
        campos.setLayout(new FlowLayout());
        campos.add(altura);
        campos.add(peso);
        
        janela.setSize(270,140);
        janela.setLayout(new GridLayout(3,1));
        janela.add(campos);
        janela.add(imc);
        janela.add(botoes);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
