package Pizza;

import java.util.ArrayList;
import java.util.List;

public class ShapeUtil {
    /**
     * Gives all shapes
     */
    public static ArrayList<Pair> returnPossibleShapes(int r1, int c1, int h, int l) {
        ArrayList<Pair> allShapes = new ArrayList<>();

        for (int i = h; i >= 2 * l; --i) {
            if (i % 2 == 1) {
                allShapes.add(new Pair(r1, c1 + i));
                allShapes.add(new Pair(r1 + i, c1));
            } else {

                allShapes.add(new Pair(r1 + i, c1 + i));
                allShapes.add(new Pair(r1 + i, c1 + i));
                allShapes.add(new Pair(r1 + i, c1 + i));
                allShapes.add(new Pair(r1 + i, c1 + i));
                allShapes.add(new Pair(r1 + i, c1 + i));
                allShapes.add(new Pair(r1 + i, c1 + i));
            }
        }
        return allShapes;
    }
}
