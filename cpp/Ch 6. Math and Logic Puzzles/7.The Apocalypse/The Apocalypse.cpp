#include <string>
#include <vector>
#include <iostream>

void std::vector<int> runOneFamily()
{
		Random *random = new Random();
		int boys = 0;
		int girls = 0;
		while (girls == 0)
		{ 
			if (random->nextBoolean())
			{ 
				girls += 1;
			}
			else
			{ 
				boys += 1;
			}
		}
		std::vector<int> genders = {girls, boys};
		return genders;
}

	double runNFamilies(int n)
	{
		int boys = 0;
		int girls = 0;
		for (int i = 0; i < n; i++)
		{
			std::vector<int> genders = runOneFamily();
			girls += genders[0];
			boys += genders[1];
		}
		return girls / static_cast<double>(boys + girls);
	}

	static void main(std::vector<std::wstring> &args)
	{
		double ratio = runNFamilies(10000000);
		std::wcout << ratio << std::endl;

	}

}
