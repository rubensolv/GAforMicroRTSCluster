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
		
		
		
		PreSelection ps=new PreSelection(populacaoInicial);			
		List<Map.Entry<Chromosome, BigDecimal>> parents=ps.Tournament();		
		
		
		Reproduction rp=new Reproduction(parents);
		Population newPopulation=rp.UniformCrossover();
		newPopulation=rp.mutation(newPopulation);
		
		HashMap<Chromosome, BigDecimal> elite=(HashMap<Chromosome, BigDecimal>)ps.sortByValue(populacaoInicial.getChromosomes());
		HashMap<Chromosome, BigDecimal> chromosomesNewPopulation=new HashMap<Chromosome, BigDecimal>();
		chromosomesNewPopulation.putAll(newPopulation.getChromosomes());
		chromosomesNewPopulation.putAll(elite);
		
		newPopulation.setChromosomes(chromosomesNewPopulation);
		
		
		
		return newPopulation;
	}
}
