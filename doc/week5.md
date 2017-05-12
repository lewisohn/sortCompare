**Week 5 report** (Viikkoraportti 5)

This week I implemented an "automatic" mode for the program. Its main method now takes optional arguments in the form of a list of positive integers. The first integer is how many times each test should be run and the second and subsequent integers are the input sizes. As an example, running *sortCompare.jar 10 10000 20000* will evaluate the sorting algorithms for n = 10000 and 20000 and both evaluations will be repeated 10 times. Running *sortCompare.jar 20* with no further arguments will switch to manual mode with 20 repetitions, while running *sortCompare.jar* with no arguments will switch to manual mode with the default number of repetitions, currently 10. The result of all this is that it's now much faster to compare algorithms for multiple input sizes (n) since before the program would only run once and then exit.

The way the program reports its data has also been improved. It now prints a table to stdout which shows min, max and mean memory in KiB and time in ms from all its runs. Before it only showed the single-run memory and time usage. I might ultimately provide the output in comma-separated values (CSV) format so it can be easily imported to spreadsheet software for further evaluation, making graphs, and so on.

I worked on my CustomListPrototype class a fair amount but I didn't have time to implement further tests for it. That's next on my to-do list. Once I'm satisfied it works as intended I can replace the current CustomList (extends ArrayList) class in my program. I also refactored a few things here and there, including making one very important modification to the abstract Sort class. I had been wondering why Bubble sort seemed to use more memory than everything else despite supposedly having an O(1) memory requirement. It turned out it was because Sort's swap() method was creating a new int every time it was called. Making that int static to the Sort class solved the problem and now Bubble runs with consistent 0 KiB memory usage, as it is supposed to do as an in-place sort. The same applies to Heap.

I also submitted my first code review this week and got one back in return, which had some useful tips. I'm aware of the problem with running the program at the moment and I'll try to solve it next week.