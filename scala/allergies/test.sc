val values: Allergen.ValueSet = Allergen.values
values.zipWithIndex.map{case (v, k) => (k, v)}.toMap

Math.pow(2, Allergen.maxId)

//Allergen.values.