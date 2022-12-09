import java.util.*;

public class BinaryTrees {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {

        private static int id = -1;

        // build using pre-order
        public Node buildTree(int[] nodes) {
            id++;
            if (nodes[id] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[id]);
            newNode.left = buildTree(nodes);

            newNode.right = buildTree(nodes);
            return newNode;
        }

        public void preOrderTraversal(Node node) {
            if (node == null) {
                System.out.print("-1" + " ");
                return;
            }

            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);

        }

        public void inOrderTraversal(Node node) {
            if (node == null) {
                System.out.print("-1" + " ");
                return;
            }
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);

        }

        public void postOrderTraversal(Node node) {
            if (node == null) {
                System.out.print("-1" + " ");
                return;
            }
            postOrderTraversal(node.left);

            postOrderTraversal(node.right);
            System.out.print(node.data + " ");

        }

        public void levelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);

            while(!q.isEmpty()){
                Node currNode = q.poll();

                if(currNode ==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.offer(null);
                    }

                } else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.offer(currNode.left);
                    }

                    if(currNode.right!=null){
                        q.offer(currNode.right);
                    }
                }


            }

        }

    }

    public static void main(String[] args) {

        // pre order binary tree
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node rootNode = tree.buildTree(nodes);

        // tree.preOrderTraversal(rootNode);

        // tree.inOrderTraversal(rootNode);
       // tree.postOrderTraversal(rootNode);
        tree.levelOrderTraversal(rootNode);

        System.out.println("Root node : " + rootNode.data);
    }
}