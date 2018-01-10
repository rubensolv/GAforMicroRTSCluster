package principal;

import ga.config.ConfigurationsGA;
import ga.model.Population;

public class RunTests {

	public static void main(String[] args) {
		//classe com as configurações = ConfigurationsGA
		
		//teste de inicialização de população
		Population p = Population.getInitialPopulation(ConfigurationsGA.SIZE_POPULATION);
		p.print();
		p = Population.getInitialPopulation(new Integer(100));
		p.print();
		
	}

}
