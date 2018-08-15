package com.xyx.leetcode.solution;

import java.util.*;

//127. Word Ladder
public class Solution127 {

    /**
    * 广度优先搜索
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return solution_1(beginWord, endWord, wordList);
    }

    /**
     * 一般的实现方案：从开始往结束的字符串广度搜索
     */
    private int solution_1(String beginWord, String endWord, List<String> wordList) {
        //剩余的字符串
        Set<String> last = new HashSet<String>(wordList);
        //当前的字符串
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] wordChar = word.toCharArray();
                    for (char w = 'a'; w <= 'z'; w++) {
                        wordChar[j] = w;
                        String nextWord = new String(wordChar);
                        if (last.contains(nextWord)) {
                            if (nextWord.equals(endWord)) return level + 1;
                            last.remove(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 优化方案：从起点和终点同时出发，每一次遍历都是遍历点数较小的那一边
     */
    private int solution_2(String beginWord, String endWord, List<String> wordList) {
        Set<String> last = new HashSet<>(wordList);
        if (!last.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;
        //当两者都不为空的时候，才有可能进行下去
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //每次操作的都是较大的那个队列
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            level++;
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] wordChArr = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        wordChArr[i] = j;
                        String nextWord = new String(wordChArr);

                        //遍历到终结位置了
                        if (endSet.contains(nextWord)) return level;
                        //找到下一个点
                        if (last.contains(nextWord)) {
                            nextSet.add(nextWord);
                            last.remove(nextWord);
                        }
                    }
                }
            }
            beginSet = nextSet;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution127().ladderLength(
                        "hit", "cog",
                        Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
