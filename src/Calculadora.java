
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculadora extends JDialog{
    JLabel titulo, num1, nume2, resultado;
    JTextField textNum1, textNum2;
    JButton calcular, limpar, sair;
    public Calculadora(Frame owner, String title ,boolean modal){
        super(owner,title,modal);
        Container tela1 = getContentPane();
        ImageIcon icone = new ImageIcon("guitarra.png");
        setIconImage(icone.getImage());
        tela1.setLayout(null);
        
        titulo = new JLabel(title);
        num1 = new JLabel("1º Número: ");
        nume2 = new JLabel("2º Número: ");
        textNum1 = new JTextField(5);
        textNum2 = new JTextField(5);
        resultado = new JLabel("");
        calcular = new JButton("Calcular");
        limpar = new JButton("Limpar");
        sair = new JButton("Voltar");
        
        titulo.setBounds(50,30,300,20);
        num1.setBounds(50,70,100,20);
        nume2.setBounds(50,110,100,20);
        textNum1.setBounds(120,70,200,20);
        textNum2.setBounds(120,110,200,20);
        resultado.setBounds(50,180,200,20);
        calcular.setBounds(140,150,120,20);
        limpar.setBounds(50,150,80,20);
        sair.setBounds(50,210,100,20);
        
        calcular.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){
            double numero1, numero2, res;
            res = 0;
            numero1 = Integer.parseInt(textNum1.getText());
            numero2 = Integer.parseInt(textNum2.getText());
            
            if(title == "Adição")
            res = numero1 + numero2;
            if(title == "Subtração")
            res = numero1 - numero2;
            if(title == "Multiplicação")
            res = numero1 * numero2;
            if(title == "Divisão")
            res = numero1 / numero2;
            
            resultado.setVisible(true);
            resultado.setText("A "+title+" é: "+res);
            }
        });
        
        limpar.addActionListener(
            new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    textNum1.setText(null);
                    textNum2.setText(null);
                    resultado.setText("");
                }
            }
        );
        sair.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            setVisible(false);
            dispose();}
        });
        
        titulo.setFont(new Font("Courier New",Font.BOLD,20));
        resultado.setVisible(false);
        
        tela1.add(titulo);
        tela1.add(num1);
        tela1.add(nume2);
        tela1.add(textNum1);
        tela1.add(textNum2);
        tela1.add(resultado);
        tela1.add(calcular);
        tela1.add(limpar);
        tela1.add(sair);
        
        setSize(400,300);
        setLocationRelativeTo(null);
    }
}


