package ga.util;


import java.time.Duration;
import java.time.Instant;

import ga.config.ConfigurationsGA;
import ga.model.Population;
import ga.util.Evaluation.RatePopulation;

public class RunGA {
	
	private Population population;
	private Instant timeInicial;
	
	/**
	 * Este metodo aplicará todas as fases do processo de um algoritmo Genético
	 * @param evalFunction Será a função de avaliação que desejamos utilizar
	 */
	public Population run(RatePopulation evalFunction){
		//Fase 1 = gerar a população inicial 
		population = Population.getInitialPopulation(ConfigurationsGA.SIZE_POPULATION);
		
		//Fase 2 = avalia a população
		population = evalFunction.evalPopulation(population); 
		
		resetStartTime();
		//Fase 3 = critério de parada
		while(hasTime()){
			
			//Fase 4 = Seleção (Aplicar Cruzamento e Mutação)
			Selection selecao = new Selection();
			population = selecao.applySelection(population);
			
			//Repete-se Fase 2 = Avaliação da população
			population = evalFunction.evalPopulation(population);
		}
		
		return population;
	}
	
	
	/**
	 * Função que inicia o contador de tempo para o critério de parada
	 */
	protected void resetStartTime(){
		this.timeInicial = Instant.now();
	}
	
	protected boolean hasTime(){
		Instant now = Instant.now();
		
		
		Duration duracao = Duration.between(timeInicial, now);
				
		//System.out.println( "Horas " + duracao.toMinutes());
		
		if(duracao.toHours() < ConfigurationsGA.TIME_GA_EXEC){
			return true;
		}else{
			return false;
		}
		
	}
}
