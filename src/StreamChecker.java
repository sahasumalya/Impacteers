class Trie {
    char data;
    Map<Character, Trie> children = new HashMap<>();
    boolean isStart = false;

    Trie(char data){
        this.data = data;
    }
}
class StreamChecker {
    Trie root = new Trie('#');
    String stream = "";
    public StreamChecker(String[] words) {
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
    }

    public boolean query(char letter) {
        stream = stream + letter;
        int index = stream.length()-1;
        Trie cur = root;
        while(index>=0 && cur.children.get(stream.charAt(index))!=null){
            if(cur.children.get(stream.charAt(index)).isStart){
                return true;
            }
            cur = cur.children.get(stream.charAt(index));
            index--;
        }
        return false;
    }

    public void insert(String word){
        Trie cur = root;
        for(int i = word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(cur.children.get(c)==null){
                Trie child = new Trie(c);
                cur.children.put(c, child);
            }
            cur = cur.children.get(c);
        }
        cur.isStart = true;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */