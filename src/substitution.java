import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class substitution extends inferenceRule
{
	
	//only works for LOGIC formulas right now
	
	 public static formula substitute(logicFormula f)
	{
		 int replace = 0;
		 int curr = 0;
		 
		//check to see which variable to substitute
		 
		while (replace == 0 && curr < f.encode().size())
		{
			if(PrimeNumberGenerator.getRealPrimes().contains(f.encode().get(curr) - 1)) {replace = f.encode().get(curr);}
			curr++;
		}
		
		formula g = logic.randomSelection();
		int largestPrime = 0;
		
		for(int i = 0; i < g.encode().size(); i++)
		{
			if(PrimeNumberGenerator.getRealPrimes().contains(f.encode().get(i) - 1)) {largestPrime = f.encode().get(i);}
		}
		
		ArrayList<Integer> wffT = f.encode();
		
		int s = 0;
		int getIndex = 0;ß
		
		while(s < PrimeNumberGenerator.getRealPrimes().size() && getIndex == 0)
		{
			if(PrimeNumberGenerator.getRealPrimes().get(s))
			s++;
		}
		
	
	}
	
}
