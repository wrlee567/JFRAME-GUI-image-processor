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

public class ReadTif implements ActionListener {

    JPanel panel;

    public String tiffpath;
    File gscale = new File(System.getProperty("user.dir") + "/gscale.tif");
    File odither = new File(System.getProperty("user.dir") + "/odither.tif");
    File hdr = new File(System.getProperty("user.dir") + "/HDR.tif");

    int counter = 0;

    public ReadTif(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser j = new JFileChooser();

        // Open the save dialog
        j.showSaveDialog(null);

        tiffpath = j.getSelectedFile().getAbsolutePath();
        System.out.println("Here is directory path: " + tiffpath);

        BufferedImage img = null;
        File file = new File(tiffpath);
        bytereading(file);
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(file);
            fin.read(bytes);
        } catch (IOException ioe) {
            System.out.println("pick good file plzz");
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ioe) {
                System.out.println("closed");
            }
        }
        try {
            img = ImageIO.read(file); // need to fix

        } catch (IOException kait) {
            System.out.println("read failed here ?");
        }

        int width = img.getWidth();
        int height = img.getHeight();

        try {
            ImageIO.write(img, "tif", gscale);
            BufferedImage gscal = ImageIO.read(gscale);

            ImageIO.write(gscal, "tif", gscale);
        } catch (IOException tsun) {
            System.out.println("file not written ");
        }

        try {
            ImageIO.write(img, "tif", odither);
            BufferedImage odith = ImageIO.read(odither);

            ImageIO.write(odith, "tif", odither);
        } catch (IOException hannah) {
            System.out.println("file not written  ");
        }

        try {
            ImageIO.write(img, "tif", hdr);
            BufferedImage hdar = ImageIO.read(hdr);

            ImageIO.write(hdar, "tif", hdr);
        } catch (IOException klarissa) {
            System.out.println("file not written");
        }
        try {
            BufferedImage image = ImageIO.read(new File(tiffpath));
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(150, 200, 200, 100);
            panel.add(label);
            panel.revalidate();
            panel.repaint();
            System.out.println("Just Printed the original version");
        } catch (IOException klarisa) {
            System.out.println("file not written");
        }
    }

    public dubl lossless(BufferedImage img, int w, int h) {

        int a;
        int b;
        int c;
        int p1;
        int p2;
        int p3;
        int p4;
        int p5;
        int p6;
        int p7;

        int[][] predict = new int[w][h];
        int[][] differ = new int[w][h];
        int[] parray = new int[7];

        int lowest = 0;
        int temp = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                int pixel = img.getRGB(x, y);
                if (y == 0 && x == 0) {
                    predict[x][y] = pixel;
                    differ[x][y] = 0;
                } else if (y == 0 && x > 0) { // case with just A so it defaults to 1 P value
                    predict[x][y] = img.getRGB(x - 1, y);
                    differ[x][y] = predict[x][y] - pixel;
                } else if (x == 0 && y > 0) {
                    predict[x][y] = img.getRGB(x, y - 1);
                    differ[x][y] = predict[x][y] - pixel;
                } else {
                    a = img.getRGB(x - 1, y);
                    b = img.getRGB(x, y - 1);
                    c = img.getRGB(x - 1, y - 1);

                    p1 = a;
                    p2 = b;
                    p3 = c;
                    p4 = a + b - c;
                    p5 = a + (b - c) / 2;
                    p6 = b + (a - c) / 2;
                    p7 = (a + b) / 2;

                    parray[0] = p1;
                    parray[1] = p2;
                    parray[2] = p3;
                    parray[3] = p4;
                    parray[4] = p5;
                    parray[5] = p6;
                    parray[6] = p7;
                    for (int p = 0; p < 7; p += 1) {
                        temp = parray[p] - pixel;
                        if (temp < lowest) {
                            predict[x][y] = parray[p];
                            differ[x][y] = temp;
                        }

                    }

                }

            }
        }
        return new dubl(predict, differ);
    }

}// final brakcet
