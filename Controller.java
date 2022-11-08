public class Controller {


    public static void main(String[] args){


        NeuralNetwork network = new NeuralNetwork();
        network.initializeNeuralNetwork();
        //network.print();
        double inputs[] = {4, 5};
        System.out.println(network.Classify(inputs));
        
    }
    
}
