package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//57. Insert Interval 
public class Solution057 {
	
	
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	 

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
    	
    	int i = 0;
    	//前面不变动的部分
    	while (i < intervals.size() && newInterval.start > intervals.get(i).end)
    		res.add(intervals.get(i++));
    	//中间合并的部分
    	int start = newInterval.start;
    	int end = newInterval.end;
    	//判断当区间能否被合并，能合并，则产生新的区间，然后用这个新的区间与下一个区间进行重复的操作
    	while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
    		start = Math.min(start, intervals.get(i).start);
    		end = Math.max(end, intervals.get(i).end);
    		i++;
    	}
    	res.add(new Interval(start, end));
    	//后面不变动的部分
    	while (i < intervals.size())
    		res.add(intervals.get(i++));
	    return res;
    }
}
