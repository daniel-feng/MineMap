import exception.OUT_OF_MINE_MAP;
import exception.SHOULD_NOT_PLANT_HERE;
import javafx.geometry.Pos;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daniel0808Feng on 18/4/29.
 */
public class MineMap {

    private int width;
    private int height;

    Set<Position> plantedMines = new HashSet<Position>();

    public MineMap(int height, int width) {
        this.width = width;
        this.height = height;
    }

    public void plant(Position pos) {
        if (pos.getWidth() >= this.width || pos.getHeight() >= this.height)
            throw new OUT_OF_MINE_MAP();

        plantedMines.add(pos);

        if (!this.validateMineMap()) {
            plantedMines.remove(pos);
            throw new SHOULD_NOT_PLANT_HERE();
        }

    }

    public boolean hasMine(Position pos) {
        return plantedMines.contains(pos);
    }

    public boolean isOutOfMap(Position pos) {
        if (pos.getWidth() < 0 || pos.getHeight() < 0
                || pos.getWidth() >= this.width || pos.getHeight() >= this.height)
            return true;
        return false;
    }

    public boolean hasMineOrOutOfMap(Position pos) {
        return hasMine(pos) || isOutOfMap(pos);
    }

    public int getNeighborCount(Position pos) {
        int mineCount = 0;
        for (Position minePos : plantedMines) {
            if (Math.abs(minePos.getWidth() - pos.getWidth()) <= 1
                    && Math.abs(minePos.getHeight() - pos.getHeight()) <= 1)
                mineCount++;
        }
        return mineCount;
    }

    private boolean validateMineMap(){
        for (int h=0;h<this.height;h++) {
            for (int w = 0; w < this.width; w++) {
                if (isSurroundedByMineOrEdge(new Position(h, w)))
                    return false;
            }
        }
        return true;
    }

    private boolean isSurroundedByMineOrEdge(Position pos) {
//        if (width == 1 && height == 1)
//            return true;
//        else if (width == 2 && height == 2 && plantedMines.size() >= 2){
//            return true;
//        }else {
            Position leftTop = new Position(pos.getHeight()-1, pos.getWidth()-1);
            Position top = new Position(pos.getHeight()-1, pos.getWidth());
            Position rightTop = new Position(pos.getHeight()-1, pos.getWidth()+1);
            Position left = new Position(pos.getHeight(), pos.getWidth()-1);
            Position right = new Position(pos.getHeight(), pos.getWidth()+1);
            Position leftBottom = new Position(pos.getHeight()+1, pos.getWidth()-1);
            Position bottom = new Position(pos.getHeight()+1, pos.getWidth());
            Position rightBottom = new Position(pos.getHeight()+1, pos.getWidth()+1);

            if (this.hasMineOrOutOfMap(leftTop) && this.hasMineOrOutOfMap(top) && this.hasMineOrOutOfMap(rightTop)
                && this.hasMineOrOutOfMap(left) && this.hasMineOrOutOfMap(right)
                && this.hasMineOrOutOfMap(leftBottom) && this.hasMineOrOutOfMap(bottom) && this.hasMineOrOutOfMap(rightBottom))
                return true;
//        }

        return false;
    }

    public String[] getMineMapArray() {
        String[] mineMapArray = new String[width*height];
        int index = 0;
        for (int h=0;h<this.height;h++){
            for (int w=0;w<this.width;w++){
                Position currPos = new Position(h, w);
                if (this.hasMine(currPos))
                    mineMapArray[index++] = "*";
                else{
                    mineMapArray[index++] = String.valueOf(this.getNeighborCount(currPos));
                }
            }
        }
        return mineMapArray;
    }
}
