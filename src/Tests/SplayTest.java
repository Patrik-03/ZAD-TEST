package Tests;
import Base.NodeSplay;

public class SplayTest
{
    public static class SplayTreeChecker
    {
        public boolean isSplayTree(NodeSplay root) //check if tree is a splay tree
        {
            if(root == null) //if root is null
            {
                return true; //return true
            }
            if(root.left != null && root.left.data > root.data) //if root left is not null and root left data is greater than root data
            {
                return false; //return false
            }
            if(root.right != null && root.right.data < root.data) //if root right is not null and root right data is less than root data
            {
                return false; //return false
            }
            return isSplayTree(root.left) && isSplayTree(root.right); //return recursive call to isSplayTree
        }
    }
}