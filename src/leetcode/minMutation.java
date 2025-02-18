package leetcode;

import java.util.*;

public class minMutation {


    public static int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> seen = new HashSet<>();
        Set<String> validGenes = new HashSet<>(Arrays.asList(bank));

        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        seen.add(startGene);

        int steps = 0;

        while (!q.isEmpty()) {

            int qSize = q.size();

            while (qSize > 0) {

                String gene = q.poll();

                if (endGene.equals(gene)) {
                    return steps;
                }

                char[] options = {'A', 'G', 'C', 'T'};

                for (int i = 0; i < gene.length(); i++) {

                    for (int c = 0; c < options.length; c++) {

                        String newGene = gene.substring(0, i) + options[c] + gene.substring(i + 1);

                        if (!seen.contains(newGene) && validGenes.contains(newGene)) {
                            seen.add(newGene);
                            q.add(newGene);
                        }
                    }
                }

                qSize--;
            }
            steps++;
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        return 0;

    }

    public static void main(String args[]) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        minMutation(startGene, endGene, bank);

        System.out.println(minMutation(startGene, endGene, bank));

    }

}
