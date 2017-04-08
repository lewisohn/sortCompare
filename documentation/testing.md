**Testing report** (Testausdokumentti)

The aim of this project is to evaluate a range of sorting algorithms under different conditions. While this hasn't been fully implemented yet, I can discuss the JUnit tests that verify the algorithms are working correctly. The times below are 10-test means, given to the nearest millisecond.

**basicTest**() has a fixed input of {5, 2, 3, 4, 1} and simply makes sure that the algorithms work at all.

|Algorithm|Time/ms|
|---|---|
|Bubble|6|
|Bucket|<1|
|Heap|<1|
|Insertion|<1|
|Merge|<1|
|Quick|6|

**negativeTest**() has a fixed input of {-5, -2, -3, -4, -1} and is effectively another basicTest except with negative integers.

|Algorithm|Time/ms|
|---|---|
|Bubble|3|
|Bucket|2|
|Heap|7|
|Insertion|1|
|Merge|1|
|Quick|1|

**reverseTest**() has a fixed input of {500, 499, 498, ..., -497, -498, -499} and tests how the algorithms perform when the input needs to be completely reversed.

|Algorithm|Time/ms|
|---|---|
|Bubble|10|
|Bucket|2|
|Heap|10|
|Insertion|6|
|Merge|4|
|Quick|11|

**nullTest**() has a fixed input of {0, 1, 2, ..., 997, 998, 999} and tests how the algorithms perform when the input is already sorted.

|Algorithm|Time/ms|
|---|---|
|Bubble|77|
|Bucket|<1|
|Heap|3|
|Insertion|<1|
|Merge|<1|
|Quick|<1|

**randomTest**() randomly generates 1000 integers across the full range of possible values (between Integer.MIN_VALUE and Integer.MAX_VALUE).

|Algorithm|Time/ms|
|---|---|
|Bubble|7|
|Bucket|5|
|Heap|5|
|Insertion|4|
|Merge|1|
|Quick|1|

**outlierTest**() randomly generates 1000 small integers (between 0 and 100) with a very large integer (at least Integer.MAX_VALUE - 100) inserted at a random position.

|Algorithm|Time/ms|
|---|---|
|Bubble|39|
|Bucket|3|
|Heap|2|
|Insertion|5|
|Merge|1|
|Quick|1|

**exactTest**() does not actually test that its input is sorted - the other tests take care of that - but makes sure that no data are added or removed when the algorithms run. The input is 1000 random integers across the full range of values.

|Algorithm|Time/ms|
|---|---|
|Bubble|51|
|Bucket|6|
|Heap|7|
|Insertion|13|
|Merge|7|
|Quick|2|

**bigTest**() randomly generates 5000 integers across the full range of possible values.

|Algorithm|Time/ms|
|---|---|
|Bubble|138|
|Bucket|14|
|Heap|11|
|Insertion|7|
|Merge|10|
|Quick|2|

**biggerTest**() randomly generates 25000 integers across the full range of possible values.

|Algorithm|Time/ms|
|---|---|
|Bubble|4863|
|Bucket|29|
|Heap|21|
|Insertion|337|
|Merge|79|
|Quick|6|

Disclaimers: This is obviously not a very thorough testing suite at the moment - that will be added to the program in the coming weeks. The interesting results only really start to come in at n = 5000 and 25000, so it's clear I'll need to run much bigger tests to get a meaningful comparison. That isn't feasible for JUnit tests, however, since Bubble is already taking almost five full seconds to run at n = 25000 (biggerTest). Furthermore, 10 tests isn't enough to get a statistically significant sample; some of the results are affected by outliers. I'll be running a lot more of them soon.