package com.qinjiangbo.watermarker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Richard on 7/8/16.
 */
public class MultiTextWaterMarkerTest {

    private String imagePath = "/Users/Richard/Desktop/smily_face_2.jpg";
    private String text = Constants.MARK_TEXT;
    private String outputPath = "/Users/Richard/Desktop/smily_with_multi_text.png";

    @Test
    public void testImageWaterMarker() {
        MultiTextWaterMarker multiTextWaterMarker = new MultiTextWaterMarker();
        multiTextWaterMarker.waterMark(imagePath, text, outputPath);
        Assert.assertEquals(1, 1);
    }
}
