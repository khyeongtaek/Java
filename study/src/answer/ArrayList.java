package answer;

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
        return array[index];
    }

    public void clear(){
        array = new int[10];
        index = 0;
    }


    public boolean isEmpty(){
        if(!isExists()) return true;
        else if(index == 0) return true;
        else return false;
    }

    public int remove(int index) {
        int element = array[index];

        for (int i = index; i < this.index - 1; i++) {
            array[i] = array[i + 1];
        }

        this.index--;
        return element;
    }

    public void trimToSize() {
        if (!isExists() || index == array.length) return;

        int[] newArr = new int[index];
        for (int i = 0; i < index; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}