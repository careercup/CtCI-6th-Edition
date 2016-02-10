#include <string>
#include <vector>
#include <iostream>

bool oneEditReplace(const std::wstring &s1, const std::wstring &s2)
{
		bool foundDifference = false;
		for (int i = 0; i < s1.length(); i++)
		{
			if (s1[i] != s2[i])
			{
				if (foundDifference)
				{
					return false;
				}

				foundDifference = true;
			}
		}
		return true;
}

	bool oneEditInsert(const std::wstring &s1, const std::wstring &s2)
	{
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length())
		{
			if (s1[index1] != s2[index2])
			{
				if (index1 != index2)
				{
					return false;
				}
				index2++;
			}
			else
			{
				index1++;
				index2++;
			}
		}
		return true;
	}

	bool oneEditAway(const std::wstring &first, const std::wstring &second)
	{
		if (first.length() == second.length())
		{
			return oneEditReplace(first, second);
		}
		else if (first.length() + 1 == second.length())
		{
			return oneEditInsert(first, second);
		}
		else if (first.length() - 1 == second.length())
		{
			return oneEditInsert(second, first);
		}
		return false;
	}

	void main(std::vector<std::wstring> &args)
	{
		std::wstring a = L"pse";
		std::wstring b = L"pale";
		bool isOneEdit = oneEditAway(a, b);
		std::wcout << a << std::wstring(L", ") << b << std::wstring(L": ") << isOneEdit << std::endl;
	}

}
