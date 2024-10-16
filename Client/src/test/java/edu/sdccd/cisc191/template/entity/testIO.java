package edu.sdccd.cisc191.template.entity;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class testIO {

    @Test
    void testImageInputStream() {
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/blueheart.png"));

        } catch(IOException e){
            e.printStackTrace();
        }

        assertNotNull(image, "The image is loaded successfully.");

    }
}