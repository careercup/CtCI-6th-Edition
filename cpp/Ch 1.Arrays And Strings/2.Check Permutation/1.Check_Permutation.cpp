#include <string>
#include <vector>
#include <iostream>

void main std::wstring sort(const std::wstring &s)
{
		std::vector<wchar_t> content = s.toCharArray();
		Arrays::sort(content);
		return std::wstring(content);
}

bool permutation(const std::wstring &s, const std::wstring &t)
	{
		return sort(s) == sort(t);
	}

void main(std::vector<std::wstring> &args)
	{
		std::vector<std::vector<std::wstring>> pairs =
		{
			{L"apple", L"papel"},
			{L"carrot", L"tarroc"},
			{L"hello", L"llloh"}
		};
		for (auto pair : pairs)
		{
			std::wstring word1 = pair[0];
			std::wstring word2 = pair[1];
			bool anagram = permutation(word1, word2);
			std::wcout << word1 << std::wstring(L", ") << word2 << std::wstring(L": ") << anagram << std::endl;
		}
	}
