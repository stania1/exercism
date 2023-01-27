package lasagna

// TODO: define the 'PreparationTime()' function
const (
	DefaultPrepTime = 2
	Noodles         = "noodles"
	Sauce           = "sauce"
	NoodleQuantity  = 50
	SauceQuantity   = 0.2
	DefaultPortion  = 2.0
)

func PreparationTime(layers []string, prepTimeMinutes int) int {
	if prepTimeMinutes <= 0 {
		prepTimeMinutes = DefaultPrepTime
	}
	return len(layers) * prepTimeMinutes
}

// TODO: define the 'Quantities()' function
func Quantities(layers []string) (noodles int, sauce float64) {
	for _, l := range layers {
		if l == Noodles {
			noodles += NoodleQuantity
		} else if l == Sauce {
			sauce += SauceQuantity
		}
	}
	return
}

// TODO: define the 'AddSecretIngredient()' function
func AddSecretIngredient(friendsList, myList []string) {
	myList[len(myList)-1] = friendsList[len(friendsList)-1]
}

// TODO: define the 'ScaleRecipe()' function
func ScaleRecipe(quantities []float64, portions int) []float64 {
	scaledQuantities := make([]float64, len(quantities))
	for i := range quantities {
		scaledQuantities[i] = quantities[i] * float64(portions) / DefaultPortion
	}
	return scaledQuantities
}
