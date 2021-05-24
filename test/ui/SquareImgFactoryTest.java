package ui;

import java.awt.*;

import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareImgFactoryTest {

    @Test
    void SquareImgFactory_SquareType_Valid_Should_be_Black(){
        int imagesize = 22;
        final Image blackDiscImg = Toolkit.getDefaultToolkit().getImage("src/ui/images/black.png").getScaledInstance(imagesize, imagesize, Image.SCALE_SMOOTH);
        ImageComponent blackImageComponent = new ImageComponent(blackDiscImg);
        Assertions.assertEquals(SquareImgFactory.buildSquare(SquareImgFactory.SquareType.BLACK).getPreferredSize(), blackImageComponent.getPreferredSize());
    }

    @Test
    void SquareImgFactory_SquareType_Valid_Should_be_White(){
        int imagesize = 22;
        final Image whiteDiscImg = Toolkit.getDefaultToolkit().getImage("src/ui/images/white.png").getScaledInstance(imagesize, imagesize, Image.SCALE_SMOOTH);
        ImageComponent whiteImageComponent = new ImageComponent(whiteDiscImg);
        Assertions.assertEquals(SquareImgFactory.buildSquare(SquareImgFactory.SquareType.WHITE).getPreferredSize(), whiteImageComponent.getPreferredSize());
    }

}
