public class Radix{
  public static int nth(int n, int col){
    int x = ((n / (int)Math.pow(10, col)) % 10);
    return Math.abs(x);
  }

  public static int length(int n){
    if (n == 0){
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
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }


  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int numOfDigit = -170000000; //any number fits in here, its only important that its neg
    int digitPlace = 0; //starts checking at ones place
    for(int i = 0; i < 10; i++){ //creates buckets 0 - 9
      buckets[i] = new SortableLinkedList();
    }

    do {
        while (data.size() > 0){
          int shift = data.get(0);
          data.remove(0);
          if (numOfDigit < length(shift)){ //this is always true
            numOfDigit = length(shift);//establishes the number of passes based on the greatest num of digits
          }
          buckets[nth(shift, digitPlace)].add(shift);
        }
        merge(data, buckets);
        digitPlace+=1;
      } while (numOfDigit > digitPlace);
  }


  public static void radixSort(SortableLinkedList data){

    SortableLinkedList positive = new SortableLinkedList();
    SortableLinkedList negative = new SortableLinkedList();
    while (data.size() > 0){
      int shift = data.get(0);
      data.remove(0);
      if (shift < 0){
        negative.add(Math.abs(shift));
      }
      else{
        positive.add(shift);
      }
    }
    radixSortSimple(positive);
    radixSortSimple(negative);

    data.extend(negative) ;
    data.extend(positive) ;

    //commit

  }

}
