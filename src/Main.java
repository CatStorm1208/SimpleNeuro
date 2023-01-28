public class Main
{
    static Neuron[] fourth;
    static Neuron[] third;
    static Neuron[] second;
    public static Neuron[] first;

    public static void main(String[] args)
    {
        init();
        for (Neuron neuron : first)
        {
            neuron.fire();
            System.out.println(first[0].value);
        }
        for (Neuron neuron : second)
        {
            neuron.fire();
            System.out.println(second[0].value);
        }
        for (Neuron neuron : third)
        {
            neuron.fire();
            System.out.println(third[0].value);
        }
        for (Neuron neuron : fourth)
        {
            neuron.fire();
            System.out.println(fourth[0].value);
        }
    }

    static void init()
    {
        first = new Neuron[]{new Neuron((byte) -17, (byte)-29, (byte)-26, second)};
        second = new Neuron[]{new Neuron((byte)-32, (byte)-69, first, third)};
        third = new Neuron[]{new Neuron((byte)-35, (byte)-42, second, fourth)};
        fourth = new Neuron[]{new Neuron((byte)-5, third)};
    }
}