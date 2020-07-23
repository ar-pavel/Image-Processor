package com.company;

import com.company.Image;

public class ImageProcessing {


    public static void main(String args[]) {

        // load an image
        Image image = new Image(args[0]);

        // print height and width
        System.out.println("Height is " + image.getHeight() + " and width is " + image.getWidth());

        int height = image.getHeight();
        int width = image.getWidth();


        // create another image for output
        // it has the same size as original image

        Image red = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int r = image.getPixelR(x, y);
                red.setPixel(x, y, r, r, r);

            }
        }
        red.save("r.png");

        Image green = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int g = image.getPixelG(x, y);
                green.setPixel(x, y, g, g, g);

            }
        }
        green.save("g.png");

        Image blue = new Image(height, width);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int b = image.getPixelB(x, y);
                blue.setPixel(x, y, b, b, b);

            }
        }
        blue.save("b.png");

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
}