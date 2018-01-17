#!/bin/bash
cd /storage1/dados/es91661/ExecAIGA
i='13;101;217;242;'
t='239;203;177;191;'
m=0
(qsub -l nodes=1:ppn=5,mem=5gb -v TUPIA1=$i,TUPIA2=$t,ID=$m bFixedJob.sh) &