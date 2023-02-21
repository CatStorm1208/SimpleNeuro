public class InNeuron extends Neuron
{
    public static NeuroLink[] links = new NeuroLink[5];

    public InNeuron()
    {
        for (int n = 0; n < links.length; n++)
        {
            links[n] = new NeuroLink();
        }
    }

    public void fire()
    {
        if (value >= 128)
        {
            value = 127;
        }
        else if (value <= -129)
        {
            value = -128;
        }

        if (value >= bias)
        {
            for (NeuroLink link : links)
            {
                if (link.out != null) link.out.value += link.weight;
            }
        }
    }
}