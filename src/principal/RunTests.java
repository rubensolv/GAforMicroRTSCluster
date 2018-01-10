package principal;

import ga.config.ConfigurationsGA;
import ga.model.Population;
import ga.util.RunGA;
import ga.util.Evaluation.RatePopulation;
import ga.util.Evaluation.RoundRobinEval;

public class RunTests {

	public static void main(String[] args) {
		//classe com as configurações = ConfigurationsGA
		
		//teste de inicialização de população
		//Population p = Population.getInitialPopulation(ConfigurationsGA.SIZE_POPULATION);
		//p.print();
		//p = Population.getInitialPopulation(new Integer(100));
		//p.print();
	
		//aplicando o Algoritmo Genético
		//criei uma classe para controlar a execução do GA.
		RunGA ga = new RunGA();
		
		//escolhemos uma função de avaliação
		RatePopulation fEval = new RoundRobinEval();
		
		//rodamos o GA
		ga.run(fEval);
		
	}

}