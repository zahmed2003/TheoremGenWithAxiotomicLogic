import java.util.ArrayList;

public class generalization extends inferenceRule
{
		public static formula ruleOfGeneralization(formula f)
		{
			int loc = 0;
			for(int i = 0; i < f.encode().size(); i++)
			{
				if((f.encode().get(i) > loc) && (PrimeNumberGenerator.primes.contains(f.encode().get(i))))
				{
					loc = f.encode().get(i);
				}
			}
			
			loc = PrimeNumberGenerator.primes.get(PrimeNumberGenerator.primes.indexOf(loc) + 1);
			
			
			ArrayList<Integer> trans = new ArrayList<Integer>();
			trans.add(3);
			trans.add(6);
			trans.add(loc);
			
			for(int j = 0; j < f.encode().size(); j++)
			{
				trans.add(f.encode().get(j));
			}
			
			trans.add(4);
			
			if(logic.isLogic(f))
			{
			logicFormula wff = new logicFormula(formula.arrayToString(trans));
			
			ArrayList<String> s = new ArrayList<String>();
			s.add(f.getStringfromFormula());
			
			wff.addDerivation(s, new generalization());
			
			return wff;
			}
			else
			{
				formula wff = new formula(formula.arrayToString(trans));
				
				ArrayList<String> s = new ArrayList<String>();
				s.add(f.getStringfromFormula());
				
				wff.addDerivation(s, new generalization());
				
				return wff;
			}
		}
}
