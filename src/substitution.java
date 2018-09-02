import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class substitution extends inferenceRule
{
	
	//only works for LOGIC formulas right now
	
	 public static formula substitute(formula f)
	{
		//check which variable to replace
		 int replace = 0;
		 int curr = 0;
		 nullFormula g = new nullFormula(logic.randomSelection().getStringfromFormula());
		 
		 while(replace == 0 && curr < f.encode().size())
		 {
			 if(PrimeNumberGenerator.getRealPrimes().contains(f.encode().get(curr) - 1) && new Random().nextInt(2) == 0)
			 {
				 replace = f.encode().get(curr);
			 }
			 curr++;
		 }
		 
		 
		 //check highest prime within g
		 int largestPrime = 0;
		 
		 for(int i = 0; i < g.encode().size(); i++)
		 {
			 if(PrimeNumberGenerator.getRealPrimes().contains(g.encode().get(i) - 1) && g.encode().get(i) > largestPrime)
			 {
				 largestPrime = g.encode().get(i);
			 }
		 }
		 
		 //create first prime
		 int cur = 0;
		 int firstIndex = 0;
		 
		 while(PrimeNumberGenerator.getRealPrimes().get(cur) <= largestPrime - 1)
		 {
			 firstIndex++;
			 cur++;
		 }
		 
		 firstIndex++;
		 
		 //change original f.encode()
		 
		 ArrayList<Integer> trans = f.encode();
		 int[] wff = new int[f.encode().size()];
		 int index = firstIndex;
		 
		 for(int i = 0; i < trans.size(); i++)
		 {
			 if(PrimeNumberGenerator.getRealPrimes().contains(trans.get(i) - 1) && trans.get(i) != replace)
			 {
				 int x = trans.get(i);
				 
				 for(int j = 0; j < trans.size(); j++)
				 {
					 if(trans.get(j) == x) 
					 {
						 wff[j] = PrimeNumberGenerator.getRealPrimes().get(index) + 1;
						 trans.set(j, 0);
					 }
				 }
				 index++;
			 }
			 else if(trans.get(i) != 0)
			 {
				 wff[i] = trans.get(i);
			 }
		 }
		 
		//create an arraylist of arraylists of integers for replacement
		 ArrayList<ArrayList<Integer>> comp = new ArrayList<ArrayList<Integer>>();
		 
		 for(int i = 0; i < wff.length; i++)
		 {
			 ArrayList<Integer> y = new ArrayList<Integer>();
			 y.add(wff[i]);
			 comp.add(y);
		 }
		 
		 //replace
		 for(int i = 0; i < comp.size(); i++)
		 {
			 if(comp.get(i).contains(replace))
			 {
				 comp.set(i, g.encode());
			 }
		 }
		 
		 //create a final array list of the replaced
		 ArrayList<Integer> end = new ArrayList<Integer>();
		 
		 for(int i = 0; i < comp.size(); i++)
		 {
			int size = comp.get(i).size();
			
			for(int j = 0; j < size; j++) {end.add(comp.get(i).get(j));}
		 }
		 
		 //return the final formula
		 
		 formula fin = new formula(formula.arrayToString(end));
		 
		 ArrayList<String> deriv = new ArrayList<String>();
		 deriv.add(f.getStringfromFormula());
		 
		 fin.addDerivation(deriv, new substitution());
		 
		 return fin;
	}
	
}
