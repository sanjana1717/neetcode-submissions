class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> s=new HashMap<>();
        for(String w :strs){
            char[] c= w.toCharArray();
            Arrays.sort(c);
            String k=new String(c);
            s.putIfAbsent(k,new ArrayList<>());
            s.get(k).add(w);
        }
        return new ArrayList<>(s.values());
          }
}
