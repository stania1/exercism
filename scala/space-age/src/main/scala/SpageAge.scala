object SpaceAge {

  private val earthOrbitalPeriodSeconds = 31557600

  private val orbitalPeriodRelativeToEarth = Map[String, Double](
    "Earth" -> 1,
    "Mercury" -> 0.2408467,
    "Venus" -> 0.61519726,
    "Mars" -> 1.8808158,
    "Jupiter" -> 11.862615,
    "Saturn" -> 29.447498,
    "Uranus" -> 84.016846,
    "Neptune" -> 164.79132
  )

  def onEarth(ageSeconds: Double): Double = ageOn("Earth", ageSeconds)

  def onMercury(ageSeconds: Double): Double = ageOn("Mercury", ageSeconds)

  def onVenus(ageSeconds: Double): Double = ageOn("Venus", ageSeconds)

  def onMars(ageSeconds: Double): Double = ageOn("Mars", ageSeconds)

  def onJupiter(ageSeconds: Double): Double = ageOn("Jupiter", ageSeconds)

  def onSaturn(ageSeconds: Double): Double = ageOn("Saturn", ageSeconds)

  def onUranus(ageSeconds: Double): Double = ageOn("Uranus", ageSeconds)

  def onNeptune(ageSeconds: Double): Double = ageOn("Neptune", ageSeconds)

  private def ageOn(planet: String, ageSeconds: Double): Double = {
    round(ageSeconds / orbitLengthSeconds(planet))
  }

  private def orbitLengthSeconds(planet: String) = {
    orbitalPeriodRelativeToEarth(planet) * earthOrbitalPeriodSeconds
  }

  private def round(value: Double) = {
    Math.round(value * 100) / 100.0
  }

}