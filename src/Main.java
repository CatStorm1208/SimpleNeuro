import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* TODOs
 * TODO Training class
*/

public class Main
{
    public static InNeuron[] Layer1 = new InNeuron[16];
    public static HiddenNeuron[] Layer2 = new HiddenNeuron[5];
    public static OutNeuron[] Layer3 = new OutNeuron[3];

    public static void main(String[] args) throws IOException
    {
        init();
        run();
    }

    public static void init() throws IOException, NullPointerException
    {
        for (int n = 0; n < Layer3.length; n++)
        {
            Layer3[n] = new OutNeuron();
            Layer3[n].bias = new Scanner(new File("src/Data/Layer3/Bias/_" + n).toURL().openStream()).nextShort();
            Layer3[n].value = new Scanner(new File("src/Data/Layer3/Value/_" + n).toURL().openStream()).nextShort();
        }

        for (int n = 0; n < Layer2.length; n++)
        {
            Layer2[n] = new HiddenNeuron();
            Layer2[n].bias = new Scanner(new File("src/Data/Layer2/Bias/_" + n).toURL().openStream()).nextShort();
            Layer2[n].value = new Scanner(new File("src/Data/Layer2/Value/_" + n).toURL().openStream()).nextShort();

            for (int m = 0; m < Layer2[n].links.length; m++)
            {
                Layer2[n].links[m].out = Layer3[m];
                Layer2[n].links[m].weight = new Scanner(new File("src/Data/Layer2/Links/_" + n + "/_" + m).toURL().openStream()).nextShort();
            }
        }

        for (int n = 0; n < Layer1.length; n++)
        {
            Layer1[n] = new InNeuron();
            Layer1[n].bias = new Scanner(new File("src/Data/Layer1/Bias/_" + n).toURL().openStream()).nextShort();
            Layer1[n].value = new Scanner(new File("src/Data/Layer1/Value/_" + n).toURL().openStream()).nextShort();

            for (int m = 0; m < Layer1[n].links.length; m++)
            {
                Layer1[n].links[m].out = Layer2[m];
                Layer1[n].links[m].weight = new Scanner(new File("src/Data/Layer1/Links/_" + n + "/_" + m).toURL().openStream()).nextShort();
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