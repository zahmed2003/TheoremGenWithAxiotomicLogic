
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
		
		formula f = new formula("(A1→A2)");
		formula g = new formula("((A3→A4)→(A4→A3))");
		
		System.out.println(g.formulaContains(f));
	
	
	
}
}
