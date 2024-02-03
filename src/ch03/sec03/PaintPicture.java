package ch03.sec03;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class PaintPicture {
    BufferedImage createImage(int width, int height, PixelFunction f){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Color color = f.apply(width, height);
                image.setRGB(x ,y, color.getRGB());
            }
        }
        return image;
    }
}

