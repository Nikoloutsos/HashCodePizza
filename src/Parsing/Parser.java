package Parsing;

import java.io.BufferedReader;
import java.io.FileReader;

public class Parser {
    private static int rows, columns, minIngredients, maxIngredients;
    private static char[][] ingredients;

    public static Data readFromFile() {
        String fileName = "C:\\Users\\KwstasNiks\\IdeaProjects\\PizzaSlicer\\src\\Parsing\\d_big.in";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            createVariables(line);
            ingredients = new char[rows][columns];
            int rowCounter = 0;
            int columnCounter = 0;

            while ((line = br.readLine()) != null) {
                char current;
                for (int i = 0; i < line.length(); i++) {
                    current = line.charAt(i);
                    ingredients[rowCounter][columnCounter++] = current;
                }
                columnCounter = 0;
                rowCounter++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new Data(rows, columns, minIngredients, maxIngredients, ingredients);
    }

    private static void createVariables(String line) {
        String[] generalInfo = line.split(" ");
        rows = Integer.parseInt(generalInfo[0]);
        columns = Integer.parseInt(generalInfo[1]);
        minIngredients = Integer.parseInt(generalInfo[2]);
        maxIngredients = Integer.parseInt(generalInfo[3]);
    }

}
