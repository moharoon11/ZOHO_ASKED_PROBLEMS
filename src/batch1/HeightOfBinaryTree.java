package batch1;

public class HeightOfBinaryTree {

    public class Node {

        int data;
        Node left;
        Node right;
    }
    int height(Node node)
    {
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}
