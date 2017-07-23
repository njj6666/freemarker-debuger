#Introduction 
A simple JAVA tool to debug freemarker. help to loading json as input and process the data with specific FTL template. At last generate a output file.

#CONSTRAINS:
1. It does not support executable jar for now. That means you cannot run it with java jar command. You have to run it in your favorite IDE.
2. It merely supports Map-Root json format.(the json data start with '{' instead of '[', but it is OK if array element is not the root element)

#How to use
1. Import the JAVA projec into your IDE.
2. The main JAVA file is \src\main\java\freemarkerdebuger\FreeMakerDebuger.java
3. Run it as Java application with 2 arguments. The first is your input file name. it shall be a json. And make sure that this file really exists under projectroot/input folder; The second arg is your FTL template file name you want to use to process the input data, make sure that this file really exists in projectroot\src\main\java\templates folder.
4. You can also run it without arguments, it will use input/input.json and \src\main\java\templates\default.ftl as default.
