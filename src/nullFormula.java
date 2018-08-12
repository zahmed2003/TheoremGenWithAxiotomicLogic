
public class nullFormula extends formula
{

	public nullFormula(String f)
	{
		super(f);
		
		derivationList.formulas.remove(this.f);
		formulaList.formulas.remove(this);
		
	}
	
}
