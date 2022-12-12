//Se crea una matriz de cadenas llamada "cadenas" y luego se convierte en un Apache Spark RDD llamado "cadenasRDD" 
val cadenas = Array("Docentes", "inteligenciaArtificial", "quefinal")

//con el método "parallelize" proporcionado por SparkContext (sc en este caso). Luego, este RDD se recopila 
val cadenasRDD = sc . parallelize (cadenas)

//con el método de "collect", que devuelve una matriz que contiene todos los elementos en el RDD.
cadenasRDD.collect()

//Se llama al método "collect" en la variable "file", que parece ser un RDD que contiene datos de un archivo de texto.
//Esto devolverá una matriz que contiene todas las líneas en el archivo de texto.
file.collect() //en este caso file no existe

//El método "filter" se usa para crear un nuevo RDD llamado "filtro" que contiene sólo los elementos en "cadenasRDD" que contienen la cadena "quefinal".
val filtro = cadenasRDD.filter(line => line.contains("quefinal"))

//El método "textFile" se usa para crear un nuevo RDD llamado "fileNotFound" a partir de un archivo ubicado en /abc/xyz/. 
val fileNotFound = sc.textFile("/abc/xyz/", 6)

//Este método generará una excepción FileNotFoundException si el archivo no existe, lo que provocará que el método "collect" siguiente falle.
fileNotFound.collect()
