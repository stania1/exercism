package purchase

import (
	"fmt"
	"sort"
)

// NeedsLicense determines whether a license is needed to drive a type of vehicle. Only "car" and "truck" require a license.
func NeedsLicense(kind string) bool {
	return kind == "car" || kind == "truck"
}

// ChooseVehicle recommends a vehicle for selection. It always recommends the vehicle that comes first in lexicographical order.
func ChooseVehicle(option1, option2 string) string {
	options := []string{option1, option2}
	sort.Strings(options)
	return fmt.Sprintf("%v is clearly the better choice.", options[0])
	// panic("ChooseVehicle not implemented")
}

// CalculateResellPrice calculates how much a vehicle can resell for at a certain age.
func CalculateResellPrice(originalPrice, age float64) float64 {
	if age < 3 {
		return float64(originalPrice * 0.8)
	} else if age < 10 {
		return float64(originalPrice * 0.7)
	} else {
		return float64(originalPrice * 0.5)
	}
}
