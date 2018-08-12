import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class logic 
{

	/** method for inputting a set of axioms (string format) */
	public static void inputAxiomsFromString(ArrayList<String> s)
	{
		for(int i = 0; i < s.size(); i++)
		{
			new axiom(s.get(i));
		}
	}
	
	/** method for inputting a set of axioms (textFile format) */
	public static void inputAxiomsFromTextFile(String filePath)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			try {
				String s = br.readLine();
				while(s != null)
				{
					new axiom(s);
					s = br.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** method for inputting a set of logic axioms (textFile format) */
	public static void inputLogicAxiomsFromTextFile(String filePath)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			try {
				String s = br.readLine();
				while(s != null)
				{
					new logicFormula(s);
					s = br.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** returns true if the formula is a logic formula*/
	public static boolean isLogic(formula f)
	{
		if(f instanceof logicFormula)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**  Random selection of a formula */
	public static formula randomSelection()
	{
			Object[] keys = formulaList.formulas.keySet().toArray();
			formula wff = (formula) keys[new Random().nextInt(keys.length)];
			
			
			if(derivationList.formulas.keySet().contains(wff.getStringfromFormula()))
			{
			wff.addDerivation(derivationList.formulas.get(wff.getStringfromFormula()).getFormulae(), derivationList.formulas.get(wff.getStringfromFormula()).getinferenceRule());
			}
			return wff;
	}
	
	/** a method that iterates through each inference rule (update later when more rules)*/
	public static void iterateThroughRules()
	{
		formula wff1 = generalization.ruleOfGeneralization(randomSelection());
			System.out.println(wff1.getStringfromFormula());
			
		formula wff2 = arrowRule.modusPonens(randomSelection(), randomSelection());
			if(wff2 != null) {System.out.println(wff2.getStringfromFormula());}
	
	}
	
	/** begins the process */
	public static void beginLoop()
	{
		while (true)
		{
			iterateThroughRules();
		}
	}
}
