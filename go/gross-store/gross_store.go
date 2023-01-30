package gross

// Units stores the Gross Store unit measurements.
func Units() map[string]int {
	return map[string]int{
		"quarter_of_a_dozen": 3,
		"half_of_a_dozen":    6,
		"dozen":              12,
		"small_gross":        120,
		"gross":              144,
		"great_gross":        1728,
	}
}

// NewBill creates a new bill.
func NewBill() map[string]int {
	return map[string]int{}
}

// AddItem adds an item to customer bill.
func AddItem(bill, units map[string]int, item, unit string) bool {
	unitVal, unitExists := units[unit]
	if !unitExists {
		return false
	}
	bill[item] += unitVal
	return true
}

// RemoveItem removes an item from customer bill.
func RemoveItem(bill, units map[string]int, item, unit string) bool {
	_, isItemInBill := bill[item]
	_, isUnitKnown := units[unit]

	if !isItemInBill || !isUnitKnown {
		return false
	}

	newBillValue := bill[item] - units[unit]
	if newBillValue < 0 {
		return false
	} else if newBillValue == 0 {
		// remove item from bill
		delete(bill, item)
		return true
	} else {
		bill[item] = newBillValue
		return true
	}
}

// GetItem returns the quantity of an item that the customer has in his/her bill.
func GetItem(bill map[string]int, item string) (int, bool) {
	itemValue, isItemInBill := bill[item]
	return itemValue, isItemInBill
}
