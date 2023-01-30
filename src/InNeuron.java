public class InNeuron extends Neuron
{
    public NeuroLink[] links = new NeuroLink[15];

    public void fire()
    {
        if (value >= bias)
        {
            for (NeuroLink link : links)
            {
                link.out.value += link.weight;
            }
        }
    }
}