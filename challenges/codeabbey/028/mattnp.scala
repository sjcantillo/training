object Solution extends App {
  val nPeople = scala.io.StdIn.readLine.toInt
  var words = Array("under", "normal", "over", "obese")
  for (a <- 1 to nPeople) {
    val values = scala.io.StdIn.readLine.split(" ").map(_.toDouble)
    val bmi = bodyMassIndex(values(0), values(1))
    var indWord = 0
    if (bmi < 18.5) {
      indWord = 0
    } else if (bmi < 25) {
      indWord = 1
    } else if (bmi < 30) {
      indWord = 2
    } else {
      indWord = 3
    }
    System.out.print(words(indWord) + " ")
  }

  def bodyMassIndex(weight: Double, height: Double) = weight / Math.pow(height, 2)
}
