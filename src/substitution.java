import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class substitution extends inferenceRule
{
	
	 public static formula substitute(logicFormula f)
	{
		 
		 /*
		ArrayList<Integer> x = f.encode();
		
		ListIterator<Integer> itr = x.listIterator();
        while (itr.hasNext())
        {
            int t = (Integer)itr.next();
            int r = new Random().nextInt(2);
            
            if(PrimeNumberGenerator.getRealPrimes().contains(t - 1))
            {
            	if(r == 0) {}
            	else
            	{
            		nullFormula s = new nullFormula(logic.randomSelection().getStringfromFormula());
            		
            		//need a check to replace all others of same variable
            		
            		
            	}
            }
            
        }
		
        return null;
        
        */
		 
		 ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> y = f.encode();
		 
		 for(int i = 0; i < y.size(); i++)
		 {
			 ArrayList<Integer> temp = new ArrayList<Integer>();
			 temp.add(f.encode().get(i));
			 
			 x.add(temp);
		 }
		 
		 for(int j = 0; j < y.size(); j++)
		 {
			 int r = new Random().nextInt(2);
			 
			 if(PrimeNumberGenerator.getRealPrimes().contains(f.encode().get(j) - 1))
			 {
				 if(r==0)
				 {
					 for(int k = 0; k < y.size(); k++)
					 {
						 if(y.get(k) == f.encode().get(j))
					 }
				 }
			 }
		 }
		 
	
	}
	
	
}
