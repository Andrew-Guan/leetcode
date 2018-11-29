class MovingAverage {
    public double[] data;
    public int pointer = 0;
    public int totalSize = 0;
    public int currentSize = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        double[]  output = new double[size];
        data = output;
        totalSize = size;
        currentSize = 0;
    }
    
    public double next(int val) {
        if(currentSize < totalSize){
            currentSize++;
        }
        if(pointer == totalSize){
            pointer -= totalSize;
        }
        data[pointer] = val;
        pointer++;
        double sum = 0;
        for(int i = 0; i< totalSize; i++){
            sum += data[i];
        }
        double average = sum/currentSize;
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
