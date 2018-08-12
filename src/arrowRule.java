import java.util.ArrayList;
import java.util.Iterator;

public class arrowRule extends inferenceRule
{
	
	public static formula modusPonens(formula f, formula g)
	{
		if(f.formulaContains(new nullFormula(g.getStringfromFormula() +"→")))
		{
			ArrayList<Integer> x = g.encode();
			x.add(2);
			
			ArrayList<Integer> y = f.encode();
			
			int loc = 0;
			for(int i = 0; i < y.size() - x.size(); i++)
			{
				ArrayList<Integer> z = new ArrayList<Integer>();
				
				
				for(int j = 0; j < x.size(); j++)
				{
					z.add(y.get(i + j));
				}
				
				if(formula.arrayToString(x).equals(formula.arrayToString(z)))
				{
					
					for(int l = loc; l < z.size() + loc; l++)
					{
						y.set(l, 0);
					}
					
					Iterator itr = y.iterator();
			        while (itr.hasNext())
			        {
			            int t = (Integer)itr.next();
			            if (t == 0)
			                itr.remove();
			        }
					
					if(logic.isLogic(f) && logic.isLogic(g))
					{
						logicFormula wff = new logicFormula(formula.arrayToString(y));
						
						ArrayList<String> der = new ArrayList<String>();
						der.add(f.getStringfromFormula());
						der.add(g.getStringfromFormula());
						
						wff.addDerivation(der, new arrowRule());
						
						return wff;
					}
					
					else
					{
						formula wff = new formula(formula.arrayToString(y));
						
						ArrayList<String> der = new ArrayList<String>();
						der.add(f.getStringfromFormula());
						der.add(g.getStringfromFormula());
						
						wff.addDerivation(der, new arrowRule());
						
						return wff;
					}
				}
				
				loc++;
			}
			
			
		}
		
		else	 if(g.formulaContains(new nullFormula(f.getStringfromFormula() +"→")))
		{
			ArrayList<Integer> x = f.encode();
			x.add(2);
			
			ArrayList<Integer> y = g.encode();
			
			int loc = 0;
			for(int i = 0; i < y.size() - x.size(); i++)
			{
				ArrayList<Integer> z = new ArrayList<Integer>();
				
				
				for(int j = 0; j < x.size(); j++)
				{
					z.add(y.get(i + j));
				}
				
				if(formula.arrayToString(x).equals(formula.arrayToString(z)))
				{
					
					for(int l = loc; l < z.size() + loc; l++)
					{
						y.set(l, 0);
					}
					
					Iterator itr = y.iterator();
			        while (itr.hasNext())
			        {
			            int t = (Integer)itr.next();
			            if (t == 0)
			                itr.remove();
			        }
					
					if(logic.isLogic(f) && logic.isLogic(g))
					{
						logicFormula wff = new logicFormula(formula.arrayToString(y));
						
						ArrayList<String> der = new ArrayList<String>();
						der.add(f.getStringfromFormula());
						der.add(g.getStringfromFormula());
						
						wff.addDerivation(der, new arrowRule());
						
						return wff;
					}
					
					else
					{
						formula wff = new formula(formula.arrayToString(y));
						
						ArrayList<String> der = new ArrayList<String>();
						der.add(f.getStringfromFormula());
						der.add(g.getStringfromFormula());
						
						wff.addDerivation(der, new arrowRule());
						
						return wff;
					}
				}
				
				loc++;
			}
			
			
		}
		
		return null;
	}

}
