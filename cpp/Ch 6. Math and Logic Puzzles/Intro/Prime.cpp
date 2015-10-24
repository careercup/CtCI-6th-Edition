#include <iostream>

using namespace std;

int main()
{
  int i,j,sq;
  int min;
  for(sq = 2; sq <= 10; sq++)
  {
    min = (sq-1)*(sq-1);
    min = min + (min+1)%2;
      for(i = min; i < sq*sq; i+=2)
      {
        for(j = 3; j <= sq; j+=2)
        {
          if (i%j == 0)
            bad;
        }
      }
  }
}