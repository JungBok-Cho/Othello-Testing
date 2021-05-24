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
        final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/cols.png");
        ImageComponent imageComponent = new ImageComponent(image);
        int imageWidth = -1;
        int imageHeight = -1;
        Dimension unExpectedSize = new Dimension(imageWidth, imageHeight);
        Assertions.assertNotEquals(imageComponent.getPreferredSize(), unExpectedSize);
    }
}
