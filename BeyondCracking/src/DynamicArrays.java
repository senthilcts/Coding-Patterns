public class DynamicArrays {

    /*
 Problem 1:
    Assume your programming language only supports fixed-size arrays. Implement a dynamic array data structure that supports the following:

        Dynamic Array API:

        append(x): adds element x to the end of the array
        get(i): returns the element at index i
        set(i, x): updates the preexisting element at index i to be x
        size(): returns the number of elements in the array
        pop_back(): removes the last element
        You should only declare arrays of a fixed size and not use built-in append() methods or equivalent. If you are coding in a strongly typed language, assume all elements are integers.
        Example 1:
        d = DynamicArray()
        d.append(1)
        d.append(2)
        d.get(0)  # returns 1
        d.get(1)  # returns 2
        d.size()  # returns 2

        Example 2:
        d = DynamicArray()
        d.append(1)
        d.set(0, 10)
        d.get(0)  # returns 10

        Example 3:
        d = DynamicArray()
        d.append(1)
        d.append(2)
        d.pop_back()
        d.size()  # returns 1
        d.get(0)  # returns 1
        Constraints:

        All operations should work with arrays of up to 10^6 elements
        All integer elements are between -10^9 and 10^9
     */
    private int[] fixedArray;
    private int capacity;
    private int _size;

    public DynamicArrays() {
        this.capacity = 10;
        this.fixedArray = new int[this.capacity];
        this._size = 0;
    }
    public int get(int index) {
        if(index < 0 || index >= this._size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.fixedArray[index];
    }
    public void set(int index, int value) {
        if(index < 0 || index >= this._size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this.fixedArray[index] = value;
    }
    public int size() {
        return this._size;
    }
    public void append(int value) {
        if(_size == this.capacity) {
            resize(2 * capacity);
        }
        fixedArray[this._size] = value;
        this._size++;
    }
    private void resize(int newCapacity) {
        int[] newFixedArray = new int[newCapacity];
        for(int i = 0; i < this._size; i++) {
            newFixedArray[i] = this.fixedArray[i];
        }
        this.fixedArray = newFixedArray;
        this.capacity = newCapacity;
    }
    public void popback() {
        if(_size == 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this._size--;
        if(this._size * 4 < this.capacity && capacity > 10) {
            resize(this.capacity / 2);
        }
    }
    public int getCapacity() {
        return this.capacity;
    }
    public static void main(String[] args) {

    }
}
