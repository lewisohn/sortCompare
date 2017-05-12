**Implementation** (Toteutusdokumentti)

This program comprises a Main class and three packages, which are detailed below.

- Main.java contains the program's main method. If two or more arguments are passed to this method, the program will run in automatic mode, otherwise it will run in manual mode by launching the user interface. The first argument is the number of times the sorting algorithms will be run for each input (defaults to 10 if no arguments are provided). Subsequent arguments represent the sizes of inputs, or in other words, how many randomly generated numbers should be passed to the algorithms for sorting.

Package 1: **sortcompare.algorithms**

- Bubble.java compares adjacent items and swaps them if they're in the wrong order. It contains a slight optimisation - if, after any single pass, no swaps were made, it means the data is already in the correct order and no further passes need to be made.

- Bucket.java divides items into buckets, sorts them and recombines the buckets. I originally wanted a "pure" bucket sort which continually divided buckets into further buckets until each item was in a bucket on its own, and while it was feasible, it used far too much memory, causing heap space exceptions when I ran it. Now it divides items once (into a number of buckets that grows with the size of the input) and then sorts the buckets using an inner sorting algorithm. I first tried using insertion sort for this purpose, then quick sort, before finally settling on bubble sort. The reason for this is because I think it shows an interesting contrast: bubble sort uses no memory but a lot of time, while bucket sort uses a lot of memory but very little time.

- Counting.java is actually that "pure" bucket sort implementation. It's not actually used in the program but remains in the repository for legacy purposes.

- Heap.java divides data into a sorted region and an unsorted region then shrinks the unsorted region until it is empty. I originally tried writing a separate heap class but it turned out to be easier to implement it directly into the algorithm. It starts by "heapifying" the input then sorts the heap.

- Insertion.java adds one item at a time to a previously sorted region. It was one of the more straightforward sorting algorithms to understand and implement.

- Merge.java divides data into small subsets, sorts them, then compares and combines the subsets. Unlike bucket sort, it doesn't divide the items based on any properties they might have (such as the value of an integer); instead it divides them by their position in the input.

- Quick.java chooses a item (a pivot) then moves everything less than it to the left and everything greater than or equal to it to the right. This is repeated iteratively until the data are sorted. It lives up to its name, usually being the fastest sorting algorithm in my tests.

- Sort.java is an abstract class which defines three methods: *measure*, which is used to benchmark sorting algorithms, *sort*, an abstract method which must be overridden, and *swap*, a simple utility for swapping two elements of a list. Every other class in this package extends Sort.

Package 2: **sortcompare.structures**

- CustomList.java is a custom implementation of a flexible-sized list akin to Java's ArrayList. It supports operations such as add, remove, set, clear, and so on. It has a default size of 10 which can be overridden in the constructor. If an attempt is made to add an element to the list when its underlying array is full, it will double in capacity. I'm not sure if this is the most optimal way of doing it - ArrayList expands by a factor of 1.5 instead of 2 - but it does the job.

- CustomListLegacy.java is not used in the program. It was an extension of ArrayList which served as a placeholder for CustomList until I had finished it.

- CustomPair.java is a very simple class used for storing a pair of values.

Package 3: **sortcompare.ui**

- DataSelector.java asks the user to provide or generate some data to be sorted.

- Evaluator.java feeds the data to the selected sorting algorithms, calls their *measure* methods multiple times,  processes the results and prints a table.

- Selector.java is another abstract class which defines a number of methods for DataSelector and SortSelector.

- SortSelector.java asks the user to choose which sorting algorithms to evaluate.

- UI.java is a very simple parent class which launches the user interface.

Further improvements: I would like to add a way of comparing the sorting algorithms to Java's own Collections.Sort() method.