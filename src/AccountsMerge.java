import java.util.*;

class AccountsMerge {
    public int findRootParent(int account, int parent[]){
        int cur = account;
        while(parent[cur]!=cur){
            cur = parent[cur];
        }
        parent[account] = cur;
        return cur;

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int len = accounts.size();
        int parent[] = new int[len];
        for(int i=0;i<len;i++){
            parent[i] = i;
        }
        Map<String, Integer> emailToAccount = new HashMap<>();
        List<List<String>> emails = new ArrayList<>();
        for(int i=0;i<len;i++){
            emails.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(emailToAccount.get(email)==null){
                    emailToAccount.put(email, i);
                } else {
                    int rootParent1 = findRootParent(emailToAccount.get(email), parent);
                    int rootParent2 = findRootParent(i, parent);
                    if(rootParent1!=rootParent2){
                        parent[rootParent1] = rootParent2;
                    }
                }
            }
        }
        for(Map.Entry<String,Integer> entry: emailToAccount.entrySet()){
            String email = entry.getKey();
            int account = entry.getValue();
            int rootAccount = findRootParent(account, parent);
            emails.get(rootAccount).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<emails.size();i++){
            if(emails.get(i).size()>0){
                Collections.sort(emails.get(i));
                List<String> curList = new ArrayList<>();
                curList.add(accounts.get(i).get(0));
                curList.addAll(emails.get(i));
                res.add(curList);

            }
        }
        return res;


    }
}
