package RandomAlgorithm;

import Parsing.Data;
import Parsing.Parser;
import Pizza.Pair;
import Pizza.PizzaSlice;
import Pizza.ShapeUtil;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static char[][] pizza;
    static boolean[][] usedCells;
    static Random rn = new Random();
    static int surface = 0;
    static ArrayList<PizzaSlice> pizzaSlices = new ArrayList<>();
    static Data info;


    public static void main(String[] args) {
        /**
         * Initializations
         */
        info = Parser.readFromFile();
        pizza = info.ingredients;
        usedCells = new boolean[info.rows][info.columns];
        for(int i=0; i<info.rows;++i){
            for(int j=0; j<info.columns;++j){
                usedCells[i][j] = false;
            }
        }


        /**
         * Algorithm
         */
        final int ITERATIONS = 10_000_000;
        for(int i=0; i<= ITERATIONS; ++i){
            int rRand = rn.nextInt(info.rows - 1);
            int cRand = rn.nextInt(info.columns - 1);

            ArrayList<Pair> allShapes = ShapeUtil.returnPossibleShapes(rRand, cRand, info.maxSizeOfSlice, info.minIngredients);

            int randomShapeNumber = rn.nextInt(allShapes.size()-1);
            int rShapeRand = allShapes.get(randomShapeNumber).r1;
            int cShapeRand = allShapes.get(randomShapeNumber).c1;

            PizzaSlice slice = new PizzaSlice(rRand, cRand, rShapeRand, cShapeRand);

            if(isSliceOkay(slice)){
                add(slice);
            }
        }
        int sum = 0;
        for(PizzaSlice current: pizzaSlices){
            sum += current.size();
        }
        System.out.println(sum);

    }

    private static void add(PizzaSlice slice) {
        for(int i=slice.r1;i<=slice.r2;++i){ //update usedCells 2d array
            for(int j=slice.c1;j<=slice.c2;++j){
                usedCells[i][j] = true;
            }
        }
        pizzaSlices.add(slice);
        surface += slice.size();
    }


    private static boolean isSliceOkay(PizzaSlice slice){
        int numberOfTomatoes = 0;
        int numberOfMushroom = 0;
        boolean isOverlaping = false;

        if(slice.c2 >= info.columns || slice.r2 >= info.rows) return false;


        outerLoop:
        for(int i=slice.r1;i<=slice.r2;++i){ //update usedCells 2d array
            for(int j=slice.c1;j<=slice.c2;++j){
                if (pizza[i][j] == 'T') ++numberOfTomatoes;
                if (pizza[i][j] == 'M') ++numberOfMushroom;

                if(usedCells[i][j]){
                    isOverlaping = true;
                    break outerLoop;
                }
            }
        }

        return numberOfTomatoes >= info.minIngredients && numberOfMushroom >= info.minIngredients && !isOverlaping;
    }
}
