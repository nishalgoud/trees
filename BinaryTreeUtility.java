public class BinaryTreeUtility {
    

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

    public static int heightOfBinaryTree(Node root){
        if(root ==null){
            return 0;
        }
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int countOfNodes(Node root){
        if(root ==null){
            return 0;
        }
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount + rightCount+1;
    }

    public static int sumOfNodes(Node root){
        if(root ==null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum+root.data;
    }

    public static void main(String[] args) {

        /*
         *               1
         *             
         *             /     \
         *            
         *           2          3
       
                  /     \     /     \
            
                4         5  6        7

  */

  Node root = new Node(1);
  root.left = new Node(2);
  root.right = new Node(3);
  root.left.left = new Node(4);
  root.left.right = new Node(5);
  root.right.left = new Node(6);
  root.right.right = new Node(7);


  System.out.println(heightOfBinaryTree(root));
  System.out.println(countOfNodes(root));
  System.out.println(sumOfNodes(root));

    }
}
