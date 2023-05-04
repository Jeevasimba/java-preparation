package com.interview.trie;

class Node{
    Node links[] = new Node[26];

    public Node get(char key){
        return links[key-'a'];
    }

    public boolean containskey(char key){
        return links[key - 'a'] != null;
    }

    public void put(char key , Node node){
        links[key-'a'] = node;
    }

}

class Solution {

    public static int insert(String s) {
        // Write your code here.

        int count = 1;

        Node root = new Node();

        for (int i = 0; i < s.length() ; i++) {
            Node node = root;
            String word = s.substring(i);

            for (int j = 0; j < word.length() ; j++) {

                if(!node.containskey(word.charAt(j))){
                    node.put(word.charAt(j),new Node());
                    count++;
                }

                node = node.get(word.charAt(j));
            }

        }

        return count;
    }

    public static int countDistinctSubstrings(String s)
    {
        //	  Write your code here.

        for (int i = 0; i < s.length() ; i++) {

            insert(s.substring(i));

        }

        return insert(s);
    }

}