package NeuralNetworkXOR;

/*
 * naomijubs
 * Training a XOR Neural Network
 * */

public class Learn {
	private double[][] training;
	public double learnCoef;
	
	public Learn(double learnCoef){
		training = new double[][]{{1, 1, 0}, {0, 0, 0}, {1, 0, 1}, {0, 1, 1}};
		this.learnCoef = learnCoef;
	}
	
	public void train(InNeuron[] in, HidNeuron[] hid, OutNeuron out){
		double error = 10;
		while(error > 0.01){
			double errorStep = 0;
			for(int i = 0;i < 4;i++){
				System.out.println();
				System.out.println("IN: "+training[i][0]+" "+training[i][1]+" Out: "+training[i][2]);
				double result = 0;
				in[0].setIn(training[i][0]);
				in[1].setIn(training[i][1]);
				hid[0].setInput(in); hid[0].output();
				hid[1].setInput(in); hid[1].output();
				out.setInput(hid); out.output();
				result = training[i][2] - Math.abs(out.getOutput());
				//System.out.println("Expected: "+training[i][2]+" Obtained: "+out.getOutput());
				errorStep = errorStep +Math.pow(result, 2.0);
				errorOut(hid, out, training[i][2]);
				errorHid(in, hid, out);
			}
			error = errorStep / 2;
			//System.out.println("Error: "+error);
		}
	}
	
	public double errorOut(HidNeuron[] hid, OutNeuron out, double target){
		double output = out.getOutput();
		//System.out.println("Output: "+output);
		double error = output*(1 - output)*(target - output);
		//System.out.println("Error: "+error);
		out.setError(error);
		for(int j = 0;j < 2;j++){
			 double weightPartial = out.getWeightI(j) + learnCoef*error*hid[j].getOutput();
			 //System.out.println("Weight Prev: "+out.getWeightI(j));
			 out.setWeightI(weightPartial, j);
			 //System.out.println("Weight: "+weightPartial);
		}
		return error;
	}
	
	public void errorHid(InNeuron[] in, HidNeuron[] hid, OutNeuron out){
		for(int i = 0;i < 2;i++){
			double output = hid[i].getOutput();
			double error = output*(1 - output)*out.getError()*(out.getWeightI(i)*in[i].getInput());
			for(int j = 0;j < 2;j++){
				double weight = hid[i].getWeightI(j) + learnCoef*error*in[j].getInput();
				hid[j].setWeightI(weight, j);
			}
		}
	}
}
