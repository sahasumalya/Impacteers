//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class EmployeeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee employee1, Employee employee2) {

       if(employee1.age == employee2.age){
           return employee1.name.compareTo(employee2.name);
       }

        if(employee1.age > employee2.age){
            return 1;
        }

        return -1;
    }
}
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            hmap.put(preorder[i], i);
        }
        return dfs(inorder, 0, inorder.length-1, hmap);

    }

    public TreeNode dfs(int[] inorder, int start, int end, Map<Integer, Integer> hmap){
        if(start==end){
            return new  TreeNode(inorder[start]);
        }
        int minPos = hmap.get(inorder[start]);
        int minIndex = start;
        for(int i=start+1;i<=end;i++){
            if(minPos>hmap.get(inorder[i])){
                minPos = hmap.get(inorder[i]);
                minIndex = i;
            }
        }
        TreeNode root = new TreeNode(inorder[minIndex]);
        if(minIndex>start){
            root.left = dfs(inorder, start, minIndex-1, hmap);
        }
        if(minIndex<end){
            root.right = dfs(inorder, minIndex+1, end, hmap);
        }
        return root;
    }


public int[] searchRange(int[] nums, int target) {

    //min index element
    int start = 0;
    int[] res = {-1,-1};
    int end = nums.length -1;
    int minindex = Integer.MAX_VALUE;
    while(start <= end){
        int mid = (start+end)/2;
        if(nums[mid]==target){
            minindex = Math.min(minindex, mid);
        }

        if(target <= nums[mid]){
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }

    }
    // max index element
    start = 0;
    end = nums.length - 1;
    int maxIndex = -1;
    while(start <= end){
        int mid = (start+end)/2;
        if(nums[mid]==target){
            maxIndex = Math.max(maxIndex, mid);
        }

          /*if(target < nums[mid]){
            end = mid - 1;
          }
          else {
            start = mid + 1;
          }*/
        if(target >= nums[mid]){
            start = mid+1;
        } else {
            end = mid - 1;
        }

    }

    if(maxIndex>-1){
        res[0] = minindex;
        res[1] = maxIndex;
    }
    return res;

}
public int search(int[] nums, int target) {

    int start = 0;
    int end = nums.length-1;

    while(start<=end){

        int mid = (start+end)/2;
        if(nums[mid]==target){
            return mid;
        }
        // start == end == mid
        // start = end+1
        //. end = start - 1
        if(target> nums[mid]){
            start = mid+1;
        }
        else {
            end = mid-1;
        }

    }
    return -1;


}

public int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length-1;
    if(nums.length==1){
        return 0;
    }
    if(nums[0]>nums[1]){
        return 0;
    }
    if(nums[nums.length-1]>nums[nums.length-2]){
        return nums.length-1;
    }
    while(start<=end){
        if(start==end){
            return start;
        }
        int mid = (start+end)/2;
        System.out.println(mid+":"+nums[mid]);
        if((mid-1<0 || nums[mid-1]<nums[mid]) && (mid+1>=nums.length || nums[mid+1]<nums[mid]) ){
            return mid;
        }

        if(mid+1<nums.length && nums[mid+1]>nums[mid]){
            start = mid+1;
        }

        else if(mid-1>=0 && nums[mid-1]>nums[mid]){
            end = mid-1;
        }

    }
    return -1;
}

