package ga.util.Evaluation;

import ga.model.Population;

public interface RatePopulation {
	/* A função de avaliação irá controlar as chamadas no cluster, ou fazer os cálculos das simulações e entregar
	*  uma população devidamente avaliada.
	*/
	public Population evalPopulation(Population population);
}
