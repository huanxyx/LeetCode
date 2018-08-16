package com.xyx.leetcode.solution;

import java.util.*;

//126. Word Ladder II
public class Solution126 {

    /**
     * 将问题抽象为无向图问题
     * 将无向图通过BFS转换为树：利用hashMap存储每个节点的父节点（在这个地方可以使用双端bfs，用来提高效率）
     * 再对树进行DFS
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>(wordList);
        if (!unvisited.contains(endWord)) return res;
        unvisited.remove(beginWord);                //记得去除集合中的beginWord，不然会造成死递归

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, List<String>> fathers = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                for (int j = 0; j < curWord.length(); j++) {
                    char[] chArr = curWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {          //优化
                        chArr[j] = ch;
                        String nextWord = new String(chArr);
                        if (unvisited.contains(nextWord)) {
                            if (visited.add(nextWord))
                                queue.offer(nextWord);
                            if (fathers.containsKey(nextWord)) {
                                fathers.get(nextWord).add(curWord);
                            } else {
                                List<String> list = new ArrayList<>();
                                list.add(curWord);
                                fathers.put(nextWord, list);
                            }
                        }
                    }
                }
            }
            //在最后才去除掉当前层已经遍历过的节点
            //不能遍历到就把节点去除，应该等待当前层的所有节点遍历完才行，不然的话，通过k个节点到达终止节点的路径只有一条
            unvisited.removeAll(visited);
            if (fathers.containsKey(endWord)) break;
        }

        if (fathers.containsKey(endWord)) {
            dfs(fathers, new ArrayList<>(), endWord, res);
        }
        return res;
    }

    //dfs查找路径
    private void dfs(Map<String, List<String>> fathersMap, List<String> con, String cur, List<List<String>> res) {
        if (cur == null) {
            ArrayList<String> newRes = new ArrayList<>(con);
            Collections.reverse(newRes);
            res.add(newRes);
        } else {
            con.add(cur);
            List<String> fathers = fathersMap.get(cur);
            if (fathers == null) //意味着这是根节点(注意，当不存父节点的时候，是为空)
                dfs(fathersMap, con, null, res);
            else  { //不是根节点
                for (String father : fathers)
                    dfs(fathersMap, con, father, res);
            }
            con.remove(cur); //用完之后记得删除
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution126().findLadders(
                        "a", "c",
                        Arrays.asList("a","b","c")));
    }
}
