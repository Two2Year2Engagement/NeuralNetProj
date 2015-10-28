/*
 * naomijubs
 * Output Neuron of a XOR Neural Network
 * */

package NeuralNetworkXOR;

import java.util.Random;

public class OutNeuron {
	private double[] input;
	private double output;
	private double[] weight;
	private double error;

	public OutNeuron(){
		Random rg = new Random();
		input = new double[2];
		output = -1;
		error = 0;
		weight = new double[2];
		for(int i = 0;i < 2;i++){
			//Valores entre -1 e 1 para os pesos iniciais
			weight[i] = rg.nextInt(2)*2 - 1; 
		}
	}

	public void setInput(HidNeuron[] hid) {
		for(int i = 0;i < 2;i++){
			input[i] = hid[i].getOutput();
		}
	}

	public double getOutput() {
		return output;
	}

	public void output() {
		double sum = weight[0]*input[0] + weight[1]*input[1];
		output = Math.tanh(sum);
	}

	public double[] getWeight() {
		return weight;
	}

	public void setWeight(double[] weight) {
		this.weight = weight;
	}
	
	public double getWeightI(int i){
		return weight[i];
	}
	
	public void setWeightI(double weight, int i){
		this.weight[i] = weight;
	}

	public double getError(){
		return error;
	}
	
	public void setError(double error){
		this.error = error;
	}
}
