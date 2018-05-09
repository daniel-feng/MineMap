import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel0808Feng on 18/5/8.
 */
public class SweepMineTest {

    @Test
    public void should_win_with_no_mine_1x1() {
        MineMap minemap = new MineMap(1, 1);

        minemap.sweep(new Position(0, 0));
        assertEquals(0, minemap.getNeighborCount(new Position(0, 0)));
        assertTrue(minemap.isOpened(new Position(0, 0)));
        assertTrue(minemap.isFinished());
        assertTrue(minemap.isWin());
    }

    @Test
    public void should_win_with_2_mines_and_sweep_2_blank_2x2() {
        MineMap minemap = new MineMap(2, 2);
        minemap.plant(new Position(0, 0));
        minemap.plant(new Position(0, 1));

        minemap.sweep(new Position(1, 0));
        assertEquals(2, minemap.getNeighborCount(new Position(1, 0)));
        minemap.sweep(new Position(1, 1));
        assertEquals(2, minemap.getNeighborCount(new Position(1, 1)));
        assertTrue(minemap.isFinished());
        assertTrue(minemap.isWin());
    }

    @Test
    public void should_lose_with_2_mines_and_sweep_1_mine_2x2() {
        MineMap minemap = new MineMap(2, 2);
        minemap.plant(new Position(0, 0));
        minemap.plant(new Position(0, 1));

        minemap.sweep(new Position(0, 0));
        assertTrue(minemap.isFinished());
        assertFalse(minemap.isWin());
    }

    /*
        * 1 0
        1 1 0
        0 0 0
     */
    @Test
    public void should_win_with_1_mines_in_corner_and_sweep_all_blank_3x3() {
        MineMap minemap = new MineMap(3, 3);
        minemap.plant(new Position(0, 0));

        minemap.sweep(new Position(2, 2));
        assertTrue(minemap.isOpened(new Position(2, 1)));
        assertTrue(minemap.isOpened(new Position(2, 0)));
        assertTrue(minemap.isOpened(new Position(2, 2)));
        assertTrue(minemap.isOpened(new Position(1, 2)));
        assertTrue(minemap.isOpened(new Position(0, 2)));
        assertEquals(1, minemap.getNeighborCount(new Position(0, 1)));
        minemap.sweep(new Position(0, 1));
        minemap.sweep(new Position(1, 1));
        minemap.sweep(new Position(1, 0));
        assertTrue(minemap.isFinished());
        assertTrue(minemap.isWin());
    }

    /*
        * 2 1 0 0
        2 * 1 0 0
        1 1 1 0 0
        0 0 0 0 0
        0 0 0 0 0
     */
    @Test
    public void should_win_with_2_mines_and_sweep_all_blank_5x5() {
        MineMap minemap = new MineMap(5, 5);
        minemap.plant(new Position(0, 0));
        minemap.plant(new Position(1, 1));

        minemap.sweep(new Position(4, 4));
        assertTrue(minemap.isOpened(new Position(4, 4)));
        assertTrue(minemap.isOpened(new Position(4, 3)));
        assertTrue(minemap.isOpened(new Position(4, 2)));
        assertTrue(minemap.isOpened(new Position(4, 1)));
        assertTrue(minemap.isOpened(new Position(4, 0)));
        assertTrue(minemap.isOpened(new Position(3, 4)));
        assertTrue(minemap.isOpened(new Position(3, 3)));
        assertTrue(minemap.isOpened(new Position(3, 2)));
        assertTrue(minemap.isOpened(new Position(3, 1)));
        assertTrue(minemap.isOpened(new Position(3, 0)));
        assertTrue(minemap.isOpened(new Position(0, 4)));
        assertTrue(minemap.isOpened(new Position(1, 4)));
        assertTrue(minemap.isOpened(new Position(2, 4)));
        assertTrue(minemap.isOpened(new Position(2, 4)));
        assertTrue(minemap.isOpened(new Position(0, 3)));
        assertTrue(minemap.isOpened(new Position(1, 3)));
        assertTrue(minemap.isOpened(new Position(2, 3)));

        assertEquals(1, minemap.getNeighborCount(new Position(2, 2)));
        assertEquals(1, minemap.getNeighborCount(new Position(2, 1)));
        assertEquals(1, minemap.getNeighborCount(new Position(2, 0)));
        assertEquals(1, minemap.getNeighborCount(new Position(1, 2)));
        assertEquals(1, minemap.getNeighborCount(new Position(0, 2)));
        assertEquals(2, minemap.getNeighborCount(new Position(0, 1)));
        assertEquals(2, minemap.getNeighborCount(new Position(1, 0)));
        minemap.sweep(new Position(0, 1));
        minemap.sweep(new Position(1, 0));
        minemap.sweep(new Position(2, 0));
        minemap.sweep(new Position(2, 1));
        minemap.sweep(new Position(2, 2));
        minemap.sweep(new Position(0, 2));
        minemap.sweep(new Position(1, 2));
        assertTrue(minemap.isFinished());
        assertTrue(minemap.isWin());
    }
}
