
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
		
		 new Thread(() -> {
			logic.inputLogicAxiomsFromTextFile("src/logicAxioms");
			logic.beginLoop();
		}).start(); 
		
}
}
