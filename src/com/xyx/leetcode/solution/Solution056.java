package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 56. Merge Intervals
public class Solution056 {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalsComparator());
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0)
			return result;
		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval last = result.get(result.size()-1);
			Interval cur = intervals.get(i);
			if (last.end >= cur.start) {
				int end = Math.max(last.end, cur.end);
				result.get(result.size()-1).end = end;
			}
			else
				result.add(cur);
		}
		return result;
	}
	
	static class IntervalsComparator implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}
	
	class Interval {
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
}

