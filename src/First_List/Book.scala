package First_List
import scala.io.Source
import java.io._

object Book extends App {
  
  var Book = Source.fromFile("Ostatnie_zyczenie.txt", "UTF-8").mkString.replaceAll("""[\p{Punct}]""", "").replaceAll("—", "").replaceAll(" ", "").toLowerCase.split("\\s+")

  var Stop = Source.fromFile("Stop_words.txt", "UTF-8").mkString.replaceAll("""[\p{Punct}]""", "").split("\\s+")

  var Filtered = Book.filterNot(Stop.contains(_))

  var Groupped = Filtered.groupBy(x=>x)

  var Reduced = Groupped.mapValues(x=>x.length)

  var Final = Reduced.toSeq.sortWith((x,y)=>x._2>y._2)

  var Fin2 = Final.take(50)

  val writer = new PrintWriter(new File("List_50elem.txt" ))

  for (pair <- Fin2) {
	  writer.write(pair._2 + " " + pair._1 + "\n")
  }
  writer.close()
      
}