
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Sobre extends JDialog{
    
    JLabel jlname, jldate, jlschoolclass;
    JButton sair;

    public Sobre(Frame owner, String title ,boolean modal){
        super(owner,title,modal);
        Container tela1 = getContentPane();
        ImageIcon icone = new ImageIcon("guitarra.png");
        setIconImage(icone.getImage());
        tela1.setLayout(null);
        
        jlname = new JLabel("Nome: Carlos Henrique Rodrigues Barile");
        jldate = new JLabel("Data de entrega: 22/06/2024");
        jlschoolclass = new JLabel("Sala: 2º DS AMS");
        sair = new JButton("Voltar");
        
        jlname.setBounds(50,20,300,20);
        jldate.setBounds(50,50,300,20);
        jlschoolclass.setBounds(50,80,300,20);
        sair.setBounds(125,120,100,20);
        
        sair.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
            setVisible(false);
            dispose();}
        });
        
        tela1.add(jlname);
        tela1.add(jldate);
        tela1.add(jlschoolclass);
        tela1.add(sair);
        
        setSize(350,200);
        setLocationRelativeTo(null);
    }
}


