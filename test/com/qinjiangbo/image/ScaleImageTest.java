package com.qinjiangbo.image;

import org.junit.Test;

/**
 * Created by Richard on 7/17/16.
 */
public class ScaleImageTest {

    public String imagePath = "/Users/Richard/Desktop/smily_face_2.jpg";
    public ScaleImage scaleImage = new ScaleImage();

    @Test
    public void testScaleImage1() {
        String outputPath = "/Users/Richard/Desktop/smily_face_scale.jpg";
        scaleImage.scaleImage(imagePath, 1920, 1080, outputPath);
    }

    @Test
    public void testScaleImage2() {
        String outputPath = "/Users/Richard/Desktop/smily_face_scale2.jpg";
        scaleImage.scaleImage(imagePath, 0.75f, outputPath);
    }

}
