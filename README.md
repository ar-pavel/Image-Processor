## Image-Processor

Image Processor is a java program that can used to apply different type transformations in an image. 

#### Description
This program read an image file using `jFileChooser` from `java swing` and can perform multiple types of operations on it.  

##### generateBlue()
This method detect all the appearances of blue color in this image. The more dark in the saved image a point is the more blue color on that pixel presented on that pixel.

##### generateRed()
This method detect all the appearances of red color in this image. The more dark in the saved image a point is the more red color on that pixel presented on that pixel.


##### generateGreen()
This method detect all the appearances of green color in this image. The more dark in the saved image a point is the more green color on that pixel presented on that pixel.


##### resizeImage()
This operation is used to shrink or zoom/enlarge the image. This method takes two variable, `height` and `width` to resize the current image and return a new image. 


##### to8bit()
This method convert this `Buffered Image` to `8 Bit Image` by keeping 3 bits from red, 3 bits from green and 2 bits from blue.


