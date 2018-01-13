package ga.util;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ga.config.ConfigurationsGA;
import ga.model.Chromosome;
import ga.model.Population;

public class Reproduction {

	static Random rand = new Random();

	List<Map.Entry<Chromosome, BigDecimal>> parents;
	public Reproduction(List<Map.Entry<Chromosome, BigDecimal>> parents)
	{
		this.parents=parents;
	}
	public Population UniformCrossover()
	{
		Population newGeneration;
		HashMap<Chromosome, BigDecimal> newChromosomes =new HashMap<Chromosome, BigDecimal>();		
		while(newChromosomes.size()<ConfigurationsGA.SIZE_POPULATION-ConfigurationsGA.SIZE_ELITE)
		{
			Collections.shuffle(parents);
			Chromosome parent1=parents.get(0).getKey();
			Chromosome parent2=parents.get(1).getKey();
			Chromosome child= new Chromosome();

			int sizeParent1=parent1.getGenes().size();
			int sizeParent2=parent2.getGenes().size();
			int maxSize=Math.max(sizeParent1, sizeParent2);

			for(int i=0;i<maxSize;i++)
			{
				int newGen=rand.nextInt(2)+1;
				if(newGen==1)
				{
					if(i<=sizeParent1)
						child.addGene(parent1.getGenes().get(i));
				}
				else
				{
					if(i<=sizeParent2)
						child.addGene(parent2.getGenes().get(i));
				}
			}
			newChromosomes.put(child, BigDecimal.ZERO);
		}
		newGeneration=new Population(newChromosomes);
		return newGeneration;
	}

	public Population mutation(Population p)
	{
		for(Chromosome c : p.getChromosomes().keySet()){

			for(int i=0; i<c.getGenes().size();i++)
			{
				double mutatePercent = 0.01;
				boolean m = rand.nextFloat() <= mutatePercent;

				if (m)
					c.getGenes().set(i, rand.nextInt(ConfigurationsGA.QTD_SCRIPTS));
			}
		}
		return p;
	}
	
	public Population completewithelite(Population p)
	{
		
		return p;
	}
	

}
