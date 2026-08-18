//Assignment Task (must Submit)
// Complete the sumOfLeaves method
public class Task5 {

    //===================================TASK#5======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){

       if (root == null) return 0;
        return mirrorSumHelper(root.left,root.right);
    }

    private static int mirrorSumHelper(BSTNode l,BSTNode r){

        if (l==null|| r==null) {
            return 0;
        }
        int curr=(Integer)l.elem+(Integer)r.elem;
        int outSum=mirrorSumHelper(l.left, r.right);
        int inSum=mirrorSumHelper(l.right, r.left);

        return curr+outSum+inSum;
    }

    //===============================================================


}
