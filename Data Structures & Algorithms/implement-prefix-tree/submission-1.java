

// TrieNode represents one node/character in the Trie
class TrieNode {

    // This HashMap stores child characters and their connected TrieNode
    // Example: 'a' -> node for character 'a'
    HashMap<Character, TrieNode> children = new HashMap<>();

    // This tells whether a complete word ends at this node
    boolean endOfWord = false;
}

// PrefixTree is the actual Trie data structure
public class PrefixTree {

    // Root is the starting node of the Trie
    // Root does not store any character
    private TrieNode root;

    // Constructor runs when we create a new PrefixTree object
    public PrefixTree() {

        // Create an empty root node
        root = new TrieNode();
    }

    // This method inserts a word into the Trie
    public void insert(String word) {

        // Start from the root node
        TrieNode cur = root;

        // Loop through each character of the word
        for (char c : word.toCharArray()) {

            // If current character is not already present as a child,
            // create a new TrieNode for that character
            cur.children.putIfAbsent(c, new TrieNode());

            // Move cur to the child node of character c
            cur = cur.children.get(c);
        }

        // After inserting all characters,
        // mark the last node as the end of a complete word
        cur.endOfWord = true;
    }

    // This method searches whether the complete word exists in the Trie
    public boolean search(String word) {

        // Start from the root node
        TrieNode cur = root;

        // Loop through each character of the word
        for (char c : word.toCharArray()) {

            // If current character is not found,
            // then the word does not exist in the Trie
            if (!cur.children.containsKey(c)) {

                // Return false because path is broken
                return false;
            }

            // Move cur to the child node of character c
            cur = cur.children.get(c);
        }

        // After checking all characters,
        // return true only if this node marks the end of a word
        return cur.endOfWord;
    }

    // This method checks whether any word starts with the given prefix
    public boolean startsWith(String prefix) {

        // Start from the root node
        TrieNode cur = root;

        // Loop through each character of the prefix
        for (char c : prefix.toCharArray()) {

            // If current character is not found,
            // then no word starts with this prefix
            if (!cur.children.containsKey(c)) {

                // Return false because prefix path is missing
                return false;
            }

            // Move cur to the child node of character c
            cur = cur.children.get(c);
        }

        // If all prefix characters are found, return true
        return true;
    }
}