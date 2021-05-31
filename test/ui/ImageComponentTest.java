package ui;

import java.awt.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImageComponentTest {

    @Test
    void ImageComponent_PreferredSize_Valid() {
        final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/cols.png");
        ImageComponent imageComponent = new ImageComponent(image);
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        Dimension expectedSize = new Dimension(imageWidth, imageHeight);
        Assertions.assertEquals(imageComponent.getPreferredSize(), expectedSize);
    }

    @Test
    void ImageComponent_PreferredSize_Invalid() {
        final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/rows.png");
        ImageComponent imageComponent = new ImageComponent(image);
        int imageWidth = -1;
        int imageHeight = -1;
        Dimension unExpectedSize = new Dimension(imageWidth, imageHeight);
        Assertions.assertNotEquals(imageComponent.getPreferredSize(), unExpectedSize);
    }

    @Test
    void ImageComponent_Paint_invalid() {
        final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/rows.png");
        ImageComponent imageComponent = new ImageComponent(image);

        // Verify successful run of paint()
        try
        {
            Graphics graphics = null;
            imageComponent.paint(graphics);
            Assertions.fail("ImageComponent.paint should throw with invalid graphics object");
        }
        catch(Exception ex)
        {
            Assertions.assertNotNull(ex, "Should throw an exception with null graphics");
        }
    }
}
