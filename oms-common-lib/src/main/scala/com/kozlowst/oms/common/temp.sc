
case class Comment(id: Long, tag: String)

val id1 = 123
val id2 = 22
val tag1 = "tag33"
val tag2 = "tag22"
val c1 = Comment(id1, tag1)

c1 match {
  case Comment(`id2`, tag1) => println(id2, tag2)
  case _ => println("any")
}

trait A {
  def a: String

  println("A::a = " + a)
}

class AA(aa: String) extends A {
  override def a: String = aa
}

val aa: AA = new AA("HOME")