package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//68. Text Justification
public class Solution068 {

    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<String>();
    	
    	//剩余的单词
    	Queue<String> residue = new LinkedList<String>(Arrays.asList(words));
    	//当前行的单词
    	Queue<String> curLine = new LinkedList<String>();
    	//当前行的单词总长度
    	int curLineLen = 0;
    	
    	while (!residue.isEmpty()) {
    		String curStr = residue.peek();
    		if (curStr.length() + curLineLen + curLine.size() <= maxWidth) {
    			curLine.offer(residue.poll()); 
    			curLineLen += curStr.length();
    		} else {		
    			res.add(createLine(curLine, maxWidth, curLineLen));
    			curLineLen = 0;
    		}
    	}
    	
    	//处理最后一行
    	StringBuilder builder = new StringBuilder();
    	builder.append(curLine.poll());
    	while (!curLine.isEmpty()) {
    		addSpace(builder, 1);
    		builder.append(curLine.poll());
    	}
    	addSpace(builder, maxWidth - builder.length());
    	res.add(builder.toString());
    	
    	return res;
    }
    
    //添加指定数目的空格
    private void addSpace(StringBuilder builder, int n) {
    	for (int i = 0; i < n; i++)
    		builder.append(' ');
    }
    
    //根据单词创建一行
    private String createLine(Queue<String> words, int maxWidth, int len) {
    	StringBuilder builder = new StringBuilder();
		if (words.size() == 1) {
			int spaceNum = maxWidth - words.peek().length();
			builder.append(words.poll());
			addSpace(builder, spaceNum);
		} else {
			//计算空格数目
			int spaceNum = maxWidth - len;
			int averageNum = spaceNum / (words.size() - 1);
			int more = spaceNum % (words.size() - 1);
			
			//加入单词和空格
			while (!words.isEmpty()) {
				builder.append(words.poll());
				if (!words.isEmpty()) {
					addSpace(builder, averageNum);
					spaceNum -= averageNum;
					if (more > 0) {
						spaceNum -= 1;
						more--;
						addSpace(builder, 1);
					}
				}
			}
		}
    	return builder.toString();
    }
}
