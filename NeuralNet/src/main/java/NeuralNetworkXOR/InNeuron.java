/*
 * naomijubs
 * Input Neuron of a XOR Neural Network
 * */

package NeuralNetworkXOR;

public class InNeuron {
	private double input;
	
	public InNeuron(){
		input = -1;
	}

	public double getInput() {
		return input;
	}

	public void setIn(double input) {
		this.input = input;
	}
	
}
