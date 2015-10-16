#include <string>
#include <vector>
#include <iostream>

bool isUniqueChars(const std::string &str)
	{
		if (str.length() > 128)
		{
			return false;
		}
		std::vector<bool> char_set(128);
		for (int i = 0; i < str.length(); i++)
		{
			int val = str[i];
			if (char_set[val])
			{
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

void main(std::vector<std::string> &args)
	{
		std::vector<std::string> words = {"abcde", "hello", "apple", "kite", "padle"};
		for (auto word : words)
		{
			std::cout << word << std::string(": ") << isUniqueChars(word) << std::endl;
		}
	}

