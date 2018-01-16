#!/bin/bash
cd /mnt/nfs/home/ludwinpe/Julian/ExecAIGA/
i='13;101;217;242;'
t='239;203;177;191;'
m=0
(qsub -v TUPIA1=$i,TUPIA2=$t,ID=$m bFixedJob.sh) &
