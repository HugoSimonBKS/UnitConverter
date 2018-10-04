import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
public class Unretard extends JFrame implements ActionListener{
  private Converter cv = new Converter();
  private static JTextField nombre = new JTextField(20);
  private static int qi = 100;
  public Unretard(){
    super("Unretard");
    init();
    this.setBounds(0, 0, 1500, 1000);
    this.setVisible(true);
  }

  public void init(){
    this.setFocusable(true);
    this.requestFocus();
    this.add(convertisseur());
  }

  public JPanel convertisseur(){
    JPanel pano = new JPanel();
    JButton envoi = new JButton("calculer");
    envoi.addActionListener(this);
    pano.add(Unretard.nombre);
    pano.add(envoi);
    return pano;
  }

  public void actionPerformed(ActionEvent e)
  {
    System.out.println("ca passe");
    if(Unretard.nombre.getText() != null)
      this.cv.reader(Unretard.nombre.getText());
    else
      System.out.println("qi = " + qi);
  }
}
