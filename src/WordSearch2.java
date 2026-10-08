import java.util.*;

class Trie3{
    char data;
    Map<Character, Trie> children = new HashMap<>();
    int index = -1;

    Trie3(char data){
        this.data = data;
    }
}
class WordSearch2 {
    Trie3 root = new Trie3('#');
    public List<String> findWords(char[][] board, String[] words) {

        for(int i=0;i<words.length;i++){
            insert(words[i], i);
        }
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                boolean visited[][] = new boolean[board.length][board[i].length];
                res.addAll(dfs(i,j,board,root,visited));
            }
        }
        List<String> finalRes = new ArrayList<>();
        Iterator<Integer> it = res.iterator();
        while(it.hasNext()){
            finalRes.add(words[it.next()]);
        }
        return finalRes;

    }

    public Set<Integer> dfs(int x, int y, char[][] board, Trie3 node, boolean[][] visited){

        int rows = board.length;
        int cols = board[0].length;

        visited[x][y] = true;

        if(node.children.get(board[x][y])==null){
            visited[x][y] = false;
            return new HashSet<>();
        }
        Set<Integer> res = new HashSet<>();
        Trie childNode = node.children.get(board[x][y]);
        if(childNode.index>=0){
            res.add(childNode.index);
        }

        if(x-1>=0 && !visited[x-1][y]){
            Set<Integer> upRes =  dfs(x-1, y, board, childNode, visited);
            res.addAll(upRes);
        }
        if(x+1<rows && !visited[x+1][y]){
            Set<Integer> downRes =  dfs(x+1, y, board, childNode, visited);
            res.addAll(downRes);
        }
        if(y-1>=0 && !visited[x][y-1]){
            Set<Integer> leftRes =  dfs(x, y-1, board, childNode, visited);
            res.addAll(leftRes);
        }
        if(y+1<cols && !visited[x][y+1]){
            Set<Integer> rightRes =  dfs(x, y+1, board, childNode, visited);
            res.addAll(rightRes);
        }

        visited[x][y] = false;
        return res;

    }

    public void insert(String word, int index){
        Trie cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children.get(c)==null){
                Trie child = new Trie(c);
                cur.children.put(c, child);
            }
            cur = cur.children.get(c);
        }
        cur.index = index;
    }


}
