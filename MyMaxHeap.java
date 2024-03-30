public class MyMaxHeap {
    private int[] heapArray;
    private int size;
    private int maxsize;

    public MyMaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heapArray = new int[this.maxsize + 1];
        heapArray[0] = Integer.MAX_VALUE; 
    }

    public int getSize(){
        return size;
    }

    private int parent(int k) {
        return k / 2;
    }

    private int leftChild(int k){
        return ((2*k));
    }

    private int rightChild(int k){
        return ((2*k)+1);
    }

    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    public void insert(int newNode) {
        if (size >= maxsize) {
            return;
        }
        heapArray[++size] = newNode; 
        int current = size;
        while (heapArray[current] > heapArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void maxHeapify(int pos) {
        if (pos > size / 2 || pos <= 0) {
            return;
        }
        if(heapArray[pos]<heapArray[leftChild(pos)] || heapArray[pos]<heapArray[rightChild(pos)]){
            if(heapArray[leftChild(pos)]>heapArray[rightChild(pos)]){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else{
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public int popMaxHeap() {
        int heapData = heapArray[1];
        heapArray[1] = heapArray[size--];
        maxHeapify(1);
        return heapData;
    }

}