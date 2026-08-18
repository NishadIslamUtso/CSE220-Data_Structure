// Complete the subtractSummation method
//ASSIGNMENT TASK MUST SUBMIT
public class Task6 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer subtractSummation( BTNode root ){
        Integer sum=sumOfTree(root.left)-sumOfTree(root.right);
        return sum; 
    }

    private static Integer sumOfTree(BTNode root) {
        if(root==null) return 0;
        return (Integer)root.elem+sumOfTree(root.left)+sumOfTree(root.right);
    }
    //============================================================================

}
