package edu.sdccd.cisc191.template;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Utility class that provides methods for common image-related operations,
 * such as scaling images.
 */
public class UtilityTool {

    /**
     * Scales a given BufferedImage to the specified width and height.
     *
     * @param org    The original BufferedImage to be scaled.
     * @param width  The desired width of the scaled image.
     * @param height The desired height of the scaled image.
     * @return       A new BufferedImage that has been scaled to the specified width and height.
     */
    public BufferedImage scaleImage(BufferedImage org, int width, int height) {

        BufferedImage scaledImage = new BufferedImage(width, height, org.getType());
        Graphics2D g2 = scaledImage.createGraphics();

        // Draw the original image scaled to the new width and height
        g2.drawImage(org,0,0, width, height, null);

        // Dispose of the Graphics2D context to release resources
        g2.dispose();

        return scaledImage;
    }
}
