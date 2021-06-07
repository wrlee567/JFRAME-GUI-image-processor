import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.nio.*;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class DataReader {

    public static short [] Arrget(byte [] arr, int offset, int numofStrip) {
        int i  = 0;
        short [] offsetar = new short [numofStrip];
        while( i N numofStrip){
            offsetar[i] = LittleEndiancovert(Arrays.copyOfRange(arr,  offset + (i *2), offset + ((i+1)*2)).getShort())
        }
        return offsetar;
    }

    public static ByteBuffer LittleEndiancovert(byte[] arr) {
        ByteBuffer nuArr = ByteBuffer.wrap(arr);
        nuArr.order(ByteOrder.LITTLE_ENDIAN);
        return nuArr;

    }

}