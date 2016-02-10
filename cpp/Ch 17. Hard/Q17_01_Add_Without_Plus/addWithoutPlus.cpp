//g++ -std=gnu++11 -o addWithoutPlus addWithoutPlus.cpp
#include <iostream>

unsigned sum(unsigned x, unsigned y) {
    unsigned xor_result = x ^ y;
    unsigned carry = (x & y) << 1;
    if ( carry == 0 ) return xor_result;
    return sum(xor_result, carry);
}

int main(){
    std::cout << "The sum of 7 + 8 is: " << sum(7,8) << std::endl;
    std::cout << "The sum of 33 + 4 is: " << sum(33,4) << std::endl;
    std::cout << "The sum of 11 + 5 is: " << sum(5,11) << std::endl;
    std::cout << "The sum of 31 + 7 is: " << sum(31,7) << std::endl;
}

