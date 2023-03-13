package Base;
public class NodeAvl
{
    public int data;
    public int height;
    public NodeAvl left;
    public NodeAvl right;

    public NodeAvl(int data) //constructor for NodeAvl
    {
        this.data = data; //set data
        this.height = 1; //set height to 1
    }
}