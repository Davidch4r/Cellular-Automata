import java.util.Random;

public class AVG_AUTO {
    public final int WIDTH;
    public final int HEIGHT;
    private float[][] board;
    private float[][] nextBoard;
    private final Activation activation;
    private final float[][] filter;
    private static Random rand = new Random();
    public AVG_AUTO(long seed, float ratio, int WIDTH, int HEIGHT, float[][] filter, Activation activation) {
        rand = new Random(seed);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.filter = filter;
        this.activation = activation;
        initBoard(ratio);
    }
    public AVG_AUTO(float ratio, int WIDTH, int HEIGHT, float[][] filter, Activation activation) {
        this(rand.nextLong(), ratio, WIDTH, HEIGHT, filter, activation);
    }
    private void initBoard(float ratio) {
        this.board = new float[HEIGHT][WIDTH];
        this.nextBoard = new float[HEIGHT][WIDTH];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (rand.nextFloat() <= ratio) {
                    board[i][j] = 1.0f;
                }
            }
        }
    }

    public void nextInstance() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                float sum = 0.0f;
                int n = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int px = j + x;
                        int py = i + y;
                        if (px < 0) {
                            px = WIDTH - 1;
                        } else if (px >= WIDTH) {
                            px = 0;
                        }
                        if (py < 0) {
                            py = HEIGHT - 1;
                        } else if (py >= HEIGHT) {
                            py = 0;
                        }
                        sum += board[py][px] * filter[y + 1][x + 1];
                    }
                }
                nextBoard[i][j] = activation.calculate(sum);
            }
        }
        board = nextBoard.clone();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            s.append("{ ");
            for (int j = 0; j < board[i].length; j++) {
                s.append(board[i][j]).append(", ");
            }
            s.append("}\n");
        }

        return s.toString();
    }
    public float[][] getBoard() {
        return board;
    }
}
