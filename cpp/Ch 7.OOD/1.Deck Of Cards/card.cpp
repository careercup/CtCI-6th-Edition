#include <string>
#include <vector>
#include <iostream>

class Card
{
private:
	bool available = true;

protected:
	int faceValue = 0;

	Suit *suit_Renamed;

public:
	Card(int c, Suit *s)
	{
		faceValue = c;
		suit_Renamed = s;
	}

	virtual int value() = 0;

	virtual Suit *suit()
	{
		return suit_Renamed;
	}

	
	virtual bool isAvailable()
	{
		return available;
	}

	virtual void markUnavailable()
	{
		available = false;
	}

	virtual void markAvailable()
	{
		available = true;
	}

	virtual void print()
	{
		std::vector<std::wstring> faceValues = {L"A", L"2", L"3", L"4", L"5", L"6", L"7", L"8", L"9", L"10", L"J", L"Q", L"K"};
		std::wcout << faceValues[faceValue - 1];
		switch (suit_Renamed)
		{
		case Club:
			std::wcout << std::wstring(L"c");
			break;
		case Heart:
			std::wcout << std::wstring(L"h");
			break;
		case Diamond:
			std::wcout << std::wstring(L"d");
			break;
		case Spade:
			std::wcout << std::wstring(L"s");
			break;
		}
		std::wcout << std::wstring(L" ");
	}
};
