import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            words.add(wordList.get(i));
        }
        if(!words.contains(endWord)){
            return 0;
        }
        queue.add(beginWord);
        words.remove(beginWord);
        int counter = 0;
        //. dog --> aog, bog, cog
        while(queue.size()>0){
            int len = queue.size();
            while(len>0){
                String cur = queue.poll();
                System.out.println("cur="+cur);
                if(cur.equals(endWord)){
                    return counter+1;
                }
                len--;
                // hot. --> a+ ot, b + ot
                // hot --> ho + a, ho + b
                // hot ---> h + a/b/c/d  + t
                for(int i=0;i<cur.length();i++){
                    String prefix = "";
                    if(i>0){
                        prefix = cur.substring(0,i);
                    }
                    String suffix = "";
                    if(i<cur.length()-1){
                        suffix = cur.substring(i+1);
                    }
                    for(char c='a';c<='z';c++){
                        String stepWord = prefix + c + suffix;
                        System.out.println("stepword="+stepWord);
                        if(words.contains(stepWord)){
                            queue.add(stepWord);
                            words.remove(stepWord);
                        }
                    }
                }
            }
            counter++;
        }
        return 0;
    }
}