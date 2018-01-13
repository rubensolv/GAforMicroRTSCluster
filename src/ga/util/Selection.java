package ga.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ga.model.Chromosome;
import ga.model.Population;

public class Selection {

	/**
	 * Este método será responsável por controlar o processo de seleção. 
	 * Acredito que nele poderá ser feitas as chamadas para cruzamento e para mutação.
	 * @param populacaoInicial que será utilizada para aplicarmos as alterações.
	 * @return Population com os devidos novos cromossomos.
	 */
	public Population applySelection(Population populacaoInicial){


		System.out.println("printing the initial population");
		printMap(populacaoInicial.getChromosomes());

		//class preselection have the methods for selecting parents
		PreSelection ps=new PreSelection(populacaoInicial);			
		List<Map.Entry<Chromosome, BigDecimal>> parents=ps.Tournament();		
		System.out.println("printing the parents selected for tournment ");
		printList(parents);

		//Class Reproduction have the methods for getting new population according the parents
		//using crossover and mutation
		Reproduction rp=new Reproduction(parents);
		Population newPopulation=rp.UniformCrossover();
		System.out.println("printing the new population after crossover");
		printMap(newPopulation.getChromosomes());
		newPopulation=rp.mutation(newPopulation);
		System.out.println("printing the new population after mutation");
		printMap(newPopulation.getChromosomes());

		//in elite is saved the best guys from the last population in order
		//to complete the population with the new guys
		HashMap<Chromosome, BigDecimal> elite=(HashMap<Chromosome, BigDecimal>)ps.sortByValue(populacaoInicial.getChromosomes());
		System.out.println("printing elite last population");
		printMap(elite);

		//joining elite and new sons in chromosomesNewPopulation
		HashMap<Chromosome, BigDecimal> chromosomesNewPopulation=new HashMap<Chromosome, BigDecimal>();
		chromosomesNewPopulation.putAll(newPopulation.getChromosomes());
		chromosomesNewPopulation.putAll(elite);
		System.out.println("printing complete new population (elite+new population)");
		printMap(chromosomesNewPopulation);

		newPopulation.setChromosomes(chromosomesNewPopulation);
		return newPopulation;
	}

	public void printMap(HashMap<Chromosome, BigDecimal> m)
	{
		for (Chromosome ch: m.keySet()){

			String key =ch.getGenes().toString();
			String value = m.get(ch).toString();  
			System.out.println(key + " " + value);  


		} 
	}
	public void printList(List<Map.Entry<Chromosome, BigDecimal>> l)
	{
		for (Map.Entry<Chromosome, BigDecimal> it: l){

			String key =it.getKey().getGenes().toString();
			String value = it.getValue().toString(); 
			System.out.println(key + " " + value);

		} 
	}

}
