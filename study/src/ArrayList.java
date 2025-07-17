public class ArrayList {

    private int[] array;
    private int index;

    private boolean isExists() {
        if (array == null) return false;
        else return true;
    }

    public boolean add(int element) {
        if (!isExists()) array = new int[10];
        if (isFull()) sizeUp();

        int old = index;
        array[index++] = element;

        if (old + 1 == index) return true;
        else return false;
    }

    public int size() {
        return index;
    }

    private void sizeUp() {
        int length = (int) (array.length * 1.5);
        int[] newArr = new int[length];

        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }

        array = newArr;
    }

    public boolean isFull() {
        if (index == array.length) return true;
        else return false;
    }
//
//    ? ? get(?){
//        ?
//    }
//
//    ? ? clear(?){
//        ?
//    }
//
//
//    ? ? isEmpty(?){
//        ?
//    }
//
//    ? ? remove(?){
//        ?
//    }

}