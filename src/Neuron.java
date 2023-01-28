import java.util.*;

public class Neuron
{
    public byte value;
    public byte weight;
    public byte bias;
    public Set<Neuron> motherNeurons;
    public Neuron[] nextNeurons;

    //Constructor for in Neurons
    public Neuron(byte _value, byte _weight, byte _bias, Neuron[] _next)
    {
        value = _value;
        weight = _weight;
        bias = _bias;
        motherNeurons = new HashSet<>();
        nextNeurons = _next;
    }

    //Constructor for hidden Neurons
    public Neuron(byte _weight, byte _bias, Neuron[] _mothers, Neuron[] _next)
    {
        weight = _weight;
        bias = _bias;
        motherNeurons = new HashSet<>(Arrays.asList(_mothers));
        nextNeurons = _next;
        value = computeValue();
    }

    //Constructor for out Neurons
    public Neuron(byte _bias, Neuron[] _mothers)
    {
        bias = _bias;
        motherNeurons = new HashSet<>(Arrays.asList(_mothers));
        value = computeValue();
    }

    public byte computeValue()
    {
        byte _result = -127;
        for (Neuron mother : motherNeurons)
        {
            _result += mother.weight;
        }
        return (byte) (_result/motherNeurons.size());
    }

    public void fire()
    {
        if (value >= bias)
        {
            for (Neuron next : nextNeurons)
            {
                next.value = (byte) ((next.value + weight)/2);
            }
        }
    }
}