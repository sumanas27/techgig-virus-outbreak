package com.sumanasaha;

import java.util.Arrays;
import java.util.Scanner;


public class SubSequence {

    public static void main( String args[] ) throws Exception {

        Scanner sc = new Scanner( System.in );
        String V = sc.nextLine();
        int N = sc.nextInt();
        sc.nextLine();
        String[] B;
        if( N >= 1 && N <= 10 ) {
            B = new String[N];
            for( int i = 0; i < N; i++ ) {
                String bloodComposition = sc.nextLine();
                if( bloodComposition.length() >= 1 && bloodComposition.length() <= V.length() ) {
                    B[i] = bloodComposition;
                }
            }
            String[] subsequences = findSubsequences( V );
            printIfMatchFound( subsequences, B );
        }

    }

    private static void printIfMatchFound( final String[] subsequences, final String[] bloodCompositions ) {
        boolean[] matchesFound = new boolean[bloodCompositions.length];
        for( int i = 0; i < bloodCompositions.length; i++ ) {
            matchesFound[i] = Arrays.asList( subsequences ).contains( bloodCompositions[i] );
        }
        for( boolean b : matchesFound ) {
            if( b ) {
                System.out.println( "POSITIVE" );
            }
            else {
                System.out.println( "NEGATIVE" );
            }
        }

    }

    private static boolean isValidVirusComposition( final String input ) {

        if( input.length() >= 1
            && input.length() <= 10000
            && input.chars().allMatch( Character::isLowerCase ) ) {
            return true;
        }
        return false;
    }

    private static String[] findSubsequences( final String input ) {

        String[] result = new String[] { "" };
        if( isValidVirusComposition( input ) ) {
            if( input.length() == 0 ) {
                return result;
            }
            String[] smallestSubsequence = findSubsequences( input.substring( 1 ) );
            result = new String[2 * smallestSubsequence.length];

            for( int i = 0; i < smallestSubsequence.length; i++ ) {
                result[i] = smallestSubsequence[i];
            }
            for( int i = 0; i < smallestSubsequence.length; i++ ) {
                result[i + smallestSubsequence.length] = input.charAt( 0 ) + smallestSubsequence[i];
            }
        }
        return result;
    }
}
