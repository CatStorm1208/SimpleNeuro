import java.util.Random;

/** section for TODOs
 * TODO Make the init class pull from files
 * TODO Make Sure, that output doesn't always escalate NOTE: this may not be a bug but the regular behavior
 * TODO Make sure, that outputs on
*/

public class Main
{
    public static InNeuron[] Layer1 = new InNeuron[16];
    public static HiddenNeuron[] Layer2 = new HiddenNeuron[5];
    public static OutNeuron[] Layer3 = new OutNeuron[3];

    public static void main(String[] args)
    {
        init();
        run();
    }

    public static void init()
    {
        for (int n = 0; n < Layer3.length; n++)
        {
            Layer3[n] = new OutNeuron();
            Layer3[n].bias = (short) ((short) new Random().nextInt(128-(-127)) - 128);
        }

        for (int n = 0; n < Layer2.length; n++)
        {
            Layer2[n] = new HiddenNeuron();
            Layer2[n].bias = (short) ((short) new Random().nextInt(128-(-127)) - 128);
            for (int m = 0; m < Layer2[n].links.length; m++)
            {
                Layer2[n].links[m].weight = (short) ((short) new Random().nextInt(128-(-127)) - 128);
                Layer2[n].links[m].out = Layer3[m];
            }
        }

        for (int n = 0; n < Layer1.length; n++)
        {
            Layer1[n] = new InNeuron();
            Layer1[n].bias = (short) ((short) new Random().nextInt(128-(-127)) - 128);
            Layer1[n].value = (short) ((short) new Random().nextInt(128-(-127)) - 128);
            for (int m = 0; m < Layer1[n].links.length; m++)
            {
                Layer1[n].links[m].weight = (short) ((short) new Random().nextInt(128-(-127)) - 128);
                Layer1[n].links[m].out = Layer2[m];
            }
        }
    }

    public static void run()
    {
        for (InNeuron neuron : Layer1)
        {
            neuron.fire();
            System.out.print(neuron.value + " ");
        }
        System.out.println();

        for (HiddenNeuron neuron : Layer2)
        {
            neuron.fire();
            System.out.print(neuron.value + " ");
        }
        System.out.println();

        for (OutNeuron neuron : Layer3)
        {
            neuron.fire();
            System.out.print(neuron.value + " ");
        }
    }
}