package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.*;

public class Image {

    private BufferedImage image;

    //it takes an file path as input and loads the image
    Image(String path) {
        try {
            File img = new File(path);
            image = ImageIO.read(img);

        } catch (IOException e) {
            image = null;
        }
    }

    //it takes height and width as input and creates an empty image
    Image(int height, int width) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    //it takes a file path as input and saves image to that path
    void save(String path) {
        try {
            File img = new File("Images/output/" + path);
            ImageIO.write(image, "PNG", img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //takes a pixel position and r,g,b values. and sets the color
    void setPixel(int x, int y, int r, int g, int b) {
        image.setRGB(x, y, new Color(r, g, b).getRGB());
    }

    //returns r component of x,y position
    int getPixelR(int x, int y) {
        return (int) ((image.getRGB(x, y) & 0xff0000) >> 16);
    }

    //returns g component of x,y position
    int getPixelG(int x, int y) {
        return (int) ((image.getRGB(x, y) & 0xff00) >> 8);
    }

    //returns b component of x,y position
    int getPixelB(int x, int y) {
        return (int) (image.getRGB(x, y) & 0xff);
    }

    //returns height of the image
    int getHeight() {
        return image.getHeight();
    }

    //returns width of the image
    int getWidth() {
        return image.getWidth();
    }

    Image to8bit(){
        /**
         * Task: convert Buffered image to a 8bit color Image
         * @return a new 8bit color image
         * */
        Image res = new Image(getHeight(), getWidth());

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {

                int r = getPixelR(x,y);
                r = r & (7<<5);            // marking all the bits of Red to 0 except first 3 bits
                int g = getPixelG(x,y);
                g =  g & (7<<5);           // marking all the bits of Green to 0 except first 3 bits
                int b = getPixelB(x,y);
                b = b & (3<<5);             // marking all the bits of Green to 0 except first 2 bits

//                System.out.println(r + "\t" + g + "\t" + b);

                res.setPixel(x, y, r, g, b);
            }
        }

        return res;
    }

    Image resizedImage(int newHeight, int newWidth){
        /**
         * Task: convert image to a new one according to the given height
         * @param newHeight Height of the the new Image to be
         * @param newWidth Width of the the new Image to be
         * @return a new image with correspond size
         * */

        int curHeight = this.image.getHeight();
        int curWidth = this.image.getWidth();
//
//        System.out.println("Image Transformation Info : ");
//        System.out.println("Original image height : " + curHeight + ",\tNew image height : " + newHeight);
//        System.out.println("Original image width : " + curWidth + ",\tNew image width : " + newWidth);

        Image res = new Image(newHeight, newWidth);

        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                int ay = (int) ceil(y * (curHeight-1) / (newHeight-1));
                int ax = (int) ceil(x * (curWidth-1) / (newWidth-1));
//                System.err.println("x : " + x + ", ax : " + ax + ", y : " + y + ", ay : "+ ay);
                int r = getPixelR(ax, ay);
                int g = getPixelG(ax, ay);
                int b = getPixelB(ax, ay);
                res.setPixel(x, y, r, g, b);
            }
        }

        return res;
    }

}
