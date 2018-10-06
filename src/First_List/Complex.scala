package First_List

case class Complex(real: Double, imag: Double) {
  override def toString =real+" + "+imag+"i"
  def re()=real
  def im()=imag
  def +(that: Complex)=
    Complex(this.real+that.real,this.imag+that.imag)
   def +(that: Int) =
    Complex(this.real + that, this.imag)

  def +(that: Long) =
    Complex(this.real + that, this.imag)

  def +(that: Float) =
    Complex(this.real + that, this.imag)

  def +(that: Double) =
    Complex(this.real + that, this.imag)
  def *(that: Complex) =
    Complex(this.real * that.real - this.imag * that.imag, this.real * that.imag + this.imag * that.real)

  def *(that: Int) =
    Complex(this.real * that, this.imag * that)

  def *(that: Long) =
    Complex(this.real * that, this.imag * that)

  def *(that: Float) =
    Complex(this.real * that, this.imag * that)

  def *(that: Double) =
    Complex(this.real * that, this.imag * that)
    
  def abs=
    math.sqrt(real * real + imag * imag)
    
}