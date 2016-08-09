package com.qinjiangbo.watermarker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Richard on 7/8/16.
 */
public class TextWaterMarkerTest {

    private String imagePath = "/Users/Richard/Desktop/smily_face_2.jpg";
    private String text = Constants.MARK_TEXT;
    private String outputPath = "/Users/Richard/Desktop/smily_with_text.png";

    @Test
    public void testImageWaterMarker() {
        TextWaterMarker textWaterMarker = new TextWaterMarker();
        textWaterMarker.waterMark(imagePath, text, outputPath);
        Assert.assertEquals(1, 1);
    }
}