public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int res = 0;
    int children = 0;
    int cookie = 0;
    while(children<g.length && cookie<s.length){
        if(g[children]<=s[cookie]){
            res++;
            children++;
            cookie++;
        } else {
            cookie++;
        }
    }
    return res;
}
public int minEatingSpeed(int[] piles, int h) {
    int maxSpeed = piles[0];
    for(int i=1;i<piles.length;i++){
        maxSpeed = Math.max(maxSpeed, piles[i]);
    }
    int res = maxSpeed;
    int minSpeed = 1;
    while(minSpeed<=maxSpeed){
        int mid = (minSpeed+maxSpeed)/2;
        if(isPossible(piles, mid, h)){
            //System.out.println(mid+"##"+res);
            res = Math.min(res, mid);
            maxSpeed = mid-1;
        } else {
            minSpeed = mid+1;
        }

    }
    return res;
}
// 1879048192 1000000000
public boolean isPossible(int[] piles, int rate, int h){
    long duration = 0;
    for(int i=0;i<piles.length;i++){
        duration = (long)duration + (piles[i]/rate);
        if(piles[i]%rate!=0){
            duration++;
        }
    }
    //System.out.println(rate+"--"+duration);
    return duration<=h;
}
public int jump(int[] nums) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    boolean visited[] = new boolean[nums.length];
    visited[0] = true;
    int steps = 0;
    while(queue.size()>0){
        int len = queue.size();
        while(len>0){
            int cur = queue.poll();
            if(cur==nums.length-1){
                return steps;
            }
            for(int i=1;i<=nums[cur];i++){
                int newStep = cur + i;
                if(newStep>=nums.length){
                    break;
                }
                if(!visited[newStep]){
                    visited[newStep] = true;
                    queue.add(newStep);
                }
            }
            len--;
        }
        steps++;
    }
    return steps;
}
public int searchRotateArray(int[] nums, int target) {
    int start = 0;
    int end = nums.length-1;
    while(start<=end){

        int mid = (start+end)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[end]>nums[mid]){
            if(target>nums[mid] && target<=nums[end]){
                start = mid+1;
            } else {
                end = mid-1;
            }
        } else {
            if(target<nums[mid] && target>=nums[start]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

    }
    return -1;
}



public void main() {

    int[] inorder = {9,3,15,20,7};
    int[] preorder = {3,9,20,15,7};
    TreeNode tree = buildTree(preorder, inorder);
    System.out.println("success");
    /*Employee employee1 = new Employee("tarun",30);
    Employee employee2 = new Employee("rohit", 32);
    Employee employee3 = new Employee("rana", 24);

    Employee employee4 = new Employee("alia", 26);

    Employee employee5 = new Employee("bhanu", 26);


    ArrayList<Employee> employeeList = new ArrayList<>();
    employeeList.addAll(List.of(employee1, employee2, employee3, employee4, employee5));

    Collections.sort(employeeList);
    employeeList.forEach(e-> System.out.println(e.name + "---" + e.age));*/
    // int arr[] = {10,7,5,6,9,3,2,1};
    // int res[] = mergeSort(arr, 0, arr.length-1);
    /* for(int i=0;i<res.length;i++){
         System.out.println(res[i]);
     }*/
    //List<String> combinations = letterCombinations("4563");
    //combinations.forEach(System.out::println);
   /*
   board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    */
    //char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    //String word = "DECC";
    //System.out.println(exist(board, word));
    //solvenQueens(16);
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    //int[] arr = {73,74,75,71,69,72,76,73};
    //int[] res = dailyTemperatures(arr);
    //
    //int[] input = {2,3,6,7};
    //combinationSum(input, 7);
    //List<List<Integer>> res = subsets(input);
    //int[] res = maxSlidingWindow(input, 3);
    //Arrays.stream(res).forEach((i)->System.out.println(i));
    //MyLinkedList root = create(arr);
    //MyLinkedList reversedList = reverse(root);
    //displayLinkedList(reversedList);
    //System.out.println(getNthElement(root, 5));

    //int k = 6;
    //System.out.println(checkSubarraySum(arr, k));


}

public void quicksort(int[] arr, int start, int end){

    if(start==end || start>end){
        return;
    }
    int pivot = arr[start];
    int low = start;
    int curPos = start;
    for(int i=start+1;i<end;i++){
        if(arr[i]==pivot){
            curPos = i;
        }
        if(arr[i]<pivot){
            if(arr[low]==curPos){
                curPos = i;
            }
            int temp = arr[i];
            arr[i] = arr[low];
            arr[low] = temp;
            low++;
        }

    }
    if(curPos != low){
        int temp = arr[low];
        arr[low] = pivot;
        arr[curPos] = temp;
    }
    quicksort(arr, start, low-1);
    quicksort(arr, low+1, end);

}

public int[] merge(int[] left, int[] right){
    int[] res = new int[left.length+right.length];
    int l = 0, r = 0;
    int index = 0;
    while(l<left.length && r<right.length){
        if(left[l]<=right[r]){
            res[index] = left[l];
            l++;
        } else {
            res[index] = right[r];
            r++;
        }
        index++;
    }

    while(l<left.length){
        res[index] = left[l];
        l++;
        index++;
    }

    while(r<right.length){
        res[index] = right[r];
        r++;
        index++;
    }

    return res;
}
public int[] mergeSort(int[] arr, int start, int end){

    if(start==end){
        int[] res = {arr[start]};
        return res;
    }
    int mid = (start + end)/2;
    int[] left = mergeSort(arr, start, mid);
    int[] right = mergeSort(arr, mid+1, end);
    return merge(left, right);
}

public List<String> letterCombinations(String digits) {

     Map<Character, List<Character>> characterListMap = new HashMap<>();
     characterListMap.put('2', List.of('a','b','c'));
    characterListMap.put('3', List.of('d','e','f'));
    characterListMap.put('4', List.of('g','h','i'));
    characterListMap.put('5', List.of('j','k','l'));
    characterListMap.put('6', List.of('m','n','o'));
    characterListMap.put('7', List.of('p','q','r','s'));
    characterListMap.put('8', List.of('t','u','v'));
    characterListMap.put('9', List.of('w','x','y','z'));

    List<String> res = new ArrayList<>();
    letterDfs(digits, characterListMap, 0, "", res);

    return res;


}

public void letterDfs(String digits, Map<Character, List<Character>> characterListMap, int index, String combination, List<String> res){

    if(index==digits.length()){
        res.add(combination);
        return;
    }
    char digit = digits.charAt(index);
    List<Character> charList = characterListMap.get(digit);
    for(int i=0;i<charList.size();i++){
        letterDfs(digits, characterListMap, index+1, combination + charList.get(i), res);
    }
}

public boolean exist(char[][] board, String word) {

   boolean[][] processed = new boolean[board.length][board[0].length];
   for(int i=0;i<board.length;i++){
       for(int j=0;j<board[i].length;j++){
           boolean res = wordDfs(board, word, i, j, 0, processed);
           if(res){
               return true;
           }
       }
    }
   return false;
}

public boolean wordDfs(char[][] board, String word, int x, int y, int index, boolean [][] processed){
    processed[x][y] = true;
    if(board[x][y] == word.charAt(index)){
        if(index==word.length()-1){
            processed[x][y] = false;
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean cur = false;
        if(x+1<rows && !processed[x+1][y]){
            cur = wordDfs(board, word, x+1, y, index+1, processed);
            if(cur){
                processed[x][y] = false;
                return true;
            }
        }
        if(x-1>=0 && !processed[x-1][y]){
            cur = wordDfs(board, word, x-1, y, index+1, processed);
            if(cur){
                processed[x][y] = false;
                return true;
            }
        }
        if(y+1<cols && !processed[x][y+1]){
            cur = wordDfs(board, word, x, y+1, index+1, processed);
            if(cur){
                processed[x][y] = false;
                return true;
            }
        }
        if(y-1>=0 && !processed[x][y-1]){
            cur = wordDfs(board, word, x, y-1, index+1, processed);
            if(cur){
                processed[x][y] = false;
                return true;
            }
        }

    }
    processed[x][y] = false;
    return false;

}

public char[][] solvenQueens(int n){

    char[][] board = new char[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j] = '.';
        }
    }

    dfs(board, 0);

    // print my solution
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print(board[i][j]+ " ");
        }
        System.out.println();
    }

    return board;

}

