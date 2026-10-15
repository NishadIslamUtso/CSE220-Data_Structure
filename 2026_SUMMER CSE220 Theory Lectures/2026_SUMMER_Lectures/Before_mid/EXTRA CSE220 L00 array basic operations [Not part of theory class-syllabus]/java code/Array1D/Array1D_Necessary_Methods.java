public class Array1D_Necessary_Methods {
    public int[] arr;

    public Array1D_Necessary_Methods(int[] arr) {
        if (arr == null) {
            this.arr = new int[0];
        } else {
            this.arr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                this.arr[i] = arr[i];
            }
        }
    }

    public void printForLoop() {
        System.out.println("Using For Loop");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public int[] resizeArrayWithConstantIncrement(int constantInc) {
        int newSize = arr.length + constantInc;
        int[] resizedArr = new int[newSize];
        for (int i = 0; i < arr.length; i++) {
            resizedArr[i] = arr[i];
        }
        arr = resizedArr;
        return arr;
    }

    public int[] resizeArrayWithNewSize(int newSize) {
        int[] resizedArr = new int[newSize];
        for (int i = 0; i < arr.length; i++) {
            resizedArr[i] = arr[i];
        }
        arr = resizedArr;
        return arr;
    }

    public int[] copyArray() {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public int[] shiftLeft() {
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = 0;
        return arr;
    }

    public int[] shiftLeftMultiple(int shiftVal) {
        for (int i = 0; i < arr.length - shiftVal; i++) {
            arr[i] = arr[i + shiftVal];
        }
        for (int i = arr.length - shiftVal; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public int[] rotateLeft() {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    public int[] shiftRight() {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = 0;
        return arr;
    }

    public int[] shiftRightMultiple(int shiftVal) {
        for (int i = arr.length - 1; i >= shiftVal; i--) {
            arr[i] = arr[i - shiftVal];
        }
        for (int i = 0; i < shiftVal; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public int[] rotateRight() {
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    public int[] reverseOutOfPlace() {
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        return reversedArr;
    }

    public int[] reverseInPlace() {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public int[] reverseInPlace2() {
        for (int i = 0; i < arr.length / 2; i++) {
            int indexFromEnd = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[indexFromEnd];
            arr[indexFromEnd] = temp;
        }
        return arr;
    }

    public void printNonDummies(int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public int getSize() {
        int count = 0;
        while (count < arr.length && arr[count] != 0) {
            count++;
        }
        return count;
    }

    public int[] insertAnywhere(int size, int index, int elem) {
        if (size >= arr.length) {
            resizeArrayWithNewSize(arr.length + 3);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = elem;
        return arr;
    }

    public int[] deleteAnyElement(int size, int index) {
        if (size == 0 || index < 0 || index >= size) {
            System.out.println("Deletion Not Possible");
            return arr;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
        return arr;
    }
}
