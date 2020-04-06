import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*class EcouteurText implements MouseListener {

  void public actionPerformed(actionEvent evt) {
    Object source = evt.getSource();
    if (source == b) // action a effectuer
  }


}*/

class MaFenetre extends JFrame {

  MaFenetre()
  {
    //Définit un titre pour notre fenêtre
    setTitle("Mon convertisseur euros francs");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    setSize(600, 200);
    //Nous demandons maintenant à notre objet de se positionner au centre
    setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Et enfin, la rendre viThe method addMouseListener(Ex1) is undefined for the typesible
    setVisible(true);
  }
}




public class Convertisseur  extends JPanel implements ActionListener {

GridLayout grid;

//JTextField
JTextField euros;
JTextField francs;

//label
JLabel labelEuro;
JLabel labelFrancs;

//bouton
JButton conversionEuro;
JButton conversionFranc;

  Convertisseur()
  {
    grid =new GridLayout(3,2);
    setLayout(grid);
    euros = new JTextField("Montant en euros");

    add(euros);
    labelEuro = new JLabel("Somme en euros");
    add(labelEuro);
    conversionFranc = creerBouton("Conversion en francs", Color.BLUE);
    conversionEuro = creerBouton("Conversion en euros", Color.YELLOW);
    francs = new JTextField("Montant en francs");
    add(francs);
    labelFrancs = new JLabel("Somme en francs");
    add(labelFrancs);

    euros.addFocusListener(new FocusListener() {
     public void focusGained(FocusEvent e) {

       euros.setText("");
     }

     public void focusLost(FocusEvent e) {
     }
   });


   francs.addFocusListener(new FocusListener() {
    public void focusGained(FocusEvent e) {

      francs.setText("");
    }

    public void focusLost(FocusEvent e) {
    }

  });
    //setSize(600, 100);

  }
  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if(source == conversionEuro)
    {
      if(euros.getText()=="") {
        System.out.println("Aucun contenu dans le champ Francs");
        return;
      }
      System.out.println("conversionEuro");
      float value = Float.valueOf(francs.getText());
      euros.setText(String.valueOf(value/6.5596));

    }

    if(source == conversionFranc)
    {
      if(francs.getText()=="") {
        System.out.println("Aucun contenu dans le champ Euros");
        return;
      }
      System.out.println("conversionFranc");
      float value = Float.valueOf(euros.getText());
      francs.setText(String.valueOf(value*6.5596));

    }

  }

  /*  if (source == JTextField)
    {
      System.out.println("euros");
    } // action a effectuer
  }*/

  protected JButton creerBouton(String nom, Color c)
  {
    JButton bouton =new JButton(nom);
    bouton.setBackground(c);
    bouton.addActionListener(this);
    if(c == Color.BLUE)  bouton.setForeground(Color.WHITE);
    add(bouton);
    return bouton;
  }


  public static void main(String[] args){
    MaFenetre fenetre = new MaFenetre();

    fenetre.setContentPane(new Convertisseur());
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //fenetre.pack();
    fenetre.setVisible(true);
  }
}
