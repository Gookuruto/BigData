package First_List

import scala.io.Source
import java.io._

object BookChapters extends App {
  var Chapter = Source.fromFile("rozdzialy/1", "UTF-8").mkString.replaceAll("""[\p{Punct}]""", "").replaceAll("—", "").replaceAll(" ", "").toLowerCase.split("\\s+")

  var Stop = Source.fromFile("Stop_words.txt", "UTF-8").mkString.replaceAll("""[\p{Punct}]""", "").split("\\s+")

  var Filtered = Chapter.filterNot(Stop.contains(_))

  var Groupped = Filtered.groupBy(x=>x)

  var Reduced = Groupped.mapValues(x=>x.length)

  var Final = Reduced.toSeq.sortWith((x,y)=>x._2>y._2)

  var AllWord =0.0
  var ChapterTemp = Source.fromFile("rozdzialy/1", "UTF-8").mkString.replaceAll("""[\p{Punct}]""", "").replaceAll("—", "").replaceAll(" ", "").toLowerCase.split("\\s+")


  for (pair <- Final){
    AllWord+=pair._2
  }

  val writer = new PrintWriter(new File("List_ch1_v2.txt" ))

  for (pair <- Final) {
    var containterm =0.0
    for(i<- 1 to 12){
       ChapterTemp = Source.fromFile("rozdzialy/"+i, "UTF-8").mkString.replaceAll("""[\p{Punct}]""", "").replaceAll("—", "").replaceAll(" ", "").toLowerCase.split("\\s+")
      if(ChapterTemp.contains(pair._1)){
        containterm+=1
      }
    }
    println(containterm)
    writer.write(((pair._2/AllWord.toDouble)*(math.log(12/containterm))) + " " + pair._1 + "\n")
  }
  writer.close()


}
