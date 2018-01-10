package ga.util;

import ga.config.ConfigurationsGA;
import ga.model.Population;
import ga.util.Evaluation.RatePopulation;

public class RunGA {
	
	Population population;
	
	
	public void run(RatePopulation evalFunction){
		//Fase 1 = gerar a população inicial 
		population = Population.getInitialPopulation(ConfigurationsGA.SIZE_POPULATION);
		
		//Fase 2 = avalia a população
		population = evalFunction.evalPopulation(population); 
	}

}
