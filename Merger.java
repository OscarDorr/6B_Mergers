/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
        ArrayList<String> sorted = new ArrayList<String>(nItems);
        int list0counter = 0;
        int list1counter = 0;
        //possibly iffy method of keeping track of positions within the unsorted list
        while ((list0counter + start0 > start1) && (list1counter + start1 > nItems)){
          if (usersData.get(list0counter + start0).compareTo(usersData.get(list1counter + start1)) <= 0){
            sorted.add(usersData.get(list0counter + start0));
            list0counter++;
          }
          else{
            sorted.add(usersData.get(list1counter + start1));
            list1counter++;
          }
        }
        int startN;
        int listNcounter;
        int endIndex;
        if ((list0counter + start0) < start1){
          startN = start0;
          listNcounter = list0counter;
          endIndex = start1;
        }
        else{
          startN = start1;
          listNcounter = list1counter;
          endIndex = nItems;
        }

        while(startN + listNcounter < endIndex){
          sorted.add(usersData.get(listNcounter + startN));
          listNcounter ++;
        }

    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}
