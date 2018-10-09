import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
public class Unretard extends JFrame implements ActionListener{
  private Converter cv = new Converter();
  private static JTextField nombre = new JTextField(20);
  private static int qi = 100;
  private JPanel conv;
  private JLabel result;
  private JTextField resultatcv = new JTextField(50);
  private Font poliss = new Font("Arial", Font.BOLD, 20);
  public Unretard(){
    super("Unretard");
    init();
    this.setBounds(0, 0, 1200, 300);
    this.setVisible(true);
  }

  public void init(){
    this.setFocusable(true);
    this.requestFocus();
    this.conv = convertisseur();
    this.add(conv);
  }

  public JPanel convertisseur(){
    JPanel pano = new JPanel();
    JButton envoi = new JButton("calculer");
    envoi.addActionListener(this);
    pano.add(Unretard.nombre);
    pano.add(envoi);
    this.resultatcv.setFocusable(false);
    this.resultatcv.setFont(poliss);
    pano.add(this.resultatcv);
    return pano;
  }

  public void actionPerformed(ActionEvent e)
  {
    if(Unretard.nombre.getText() != null){
      try{
        this.resultatcv.setText(this.cv.reader(Unretard.nombre.getText()));
      }
      catch(FormatSaisieException fse){}
    }
    else
      System.out.println("qi = " + qi);
  }
}
