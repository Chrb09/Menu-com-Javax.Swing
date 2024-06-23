import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame{
    JMenuBar barramenu;
    JButton jbadicao, jbsubtracao, jbmultiplicacao, jbdivisao, jbsair;
    ImageIcon imagens[];
    JToolBar barraferramenta;
    JPopupMenu opcoespopup;
    JMenu operacoes, sobre, sair;
    JMenuItem  adicao, subtracao, multiplicacao, divisao, sobrepopup, sairpopup;
    Calculadora janelacalc;
    Sobre janelasobre;
    
    
    String icones[]={"adicao.png","subtracao.png", "multiplicacao.png", "divisao.png", "sair.png"};
    public Main(){
        super("Menu Lista 12");
        Container tela = getContentPane();
        ImageIcon icone = new ImageIcon("guitarra.png");
        setIconImage(icone.getImage());
        tela.setLayout(null);
        barramenu = new JMenuBar();
        barraferramenta = new JToolBar("Barra de Ferramentas");
        imagens = new ImageIcon[5];
        for(int i = 0;i < 5;i++){
            imagens[i] = new ImageIcon(icones[i]);
        }
        jbadicao = new JButton(imagens[0]);
        jbsubtracao = new JButton(imagens[1]);
        jbmultiplicacao = new JButton(imagens[2]);
        jbdivisao = new JButton(imagens[3]);
        jbsair = new JButton(imagens[4]);      
        opcoespopup = new JPopupMenu();
        operacoes = new JMenu("Operações");
        sobre = new JMenu("Sobre");
        sair = new JMenu("Sair");
        sobrepopup = new JMenuItem("Sobre");
        sairpopup = new JMenuItem("Sair");
        adicao = new JMenuItem("Somar");
        subtracao = new JMenuItem("Subtração");
        multiplicacao = new JMenuItem("Multiplicação");
        divisao = new JMenuItem("Divisão");     
        
        setJMenuBar(barramenu);
        barramenu.add(operacoes);
        barramenu.add(sobre);   
        barramenu.add(sair);
        opcoespopup.add(sobrepopup);   
        opcoespopup.add(sairpopup);
        operacoes.add(adicao);
        operacoes.add(subtracao);
        operacoes.add(multiplicacao);
        operacoes.add(divisao);
        barraferramenta.add(jbadicao);
        barraferramenta.add(jbsubtracao);
        barraferramenta.add(jbmultiplicacao);
        barraferramenta.add(jbdivisao);
        barraferramenta.addSeparator();
        barraferramenta.add(jbsair);
        
        barraferramenta.setBounds(1,1,260,50);
        
        tela.add(barraferramenta);
        
        jbadicao.setToolTipText("Adição (Alt+A)");
        jbsubtracao.setToolTipText("Subtração (Alt+S)");
        jbmultiplicacao.setToolTipText("Multiplicação (Alt+M)");
        jbdivisao.setToolTipText("Divisão (Alt+D)");
        jbsair.setToolTipText("Sair (Alt+E)");
        
        tela.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                if(e.isPopupTrigger())
                opcoespopup.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        );
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getButton() == MouseEvent.BUTTON1)
                Sair();
                }
            }
        );
        
        sairpopup.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                Sair();
                }
            }
        );
        
        sobre.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getButton() == MouseEvent.BUTTON1)
                AbrirSobre();
                }
            }
        );
        
        sobrepopup.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirSobre();
                }
            }
        );
        
        jbsair.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                Sair();
                }
            }
        );
        
        adicao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Adição");
                }
            }
        );
        
        jbadicao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Adição");
                }
            }
        );
        
        subtracao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Subtração");
                }
            }
        );
        
        jbsubtracao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Subtração");
                }
            }
        );
        
        multiplicacao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Multiplicação");
                }
            }
        );
        
        jbmultiplicacao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Multiplicação");
                }
            }
        );
        
        divisao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Divisão");
                }
            }
        );
        
        jbdivisao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                AbrirCalc("Divisão");
                }
            }
        );
        
        jbadicao.setMnemonic(KeyEvent.VK_A);
        jbsubtracao.setMnemonic(KeyEvent.VK_S);
        jbmultiplicacao.setMnemonic(KeyEvent.VK_M);
        jbdivisao.setMnemonic(KeyEvent.VK_D);
        jbsair.setMnemonic(KeyEvent.VK_E);
        
        setSize(500,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main (String args[]){
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    }
    public void Sair(){
        int opcao;
        Object[] botoes = {"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar a janela?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
        if (opcao==JOptionPane.YES_OPTION)
        System.exit(0); 
    }
    public void Fechar(){
        setVisible(false);
        dispose();
    }
    public void AbrirCalc(String equacao){
        janelacalc = new Calculadora(null,equacao,true);
        janelacalc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelacalc.setVisible(true);
    }
    public void AbrirSobre(){
        janelasobre = new Sobre(null,"Sobre",true);
        janelasobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelasobre.setVisible(true);
    }
}