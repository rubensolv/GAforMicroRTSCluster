package ga.util;


import java.time.Duration;
import java.time.Instant;

import ga.config.ConfigurationsGA;
import ga.model.Population;
import ga.util.Evaluation.RatePopulation;

public class RunGA {
	
	private Population population;
	private Instant timeInicial;
	private int generations;
	
	/**
	 * Este metodo aplicará todas as fases do processo de um algoritmo Genético
	 * @param evalFunction Será a função de avaliação que desejamos utilizar
	 */
	public Population run(RatePopulation evalFunction){
		//Fase 1 = gerar a população inicial 
		population = Population.getInitialPopulation(ConfigurationsGA.SIZE_POPULATION);
		
		//Fase 2 = avalia a população
		population = evalFunction.evalPopulation(population); 
		
		resetControls();
		//Fase 3 = critério de parada
		while(continueProcess()){
			
			//Fase 4 = Seleção (Aplicar Cruzamento e Mutação)
			Selection selecao = new Selection();
			population = selecao.applySelection(population);
			
			//Repete-se Fase 2 = Avaliação da população
			population = evalFunction.evalPopulation(population);
			
			//atualiza a geração
			updateGeneration();
		}
		
		return population;
	}
	
	private void updateGeneration(){
		this.generations++;
	}
	
	private boolean continueProcess() {
		switch (ConfigurationsGA.TYPE_CONTROL) {
		case 0:
			return hasTime();
			
		case 1:
			return hasGeneration();
				
		default:
			return false;
		}
		
	}


	private boolean hasGeneration() {
		if(this.generations < ConfigurationsGA.QTD_GENERATIONS){
			return true;
		}
		return false;
	}


	/**
	 * Função que inicia o contador de tempo para o critério de parada
	 */
	protected void resetControls(){
		this.timeInicial = Instant.now();
		this.generations = 0;
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
