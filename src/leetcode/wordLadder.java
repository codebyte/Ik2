package leetcode;

import java.util.*;

public class wordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Word Transformation
        Map<String, ArrayList<String>> mutations = new HashMap<>();

        for (String gene : wordList) {
            for (int i = 0; i < gene.length(); i++) {
                String newGen = gene.substring(0, i) + '*' + gene.substring(i + 1);
                mutations.putIfAbsent(newGen, new ArrayList<>());
                mutations.get(newGen).add(gene);
            }
        }

        // Begin Word
        for (int i = 0; i < beginWord.length(); i++) {
            String newGen = beginWord.substring(0, i) + '*' + beginWord.substring(i + 1);
            mutations.putIfAbsent(newGen, new ArrayList<>());
            mutations.get(newGen).add(beginWord);
        }

        Map<String, ArrayList<String>> adjacencyList = new HashMap<>();

        for (ArrayList<String> values : mutations.values()) {
            for (String key : values) {
                adjacencyList.putIfAbsent(key, new ArrayList<>());
                for (String value : values) {
                    if (!key.equals(value))
                        adjacencyList.get(key).add(value);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        int steps = 1;
        q.add(beginWord);
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);


        while (!q.isEmpty()) {

            int qSize = q.size();

            while (qSize > 0) {

                String gene = q.poll();
                if (gene.equals(endWord)) {
                    return steps;
                }

                adjacencyList.get(gene).forEach(v -> {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.add(v);
                    }
                });
                qSize--;
            }
            steps++;

        }
        return 0;
    }

    public static void main(String args[]) {

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));

    }
}
