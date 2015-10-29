package Algorithm.Other;

import java.util.*;

public class MergeInterval{

	//Using a priorityqueue to sort the list first
  public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return res;
        }
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval v1,Interval v2){
                if(v1.start == v2.start){
                    return v1.end - v2.end;
                }
                return v1.start-v2.start;
            }
        };
        Collections.sort(intervals,comp);
        //after sort, we go throught the lists 
        Interval cur = intervals.get(0);
        for(int i = 1;i<intervals.size();i++){
        	//no overlap, add cur to result
            if(intervals.get(i).start > cur.end){
                res.add(cur);
                cur = intervals.get(i);
            }else if(intervals.get(i).start <= cur.end && intervals.get(i).end > cur.end){
            	//overlap, then merge
                cur.end = intervals.get(i).end;
            }
        }
        //don't forget the last cur
        res.add(cur);
        return res;
    }

}