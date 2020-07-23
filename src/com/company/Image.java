package com.company;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;
import java.lang.Math;

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
            File img = new File(path);
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
         *
         * */
        Image res = new Image("demo");

        return res;
    }

    Image resizedImage(int newHeight, int newWidth){
        /**
         * Task: convert image to a new one according to the given height
         * @param newHeight Height of the the new Image to be
         * @param newWidth Width of the the new Image to be
         *                 
         * */
        Image res = new Image("demo");

        return res;
    }

}
