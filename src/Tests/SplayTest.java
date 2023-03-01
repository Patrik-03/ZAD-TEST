package Tests;
import Nodes.NodeSplay;

public class SplayTest {
    public static class SplayTreeChecker {

        public boolean isSplayTree(NodeSplay root)
        {
            return !isSplayTreeUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        public boolean isSplayTreeUtil(NodeSplay node, int minVal, int maxVal)
        {
            // If the node is null, it satisfies the splay tree property by default
            if (node == null) {return true;}
            // Check if the node's key value is within the range of minVal and maxVal
            if (node.data < minVal || node.data > maxVal) {return false;}
            // Check if the node's left child has a key value smaller than the node's key value
            if (node.left != null && node.left.data > node.data) {return false;}
            // Check if the node's right child has a key value greater than the node's key value
            if (node.right != null && node.right.data < node.data) {return false;}
            // Recursively check the left and right subtrees
            return isSplayTreeUtil(node.left, minVal, node.data) && isSplayTreeUtil(node.right, node.data, maxVal);
        }
    }
}