public class HiddenNeuron extends Neuron
{
    public NeuroLink[] links = new NeuroLink[9];

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