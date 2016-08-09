package com.qinjiangbo.watermarker;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Richard on 7/10/16.
 */
public class MultiImageWaterMarker {

    public void waterMark(String imagePath, String logoPath, String outputPath) {
        // logoPath --> /Users/Richard/Desktop/xxx.png
        // imagePath --> /Users/Richard/Desktop/xxx.jpg
        OutputStream outputStream = null;
        try {

            File imageFile = new File(imagePath);
            Image image = ImageIO.read(imageFile);
            int width = image.getWidth(null);
            int height = image.getHeight(null);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, width, height, null);

            File logoFile = new File(logoPath);
            Image logo = ImageIO.read(logoFile);
            int width1 = logo.getWidth(null);
            int height1 = logo.getHeight(null);

            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,Constants.ALPHA));
            graphics2D.rotate(Math.toRadians(30), width / 2, height /2);

            //原点左上方,保证能够覆盖掉整个图片就行
            int x= -width / 2;
            int y = -height / 2;

            while(x < width * 1.5){
                y = -height / 2;
                while(y < height * 1.5){
                    graphics2D.drawImage(logo, x, y, null);
                    y += height1 + 100;
                }
                x += width1 + 100;
            }
            graphics2D.dispose();

            outputStream = new FileOutputStream(outputPath);
            JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
            jpegImageEncoder.encode(bufferedImage);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
