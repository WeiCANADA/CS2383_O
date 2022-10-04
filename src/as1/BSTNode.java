package as1;

/**
 * This class represent a Binary Tree Node
 *
 * @author Wei Liu 3718446
 */
public class BSTNode<T extends Comparable<T>> {
    // instance variables

    private T node;
    private BSTNode<T> left, right;
    // constructor

    public BSTNode(T key) {
        this.node = key;
        this.left = null;
        this.right = null;
    }

    // methods

    public void setNode(T node) {
        this.node = node;
    }

    public T getNode() {
        return node;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    /**
     * Display the subtree rooted in Preorder DLR
     */
    public void displayPreOrder(String indent) {
        System.out.print(indent + node);
        if (left != null)
            left.displayPreOrder(indent);
        if (right != null)
            right.displayPreOrder(indent);

    }

    /**
     * Display the subtree rooted in Inorder LDR
     */
    public void displayInOrder(String indent) {

        if (left != null)
            left.displayInOrder(indent);
        System.out.print(indent + node);
        if (right != null)
            right.displayInOrder(indent);
    }

    /**
     * Display the subtree rooted in Postorder LRD
     */
    public void displayPostOrder(String indent) {
        if (left != null)
            left.displayPostOrder(indent);
        if (right != null)
            right.displayPostOrder(indent);
        System.out.print(indent + node);
    }

    /**
     * Inserts a given  node into the subtree which is that all smaller values
     * go into the left subtree, and all larger values go into the right subtree.
     */
    public void insert(T newKey) {

        // if the node to be inserted less than or equal the node in this node...
        if (newKey.compareTo(node) <= 0) {    // ...then insert into the left subtree.
            // First check to see if the insertion
            // should happen right here.
            if (left == null)
                left = new BSTNode<>(newKey);
            else
                left.insert(newKey);
        } else {    // ...otherwise insert into the right subtree.
            // First check to see if the insertion should
            // happen right here.
            if (right == null)
                right = new BSTNode<>(newKey);
            else
                right.insert(newKey);
        }// end if (node comparison)

    } // end insert method

    @Override
    public String toString() {
        return "BSTNode{" +
                "node=" + node +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


} // end class
