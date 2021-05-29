package ui;

import java.awt.*;
import core.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

public class SquareImgFactoryTest extends SquareImgFactory {

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

    @Test
    void SquareImgFactory_SquareType_Valid_Should_be_PssblBlk(){
        int imageSize = 22;
        final Image pssblBlkDiscImg = Toolkit.getDefaultToolkit().getImage("src/ui/images/blackpssbl.png").getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
        ImageComponent pssbleBlkImageComponent = new ImageComponent(pssblBlkDiscImg);
        Assertions.assertEquals(SquareImgFactory.buildSquare(SquareImgFactory.SquareType.PSSBLBLK).getPreferredSize(), pssbleBlkImageComponent.getPreferredSize());
    }

    @Test
    void SquareImgFactory_SquareType_Valid_Should_be_PssblWht(){
        int imageSize = 22;
        final Image pssblWhtDiscImg = Toolkit.getDefaultToolkit().getImage("src/ui/images/whitepssbl.png").getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
        ImageComponent pssbleWhtDiscImageComponent = new ImageComponent(pssblWhtDiscImg);
        Assertions.assertEquals(SquareImgFactory.buildSquare(SquareImgFactory.SquareType.PSSBLWHT).getPreferredSize(), pssbleWhtDiscImageComponent.getPreferredSize());
    }

    @Test
    void SquareImgFactory_SquareType_Valid_Should_be_Empty(){
        int imageSize = 22;
        final Image emptyDiscImg = Toolkit.getDefaultToolkit().getImage("src/ui/images/empty.png").getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
        ImageComponent emptyDiscImageComponent = new ImageComponent(emptyDiscImg);
        Assertions.assertEquals(SquareImgFactory.buildSquare(SquareImgFactory.SquareType.EMPTY).getPreferredSize(), emptyDiscImageComponent.getPreferredSize());
    }
//
//    @Test
//    void SquareImgFactory_SquareType_Valid_Should_be_Null() {
//        int imageSize = 22;
//        final Image emptyDiscImg = Toolkit.getDefaultToolkit().getImage("src/ui/images/empty.png").getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
//
//        // create mock class
//        SquareImgFactory mockSquareType = mock(SquareImgFactory.class);
//        ImageComponent emptyDiscImageComponent = new ImageComponent(emptyDiscImg);
//        when(SquareType.BLACK).thenReturn(null);
//        Assertions.assertEquals(SquareImgFactory.buildSquare(SquareType.valueOf("")), null);
//    }
}
