package cars

const MinutesInHour = 60

const GroupSize = 10
const GroupCost = 95000
const UnitCost = 10000

// CalculateWorkingCarsPerHour calculates how many working cars are
// produced by the assembly line every hour.
func CalculateWorkingCarsPerHour(productionRate int, successRate float64) float64 {
	return float64(productionRate) * successRate / float64(100)
}

// CalculateWorkingCarsPerMinute calculates how many working cars are
// produced by the assembly line every minute.
func CalculateWorkingCarsPerMinute(productionRate int, successRate float64) int {
	return int(CalculateWorkingCarsPerHour(productionRate, successRate)) / MinutesInHour
}

// CalculateCost works out the cost of producing the given number of cars.
func CalculateCost(carsCount int) uint {
	groups := int(carsCount / GroupSize)
	units := int(carsCount % GroupSize)

	return uint((groups * GroupCost) + (units * UnitCost))
}
