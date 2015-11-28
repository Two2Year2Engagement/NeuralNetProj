package NeuralNetworkXOR;

/*
 * naomijubs
 * Make it do it XOR Neural Network
 * */
import java.util.Scanner;


public class Think {
	private double output;
	
	public Think(){
		output = -1;
	}
	
	public void think(InNeuron[] in, HidNeuron[] hid, OutNeuron out){
		Scanner sc = new Scanner(System.in);
		double in1 = 0;
		double in2 = 0;
		
		System.out.println("Digite o primeiro numero: (0 / 1)");
		in1 = sc.nextDouble();
		in[0].setIn(in1);
		System.out.println("Digite o segundo numero: (0 / 1)");
		in2 = sc.nextDouble();
		in[1].setIn(in2);
		hid[0].setInput(in); hid[0].output();
		hid[1].setInput(in); hid[1].output();
		out.setInput(hid); out.output();
		
		output = out.getOutput();
		System.out.println("O resultado é: "+Math.round(Math.abs(output)));
		
	}

}
