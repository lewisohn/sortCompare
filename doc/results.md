**Results (tulokset)**

Random data
------------

This represents the bulk of the comparison. The tables below show memory and time usage for each algorithm with various input sizes (top row). Each test was performed 100 times and the values shown are arithmetic means.

**Memory used in kibibytes (KiB)**

| Algorithm       | Worst case* | 1000 | 2000 | 3000 | 4000 | 5000 | 10000 | 20000 | 30000 | 40000 | 50000 | 100000 |
|-----------------|-------------|------|------|------|------|------|-------|-------|-------|-------|-------|--------|
| Bubble          | O(1)        | 0    | 0    | 0    | 0    | 0    | 0     | 0     | 0     | 0     | 0     | 0      |
| Bucket (Bubble) | O(n)        | 665  | 665  | 1331 | 1331 | 1996 | 3328  | 6656  | 9321  | 12646 | 15975 | 30773  |
| Heap            | O(1)        | 7    | 0    | 6    | 0    | 0    | 0     | 0     | 0     | 0     | 0     | 0      |
| Insertion       | O(1)        | 665  | 665  | 665  | 665  | 665  | 665   | 665   | 665   | 665   | 1331  | 1956   |
| Merge           | O(n)        | 665  | 665  | 665  | 665  | 1331 | 1997  | 3432  | 5034  | 6375  | 8910  | 17883  |
| Quick           | O(log(n))   | 669  | 670  | 674  | 681  | 685  | 704   | 743   | 782   | 821   | 860   | 994    |

![Graph: memory](https://raw.githubusercontent.com/lewisohn/sortCompare/master/doc/results_memory.png)

**Time taken in milliseconds (ms)**

| Algorithm       | Worst case* | 1000 | 2000 | 3000 | 4000 | 5000 | 10000 | 20000 | 30000 | 40000 | 50000 | 100000 |
|-----------------|-------------|------|------|------|------|------|-------|-------|-------|-------|-------|--------|
| Bubble          | O(n^2)      | 1    | 6    | 15   | 28   | 48   | 234   | 1122  | 2718  | 5052  | 8264  | 35057  |
| Bucket (Bubble) | O(n^2)      | 0    | 0    | 0    | 1    | 1    | 3     | 8     | 13    | 20    | 28    | 81     |
| Heap            | O(nlog(n))  | 0    | 0    | 0    | 0    | 0    | 1     | 3     | 5     | 8     | 10    | 26     |
| Insertion       | O(n^2)      | 0    | 1    | 2    | 4    | 6    | 29    | 130   | 335   | 643   | 1037  | 5639   |
| Merge           | O(nlog(n))  | 0    | 1    | 3    | 3    | 4    | 19    | 73    | 221   | 287   | 801   | 3361   |
| Quick           | O(n^2)      | 0    | 0    | 0    | 0    | 0    | 0     | 2     | 3     | 4     | 6     | 12     |

![Graph: time](https://raw.githubusercontent.com/lewisohn/sortCompare/master/doc/results_time.png)

* Theoretical

Observations:

- The first thing that catches my eye is how differently Bubble and Bucket perform, despite Bucket relying on Bubble for its inner sorting algorithm. Bubble, being an in-place sort, uses no memory at all (like Heap) but becomes incredibly slow at large *n*, whereas Bucket is precisely the opposite, using the most memory of any algorithm but running much, much faster (though still not as fast as Heap or Quick). Bubble's performance matches its theoretical Big-O worst case performance very closely (R^2 = 0.9999), which is pleasing.

- Quicksort lives up to its name, being the fastest or joint-fastest sorting algorithm at every *n*. It could potentially be optimised further with a smarter pivot selection.

- Heapsort is almost as fast as Quick but uses no memory at all, which is impressive.

- Insertion sort is supposed to have O(1) memory usage but this doesn't seem to be the case, and I'm not quite sure why, since my implementation uses exactly three variables (ints i, j and temp) regardless of size. Whatever the reason, it ended up using more memory than the supposedly worse-performing Quick at large *n*.

- Merge sort is a pretty mediocre algorithm which is neither the best nor worst in either category of measurement.


Pre-sorted data
---------------

This test was done with numbers from 0 to 99999 (inclusive) in ascending order, meaning the sorting algorithms did not have to change anything. Again, the tests were performed 100 times and the results below are arithmetic means.

| Algorithm       | Memory / KiB | Time / ms |
|-----------------|--------------|-----------|
| Bubble          | 6            | 0         |
| Bucket (Bubble) | 17894        | 9         |
| Heap            | 0            | 21        |
| Insertion       | 1929         | 1         |
| Merge           | 17911        | 3397      |
| Quick           | 994          | 8632      |

Observations:

- Here we see Bubble "come into its own" - we already know it uses no memory (here it uses 6 KiB, but that can safely be called an outlier) and now it takes less than one millisecond as well. Insertion sort also runs very quickly in this situation, though with a higher memory overhead.

- Bucket is no longer an optimisation of Bubble in this scenario.

- Conversely, Quick performs slowest of all since it still has to go through its select-pivot-and-move-elements operation no matter what.

- Merge and Heap use pretty much exactly the same time and memory with pre-sorted data as it does with random data.

Reverse data
------------
This test was done with numbers from 99999 to 0 (inclusive) in descending order, meaning the sorting algorithms had to reverse the entire data set. Again, the tests were performed 100 times each and the results below are arithmetic means.

| Algorithm       | Memory / KiB | Time / ms |
|-----------------|--------------|-----------|
| Bubble          | 0            | 15323     |
| Bucket (Bubble) | 17974        | 64        |
| Heap            | 0            | 17        |
| Insertion       | 1929         | 6876      |
| Merge           | 17911        | 3362      |
| Quick           | 994          | 13756     |

Observations:

- Bubble goes back to being the worst-performing algorithm, though it manages to sort this data twice as fast as it did the completely random data. Bucket-Bubble resumes its earlier position as a memory/time tradeoff.

- Again, Merge and Heap are consistent. I think Heap deserves a "best in show" award, having used no memory and no more than 26 ms in any of these tests. Only Quick was faster than Heap with random data, but we can now see that Quick performs much worse in some situations. Here it's almost as slow as Bubble, though that is at least partly down to my specific implementation of the algorithm: it chooses the last element in the data as the pivot, which is the worst possible pivot in this situation.