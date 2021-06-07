import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Arrays;
import java.nio.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.io.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.awt.image.*;

public class DoNext implements ActionListener {

    int counter = 1;
    JFrame frame;
    JPanel panel;
    ReadTif readTif;

    public DoNext(JFrame frame, JPanel panel, ReadTif readTif) {
        this.frame = frame;
        this.panel = panel;
        this.readTif = readTif;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter == 0) {
            return;
        } else if (counter % 3 == 1) {
            try {

                BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/gscale.tif"));
                JLabel label = new JLabel(new ImageIcon(image));
                label.setBounds(150, 200, 200, 100);
                panel.add(label);
                System.out.println("Just Printed the grayscale version");
            } catch (IOException kait) {
            }

        } else if (counter % 3 == 2) {
            try {
                BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/odither.tif"));
                JLabel label = new JLabel(new ImageIcon(image));
                label.setBounds(150, 200, 200, 100);
                panel.add(label);
                System.out.println("Just Printed the Dithered version");
            } catch (IOException kait) {
            }

        } else if (counter % 3 == 0) {
            try {
                BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/HDR.tif"));
                JLabel label = new JLabel(new ImageIcon(image));
                label.setBounds(150, 200, 200, 100);
                panel.add(label);
                System.out.println("Just Printed the Dynamic Range ratio 10 compression ");
            } catch (IOException kait) {
            }
            // frame.add(label);
        }
        panel.revalidate();
        panel.repaint();
        counter++;
    }
}