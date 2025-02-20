import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {

    @Test
    void testaddScoreSize() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        scoreCollection.addScore(20);
        scoreCollection.addScore(30);
        scoreCollection.addScore(40);
        scoreCollection.addScore(50);
        assertEquals(5, scoreCollection.scores.size());
    }

    @Test
    void testaddScoreArrayValues(){
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        scoreCollection.addScore(20);
        scoreCollection.addScore(30);
        scoreCollection.addScore(40);
        scoreCollection.addScore(50);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50}, scoreCollection.scores.stream().mapToInt(i -> i).toArray());
    }


    @Test
    void testaverageScoreOneElement() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        assertEquals(10, scoreCollection.averageScore());
    }

    @Test
    void testaverageScore() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        scoreCollection.addScore(20);
        scoreCollection.addScore(30);
        scoreCollection.addScore(40);
        scoreCollection.addScore(50);
        assertEquals(30, scoreCollection.averageScore());
    }

    @Test
    void testaverageScoreNegative() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(-10);
        scoreCollection.addScore(-20);
        scoreCollection.addScore(-30);
        scoreCollection.addScore(-40);
        scoreCollection.addScore(-50);
        assertEquals(-30, scoreCollection.averageScore());
    }

    

}