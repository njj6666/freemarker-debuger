package freemarkerdebuger;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class FreeMakerDebuger {
	
	private static String inputfile = "input.json";
	private static String templateName = "default.ftl";

	public static void main(String[] args) throws Exception {
		
		if(args==null || args.length==0){
			
		}else if(args.length==2){
			inputfile=args[0];
			templateName=args[1];
		}else{
			System.out.println("args for the debug is wrong.");
			System.out.println("You have 2 options:");
			System.out.println("1. Indicating no args. App will load default files under project root directory as following");
			System.out.println("\t input/input.json");
			System.out.println("\t src/main/java/templates/default.ftl");
			System.out.println("2. You need to specify above 2 files names in sequence.");
			System.out.println("\t 1). Input json file name. e.g. paramater is 'abc.json', you should put abc.json to projectroot/input folder.");
			System.out.println("\t 2). FTL file name. e.g. paramater is 'mytemplate.ftl', you should put mytemplate.ftl under src/main/java/templates folder");
			System.out.println("Go to projectroot/output to get your output file.");
		}
		// 1. Configure FreeMarker
		//
		// You should do this ONLY ONCE, when your application starts,
		// then reuse the same Configuration object elsewhere.

		@SuppressWarnings("deprecation")
		Configuration cfg = new Configuration();

		// Where do we load the templates from:
		cfg.setClassForTemplateLoading(FreeMakerDebuger.class, "../templates");

		// Some other recommended settings:
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader("input/"+inputfile));
		JSONObject input = (JSONObject) obj;

		//Debug input json in java object
//		String id = (String) input.get("id");
//		System.out.println(id);

		Template template = cfg.getTemplate("default.ftl");

		// Write output to the console
//		Writer consoleWriter = new OutputStreamWriter(System.out);
//		template.process(input, consoleWriter);

		// For the sake of example, also write output into a file:
		Writer fileWriter = new FileWriter(new File("output/"+templateName+".output"));
		try {
			template.process(input, fileWriter);
		} finally {
			fileWriter.close();
		}
		
		System.out.println("Finished");

	}
}