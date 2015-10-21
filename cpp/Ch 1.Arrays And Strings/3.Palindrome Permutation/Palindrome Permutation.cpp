#include <string>
#include <vector>
#include <iostream>

bool checkMaxOneOdd(std::vector<int> &table)
{
		bool foundOdd = false;
		for (auto count : table)
		{
			if (count % 2 == 1)
			{
				if (foundOdd)
				{
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
}

	bool isPermutationOfPalindrome(const std::wstring &phrase)
	{
		std::vector<int> table = Common::buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	void main(std::vector<std::wstring> &args)
	{
		std::wstring pali = L"Rats live on no evil star";
		std::wcout << isPermutationOfPalindrome(pali) << std::endl;
	}
