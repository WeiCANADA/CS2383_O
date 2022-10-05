package as2;

/**
 * @author Wei Liu 3718446
 */
public class AVLTree<T extends Comparable<? super T>> {


    private static class Node<T> {
        private T value;
        Node<T> left;
        Node<T> right;
        int height = 0;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;

    public AVLTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);

    }

    private Node<T> insert(Node<T> node, T value) {

        if(node == null) return new Node<>(value, null, null);

        int i = value.compareTo(node.value);
        if (i < 0) {
            node.left = insert(node.left, value);
            if (height(node.left) - height(node.right) == 2)
                if (value.compareTo(node.left.value) < 0)//L+L type
                    node = rR(node);
                else                                    //L+R type(rL + rR)
                    node = doubleLeft(node);

        }

        if (i > 0) {
           node.right  = insert(node.right, value);
            if (height(node.right) - height(node.left) == 2) {
                if (value.compareTo(node.right.value) > 0)//R+R type
                    node = rL(node);
                else                                    //R+L type (rR + rL)
                    node = doubleRight(node);
            }

        }

        node.height = Math.max(height(node.left), height(node.right));
        return node;
    }

    // For L+R using RL then RR
    private Node<T> doubleLeft(Node<T> node) {
        node.left = rL(node.left);
        return rR(node);

    }

    //For R+R using RL
    private Node<T> rL(Node<T> node) {
        Node<T> right = node.right;
        node.left = right.left;
        right.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        right.height = Math.max(height(right.right), node.height) + 1;
        return right;
    }

    private Node<T> doubleRight(Node<T> node) {
        node.right = rR(node.right);
        return rL(node);
    }

    //For LL
    private Node<T> rR(Node<T> node) {
        Node<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        left.height = Math.max(height(left.right), node.height) + 1;
        return left;
    }

    private int height(Node<T> node) {
        return node == null ? 0: node.height;
        //return node == null ? 0: (Math.max(height(node.right),height(node.left) ) + 1);
    }

    public void inorder() {
        if (root != null)
            inorder(root);
    }

    private void inorder(Node<T> node) {
        if (node.left != null) inorder(node.left);
        System.out.print(node.value + ", ");
        if (node.right != null) inorder(node.right);

    }

    public void preorder() {
        if (root != null)
            preorder(root);
    }

    private void preorder(Node<T> node) {
        System.out.print(node.value + ", ");
        if (node.left != null) preorder(node.left);
        if (node.right != null) preorder(node.right);

    }

    public void postorder() {
        if (root != null)
            postorder(root);
    }

    private void postorder(Node<T> node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        System.out.print(node.value + ", ");

    }

    public static void main(String[] args) {
        AVLTree<Integer> integerAVLTree = new AVLTree<>();

        int[] intsArray = { 40, 20, 10, 25, 30, 22, 50 };
        for (int i : intsArray) {
            integerAVLTree.insert(i);
        }
        System.out.println("Inorder:");
        integerAVLTree.inorder();
        System.out.println(
        );

        System.out.println("Preorder:");
        integerAVLTree.preorder();
        System.out.println();

        System.out.println("Postorder:");
        integerAVLTree.postorder();
    }
}
