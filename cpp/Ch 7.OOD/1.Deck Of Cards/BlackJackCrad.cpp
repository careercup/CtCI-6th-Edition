class BlackJackCard : public Card
{
public:
	BlackJackCard(int c, Suit *s) : Card(c, s)
	{
	}

	virtual int value()
	{
		if (isAce())
		{ 
			return 1;
		}
		else if (faceValue >= 11 && faceValue <= 13)
		{ 
			return 10;
		}
		else
		{ 
			return faceValue;
		}
	}

	virtual int minValue()
	{
		if (isAce())
		{ 
			return 1;
		}
		else
		{
			return value();
		}
	}

	virtual int maxValue()
	{
		if (isAce())
		{ 
			return 11;
		}
		else
		{
			return value();
		}
	}

	virtual bool isAce()
	{
		return faceValue == 1;
	}

	virtual bool isFaceCard()
	{
		return faceValue >= 11 && faceValue <= 13;
	}
};
