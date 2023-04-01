# Cellular-Automata

Fully customizable filter, rate, size, and activation function in Main.java

# Filter
      float[][] filter = {
          {0.3f, 0.2f, -0.3f}, 
          {0.4f, 0.1f, -0.2f},
          {0.5f, 0f, -0.1f}
      };
      
A pixel value is first calculated by having a dot product of the pixel and its neighbors to the filter

# Activation Function
    public float calculate(float val) {
        val = 2 * ((float)Math.pow(val - 0.5, 2));
        return Math.max(0, Math.min(1, val));
    }

After the value is calculated, it goes through the activation function. Note that the value must be between 0 and 1 (As seen by the return)

# ETC
      AVG_AUTO runner = new AVG_AUTO( 
        0.01f, 1000, 800, 
        filter, new Activation());

Parameters can be as follows:
- seed (optional)
- ratio (percent of board to be filled)
- width
- height
