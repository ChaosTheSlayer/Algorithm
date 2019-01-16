package Number;


//Question: http://blog.csdn.net/linhuanmars/article/details/20089131

public class Sqrt{
	//Divide and conquar
	public static int mySqrt(int x) {
        if(x<0){
        	return -1;
        }
        if(x == 0){
        	return 0;
        }
        int l = 1;
        int r = x;
        while(l<=r){
        	int m = l+(r-l)/2;
        	if(m <= x/m && m+1>x/(m+1)){
        		return m;
        	}
        	if(m<x/m){
        		l = m+1;
        	}else{
        		r = m-1;
        	}
        }
        return 0;
    }

    public static  double sqrtDouble(double x){
    	if(x <0){
    		return 1.0;
    	}
    	if(x == 0){
    		return 0.0;
    	}
    	double l = 0.0;
    	double r = x;
    	double tolerence = 0.00000000001;
    	while(r-l>tolerence){
    		double m = l+(r-l)/2;
    		if(m<=x/m && m+1>x/m+1){
    			return m;
    		}if(m<x/m){
    			l = m;
    		}else{
    			r = m;
    		}
    	}
    	return 0.0;

    }
}