public boolean isValidPosition(char[][] board, int x, int y){

    int size = board.length;
    for(int i=0;i<size;i++) {
        if (board[x][i] == 'Q') {
            return false;
        }
    }
        for(int i=0;i<size;i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
    int a = x, b = y;
    while(a-1>=0 && b+1<size){
        a--;
        b++;
        if(board[a][b]=='Q'){
            return false;
        }
    }
    a = x;
    b = y;
    while(a-1>=0 && b-1>=0){
        a--;
        b--;
        if(board[a][b]=='Q'){
            return false;
        }
    }
    a = x;
    b = y;
    while(a+1<size && b-1>=0){
        a++;
        b--;
        if(board[a][b]=='Q'){
            return false;
        }
    }
    a = x;
    b = y;
    while(a+1<size && b+1<size){
        a++;
        b++;
        if(board[a][b]=='Q'){
            return false;
        }
    }

    return true;
}

public boolean dfs(char[][] board, int column){

    if(column==board.length){
        return true;
    }
    for(int i=0;i<board.length;i++){
        if(isValidPosition(board, i, column)){
            board[i][column] = 'Q';
            boolean cur = dfs(board, column+1);
            if(cur){
                return true;
            }
            board[i][column] = '.';
        }
    }
    return false;

}

public boolean isValid(String s) {
    Map<Character, Character> hmap = new HashMap<>();
    // closing - opening
    hmap.put(')','(');
    hmap.put('}', '{');
    hmap.put(']','[');
    Stack<Character> st = new Stack<>();

    for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(hmap.get(c)==null){
            st.add(c);
        } else {
            char opening = hmap.get(c);
            if(st.size()>0 && st.peek()==opening){
                st.pop();
            } else {
                return false;
            }
        }
    }

    return st.size()==0;
}

public int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Stack<List<Integer>> stack = new Stack<>();
    for(int i=0;i<temperatures.length;i++){
        int cur = temperatures[i];
        while(stack.size()>0 && stack.peek().get(0) < cur){
            res[stack.peek().get(1)] = i - stack.peek().get(1);
            stack.pop();
        }
        List<Integer> list = List.of(cur, i);
        stack.push(list);
    }
    return res;
}

public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();
    addSubsets(nums, 0, new ArrayList<>(), res);

    return res;


}

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    solve(target, 0, candidates, res, new ArrayList<>());
    return res;
    /// 1 2 3


}

