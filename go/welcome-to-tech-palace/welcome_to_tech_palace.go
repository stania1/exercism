package techpalace

import (
	"fmt"
	"strings"
)

// WelcomeMessage returns a welcome message for the customer.
func WelcomeMessage(customer string) string {
	return fmt.Sprintf("Welcome to the Tech Palace, %v", strings.ToUpper(customer))
}

// AddBorder adds a border to a welcome message.
func AddBorder(welcomeMsg string, numStarsPerLine int) string {
	stars := strings.Repeat("*", numStarsPerLine)
	message := stars + "\n" + welcomeMsg + "\n" + stars
	return message
}

// CleanupMessage cleans up an old marketing message.
func CleanupMessage(oldMsg string) string {
	message := strings.ReplaceAll(oldMsg, "*", "")

	return strings.TrimSpace(message)
}
