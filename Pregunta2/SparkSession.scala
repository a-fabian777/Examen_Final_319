
//SparkSession se crea mediante el método de creación, que se utiliza para configurar la sesión. 
//El método master se usa para establecer la URL maestra de Spark, que especifica la ubicación del clúster de Spark. 
//El método appName se usa para establecer el nombre de la aplicación Spark. 
//El método getOrCreate se usa para obtener la SparkSession existente o crear una nueva si aún no existe.

val spark: SparkSession = SparkSession.builder()
    .master("local[*]")
    .appName("simple-app")
    .getOrCreate()

//La primera línea crea un Dataset[String] llamando al método textFile en el objeto SparkSession. 
//Este método lee el archivo de texto y devuelve un conjunto de datos que contiene una fila para cada línea del archivo.

val dataSet: Dataset[String] = spark.read.textFile("textfile.csv")

//En esta linea se convierte el Dataset[String] en un DataFrame llamando al método toDF. 
//Este método crea un DataFrame con una sola columna llamada "value" que contiene el contenido de cada línea en el archivo de texto.

val df: DataFrame = dataSet.toDF()
