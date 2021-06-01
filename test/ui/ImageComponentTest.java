package ui;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

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
    void ImageComponent_Valid_Interrupt() {
        Thread newThread = new Thread(() -> {
            // created a large size image, such that the processing takes time and interrupted
            int imagesize = 999999999;
            final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/black.png").getScaledInstance(imagesize, imagesize, Image.SCALE_SMOOTH);
            ImageComponent imageComponent = new ImageComponent(image);
            Assertions.fail("The thread should be interrupted before ImageComponent is instantiated");
        });
        newThread.start();
        newThread.interrupt();
    }

    @Test
    void ImageComponent_Paint_invalid() {
        final Image image = Toolkit.getDefaultToolkit().getImage("src/ui/images/rows.png");
        ImageComponent imageComponent = new ImageComponent(image);

        // Verify successful run of paint()
        try
        {
            Graphics graphics = new GraphicsExtension();
            imageComponent.paint(graphics);
        }
        catch(Exception ex)
        {
            Assertions.fail("ImageComponent.paint should successfully run with graphics object");
        }
    }

    // Added below extension for graphics so to be able to test the call to graphics method
    private class GraphicsExtension extends Graphics
    {

        @Override
        public Graphics create() {
            return null;
        }

        @Override
        public void translate(int x, int y) {

        }

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public void setColor(Color c) {

        }

        @Override
        public void setPaintMode() {

        }

        @Override
        public void setXORMode(Color c1) {

        }

        @Override
        public Font getFont() {
            return null;
        }

        @Override
        public void setFont(Font font) {

        }

        @Override
        public FontMetrics getFontMetrics(Font f) {
            return null;
        }

        @Override
        public Rectangle getClipBounds() {
            return null;
        }

        @Override
        public void clipRect(int x, int y, int width, int height) {

        }

        @Override
        public void setClip(int x, int y, int width, int height) {

        }

        @Override
        public Shape getClip() {
            return null;
        }

        @Override
        public void setClip(Shape clip) {

        }

        @Override
        public void copyArea(int x, int y, int width, int height, int dx, int dy) {

        }

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {

        }

        @Override
        public void fillRect(int x, int y, int width, int height) {

        }

        @Override
        public void clearRect(int x, int y, int width, int height) {

        }

        @Override
        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

        }

        @Override
        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

        }

        @Override
        public void drawOval(int x, int y, int width, int height) {

        }

        @Override
        public void fillOval(int x, int y, int width, int height) {

        }

        @Override
        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

        }

        @Override
        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

        }

        @Override
        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawString(String str, int x, int y) {

        }

        @Override
        public void drawString(AttributedCharacterIterator iterator, int x, int y) {

        }

        @Override
        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public void dispose() {

        }
    }

}
