package Nodes;

public class NodeAvl
{
    public int data;
    public int height;
    public NodeAvl left;
    public NodeAvl right;
    public NodeAvl(int data)
    {
        this.data = data;
        this.height = 1;
    }
}