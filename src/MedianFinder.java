import java.util.Comparator;
import java.util.PriorityQueue;

class MaxHeapComparartor implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        if(a<b){
            return 1;
        }
        return -1;
    }
}
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new MaxHeapComparartor());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.size()==minHeap.size()){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(minHeap.size()>0 && maxHeap.peek() > minHeap.peek()){
            int a = maxHeap.poll();
            int b = minHeap.poll();
            minHeap.add(a);
            maxHeap.add(b);
        }
    }

    public double findMedian() {
        int len = maxHeap.size()+minHeap.size();
        if(len%2==0){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }
        return (double)maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
