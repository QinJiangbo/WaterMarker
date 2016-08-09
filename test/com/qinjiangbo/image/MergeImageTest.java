package com.qinjiangbo.image;

import org.junit.Test;

/**
 * Created by Richard on 7/17/16.
 */
public class MergeImageTest {

    public String[] imagePaths = {"/Users/Richard/Desktop/smily_face_2.jpg",
                                  "/Users/Richard/Desktop/serenity_7.jpg",
                                  "/Users/Richard/Desktop/vintage_flowers.jpg"};
    public MergeImage mergeImage = new MergeImage();

    @Test
    public void testMergeImage() {
        String outputPath = "/Users/Richard/Desktop/smily_face_merge.jpg";
        mergeImage.mergeImages(imagePaths, Style.LEFT1RIGHT2, outputPath);
    }
}
