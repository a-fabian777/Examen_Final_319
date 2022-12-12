//importando librerias necesarias
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream 
import org.apache.spark.streaming.Seconds 

//Para crear un DataFrame o Dataset de datos se puede usar el método socketTextStream proporcionado por el objeto SparkContext. 
//Este método crea un ReceiverInputDStream que recibirá datos de un socket de red, lo que le permitirá transmitir datos a Spark.
//se crea un StreamingContext utilizando el sparkContext y un intervalo de lote de 20 segundos. 

val streamingContext: StreamingContext = new StreamingContext(sparkContext, Seconds(20))

//Se supone que SparkContext se creó como una variable llamada sc
//creando contexto
val streamingContext: StreamingContext = new StreamingContext(sc, Seconds(20))

//Este StreamingContext luego se usa para crear un ReceiverInputDStream que recibirá datos de un socket en el host y el puerto especificados (en este caso, localhost:9999).
val lines: ReceiverInputDStream[String] = streamingContext.socketTextStream("localhost", 9999)

//Una vez que tenga un ReceiverInputDStream, puede usar los diversos métodos proporcionados por Spark Streaming API para manipular los datos. 
//Por ejemplo, puede usar los métodos de “map” y “filter” para transformar los datos.
