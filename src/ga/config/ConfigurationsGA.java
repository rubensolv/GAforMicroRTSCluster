package ga.config;

public final class ConfigurationsGA {
	//total de scripts que serão utilizados no teste. ex.: 300 = 0-299
	public final static int QTD_SCRIPTS = 300;
	//tamanho fixo do cromossomo
	public final static int SIZE_CHROMOSOME = 4;
	//tamanho fixo da população
	public final static int SIZE_POPULATION = 3;
	//tempo, em horas, que o GA será executado
	public final static int TIME_GA_EXEC = 1;
	//Total de jobs que serão enviados ao cluster
	public final static int NUMBER_JOBS = 33;
	//tamanho fixo da elite
	public final static int SIZE_ELITE = 2;
	//tamanho fixo do k do torneio
	public final static int K_TOURNMENT = 2;
	//tamanho fixo dos pais para crossover
	public final static int SIZE_PARENTSFORCROSSOVER = 3;
	//taxa mutacao
	public final static double MUTATION_RATE = 0.01;
}
