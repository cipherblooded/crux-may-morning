package DS_Notes.Lecture_14;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int []arr= {6,5,7,5,9,3,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int []arr)
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        // big gap means covering less elements
        for (int gap = n/2; gap >= 1; gap = gap/2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted

            for (int i = gap; i < n; i++)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int key = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found

                int j = i;
                while(j >= gap && arr[j - gap] > key){
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = key;
            }
        }
    }
}
