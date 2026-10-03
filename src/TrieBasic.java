import java.util.HashMap;
import java.util.Map;

class TrieBasic {
    char data;
    boolean isEnd;
    Map<Character, TrieBasic> children = new HashMap<>();
    public TrieBasic(char data){
        this.data = data;
    }
    public TrieBasic() {
        this.data = '#';
    }

    public void insert(String word) {

        TrieBasic root = this;
        for(int i=0;i<word.length();i++){
            char cur = word.charAt(i);
            if(root.children.get(cur)==null){
                TrieBasic child = new TrieBasic(cur);
                root.children.put(cur, child);
            }
            root = root.children.get(cur);
        }
        root.isEnd = true;
    }

    public boolean search(String word) {

        TrieBasic root = this;
        for(int i=0;i<word.length();i++){
            char cur = word.charAt(i);
            if(root.children.get(cur)==null){
                return false;
            }
            root = root.children.get(cur);
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieBasic root = this;
        for(int i=0;i<prefix.length();i++){
            char cur = prefix.charAt(i);
            if(root.children.get(cur)==null){
                return false;
            }
            root = root.children.get(cur);
        }
        return true;
    }
}

