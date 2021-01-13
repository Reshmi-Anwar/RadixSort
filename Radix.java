public class Radix{
  public static int nth(int n, int col){
    int x = ((n / (int)Math.pow(10, col)) % 10);
    return Math.abs(x);
  }

  public static int length(int n){
    if (n==0){
      return 1;
    }
    if (n < 0){
      n = Math.abs(n);
    }
    int lengthNum = (int) Math.log10(n) + 1;
    return Math.abs(lengthNum);
  }

  //simple tester cases from class notes
  /*
  public static void main(String args[]){
    System.out.println("Nth");
    System.out.println(nth(123, 1));
    System.out.println(nth(-123, 1));
    System.out.println(nth(123, 2));
    System.out.println(nth(-123, 2));
    System.out.println("Length");
    System.out.println(length(0));
    System.out.println(length(15));
    System.out.println(length(-10));
    System.out.println(length(4759));
  }
  */


  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (SortableLinkedList bucket : buckets){
      original.extend(bucket);
    }
  }

/*
  public static int largestDigits(SortableLinkedList original){
    int largestValue = original.get(0);
    for (int i = 0; i < original.size() - 1; i++){
      if (original.get(i) > largestValue){
        largestValue = original.get(i);
      }
    }
    int digitLargest = length(largestValue);
    return digitLargest;
  }


  public static void main(String args[]){
    SortableLinkedList myList = new SortableLinkedList();
    myList.add(2);
    myList.add(52);
    myList.add(4);
    myList.add(7);
    System.out.println(largestDigits(myList));
  }
  */


  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int numOfDigit = -100;
    int digitPlace = 0; //starts checking at ones place
    for(int i = 0; i < 10; i++){ //creates buckets 0 - 9
      buckets[i] = new SortableLinkedList();
    }
    do{
    while (data.size() > 0){
      int shift = data.get(0);
      data.remove(0);
      if (numOfDigit < length(shift)){ //this is always true
        numOfDigit = length(shift); //establishes the number of passes based on the greatest num of digits
        buckets[nth(shift, digitPlace)].add(shift);
      }
    }
    merge(data, buckets);
    digitPlace++;
  } while (numOfDigit > digitPlace);
  }
  
  public static void radixSort(SortableLinkedList data){

  }

}
