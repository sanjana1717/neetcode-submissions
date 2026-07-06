

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        // Edge case:
        // If input is null or empty, return empty list
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // HashMap structure:
        // key   -> sorted version of the word
        // value -> list of words that become the same after sorting
        //
        // Example:
        // "aet" -> ["eat", "tea", "ate"]
        // "ant" -> ["tan", "nat"]
        // "abt" -> ["bat"]
        Map<String, List<String>> map = new HashMap<>();

        // Loop through every word in the input array
        for (String word : strs) {

            // Convert the word into a character array
            //
            // Example:
            // word = "eat"
            // charArray = ['e', 'a', 't']
            char[] chars = word.toCharArray();

            // Sort the character array
            //
            // Example:
            // ['e', 'a', 't'] becomes ['a', 'e', 't']
            Arrays.sort(chars);

            // Convert the sorted char array back into a String
            //
            // Example:
            // ['a', 'e', 't'] becomes "aet"
            String sortedKey = new String(chars);

            // If this sorted key already exists in the map,
            // it means this word belongs to an existing anagram group
            if (map.containsKey(sortedKey)) {

                // Get the list for this key and add the original word
                //
                // Example:
                // key = "aet"
                // existing list = ["eat", "tea"]
                // add "ate"
                map.get(sortedKey).add(word);

            } else {

                // If this sorted key does not exist,
                // create a new anagram group
                List<String> group = new ArrayList<>();

                // Add the current original word to the new group
                group.add(word);

                // Put the sorted key and group into the map
                //
                // Example:
                // "aet" -> ["eat"]
                map.put(sortedKey, group);
            }
        }

        // The map values contain all grouped anagrams
        //
        // Example:
        // map.values() = [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
        //
        // Convert map values into List<List<String>> and return
        return new ArrayList<>(map.values());
    }
}