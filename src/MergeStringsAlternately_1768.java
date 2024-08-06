// https://leetcode.com/problems/merge-strings-alternately

class MergeStringsAlternately_1768 {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0;

        while(i<n1 || i<n2){
            if(i<n1){
                sb.append(word1.charAt(i));
            }
            if(i<n2){
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();

    }
}


// Example 1:

// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r

// Example 2:

// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b 
// word2:    p   q   r   s
// merged: a p b q   r   s

// Example 3:

// Input: word1 = "abcd", word2 = "pq"
// Output: "apbqcd"
// Explanation: Notice that as word1 is longer, "cd" is appended to the end.
// word1:  a   b   c   d
// word2:    p   q 
// merged: a p b q c   d