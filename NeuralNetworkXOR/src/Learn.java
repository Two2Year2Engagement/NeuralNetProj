
public class Learn {
	private double learnCoef;
	private double[][] train;
	
	public Learn(double coef){
		learnCoef = coef;
		train = new double[][]{{1, 1, 0}, {0, 0, 0}, {1, 0, 1}, {0, 1, 1}};
	}
	
	public void errorOut(Neuron[] out, Neuron[] hid, double target){
		for(int i =0;i < out.length;i++){
			double output = out[i].getOutput();
			double error = output*(1 - output)*(target - output);
			out[i].setError(error);
			for(int j = 0;j < out[i].getWeight().length;i++){
				out[i].setErrorWeight(out[i].getErrorWeightI(j), j);
				double weight = out[i].getWeightI(j) + learnCoef*error*hid[j].getOutput();
				out[i].setWeightI(weight, j);
			}
		}
	}
	
	public void errorHid(Neuron[] hid, Neuron[] in, Neuron[] out){
		double[] sum = sum(hid, out);
		for(int j = 0;j < hid.length;j++){
			double output = hid[j].getOutput()*sum[j];
			double error = output*(1 - output);
			for(int k = 0;k < hid[j].getWeight().length;k++){
				double weight = hid[j].getWeightI(k) + learnCoef*error*in[k].getOutput();
				hid[j].setWeightI(weight, k);
			}
			
		}
	}
	
	public double[] sum(Neuron[] hid, Neuron[] out){
		double[] sum = new double[out.length];
		for(int j = 0;j < hid.length;j++){
			for(int i = 0;i < out.length;i++){
				sum[j] = sum[j] + out[i].getErrorWeightI(j);
			}
		}
		return sum;
	}
	
	public void train(){
		
	}

}
