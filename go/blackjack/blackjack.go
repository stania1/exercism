package blackjack

var CardValue = map[string]int{
	"ace":   11,
	"two":   2,
	"three": 3,
	"four":  4,
	"five":  5,
	"six":   6,
	"seven": 7,
	"eight": 8,
	"nine":  9,
	"ten":   10,
	"jack":  10,
	"queen": 10,
	"king":  10}

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	value, ok := CardValue[card]
	if !ok {
		return 0
	}
	return value
}

const Stand = "S"
const Hit = "H"
const Split = "P"
const Win = "W"

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	sum := ParseCard(card1) + ParseCard(card2)
	dealerValue := ParseCard(dealerCard)

	strategy := ""

	switch {
	case sum == 22:
		strategy = Split
	case sum == 21:
		if dealerValue < 10 {
			strategy = Win
		} else {
			strategy = Stand
		}
	case sum >= 17 && sum <= 20:
		strategy = Stand
	case sum >= 12 && sum <= 16 && dealerValue >= 7:
		strategy = Hit
	case sum >= 12 && sum <= 16 && dealerValue < 7:
		strategy = Stand
	default:
		strategy = Hit
	}

	return strategy
	// panic("Please implement the FirstTurn function")
}
