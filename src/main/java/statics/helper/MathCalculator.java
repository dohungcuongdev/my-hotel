/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statics.helper;

/**
 *
 * @author HUNGCUONG
 */
public class MathCalculator {
	
	public static double round(double value) {
		return round(value,2);
	}

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    public static boolean isEQstringOrInt(Object x, Object y) {
    	boolean isEQ = false;
    	if(x instanceof String) {
    		if(y instanceof String) {
    			isEQ = ((String) x).trim().equals(((String) y).trim());
    		} else if(y instanceof Integer) {
    			try {
    				isEQ = Integer.parseInt(x.toString().trim()) == (Integer) y;
    			} catch(Exception e) {
    				isEQ = false;
    			}
    		}
    			
    	} else if(x instanceof Integer) {
    		if(y instanceof String) {
    			try {
    				isEQ = Integer.parseInt(y.toString().trim()) == (Integer) x;
    			} catch(Exception e) {
    				isEQ = false;
    			}
    		} else if(y instanceof Integer) {
    			isEQ = x == y;
    		}
    	}
    	return isEQ;
    }
    
    public static boolean isGTstringOrInt(Object x, Object y) {
    	boolean isGT = false;
    	if(x instanceof String) {
    		if(y instanceof String) {
    			isGT = ((String) x).trim().compareTo(((String) y).trim()) > 0;
    		} else if(y instanceof Integer) {
    			try {
    				isGT = Integer.parseInt(x.toString().trim()) > (Integer) y;
    			} catch(Exception e) {
    				isGT = false;
    			}
    		}
    			
    	} else if(x instanceof Integer) {
    		if(y instanceof String) {
    			try {
    				isGT = Integer.parseInt(y.toString().trim()) < (Integer) x;
    			} catch(Exception e) {
    				isGT = false;
    			}
    		} else if(y instanceof Integer) {
    			isGT = (Integer) x > (Integer) y;
    		}
    	}
    	return isGT;
    }
    
    public static boolean isGTEQstringOrInt(Object x, Object y) {
    	boolean isGT = false;
    	if(x instanceof String) {
    		if(y instanceof String) {
    			isGT = ((String) x).trim().compareTo(((String) y).trim()) >= 0;
    		} else if(y instanceof Integer) {
    			try {
    				isGT = Integer.parseInt(x.toString().trim()) >= (Integer) y;
    			} catch(Exception e) {
    				isGT = false;
    			}
    		}
    			
    	} else if(x instanceof Integer) {
    		if(y instanceof String) {
    			try {
    				isGT = Integer.parseInt(y.toString().trim()) <= (Integer) x;
    			} catch(Exception e) {
    				isGT = false;
    			}
    		} else if(y instanceof Integer) {
    			isGT = (Integer) x >= (Integer) y;
    		}
    	}
    	return isGT;
    }
    
    public static boolean isLTstringOrInt(Object x, Object y) {
    	return !isGTEQstringOrInt(x, y);
    }
    
    public static boolean isLTEQstringOrInt(Object x, Object y) {
    	return !isGTstringOrInt(x, y);
    }
}
