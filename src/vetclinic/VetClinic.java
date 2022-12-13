/* 
 * The program (VetClinic) stores a few Dog objects into an array. 
 * Report which Dog is the heaviest.
 * Author: Ahmed Yussuf 
 */
package vetclinic;

import acm.gui.*;
import acm.program.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Ayuss
 */
public class VetClinic extends Program {

    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 500;
    final String TATILE = "Vet Clinic";

    JTextField name, output;
    JTextField owner;
    JTextField breed;
    IntField weight;
    JButton start;
    JButton getHeavy;

    int maxNumOfDogs = 5;
    Dog[] dogs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new VetClinic().start();
    }

    public VetClinic() {
        dogs = new Dog[maxNumOfDogs];
    }

    @Override
    public void init() {
        setUpWindow();
        tableLayout();

    }

    public void setUpWindow() {
        // set window size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // set title
        setTitle(TATILE);
        //set Background of the window
        setBackground(Color.CYAN);

    }

    public void tableLayout() {
        int rows = 6, cols = 2, rowGap = 8, colGap = 8;
        setLayout(new TableLayout(rows, cols, rowGap, colGap));

        JLabel labelName = new JLabel("Dog Name:  ");
        labelName.setForeground(Color.MAGENTA);
        labelName.setBackground(Color.LIGHT_GRAY);
        add(labelName);

        name = new JTextField(20);
        add(name);

        JLabel labelName2 = new JLabel("Owner Name:  ");
        labelName2.setForeground(Color.MAGENTA);
        labelName2.setBackground(Color.LIGHT_GRAY);
        add(labelName2);

        owner = new JTextField();
        add(owner);

        JLabel labelName3 = new JLabel("Dog Breed:  ");
        labelName3.setForeground(Color.MAGENTA);
        labelName3.setBackground(Color.LIGHT_GRAY);
        add(labelName3);

        breed = new JTextField();
        add(breed);

        JLabel labelWeight = new JLabel("Dog Wieght:  ");
        labelWeight.setForeground(Color.MAGENTA);
        labelWeight.setBackground(Color.LIGHT_GRAY);
        add(labelWeight);

        weight = new IntField();
        add(weight);

        start = new JButton("Add Dog");
        start.addActionListener(this);
        start.setForeground(Color.MAGENTA);
        start.setBackground(Color.LIGHT_GRAY);
        start.setFont(new Font("Aldhabi", Font.CENTER_BASELINE, 12));
        start.setBorder(BorderFactory.createEtchedBorder(
                Color.DARK_GRAY, Color.cyan));
        add(start);

        getHeavy = new JButton("Get Heavy");
        getHeavy.addActionListener(this);
        getHeavy.setForeground(Color.MAGENTA);
        getHeavy.setBackground(Color.LIGHT_GRAY);
        getHeavy.setFont(new Font("Aldhabi", Font.CENTER_BASELINE, 12));
        getHeavy.setBorder(BorderFactory.createEtchedBorder(
                Color.DARK_GRAY, Color.cyan));
        add(getHeavy);

        output = new JTextField(50);
        output.setForeground(Color.white);
        output.setBackground(Color.BLACK);
        output.setFont(new Font("Aldhabi", Font.ITALIC, 10));
        output.setBorder(BorderFactory.createEtchedBorder(
                Color.black, Color.orange));
        add(output, SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String a = ae.getActionCommand();
        String massage = "";
        boolean error = false;
        if (a.equals("Add Dog")) {
            String dogName = name.getText();
            String dogOwner = owner.getText();
            String dogBreed = breed.getText();
            double dogWeight = weight.getValue();

            if (maxNumOfDogs <= Dog.getCount()) {
                massage = "Max number of dogs exceed";
                error = true;
                output.setText(massage);
                JOptionPane.showMessageDialog(null, "Max number exceed");

            } else if (dogName.length() == 0) {
                massage = "Name can not be blank";
                error = true;
                output.setText(massage);
            } else if (dogOwner.length() == 0) {
                massage = "Owner can not be blank";
                error = true;
                output.setText(massage);
            } else if (dogBreed.length() == 0) {
                massage = "Breed can not be blank";
                error = true;
                output.setText(massage);
            } else if (dogWeight == 0) {
                massage = "Invalid weight";
                error = true;
                output.setText(massage);

            } else if (!error) {
                Dog c = new Dog();
                c.setName(dogName);
                c.setOwner(dogOwner);
                c.setBreed(dogBreed);
                c.setWeight(dogWeight);

                dogs[Dog.getCount() - 1] = c;
                output.setText(c.toString());
                clear();
            }
        }
        if (a.equals("Get Heavy")) {
            if (maxNumOfDogs != Dog.getCount()) {
                massage = "No Data Entered!!";
                error = true;
                output.setText(massage.toUpperCase());
                JOptionPane.showMessageDialog(null, "No Data Entered!!");

            }else if (!error) {
                Dog d = Dog.getHeaviest(dogs);
                output.setText("The heaviest dog is: " + d.toString());
            }
        }
    }
    public void clear() {
        name.setText("");
        owner.setText("");
        breed.setText("");
        weight.setText("0.0");
    }
}
