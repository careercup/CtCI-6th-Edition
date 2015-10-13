/*
 * Cracking the coding interview edition 6
 * Given a string, write a function to check if it is a permutation of a pallindrome.
 *
 * Solution Philosophy:
 * For a string to be pallindrome, it should be able to spelled backward and forward the same.
 * Therefore the chars in string should fit one of the two possibilities:
 *  - Each char appear even number of times in the string ( even length string )
 *  - Each char should appear even number of times, except just one char ( odd length string )
 * 
 * We won't care about the case of the letter
 */

#include <iostream>


/*
 * Helper routine to return an frequency Table index
 *
 */

int getCharIndex( char c )
{
    int idx = -1;
    if ( c >= 'a' && c <= 'z' )
    {
        idx = c - 'a';
    }
    else if ( c >= 'A' && c <= 'Z' )
    {
        idx = c - 'A';
    }
    return idx;
}

/*
 * Function : countFrequency
 * Args     : input string, an array of int 
 * Return   : Void, array of int will populate each letter's frequency in string.
 */

void countFrequency( const std::string & str, int *frequency )
{
    int idx;
    for (const char & c : str)
    {
        idx = getCharIndex(c);
        if ( idx != -1 )
        {
            ++frequency[idx];
        }
    }
}


/*
 * Function : isPermutePallindrome 
 * Args     : input string
 * Return   : returns true if is possible that one of the permutations of input string can be a pallindrome.
 *            else return false
 */

bool isPermutationOfPallindrome1( const std::string & str )
{
    int frequency[ 26 ] = { 0 };
    countFrequency( str, frequency );

    /*
     * We will check here that letter frequencies are all even or all even except one odd.
     */
    bool oddAppeared = false;
    std::cout << std::endl;
    for ( int i = 0 ; i < 26; ++i ) {
        if ( frequency[i] % 2  && oddAppeared ) {
            return false;
        } else if ( frequency[i] % 2 && !oddAppeared ) {
            oddAppeared = true;
        }
    }
    return true;
}


/*
 * Approach 2:
 * Let us optimize above function instead of taking another pass let us do it
 * in one go, we will count odd chars as we go along, if we are left with 
 * more that 0 or 1, then the input string can't have pallindrome permutation
 */

bool isPermutationOfPallindrome2( const std::string & str )
{
    int oddCount = 0;
    int frequency[26] = { 0 };
    int idx = 0;
    for ( const char & c : str )
    {
        idx = getCharIndex(c);
        if ( idx != -1 )
        {
            ++frequency[idx];
            if ( frequency[idx] % 2 ) 
            {   
                ++oddCount;
            } else {
                --oddCount;
            }
        }
    }
    return (oddCount <= 1);
}

/*
 * Approach 3
 * let us represent each char with a bit in a bitvector
 * Each time a char appears in the string we toggle the
 * respective bit, if we are left with more than 1 bit
 * in the bit vector, the string can not have a pallidrome
 * permutation.
 *
 */

/*
 * helper function to toggle a bit in the integer
 */ 

int toggle( int bitVector, int index )
{
    if ( index < 0 )
        return bitVector;

    int mask = 1 << index;
    //if bit is not set
    if ( (bitVector & mask ) == 0 )
    {
        bitVector |= mask;
    } else {    //if bit is set
        bitVector &= ~mask;
    }
    return bitVector;
}

/*
 * Helper functiont to find if a single bit is set
 * i.e. if bitVector is a multiple of power of 2
 */

bool isExactlyOneBitSet( int bitVector )
{
    return ( (bitVector & (bitVector - 1)) == 0 );
}

/*
 * Third approach solution
 * toggle bit represent the respective char 
 * for each appearance in the string.
 */

bool isPermutationOfPallindrome3( const std::string & str )
{
    int bitVector = 0;
    int id = 0;
    for ( const char & c : str )
    {
        id = getCharIndex(c);
        bitVector = toggle (bitVector, id );
    }
    return ( bitVector == 0 || isExactlyOneBitSet(bitVector) );
}

int main()
{
    std::string str("Tact Coa");
    std::cout << "Does \"" << str << "\"  has a string whose permutation is a pallindrome? "
              << "( 1 for true, 0 for false ) : ";
    std::cout << "Approach 1:" << isPermutationOfPallindrome1( str ) << std::endl;
    std::cout << "Approach 2:" << isPermutationOfPallindrome2( str ) << std::endl;
    std::cout << "Approach 3:" << isPermutationOfPallindrome3( str ) << std::endl;


    std::string str1("A big Cat");
    std::cout << "Does \"" << str1 << "\" has a string whose permutation is a pallindrome? "
              << "( 1 for true, 0 for false ) : ";
    std::cout << "Approach 1:" << isPermutationOfPallindrome1( str1 ) << std::endl;
    std::cout << "Approach 2:" << isPermutationOfPallindrome2( str1 ) << std::endl;
    std::cout << "Approach 3:" << isPermutationOfPallindrome3( str1 ) << std::endl;


    std::string str2("Aba cbc");
    std::cout << "Does \"" << str2 << "\" has a string whose permutation is a pallindrome? "
              << "( 1 for true, 0 for false ) : ";
    std::cout << "Approach 1:" << isPermutationOfPallindrome1( str2 ) << std::endl;
    std::cout << "Approach 2:" << isPermutationOfPallindrome2( str2 ) << std::endl;
    std::cout << "Approach 3:" << isPermutationOfPallindrome3( str2 ) << std::endl;
    return 0;
}
