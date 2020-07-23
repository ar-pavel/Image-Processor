package com.company;

import javax.swing.*;
import java.io.File;

public class ImageProcessing {
    public static Image image;
    public  static int height;
    public  static int width;

    // Image reader
    public static String readImage() {

        /**
         * Task:
         *  - Take input using JFileChooser
         *  - Read the input file
         *  - build a Directed graph from the input data
         * @return Path to the user selected image
         */


        // Open file reader window
        JFileChooser choice = new JFileChooser(new File("./Images/src"));

        //check if user selected a valid file then proceed further
        while(true){
            int option = choice.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                return choice.getSelectedFile().getAbsolutePath();
            }else{
                System.err.println("No file selected!\nPlease select a valid image file.");
//                System.exit(0);
            }
        }
    }

    public void generateGrayScale(){
        Image grayscale = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int r = image.getPixelR(x, y);
                int g = image.getPixelG(x, y);
                int b = image.getPixelB(x, y);
                int average = (r + g + b) / 3;
                grayscale.setPixel(x, y, average, average, average);

            }
        }

        // save the output image
        grayscale.save("grayscale.png");
    }

    public void generateBlue(){
        Image blue = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int b = image.getPixelB(x, y);
                blue.setPixel(x, y, b, b, b);

            }
        }
        blue.save("b.png");
    }

    public void generateRed(){
        Image red = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int r = image.getPixelR(x, y);
                red.setPixel(x, y, r, r, r);

            }
        }
        red.save("r.png");
    }

    public void generateGreen(){
        Image green = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int g = image.getPixelG(x, y);
                green.setPixel(x, y, g, g, g);

            }
        }
        green.save("g.png");

    }

    public void resizedImage(int newHeight, int newWidth){
        Image resizedImage = image.resizedImage(newHeight, newWidth);
        resizedImage.save("resized Image.png");
    }

    public void processToAssignment(){
        

    }


    public static void main(String args[]) {

        // load an image
        image = new Image(readImage());

        // print height and width
        System.out.println("Height is " + image.getHeight() + " and width is " + image.getWidth());

        height = image.getHeight();
        width = image.getWidth();

        // create another image for output
        // it has the same size as original image

        new ImageProcessing().generateGrayScale();
        new ImageProcessing().generateRed();
        new ImageProcessing().generateBlue();
        new ImageProcessing().generateGreen();

        new ImageProcessing().resizedImage(1400, 1800);




    }
}