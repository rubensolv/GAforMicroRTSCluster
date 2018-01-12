#!/bin/bash
cd /storage1/dados/es91661/ExecAIGA
i='254;4;134;106;'
t='285;88;247;213;'
m=1
(qsub -l nodes=1:ppn=5,mem=5gb -v TUPIA1=$i,TUPIA2=$t,ID=$m bFixedJob.sh) &
