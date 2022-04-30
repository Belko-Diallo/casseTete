package Calculatrice;

import operation.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fenetre extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel operation = new JLabel();
    Font forme = new Font("Arial", Font.BOLD, 32);
    String[] lesCaracteres = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", "=", "c", "+", "-", "*", "/", "(", ")"};
    ArrayList<JButton> lesBoutons = new ArrayList<>();

    public Fenetre() {
        this.setSize(1350, 1350);
        this.setTitle("Ma Calculatrice");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new FlowLayout());
        this.initialisation();

        this.setContentPane(panel);

//        panel.setBackground(Color.ORANGE);
//        panel.add(bouton);

        this.setVisible(true);
    }

    public void test() {
        //panel.setLayout(new GridLayout());
//        for(int i = 1;i<9;i++) {
//            this.getContentPane().add(new JButton(String.valueOf(i)));
//        }

//        plus.setFont(forme);
//        moins.setFont(forme);
//        fois.setFont(forme);
//        divise.setFont(forme);
//        reinitialiser.setFont(forme);
//        calcul.setFont(forme);
//        resultat.setFont(forme);
//
//        zero.setFont(forme);
//        un.setFont(forme);
//        deux.setFont(forme);
//        trois.setFont(forme);
//        quatre.setFont(forme);
//        cinq.setFont(forme);
//        six.setFont(forme);
//        sept.setFont(forme);
//        huit.setFont(forme);
//        neuf.setFont(forme);
//
//        parentheseG.setFont(forme);
//        parentheseD.setFont(forme);
//
//        plus.addActionListener(this);
//        moins.addActionListener(this);
//        fois.addActionListener(this);
//        divise.addActionListener(this);
//        reinitialiser.addActionListener(this);
//        calcul.addActionListener(this);
//
//        zero.addActionListener(this);
//        un.addActionListener(this);
//        deux.addActionListener(this);
//        trois.addActionListener(this);
//        quatre.addActionListener(this);
//        cinq.addActionListener(this);
//        six.addActionListener(this);
//        sept.addActionListener(this);
//        huit.addActionListener(this);
//        neuf.addActionListener(this);
//
//        parentheseD.addActionListener(this);
//        parentheseG.addActionListener(this);
//
//        panel.add(plus);
//        panel.add(moins);
//        panel.add(fois);
//        panel.add(divise);
//        panel.add(reinitialiser);
//        panel.add(calcul);
//        panel.add(resultat);
//
//        panel.add(zero);
//        panel.add(un);
//        panel.add(deux);
//        panel.add(trois);
//        panel.add(quatre);
//        panel.add(cinq);
//        panel.add(six);
//        panel.add(sept);
//        panel.add(huit);
//        panel.add(neuf);
//
//        panel.add(parentheseG);
//        panel.add(parentheseD);

        //this.getContentPane().add(divise);


    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == lesBoutons.get(13)) {
            operation.setText(operation.getText() + "+");
        } else if (source == lesBoutons.get(14)) {
            operation.setText(operation.getText() + "-");
        } else if (source == lesBoutons.get(15)) {
            operation.setText(operation.getText() + "*");
        } else if (source == lesBoutons.get(16)) {
            operation.setText(operation.getText() + "/");
        } else if (source == lesBoutons.get(12)) {
            operation.setText("");
        } else if (source == lesBoutons.get(11)) {
            try {
                operation.setText(String.valueOf(Main.calculer(operation.getText())));
            } catch (Exception erreur) {
                System.out.println(erreur.getMessage());
                operation.setText("");
            }
        } else if (source == lesBoutons.get(10)) {
            operation.setText(operation.getText() + ",");
        } else if (source == lesBoutons.get(0)) {
            operation.setText(operation.getText() + "0");
        } else if (source == lesBoutons.get(1)) {
            operation.setText(operation.getText() + "1");
        } else if (source == lesBoutons.get(2)) {
            operation.setText(operation.getText() + "2");
        } else if (source == lesBoutons.get(3)) {
            operation.setText(operation.getText() + "3");
        } else if (source == lesBoutons.get(4)) {
            operation.setText(operation.getText() + "4");
        } else if (source == lesBoutons.get(5)) {
            operation.setText(operation.getText() + "5");
        } else if (source == lesBoutons.get(6)) {
            operation.setText(operation.getText() + "6");
        } else if (source == lesBoutons.get(7)) {
            operation.setText(operation.getText() + "7");
        } else if (source == lesBoutons.get(8)) {
            operation.setText(operation.getText() + "8");
        } else if (source == lesBoutons.get(9)) {
            operation.setText(operation.getText() + "9");
        } else if (source == lesBoutons.get(17)) {
            operation.setText(operation.getText() + "(");
        } else if (source == lesBoutons.get(18)) {
            operation.setText(operation.getText() + ")");
        }
        System.out.println(operation.getText());
    }

    public void initialisation() {
        JPanel main = new JPanel();
        main.setPreferredSize(new Dimension(1000, 1000));
        for (String bouton : lesCaracteres) {
            JButton ephemere = new JButton(bouton);
            ephemere.setFont(forme);
            ephemere.addActionListener(this);
            ephemere.setPreferredSize(new Dimension(120, 120));
            main.add(ephemere);
            lesBoutons.add(ephemere);
        }
        operation.setFont(forme);
        operation.setHorizontalAlignment(JLabel.CENTER);
        operation.setPreferredSize(new Dimension(200, 40));
        JPanel texte = new JPanel();
        texte.setPreferredSize(new Dimension(1300, 40));
        texte.add(operation);
        texte.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(texte, BorderLayout.NORTH);
        panel.add(main, BorderLayout.SOUTH);
        //panel.add(operation);

    }
}
