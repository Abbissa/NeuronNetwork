import java.util.Arrays;

public class NeuralLayer {

    double[][] weights;
    int nodes;
    int in;

    public NeuralLayer(int in, int nodes) {
        this.in = in;
        this.nodes = nodes;
        weights = new double[nodes][in + 1];
        initializeWeights();
    }

    public void initializeWeights() {

        for (int i = 0; i < this.nodes; i++) {
            for (int j = 0; j < this.in + 1; j++) {

                weights[i][j] = 1;

            }
        }
    }

    public double[] CalculateOutputs(double[] inputs) {
        System.out.println(Arrays.toString(inputs));
        
        double[] activations = new double[nodes];
        for (int i = 0; i < nodes; i++) {

            double output = 0;
            for (int j = 0; j < weights[i].length-1; j++) {

                output += weights[i][j] * inputs[j];

            }
            output += weights[i][weights[i].length-1];
            activations[i] = ActivationFunction(output);

        }
        return activations;

    }

    private double ActivationFunction(double output) {
        
        return output>0? output : 0;
        //return output;
        //return 1 / (1 + Math.exp(-output));
    }

    public double NodeCost(double output, double expectedOutput) {
        double error = output - expectedOutput;
        return error * error;
    }

    public void print() {

        for (double[] ds : weights) {
            for (double d : ds) {
                System.out.print(" "+ d);  
            }
            System.out.println();
        }
    }

}