// Complete the levelSum method
//ASSIGNMENT TASK MUST SUBMIT
public class Task7 {

    //===================================TASK#7===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
        if(root==null) return 0;
        Integer sum=(-(Integer)root.elem-levelSum(root.left)-levelSum(root.right));
        return sum;
    }
    //============================================================================

}
