class BubbleSort
{
  public void bubblesort()
  {
    int arr[] = {7, 6, 5, 3}; //test array
    int nCounter = 0;
    int nLength = arr.length; //making .length into variable
    for (int i = 0; i < nLength - 1; i++) //runs through array
    {
      for (int j = 0; j < nLength - i - 1; j++)
      {
        nCounter++;
        if (arr[j] > arr[j+1]) //if item is greater than item ahead
        {
          int swap = arr[j]; //swaps the placements
          arr[j] = arr[j+1];
          arr[j+1] = swap;
        }
      }
    }
  printer(arr, nCounter);
  }  

  void printer(int arr[], int nCounter) //Prints
  {
    int nLength = arr.length;
    System.out.println("Sorted array:");
    for (int i = 0; i < nLength; i++)
    {
    System.out.print(arr[i] + ", ");
    }
    System.out.println("Number of Cycles:");
    System.out.println(nCounter);
  } 
}