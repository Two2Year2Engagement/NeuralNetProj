/*
 * naomijubs
 * Hidden Neuron of a XOR Neural Network
 * */

package NeuralNetworkXOR;

import java.util.Random;

public class HidNeuron {
	private double[] input;
	private double output;
	private double[] weight;

	public HidNeuron(){
		Random rg = new Random();
		input = new double[2];
		output = -1;
		weight = new double[2];
		for(int i = 0;i < 2;i++){
			//Valores entre -1 e 1 para os pesos iniciais
			weight[i] = rg.nextInt(2)*2 - 1; 
			//System.out.println("Hid Weight "+i+" = "+weight[i]);
		}
	}

	public void setInput(InNeuron[] in) {
		for(int i = 0;i < 2;i++){
			input[i] = in[i].getInput();
		}
	}

	public double getOutput() {
		return output;
	}

	public void output() {
		double sum = weight[0]*input[0] + weight[1]*input[1];
		output = Math.tanh(sum);
		System.out.println("Weight 0: "+weight[0]+" weight 1: "+weight[1]);
		System.out.println("Hid Output: "+output);
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
}
