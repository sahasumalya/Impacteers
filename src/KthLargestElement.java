import java.util.Comparator;
import java.util.PriorityQueue;

class PQComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        if(a>b)
            return 1;

        return -1;
    }
}
class KthLargestElement {
    PriorityQueue<Integer> pq;
    int queueSize;
    public KthLargestElement(int k, int[] nums) {
        pq = new PriorityQueue<>(new PQComparator());
        queueSize = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(pq.size()<queueSize){
            pq.add(val);
            return pq.peek();
        }
        if(val> pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
