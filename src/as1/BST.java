package as1;

/**
 * This class represent a Binary Tree
 *
 * @author Wei Liu 3718446
 */
public class BST<T extends Comparable<T>> {
    private BSTNode<T> root;

    /**
     * A constructor
     */
    public BST() {
        root = null;
    }

    public void insert(T key) throws IllegalArgumentException {
        if (root == null)
            root = new BSTNode<>(key);
        else
            root.insert(key);
    }

    public void displayPreOrder() {
        System.out.println("** Begin Preorder display **");
        if (root != null)
            root.displayPreOrder(" ");
        System.out.println();
        System.out.println("*** End Preorder display ***");
    }

    public void displayInOrder() {
        System.out.println("** Begin Inorder display **");
        if (root != null)
            root.displayInOrder(" ");
        System.out.println();
        System.out.println("*** End Inorder display ***");
    }

    public void displayPostOrder() {
        System.out.println("** Begin Postorder display **");
        if (root != null)
            root.displayPostOrder(" ");
        System.out.println();
        System.out.println("*** End Postorder display ***");
    }


    /**
     * Delete a node
     * Step1.find the node
     *  case1: the left and right are null
     *  case2: has only one child
     *  Case3: has two children
     */
    public BSTNode<T> delete(T key) {
        BSTNode<T> parent = root;
        BSTNode<T> current = root;
        boolean isLeftChild = false;
        // Search the deleted node and check if this node has left child
        while (key.compareTo(current.getNode()) != 0) {
            parent = current;
            if (key.compareTo(current.getNode()) < 0) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }

            if (current == null) {
                return null;
            }
        }

        // Case1: the left and right are null
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }

            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

            // Case2: has one child
            // on the lest
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
            // Case2: has one child
            // on the right
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setRight(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        // Case3: has two children
        else if (current.getLeft() != null && current.getRight() != null) {
            // Find the successor of the deleted node
            BSTNode<T> successor = getDeleteSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return current;
    }

    private BSTNode<T> getDeleteSuccessor(BSTNode<T> deleteNode) {
        BSTNode<T> successor = null;
        BSTNode<T> successorParent = null;
        BSTNode<T> current = deleteNode.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        // Check if the successor has right child
        //If it has, replace the left child of successor's parent with the right child of successor
        if (successor != deleteNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }
        return successor;
    }

    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                '}';
    }
}//End the class
