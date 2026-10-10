public class Array2D {

    private final int rows, cols;
    private final int[][] data;

    public Array2D(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    private void check(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols)
            throw new IndexOutOfBoundsException("Index out of range");
    }

    public void set(int r, int c, int value) {
        check(r, c);
        data[r][c] = value;
    }

    public int get(int r, int c) {
        check(r, c);
        return data[r][c];
    }

    public int rowSum(int r) {
        int sum = 0;
        for (int j = 0; j < cols; j++) sum += data[r][j];
        return sum;
    }

    public int colSum(int c) {
        int sum = 0;
        for (int i = 0; i < rows; i++) sum += data[i][c];
        return sum;
    }

    public Array2D transpose() {
        Array2D t = new Array2D(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                t.data[j][i] = data[i][j];
        return t;
    }

    public void display() {
        for (int[] row : data) {
            for (int v : row) System.out.printf("%4d", v);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Array2D a = new Array2D(2, 3);
        int n = 1;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                a.set(i, j, n++);
        System.out.println("Matrix:");
        a.display();
        System.out.println("Row 0 sum: " + a.rowSum(0) + " | Col 1 sum: " + a.colSum(1));
        System.out.println("Transpose:");
        a.transpose().display();
    }
}
