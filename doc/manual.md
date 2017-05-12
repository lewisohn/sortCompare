**User manual** (käyttöohje)

sortCompare.jar can be found in this repository's *src* folder. Run it from the command line as follows:

> java -jar sortCompare.jar

This will launch the program in manual mode, allowing you to generate data and choose sorting algorithms freely. Each test will be run 10 times.

Simply follow the instructions in *stdout* to proceed. First, generate some data using the options provided, then choose which algorithms you want to compare.

> java -jar sortCompare.jar n

This will also launch the program in manual mode, as above, but each test will be run *n* times, where n is between 1 and 2147483647. 

> java -jar sortCompare.jar n a b c ...

This will launch the program in automatic mode, which will evaluate all six sorting algorithms *n* times, where n is between 1 and 2147483647, with randomly generated data sets of sizes *a*, *b*, *c*, and so on. For example, running

> java -jar sortCompare.jar 50 10000 20000 50000

would sort data sets of 10000, 20000 and 5000 randomly generated numbers respectively, with each test being repeated 50 times.