import java.util.Scanner;

public class NeuralNetwork {

    public NeuralLayer[] layers;
    int input_nodes = 0;

    public void initializeNeuralNetwork() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduzca el numero de capas");
            int n = sc.nextInt();
            layers = new NeuralLayer[n-1];
            int pre = 0;
            for (int i = 0; i < n; i++) {
                System.out.println("Indique el numero de nodos de la capa " + (i + 1));
                int aux = sc.nextInt();
                if (input_nodes != 0) {
                    layers[i-1] = new NeuralLayer(pre, aux);

                } else {
                    input_nodes = aux;
                }
                pre = aux;

            }
        }
    }

    double[] CalculateOutputs(double[] inputs) {
        if (inputs.length != input_nodes) {
            System.out.println("Error");
            inputs = null;
        } else
            for (NeuralLayer layer : layers) {
                inputs = layer.CalculateOutputs(inputs);

            }
        return inputs;
    }

    public int Classify(double[] inputs) {
        double[] output = CalculateOutputs(inputs);
        if (output != null)
            return IndexOfMaxValue(output);
        return -1;
    }

    private int IndexOfMaxValue(double[] output) {
        double maxValue = output[0];
        int indexOfMaxValue = 0;

        for (int i = 1; i < output.length; i++) {
            if (maxValue < output[i]) {
                maxValue = output[i];
                indexOfMaxValue = i;
            }
        }
        System.out.println(output[indexOfMaxValue]);
        return indexOfMaxValue;
    }

    public void print() {

        for (NeuralLayer neuralLayer : layers) {
            neuralLayer.print();
        }

    }

}
