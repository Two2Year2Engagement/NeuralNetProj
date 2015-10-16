/*
 * naomijubs
 * Neuron of a Neural Network
 * */


import java.util.Random;

public class Neuron {
	private double error; 
	private double[] weight;
	private double[] errorWeight;
	private double output;
	private double sum;
	
	public Neuron(int numIn){
		Random rg = new Random();
		sum = 0;
		weight = new double[numIn];
		errorWeight = new double[numIn];
		for(int i = 0;i < numIn;i++){
			//Valores entre -1 e 1 para os pesos iniciais
			weight[i] = (rg.nextInt(301) - 150) / 150; 
		}
	}

	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}
	
	public double getWeightI(int i){
		return weight[i];
	}
	
	public void setWeightI(double weight, int i){
		this.weight[i] = weight;
	}

	public double[] getWeight() {
		return weight;
	}

	public void setWeight(double[] weight) {
		this.weight = weight;
	}

	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}
	
	
	public double getErrorWeightI(int i) {
		return errorWeight[i];
	}

	public void setErrorWeight(double errorWeight, int i) {
		this.errorWeight[i] = errorWeight;
	}

	public void sum(double[] input){
		for(int i = 0;i < input.length; i++){
			sum = sum + input[i]*weight[i];
		}
	}
	
	public void output(double[] input){
		output = Math.tanh(sum);		
	}
	
}
