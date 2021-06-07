//java file for the first project 

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project2 {

    public static void main(String[] args) {
        // write Hello world to the terminal window
        System.out.println("Here is the compressor application !!");
        final String tiffpath;

        JButton b = new JButton("read tif");
        JButton b2 = new JButton("next");
        JButton b3 = new JButton("quit");

        // create a new frame to store text field and button
        JFrame f = new JFrame("label");

        JPanel p = new JPanel();

        ReadTif readtif = new ReadTif(p);
        b.addActionListener(readtif);
        b.setBounds(150, 150, 100, 40);// x axis, y axis, width, height

        DoNext doNext = new DoNext(f, p, readtif);
        b2.addActionListener(doNext);
        b2.setBounds(150, 100, 100, 40);
        b3.addActionListener(e -> System.exit(0));

        b3.setBounds(150, 50, 100, 40);
        p.add(b2);

        p.add(b);
        p.add(b3);

        f.add(p);

        // set the size of frame
        f.setSize(1500, 800);
        JScrollPane pane = new JScrollPane(p);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        f.getContentPane().add(pane);

        f.setVisible(true);

    }

}
