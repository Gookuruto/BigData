package First_List

class functions{
def gcds(a: Integer, b:Integer): Integer = {
	if (a == 0 || b == 0) Math.abs(a);
	else Math.abs(gcds(b, a % b));
}
def lcms(a: Integer, b:Integer): Integer = {
	if (a == 0 || b == 0) 0;
	else Math.abs(a * b) / gcds(a, b);
}
def tf(n: Integer): Integer = {
  Range(1, n+1).count(n%_ == 0)
}
def sigma(n: Integer): Integer ={
  Range(1,n+1).filter(n%_==0).sum
  }
def sigma(n:Integer, a: Integer): Integer={
Range(1,n+1).filter(n%_==0).map(x=> Math.pow(x, a.doubleValue()).intValue()).sum
}
def Euler(n: Integer): Integer = {
	Range(1, n+1).count(gcds(_, n) == 1)
}
  def isPrime(num:Int):Boolean ={
(num > 1) && !(2 to scala.math.sqrt(num).toInt).exists(x =>num % x == 0)
  }
}


object functions extends App {
  val functions = new functions();
  val vector = Range(1,101).filter(100%_==0).map(x=>functions.Euler(x))//.sum
  val t = functions.sigma(10,2)
  val vec = Range(1,1000).filter(functions.isPrime(_))
  val complex = new Complex(2,2)
  println(complex+complex)
  println(complex*complex)
  println(complex.abs)
  //println(vec)
  //println(vec.length)
  
}