public void solve(int target, int index, int[] candidates, List<List<Integer>> res, List<Integer> combination){

    if(target==0){
        res.add(new ArrayList<>(combination));
        return;
    }
    if(index==candidates.length){
        return;
    }
    if(candidates[index] <= target){
        combination.add(candidates[index]);
        solve(target- candidates[index], index, candidates, res, combination);
        combination.removeLast();
    }

    solve(target, index+1, candidates, res, combination);
}

public void addSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> res){

    if(index==nums.length){
        res.add(new ArrayList<>(subset));
        return;
    }

    subset.add(nums[index]);
    // considering
    addSubsets(nums, index+1, subset, res);

    // not considering
    subset.removeLast();
    addSubsets(nums, index+1, subset, res);
    return;

}

public int[] maxSlidingWindow(int[] nums, int k) {
    // n elements , k -->
    // 1 2 3 4 --> 4, 3, 2 --> n - k + 1
    // 0 1 2 3
    int[] res = new int[nums.length - k + 1];
    int resIndex = 0;
    Deque<Integer> deque = new LinkedList<>();
    //
    for(int i=0;i<nums.length;i++){
        int curNum = nums[i];
        while(deque.size()>0 && nums[deque.peekLast()] <= curNum){
            deque.pollLast();
        }
        deque.add(i);
        // 1 2 3 4 5
        // 0 1 2 3 4
        if(i>=k-1){
            while(deque.size()> 0 && deque.peekFirst() <= i-k){
                // 02 1  3 4 5
                // 1  ---> 5 --> 3
                deque.pollLast();
            }
            res[resIndex] = nums[deque.peekFirst()];
            resIndex++;
        }
    }
    return res;


}


public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();
    Set<String> operatorSet = new HashSet<>();
    operatorSet.add("+");
    operatorSet.add("-");
    operatorSet.add("*");
    operatorSet.add("/");


    for (int i = 0; i < tokens.length; i++) {
        String cur = tokens[i];
        if (operatorSet.contains(cur)) {
            int a = st.pop();
            int b = st.pop();
            int temp = 0;
            if (cur.equals("+")) {
                temp = b + a;
            } else if (cur.equals("*")) {
                temp = b * a;
            } else if (cur.equals("-")) {
                temp = b - a;
            } else {
                //System.out.println(b+":"+a);
                temp = b / a;
            }
            st.add(temp);
        } else {
            int num = Integer.parseInt(cur);
            st.add(num);
        }
    }

    return st.pop();
}


    /*class MyLinkedList {
        int data;
        MyLinkedList prev;
        MyLinkedList next;

        MyLinkedList(int data) {
            this.data = data;
        }

    }*/


/*public MyLinkedList create(int [] arr){
    // 1,2,3
    // root --1  -->cur
    // newNode(2)
    // cur --> next --newNode
    // neNode--> prev = cur
    // newNode(3)
    // cur->next --newNode
    // newNnode->prev = cur;
    MyLinkedList root = new MyLinkedList(arr[0]);
    MyLinkedList cur = root;
    for(int i=1;i<arr.length;i++){
        MyLinkedList newNode = new MyLinkedList(arr[i]);
        cur.next = newNode;
        newNode.prev = cur;
        cur = cur.next;
    }
    return root;
}*/
// 1 2 3 4
/*public int getNthElement(MyLinkedList root, int n){
    MyLinkedList cur = root;
    for(int i=1;i<n;i++){
        cur = cur.next;
    }
    return cur.data;
}*/


/*public void displayLinkedList(MyLinkedList root){
    MyLinkedList cur = root;
    // 1,2,3,4
    while(cur!=null){
        System.out.println(cur.data);
        cur = cur.next;
    }
}*/

/*public MyLinkedList reverse(MyLinkedList root){

    MyLinkedList next = null;
    // 1 2 3 //  1 2 --> 2->1 3->2 4->3
    // next --. cur.next
    // cur-next = root
    // root = cur
    // 1 2 3 4 5
    if(root==null || root.next==null){
        return root;
    }

    // 1 2 3 4 5
    // root = 4
    // cur = 5       5(root)->4-> 3-> 2->1->null
    // next = 5
    //
    MyLinkedList cur = root.next;
    boolean isFirst = true;
    while(cur.next!=null){
        next = cur.next;
        cur.next = root;
        if(isFirst){
            isFirst = false;
            root.next = null;
        }
        root = cur;
        cur = next;
    }
    cur.next = root;
    root = cur;
    return root;

}

public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> hmap = new HashMap<>();
    int sum = 0;
    for(int i=0;i<nums.length;i++){
        sum = (sum + nums[i])%k;
        System.out.println(sum);
        if(i>0){
            if((hmap.get(sum)!=null && hmap.get(sum)<i-1) || sum == 0){
                return true;
            }
        }
        if(hmap.get(sum)==null){
            hmap.put(sum, i);
        }
    }
    return false;
}*/
