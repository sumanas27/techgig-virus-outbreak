package com.sumanasaha;


/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.util.Arrays;
import java.util.Scanner;


public class CandidateCode {

    public static void main( String args[] ) throws Exception {

        Scanner sc = new Scanner( System.in );
        String V = sc.nextLine();
        int N = sc.nextInt();
        sc.nextLine();

        for( int i = 0; i < N; i++ ) {
            String B = sc.nextLine();
            boolean result = isSubSequence( B, V );
            if( result ) {
                System.out.println( "POSITIVE" );
            }
            else {
                System.out.println( "NEGATIVE" );
            }
        }

    }

    private static boolean isSubSequence( String bloodComposition, String virusComposition ) {

        int bloodCompositionLength = bloodComposition.length();
        int virusCompositionLength = virusComposition.length();
        int bloodCompositionIndex = 0;

        for( int i = 0; i < virusCompositionLength && bloodCompositionIndex < bloodCompositionLength; i++ ){
            if( bloodComposition.charAt( bloodCompositionIndex ) == virusComposition.charAt( i ) ){
                bloodCompositionIndex++;
            }
        }
        return bloodCompositionIndex == bloodCompositionLength;

    }

}
