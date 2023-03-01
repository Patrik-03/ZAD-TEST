package Tests;
import Nodes.NodeAvl;
import Trees.AvlTree;
public class AvlTest
{
    public static class AvlTreeChecker
    {
        public AvlTree bal = new AvlTree();

        public boolean isBalanced(NodeAvl node) {
            if (node == null) //if node is null
            {
                return true; //return true
            }
            if (Math.abs(bal.BF(node)) > 1) //if balance factor is less than or equal to 1 and left and right subtrees are balanced
            {
                return false; //return true
            }
            return (node.left == null || isBalanced(node.left)) && (node.right == null || isBalanced(node.right)); //return false
        }
    }
}
