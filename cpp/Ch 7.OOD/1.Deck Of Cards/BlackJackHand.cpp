#include <vector>
#include <limits>

class BlackJackHand : public Hand<BlackJackCard*>
{
public:
	BlackJackHand()
	{

	}

	virtual int score()
	{
		std::vector<int> scores = possibleScores();
		int maxUnder = std::numeric_limits<int>::min();
		int minOver = std::numeric_limits<int>::max();
		for (auto score : scores)
		{
			if (score > 21 && score < minOver)
			{
				minOver = score;
			}
			else if (score <= 21 && score > maxUnder)
			{
				maxUnder = score;
			}
		}
		return maxUnder == std::numeric_limits<int>::min() ? minOver : maxUnder;
	}

private:
	void std::vector<int> possibleScores()
	{
		std::vector<int> scores;
		if (cards->size() == 0)
		{
			return scores;
		}
		for (BlackJackCard *card : cards)
		{
			addCardToScoreList(card, scores);
		}
		return scores;
	}

	void addCardToScoreList(BlackJackCard *card, std::vector<int> &scores)
	{
		if (scores.empty())
		{
			scores.push_back(0);
		}
		int length = scores.size();
		for (int i = 0; i < length; i++)
		{
			int score = scores[i];
			scores[i] = score + card->minValue();
			if (card->minValue() != card->maxValue())
			{
				scores.push_back(score + card->maxValue());
			}
		}
	}

public:
	virtual bool busted()
	{
		return score() > 21;
	}

	virtual bool is21()
	{
		return score() == 21;
	}

	virtual bool isBlackJack()
	{
		if (cards->size() != 2)
		{
			return false;
		}
		BlackJackCard *first = cards->get(0);
		BlackJackCard *second = cards->get(1);
		return (first->isAce() && second->isFaceCard()) || (second->isAce() && first->isFaceCard());
	}
};
