public class Main {
    public static void main(String[] args) {
        float[][] filter = {
            {0.3f, 0.2f, -0.3f},
            {0.4f, 0.1f, -0.2f},
            {0.5f, 0f, -0.1f}
        };
        AVG_AUTO runner = new AVG_AUTO( 0.01f, 1000, 800, filter, new Activation());
        new AUTO_DISPLAY(runner);
    }
}

class Activation {
    public Activation() {}
    public float calculate(float val) {
        val = 2 * ((float)Math.pow(val - 0.5, 2));
        return Math.max(0, Math.min(1, val));
    }
}