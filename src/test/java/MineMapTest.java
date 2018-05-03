import exception.OUT_OF_MINE_MAP;
import org.junit.Assert;
import org.junit.Test;
import exception.SHOULD_NOT_PLANT_HERE;

/**
 * Created by Daniel0808Feng on 18/4/29.
 */
public class MineMapTest {

    @Test (expected = SHOULD_NOT_PLANT_HERE.class)
    public void should_not_plant_mine_1x1() {
        MineMap mineMap = new MineMap(1, 1);
        mineMap.plant(new Position(0, 0));
    }

    @Test (expected = OUT_OF_MINE_MAP.class)
    public void should_not_plant_mine_out_of_width_1x1() {
        MineMap mineMap = new MineMap(1, 1);
        mineMap.plant(new Position(1, 0));
    }

    @Test (expected = OUT_OF_MINE_MAP.class)
    public void should_not_plant_mine_out_of_height_1x1() {
        MineMap mineMap = new MineMap(1, 1);
        mineMap.plant(new Position(0, 1));
    }

    @Test
    public void should_plant_one_mine_2x2() {
        MineMap mineMap = new MineMap(2, 2);
        mineMap.plant(new Position(0, 0));
        Assert.assertTrue(mineMap.hasMine(new Position(0, 0)));
        Assert.assertEquals(1, mineMap.getNeighborCount(new Position(0, 1)));
        Assert.assertEquals(1, mineMap.getNeighborCount(new Position(1, 0)));
        Assert.assertEquals(1, mineMap.getNeighborCount(new Position(1, 1)));
    }

    @Test
    public void should_plant_two_mine_2x2() {
        MineMap mineMap = new MineMap(2, 2);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        Assert.assertTrue(mineMap.hasMine(new Position(0, 0)));
        Assert.assertTrue(mineMap.hasMine(new Position(0, 1)));

        Assert.assertEquals(2, mineMap.getNeighborCount(new Position(1, 0)));
        Assert.assertEquals(2, mineMap.getNeighborCount(new Position(1, 1)));
    }

    @Test (expected = SHOULD_NOT_PLANT_HERE.class)
    public void should_not_plant_three_mine_2x2() {
        MineMap mineMap = new MineMap(2, 2);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(1, 0));
    }

    @Test
    public void should_plant_one_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));

        Assert.assertTrue(mineMap.hasMine(new Position(0, 0)));

        Assert.assertEquals(1, mineMap.getNeighborCount(new Position(0, 1)));
        Assert.assertEquals(1, mineMap.getNeighborCount(new Position(1, 0)));
        Assert.assertEquals(1, mineMap.getNeighborCount(new Position(1, 1)));
    }

    @Test
    public void should_plant_two_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));

        String[] expectedArray = new String[]{  "*", "*", "1",
                                                "2", "2", "1",
                                                "0", "0", "0"};
        Assert.assertArrayEquals(expectedArray, mineMap.getMineMapArray());
    }

    @Test
    public void should_plant_three_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(0, 2));

        String[] expectedArray = new String[]{  "*", "*", "*",
                                                "2", "3", "2",
                                                "0", "0", "0"};
        Assert.assertArrayEquals(expectedArray, mineMap.getMineMapArray());
    }

    @Test
    public void should_plant_four_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(0, 2));
        mineMap.plant(new Position(1, 0));

        String[] expectedArray = new String[]{  "*", "*", "*",
                                                "*", "4", "2",
                                                "1", "1", "0"};
        Assert.assertArrayEquals(expectedArray, mineMap.getMineMapArray());
    }

    @Test
    public void should_plant_five_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(0, 2));
        mineMap.plant(new Position(1, 0));
        mineMap.plant(new Position(1, 2));

        String[] expectedArray = new String[]{  "*", "*", "*",
                                                "*", "5", "*",
                                                "1", "2", "1"};
        Assert.assertArrayEquals(expectedArray, mineMap.getMineMapArray());
    }

    @Test
    public void should_plant_six_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(0, 2));
        mineMap.plant(new Position(1, 0));
        mineMap.plant(new Position(1, 2));
        mineMap.plant(new Position(2, 0));

        String[] expectedArray = new String[]{  "*", "*", "*",
                                                "*", "6", "*",
                                                "*", "3", "1"};
        Assert.assertArrayEquals(expectedArray, mineMap.getMineMapArray());
    }

    @Test
    public void should_plant_seven_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(0, 2));
        mineMap.plant(new Position(1, 0));
        mineMap.plant(new Position(1, 2));
        mineMap.plant(new Position(2, 0));
        mineMap.plant(new Position(2, 1));

        String[] expectedArray = new String[]{  "*", "*", "*",
                                                "*", "7", "*",
                                                "*", "*", "2"};
        Assert.assertArrayEquals(expectedArray, mineMap.getMineMapArray());
    }

    @Test (expected = SHOULD_NOT_PLANT_HERE.class)
    public void should_plant_eight_mine_3x3() {
        MineMap mineMap = new MineMap(3, 3);
        mineMap.plant(new Position(0, 0));
        mineMap.plant(new Position(0, 1));
        mineMap.plant(new Position(0, 2));
        mineMap.plant(new Position(1, 0));
        mineMap.plant(new Position(1, 2));
        mineMap.plant(new Position(2, 0));
        mineMap.plant(new Position(2, 1));
        mineMap.plant(new Position(2, 2));
//
//        String[] expectedArray = new String[]{  "*", "*", "*",
//                                                "*", "8", "*",
//                                                "*", "*", "*"};
    }
}
