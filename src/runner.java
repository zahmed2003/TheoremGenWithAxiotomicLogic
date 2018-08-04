
public class runner 
{
	
	public static void main(String[] args) 
	{
		new Thread(() -> {
			
			PrimeNumberGenerator.generatePrimes();
		}).start();
		
		new Thread(() -> {
			variables.addElements();
		}).start();
		
		/* new Thread(() -> {
			logic.inputLogicAxiomsFromTextFile("src/logicAxioms");
			logic.beginLoop();
		}).start(); */
		
		formula f = new logicFormula("(A2→A2)");
		formula g = new logicFormula("((A7→A9)→(A4→A9))");
		
		System.out.println(g.formulaContains(f));
	
	
	
}
}
