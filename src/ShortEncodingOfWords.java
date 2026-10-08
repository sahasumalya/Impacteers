import java.util.HashMap;
import java.util.Map;

class Trie2 {
    public char data;
    Map<Character, Trie2> children = new HashMap<>();

    Trie2(char data){
        this.data = data;
    }
}
class ShortEncodingOfWords {
    Trie2 root = new Trie2('#');
    int totalLen = 0;
    int numberOfLeafNodes = 0;
    public int minimumLengthEncoding(String[] words) {
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        dfs(root, 0);
        System.out.println(numberOfLeafNodes);
        return totalLen + numberOfLeafNodes;
    }

    public void insert(String word){
        Trie2 cur = root;
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(cur.children.get(c)==null){
                Trie2 child = new Trie2(c);
                cur.children.put(c, child);
            }
            cur = cur.children.get(c);
        }

    }

    public void dfs(Trie2 node, int len){
        Map<Character, Trie2> children = node.children;
        if(children.size()==0){
            numberOfLeafNodes++;
            totalLen = totalLen + len;
            return;
        }

        for(Map.Entry<Character,Trie2> entry: children.entrySet()){
            dfs(entry.getValue(), len+1);
        }
    }


}
