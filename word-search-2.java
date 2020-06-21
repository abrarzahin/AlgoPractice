class Trie{
    TN root = new TN();
    public void insert(String str){
        TN cur = root;
        for(int i = 0; i < str.length(); i++){
            int ind = str.charAt(i) - 'a';
            if(cur.ar[ind] == null){
                cur.ar[ind] = new TN();
            }
            cur = cur.ar[ind];
        }
        cur.words = str;
        cur.word = true;
    }
}
class TN{
    TN[] ar = new TN[26];
    boolean word;
    String words;
    TN(){
    for(int i = 0; i < ar.length; i++){
        ar[i] = null;
    }
        word = false;
        words = null;
    }
}