import java.util.*;

class FrequencyComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2){
        if(l1.get(1)>l2.get(1))
            return 1;
        return -1;
    }
}
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // 1 --> 3
        // 2--> 2
        //3--> 1
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i], hmap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new FrequencyComparator());
        for(Map.Entry<Integer,Integer> entry: hmap.entrySet()){
            List<Integer> cur = new ArrayList<>();
            cur.add(entry.getKey());
            cur.add(entry.getValue());

            if(pq.size()<k){
                pq.add(cur);
                continue;
            }
            if(cur.get(1) > pq.peek().get(1)){
                pq.poll();
                pq.add(cur);
            }
        }
        int res[] = new int[k];
        int index = 0;
        while(pq.size()>0){
            res[index] = pq.poll().get(0);
            index++;
        }
        return res;
    }
}
