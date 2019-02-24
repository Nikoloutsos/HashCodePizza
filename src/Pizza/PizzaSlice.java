package Pizza;

/**
 * A pizza slice is always a rectangle.
 */
public class PizzaSlice {
    public int r1,c1;
    public int r2,c2;

    public PizzaSlice(int r1, int c1, int r2, int c2) {
        this.r1 = r1;
        this.c1 = c1;
        this.r2 = r2;
        this.c2 = c2;
    }

    public int size(){
        return (Math.abs(r1-r2)+1)*(Math.abs(c1-c2)+ 1);
    }


}
