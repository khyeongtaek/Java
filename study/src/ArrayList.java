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

    public int get(int index){
        if(this.index <= index){
            throw new ArrayIndexOutOfBoundsException("index out of bounds");
        }
        return array[index];
    }

    public void clear(){
        array = null;
        index = 0;
    }


    public boolean isEmpty(){
        if(isExists()) return true;
        else if(index == 0) return true;
        else return false;
    }


//   0 1 2 3 4 5 6 7 8 9 0 0 0
//   0 1 2 3 4 5 6 7 9 9 0 0 0
    public int remove(int index){
        int removeValue = array[index];
        for(int i = index; i< this.index-1; i++){
            array[i] = array[i+1];
        }

        this.index--;
        return removeValue;
    }
    // 1 2 3 4 5 0 0 0 0 0
    public void trimToSize(){
        if(!isExists() || index == array.length) return;

        int[] newArr = new int[index];
        for(int i = 0; i<index; i++){
            newArr[i] = array[i];
        }
        array = newArr;

    }

    @Override
    public String toString() {
        return array.toString();
    }

}