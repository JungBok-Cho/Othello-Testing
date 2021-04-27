package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DifficultyLevelTest {

    @Test
    void DifficultyLevel_description_Valid_Should_Set_Easy() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.EASY;

        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.EASY.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.EASY.level());
    }

    @Test
    void DifficultyLevel_description_Valid_Should_Set_Normal() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.NORMAL;
        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.NORMAL.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.NORMAL.level());
    }

    @Test
    void DifficultyLevel_description_Valid_Should_Set_Hard() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HARD;
        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.HARD.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.HARD.level());
    }

    @Test
    void DifficultyLevel_description_Valid_Should_Set_Heroic() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HEROIC;
        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.HEROIC.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.HEROIC.level());
    }

 }