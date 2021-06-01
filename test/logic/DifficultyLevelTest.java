package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DifficultyLevelTest {

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Easy() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.EASY;

        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.EASY.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.EASY.level());
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Normal() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.NORMAL;
        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.NORMAL.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.NORMAL.level());
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Hard() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HARD;
        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.HARD.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.HARD.level());
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Heroic() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HEROIC;
        Assertions.assertEquals(difficultyLevelInstance.description(), DifficultyLevel.HEROIC.description());
        Assertions.assertEquals(difficultyLevelInstance.level(), DifficultyLevel.HEROIC.level());
    }

    // Below testcases are added after mutant testing, since above testcases failed to catch

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Easy_HardCodedLevel() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.EASY;

        Assertions.assertEquals(difficultyLevelInstance.level(), 3);
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Normal_HardCodedLevel() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.NORMAL;
        Assertions.assertEquals(difficultyLevelInstance.level(), 4);
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Hard_HardCodedLevel() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HARD;
        Assertions.assertEquals(difficultyLevelInstance.level(), 5);
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Heroic_HardCodedLevel() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HEROIC;
        Assertions.assertEquals(difficultyLevelInstance.level(), 6);
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Easy_HardCodedDescripton() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.EASY;

        Assertions.assertEquals(difficultyLevelInstance.description(), "Easy");
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Normal_HardCodedDescripton() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.NORMAL;
        Assertions.assertEquals(difficultyLevelInstance.description(), "Normal");
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Hard_HardCodedDescripton() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HARD;
        Assertions.assertEquals(difficultyLevelInstance.description(), "Hard");
    }

    @Test
    void DifficultyLevel_description_level_Valid_Should_Set_Heroic_HardCodedDescripton() {
        DifficultyLevel difficultyLevelInstance = DifficultyLevel.HEROIC;
        Assertions.assertEquals(difficultyLevelInstance.description(), "Heroic");
    }

 }
