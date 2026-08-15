//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    int[] arr = {73,74,75,71,69,72,76,73};
    int[] res = dailyTemperatures(arr);
    Arrays.stream(res).forEach((i)->System.out.println(i));
    //MyLinkedList root = create(arr);
    //MyLinkedList reversedList = reverse(root);
    //displayLinkedList(reversedList);
    //System.out.println(getNthElement(root, 5));

    //int k = 6;
    //System.out.println(checkSubarraySum(arr, k));


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
