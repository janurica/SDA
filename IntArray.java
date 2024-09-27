package Array;

import java.util.Arrays;


public class IntArray {
    private  Integer[] array;
    private int size;  // Number of elements stored in the array


    public IntArray() {
        array = new Integer[10];  // Default size
        size=0;
    }

    // adds element to next available position, enlarges the array if necessary

    public void add(Integer value){
        ensureCapacity();  // ensures capacity can hold new element
        array[size++] = value;
        System.out.println("I put element " + value + " at position " + (size - 1) + (size == array.length ? " (I enlarge the array)" : ""));
    }

    // ads an element  at a specific indes, shift elements to the reght enlages if neceserry
    public void add(Integer value, int idx){
        if(idx > size || idx <0){
            throw new IndexOutOfBoundsException("INdex " + idx + "is out of bounds.");
        }
        ensureCapacity();
        System.arraycopy(array,idx,array, idx+1, size-idx);
        array[idx] = value;
        size++;
    }
    // Retrievs the element at the specified index, prints the operation details

    public Integer get(int idx){
        if(idx>=0 && idx <size){
            System.out.println("I returned item: " + array[idx] + "from position " + idx);
            return array[idx];
        }
        System.out.println("Index " + idx + "is out of bounds.");
        return null;
    }


    // Removes an element at a specific index, shifts elements to the left

    public void remove(int idx){
        if(idx >=0 && idx< size){
            // Shift elements to the left from the idx position
            System.arraycopy(array, idx+1, array,idx, size-idx-1);
            array[--size] = null;  // Clear the last element and decrement size
        }else {
            throw new IndexOutOfBoundsException("index " + idx+ "is out of bounds.");
        }
    }

    public void  swap(int from, int to){
        if(from>= size || to>= size){
            throw new IndexOutOfBoundsException("Swap indeces out of bounds");
        }
        Integer temp = array[from];
        array[from] = array[to];
        array[to] = temp;
        System.out.println("I replace item " + array[from] + " from position " + from + " with item " + array[to] + " from position " + to);

    }
    // Increases the capacity of the array if it is full

    private void ensureCapacity(){
        if(size == array.length){
            // Double size of the array if capacity  is reached
            array = Arrays.copyOf(array,array.length*2);
        }
    }

    // Returns  a string representation of the array


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i =0; i<size; i++){
            sb.append(array[i]);
            if(i< size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        IntArray arr = new IntArray();

        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40,1);

        System.out.println("Array after additions: " + arr);

        arr.remove(2); // Remove element at index 2

        System.out.println("Array after removal: " + arr);

        arr.swap(0,2);

        System.out.println("Array after swap: " + arr);

        System.out.println("Element at index 1: " + arr.getClass().getName());
    }
}
