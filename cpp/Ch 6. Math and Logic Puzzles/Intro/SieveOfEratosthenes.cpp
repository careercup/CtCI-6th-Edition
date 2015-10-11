#include <string>
#include <vector>
#include <iostream>
#include <cmath>

void crossOff(std::vector<bool> &flags, int prime)
{		 	
		for (int i = prime * prime; i < flags.size(); i += prime)
		{
			flags[i] = false;
		}
}

	int getNextPrime(std::vector<bool> &flags, int prime)
	{
		int next = prime + 1;
		while (next < flags.size() && !flags[next])
		{
			next++;
		}
		return next;
	}

	void init(std::vector<bool> &flags)
	{
		flags[0] = false;
		flags[1] = false;
		for (int i = 2; i < flags.size(); i++)
		{
			flags[i] = true;
		}
	}

	void std::vector<int> prune(std::vector<bool> &flags, int count)
	{
		std::vector<int> primes(count);
		int index = 0;
		for (int i = 0; i < flags.size(); i++)
		{
			if (flags[i])
			{
				primes[index] = i;
				index++;
			}
		}
		return primes;
	}

	void std::vector<bool> sieveOfEratosthenes(int max)
	{
		std::vector<bool> flags(max + 1);

		init(flags);
		int prime = 2;

		while (prime <= sqrt(max))
		{
			   
			crossOff(flags, prime);

			
			prime = getNextPrime(flags, prime);
		}

		return flags;
	}

	void main(std::vector<std::wstring> &args)
	{
		std::vector<bool> primes = sieveOfEratosthenes(4);
		for (int i = 0; i < primes.size(); i++)
		{
			if (primes[i])
			{
				std::wcout << i << std::endl;
			}
		}
	}

}
