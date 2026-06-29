
// TrieNode represents one node in the Trie
class TrieNode {

    // children stores character as key and TrieNode as value
    // Example: 'a' -> node connected to character 'a'
    HashMap<Character, TrieNode> children = new HashMap<>();

    // endOfWord tells whether a complete word ends at this node
    boolean endOfWord = false;
}

// This class name must be WordDictionary for this NeetCode problem
class WordDictionary {

    // root is the starting node of the Trie
    private TrieNode root;

    // Constructor runs when WordDictionary object is created
    public WordDictionary() {

        // Create an empty root node
        root = new TrieNode();
    }

    // addWord inserts a word into the Trie
    public void addWord(String word) {

        // Start from the root node
        TrieNode cur = root;

        // Loop through every character in the word
        for (char c : word.toCharArray()) {

            // If character c is not already present, create a new TrieNode
            cur.children.putIfAbsent(c, new TrieNode());

            // Move cur to the child node of character c
            cur = cur.children.get(c);
        }

        // After inserting all characters, mark this node as end of word
        cur.endOfWord = true;
    }

    // search checks whether the word exists in the Trie
    // It also supports '.' wildcard
    public boolean search(String word) {

        // Call DFS helper starting from index 0 and root node
        return dfs(word, 0, root);
    }

    // dfs checks the word character by character
    private boolean dfs(String word, int index, TrieNode node) {

        // If we reached the end of the word
        if (index == word.length()) {

            // Return true only if a complete word ends here
            return node.endOfWord;
        }

        // Get the current character
        char c = word.charAt(index);

        // If current character is '.'
        if (c == '.') {

            // Try every child node because '.' can be any character
            for (TrieNode child : node.children.values()) {

                // If any path gives true, return true
                if (dfs(word, index + 1, child)) {

                    // Word matched successfully
                    return true;
                }
            }

            // If no child path matched, return false
            return false;
        }

        // If current character is not found in children
        if (!node.children.containsKey(c)) {

            // Word does not exist
            return false;
        }

        // Move to the next character and next TrieNode
        return dfs(word, index + 1, node.children.get(c));
    }
}