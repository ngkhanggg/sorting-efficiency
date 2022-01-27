# Sorting-Efficiency
Sorting Efficiency is a program that allows the user to use various sorting algorithms to sort and compare data.

The user will be given the choice for how big they want an array to be, which will be filled with random numbers. The user will then select a sorting algorithm to organize the randomly generated array indexes. When finished, the program will print the sorted array, alongside the amount of time and cycles it took to be completed, and the time and cycles the other algorithms took for comparison.

The code can use the following alogorithms: <br>
**Bubble sort:** Compare adjacent items and swaps if in the incorrect order <br>
**Selection Sort:** Actively searches for smallest items to place in correct order <br>
**Quick Sort:** The items are arranged by being higher or lower than a random item. Random items keep being chosen in smaller groups until the array is sorted <br>
**Merge Sort:** The program splits the items up into individual items, then puts the array back together in order


### Adding to the program
Additional sorting algorithms can be added to the program by making a new sorter subclass with getName() and internalSort() (which contains the sorting algorithm) methods. The SorterHelper will need to be updated in various places to use the new algorithm, and the GUI will need to be updated to display it. <br>
More sizes of array can be available to the user by simply updating the sizesOfArray array in GUI.java.