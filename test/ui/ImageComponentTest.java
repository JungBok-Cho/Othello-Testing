package ui;

import java.awt.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void ImageComponent_Paint_Mock_Valid() {
        final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/rows.png");
        ImageComponent imageComponent = new ImageComponent(image);

        // create mock class
        Graphics mockGraphics = mock(Graphics.class);

        // Verify successful run of paint()
        try
        {
            when(mockGraphics.drawImage(image, 0, 0, imageComponent)).thenReturn(true);
            imageComponent.paint(mockGraphics);
        }
        catch(Exception ex)
        {
            Assertions.fail("ImageComponent.paint should not throw");
        }
    }

    @Test
    void ImageComponent_Paint_Mock_invalid() {
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
            Assertions.assertEquals(ex.getMessage(), "Cannot invoke \"java.awt.Graphics.drawImage(java.awt.Image, int, int, java.awt.image.ImageObserver)\" because \"g\" is null");
        }
    }
}
