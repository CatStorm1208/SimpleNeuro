public class OutNeuron extends Neuron
{
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
    }
}