package Algorithm.Other;

import java.util.*;
//Question: https://leetcode.com/problems/insert-interval/
public class InsertInterval{
	static class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static List<Interval> insert(List<Interval> intervals,Interval newInterval){
		//Because we might need to delete the interval if we want to do in place
		//but in arraylist, the delete is O(n) operation, so which will overall not linear complexity

		//so we use a another list to copy the interval

		//so overall complexity should be both O(n) is time and space

		//The algorithm will be two parts, 
		//first we find a valid place to insert the newInterval(by compare curInterval.end and newInterval.start)
		//After that we try to do merge if necessary

		List<Interval> res = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0){
			res.add(newInterval);
			return res;
		}
		int i = 0;
		//Keep going find the right place to insert the newInterval
		while(i<intervals.size() && (intervals.get(i).end < newInterval.start)){
			res.add(intervals.get(i));
			i++;
		}
		//if it's not the end of lists
		//We update(merge) the newInterval start, should be the minimum of(newInterval.start,interval.get(i).start)
		if(i<intervals.size()){
			newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
		}
		//add it to res
		res.add(newInterval);
		//try to merge the overlapping intervals
		//the condition is cur.start <= newInterval.end
		while(i<intervals.size() && intervals.get(i).start <= newInterval.end){
			newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
			i++;
		}
		//add remain intervals to the res
		while(i<intervals.size()){
			res.add(intervals.get(i));
			i++;
		}
		return res;
	}

}