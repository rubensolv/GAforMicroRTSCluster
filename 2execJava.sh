#!/bin/bash
#Cluster USP

#PBS -N 2execJava
#PBS -l mem=2,ncpus=2
#PBS -l walltime=100:02:00
module load java-oracle/jdk1.8.0_65

cd /mnt/nfs/home/ludwinpe/Julian/ExecAIGA/

java -jar GAforMicroRTSCluster.jar
