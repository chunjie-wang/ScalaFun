# class vs case class

# Patten match
- Reg Expression
```
val EatingRegularExpression = """Eating Alert: bear=([^,]+),\s+source=(.+)""".r //.r turns a String to a regular expression
val SittingRegularExpression = """Sitting Alert: bear=([^,]+),\s+source=(.+)""".r
val SleepingRegularExpression = """Sleeping Alert: bear=([^,]+),\s+source=(.+)""".r

def goldilocks(expr: String) = expr match {
  case (EatingRegularExpression(bear, source)) => "%s said someone's been eating my %s".format(bear, source)
  case (SittingRegularExpression(bear, source)) => "%s said someone's been sitting on my %s".format(bear, source)
  case (SleepingRegularExpression(bear, source)) => "%s said someone's been sleeping in my %s".format(bear, source)
  case _ => "what?"
}
```
- Reference:
```
def patternEquals(i: Int, j: Int) = j match {
  case `i` => true
  case _ => false
}
patternEquals(3, 3) should be(true)
patternEquals(7, 9) should be(false)
patternEquals(9, 9) should be(true)
goldilocks("Eating Alert: bear=Papa, source=porridge") should be("Papa said someone's been eating my porridge")
goldilocks("Sitting Alert: bear=Mama, source=chair") should be("Mama said someone's been sitting on my chair")
```

- Match list:
```
val secondElement = List(1,2,3) match {
  case x :: y :: xs => y
  case _ => 0
}
secondElement should be(2)
```