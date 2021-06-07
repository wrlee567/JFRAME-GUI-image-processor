public class dubl {
    public int[][] predict;
    public int[][] differ;

    public dubl(int[][] predict, int[][] differ) {
        this.predict = predict;
        this.differ = differ;

    }

    public int[][] getArray1() {
        return predict;
    }

    public int[][] getArray2() {
        return differ;
    }
}