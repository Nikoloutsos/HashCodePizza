package Parsing;

import java.util.Arrays;

public class Data {
    public int rows;
    public int columns;
    public int minIngredients;
    public int maxSizeOfSlice;
    public char[][] ingredients;

    public Data(int r, int c, int minI, int maxI, char[][] ing) {
        this.rows = r;
        this.columns = c;
        this.minIngredients = minI;
        this.maxSizeOfSlice = maxI;
        this.ingredients = ing;
    }

    public String toString() {
        return "Rows: " + rows + ", Columns: " + columns + ", minIngredients: " + minIngredients + ", maxSizeOfSlice:" + maxSizeOfSlice
                + ",data: " + Arrays.deepToString(ingredients);
    }
}
