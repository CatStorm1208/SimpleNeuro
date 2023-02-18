import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/* TODOs
 * TODO Make the init function pull from files
 * TODO Training class
*/

public class Main
{
    public static InNeuron[] Layer1 = new InNeuron[16];
    public static HiddenNeuron[] Layer2 = new HiddenNeuron[5];
    public static OutNeuron[] Layer3 = new OutNeuron[3];

    public static void main(String[] args) throws IOException
    {
        System.out.println(Files.readString(Paths.get("")));
        //init();
        //run();
    }

    public static void init()
    {
        for (int n = 0; n < Layer3.length; n++)
        {
            Layer3[n] = new OutNeuron();
            //Layer3[n].bias =
        }

        for (int n = 0; n < Layer2.length; n++)
        {
            Layer2[n] = new HiddenNeuron();
            for (int m = 0; m < Layer2[n].links.length; m++)
            {
                Layer2[n].links[m].out = Layer3[m];
            }
        }

        for (int n = 0; n < Layer1.length; n++)
        {
            Layer1[n] = new InNeuron();
            for (int m = 0; m < Layer1[n].links.length; m++)
            {
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