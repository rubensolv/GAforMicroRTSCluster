#!/bin/bash

#PBS -N bFixedJob
#PBS -l mem=4mb,ncpus=4
#PBS -l walltime=100:02:00
module load java-oracle/jdk1.8.0_65

cd /mnt/nfs/home/ludwinpe/Julian/ExecAIGA/

RESULTS=cd /mnt/nfs/home/ludwinpe/Julian/ExecAIGA/logs

java -jar microRTS.jar ${TUPIA1} ${TUPIA2} >> ${RESULTS}/'Eval_'${TUPIA1}_${TUPIA2}_${ID}.txt