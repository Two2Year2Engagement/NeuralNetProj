package NeuralNetworkXOR;

/*
 * naomijubs
 * XOR Neural Network running app
 * */
public class App 
{
    public static void main( String[] args )
    {
    	InNeuron[] in = new InNeuron[2];
    	HidNeuron[] hid = new HidNeuron[2];
    	OutNeuron out = new OutNeuron();
    	Learn learn = new Learn(0.7);
    	Think think = new Think();
    	
    	for(int i = 0;i < 2;i++){
    		in[i] = new InNeuron();
    		hid[i] = new HidNeuron();
    	}
    	
    	learn.train(in, hid, out);
    	think.think(in, hid, out);
        
    }
}
