// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2 == 0)
			return x1;
		if (x2 > 0)
		{
			while (x2 > 0)
			{
				x1 ++;
				x2 --;
			}
		}
		else
		{
			while(x2 < 0)
			{
				x1 --;
				x2 ++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 == 0)
			return x1;
		if (x2 > 0)
		{
			while (x2 > 0)
			{
				x1 --;
				x2 --;
			}
		}
		else
		{
			while(x2 < 0)
			{
				x1 ++;
				x2 ++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
    public static int times(int x1, int x2) {
		int result = 0;
		int i = 0;
		int a = x1;
		int b = x2;
		boolean isN = (x1 < 0) ^ (x2 < 0);
        if (x1 == 0 || x2 == 0)
		{
        	return 0;
        }
        if (x1 < 0)
			a = minus(0, x1);
        if (x2 < 0)
			b = minus(0, x2); 
        while (i < b)
		{
            result = plus(result, a);
            i = plus(i, 1);
        }
        if (isN)
		{
            return minus(0, result);
        }
        return result;
    }

	// Returns x1^x2
    public static int pow(int x1, int x2) {
		boolean isBaseNegative = (x1 < 0);
        int base = x1;
		int result = base;
        int i = 1;
        if (x2 == 0)
		{
            return 1;
        }
        if (x2 == 1) 
		{
            return x1;
        }
        if (x1 == 0) 
		{
            return 0;
        }
        if (isBaseNegative) 
		{
            base = minus(0, x1); 
        }
        while (i < x2) {
            result = times(result, base);
            i = plus(i, 1);
        }
        if (isBaseNegative) {
            int two = plus(1, 1); 
            int remainder = mod(x2, two);
            if (remainder != 0)
			{ 
                return minus(0, result);
            }
        }
        return result;
    }

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		boolean isNegative = (x1 < 0) ^ (x2 < 0);
		int dividend = x1;
		int divisor = x2;
		int quotient = 0;
		if (x2 == 0) 
			return 0;
        if (x1 == 0) 
			return 0;
        if (x1 < 0) dividend = minus(0, x1);
        if (x2 < 0) divisor = minus(0, x2);
        while (dividend >= divisor) { 
            dividend = minus(dividend, divisor);
            quotient = plus(quotient, 1);
        }
        if (isNegative) {
            return minus(0, quotient);
        }
        return quotient;
    }

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if ((x1 == 0) || (x1 == x2))
			return 0; 
        int quotient = div(x1, x2);
        int product = times(quotient, x2);
        return minus(x1, product);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
    if (x == 0)
		return 0;
    if (x == 1) 
		return 1;
    int low = 1;
    int high = x;
    int result = 1; 
    while (low <= high)
	{
        int diff = minus(high, low);
        int mid = plus(low, div(diff, 2)); 
        int square = times(mid, mid);
        if (square < 0 || times(mid, mid) > x) 
		{ 
            high = minus(mid, 1);
        }
		else if (square == x) 
		{
            return mid;
        } 
		else 
		{ 
            result = mid;
            low = plus(mid, 1);
        }
    }
    return result;
	}	  	  
}