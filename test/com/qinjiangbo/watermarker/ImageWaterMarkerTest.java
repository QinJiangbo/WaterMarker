package com.qinjiangbo.watermarker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Richard on 7/8/16.
 */
public class ImageWaterMarkerTest {

    private String imagePath = "/Users/Richard/Desktop/smily_face_2.jpg";
    private String logoPath = "/Users/Richard/Desktop/google-logo-3.png";
    private String outputPath = "/Users/Richard/Desktop/smily_with_imooc.png";

    @Test
    public void testImageWaterMarker() {
        ImageWaterMarker imageWaterMarker = new ImageWaterMarker();
        imageWaterMarker.waterMark(imagePath, logoPath, outputPath);
        Assert.assertEquals(1, 1);
    }
}
