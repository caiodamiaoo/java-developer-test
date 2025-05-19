# 6. Performance de Processos Batch
## Descreva os passos que você tomaria para diagnosticar e melhorar a performance de um processo batch que interage com banco de dados e servidor FTP.
Eu dividiria o código de cada parte do processo para ficar mais facil de identificar possiveis falhas,
como: conexao/download do ftp, parse, banco etc.. 
Para melhorar a performance, eu utilizaria indices para as colunas utilizadas nas queries, em casos extremos, utilizar as
proprias procedures, views, functions, do banco de dados, para evitar que o java tenha que fazer o trabalho.
## Explique como identificaria gargalos, otimizaria queries, melhoraria a lógica e a eficiência da transferência de arquivos.

A melhor forma de identificar gargalos é dividir o processo para tentar entender em qual momento está ocorrendo o gargalo,
sempre dividir nas suas proprias responsabilidades.  Eu costumo colocar logs com timestamp (ex: Instant.now() ou System.nanoTime()) 
entre essas etapas para ver o tempo gasto em cada uma.

Se for possivel utilizar sempre paralelismo, como por exemplo, se o banco de dados for oracle, utilizar o parallel hint 
para melhorar a performance.

Evitar o uso de joins desnecessários, sempre que possivel, utilizar o join no banco de dados e não no java.
No caso de transferir via FTP, sempre utilizar buffer de leitura e escrita, assim como transferir os arquivos em paralelo.


## Dê exemplos de ferramentas ou técnicas utilizadas na análise.
Wireshark a nivel de ftp, usar ferramentas de banco como o proprio EXPLAIN ou ANALYZE..
