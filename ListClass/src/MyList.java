public class MyList<T> {
    private int capacity;
    private T[] arr;

    public MyList() {
        this.capacity = 10;
        this.arr = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    public int size() {
        int size = 0;
        for (Object o : this.arr) {
            if (o != null) {
                size++;
            }
        }
        return size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(T data) {
        if (size() == this.capacity) {
            this.arr = getCopy(this.arr, 2 * getCapacity());
            this.capacity = this.arr.length;
        }

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == null) {
                this.arr[i] = data;
                break;
            }
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size()) {
            return this.arr[index];
        }
        return null;
    }

    public T remove(int index) {
        if (index >= 0 && index < size()) {
            T[] tempArr = getCopy(this.arr, getCapacity());

            for (int i = index; i < size() - 1; i++) {
                this.arr[i] = tempArr[i + 1];
            }

            this.arr[size() - 1] = null;

            return tempArr[index];
        }
        return null;
    }

    public T set(int index, T data) {
        if (index >= 0 && index < size()) {
            this.arr[index] = data;
            return this.arr[index];
        }
        return null;
    }

    public String toString() {
        if (isEmpty()) return "[]";

        String str = "[";

        for (int i = 0; i < size() - 1; i++) {
            str += this.arr[i] + ", ";
        }

        str += this.arr[size() - 1] + "]";

        return str;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size(); i++) {
            if (data == this.arr[i]) return i;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size() - 1; i >= 0; i--) {
            if (data == this.arr[i]) return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            if (this.arr[i] != null) return false;
        }
        return true;
    }

    public T[] toArray() {
        T[] tempArr = (T[]) new Object[size()];

        for (int i = 0; i < size(); i++) {
            tempArr[i] = this.arr[i];
        }

        return tempArr;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            this.arr[i] = null;
        }
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> newList = new MyList<T>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            newList.add(this.arr[i]);
        }
        return newList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if (data == this.arr[i]) return true;
        }
        return false;
    }

    public T[] getCopy(T[] array, int length) {
        T[] tempArray = (T[]) new Object[length];

        for (int i = 0; i < length && i < array.length; i++) {
            tempArray[i] = array[i];
        }

        return tempArray;
    }

}
