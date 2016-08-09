package com.qinjiangbo.watermarker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Richard on 7/8/16.
 */
public class MultiImageWaterMarkerTest {

    private String imagePath = "/Users/Richard/Desktop/smily_face_2.jpg";
    private String logoPath = "/Users/Richard/Desktop/google-logo-3.png";
    private String outputPath = "/Users/Richard/Desktop/multi_smily_with_goole.png";

    @Test
    public void testImageWaterMarker() {
        MultiImageWaterMarker multiImageWaterMarker = new MultiImageWaterMarker();
        multiImageWaterMarker.waterMark(imagePath, logoPath, outputPath);
        Assert.assertEquals(1, 1);
    }
}
