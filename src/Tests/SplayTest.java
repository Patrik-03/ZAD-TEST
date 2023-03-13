package Tests;
import Base.NodeSplay;

public class SplayTest
{
    public static class SplayTreeChecker
    {
        public boolean isSplayTree(NodeSplay root)
        {
            if(root == null)
            {
                return true;
            }
            if(root.left != null && root.left.data > root.data)
            {
                return false;
            }
            if(root.right != null && root.right.data < root.data)
            {
                return false;
            }
            return isSplayTree(root.left) && isSplayTree(root.right);
        }
    }
}