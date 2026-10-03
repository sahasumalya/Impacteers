import java.util.HashMap;
import java.util.Map;

class Trie {
    public char data;
    public int value;
    public Map<Character, Trie> children = new HashMap<>();

    Trie(char data){
        this.data = data;
    }

}
class MapSumTrie {
    Trie root;
    public MapSumTrie() {
        root = new Trie('#');
    }

    public void insert(String key, int val) {
        Trie cur = root;
        for(int i=0;i<key.length();i++){
            char c = key.charAt(i);
            if(cur.children.get(c)==null){
                Trie child = new Trie(c);
                cur.children.put(c, child);
            }
            cur = cur.children.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Trie found = search(prefix);
        if(found==null){
            return 0;
        }
        return dfs(found);
    }

    public Trie search(String prefix){
        Trie cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.children.get(c)==null){
                return null;
            }
            cur = cur.children.get(c);
        }
        return cur;
    }

    public int dfs(Trie trie){
        int sum = trie.value;
        for(Map.Entry<Character, Trie> entry: trie.children.entrySet()){
            sum = sum + dfs(entry.getValue());
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
