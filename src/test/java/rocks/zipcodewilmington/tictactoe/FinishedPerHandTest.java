package rocks.zipcodewilmington.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FinishedPerHandTest {

    private Board board;

    @Before
    public void setup() {
        // Given
        this.board = new Board(new Character[][]{
                {'X', 'O', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'O'}
        });
    }

    @Test
    public void isFinishedX() {
        // Given
        Boolean expected = true;

        // When
        Boolean actual = board.victoryPerHand(board.getXHand());

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isFinishedO() {
        // Given
        Boolean expected = false;

        // When
        Boolean actual = board.victoryPerHand(board.getOHand());

        // Then
        Assert.assertEquals(expected, actual);
    }
}
