package main;

//import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;







import Utils.Constants;
import Utils.MyUtils;
//import Utils.Constants;
import Utils.Constants.FieldType;
//import Utils.DataManipulation;
//import Utils.Post;
import Utils.Constants.LogicalOperation;
import Utils.TSVManipulations;
import Utils.Constants.ConditionType;
//import Utils.Constants.SortOrder;

public class Algorithm {
	//------------------------------------------------------------------------------------------------------------------------
	private static void addCoOccurrence(String item1, String item2, TreeMap<String, Long> coOccurrences){
		String coOccurredItem;
		if (item1.compareTo(item2) < 0)
			coOccurredItem = item1 + Constants.SEPARATOR_FOR_FIELDS_IN_TSV_FILE  + item2;
		else
			coOccurredItem = item2 + Constants.SEPARATOR_FOR_FIELDS_IN_TSV_FILE  + item1;
		Long numberOfTimesCoOccurred = coOccurrences.get(coOccurredItem);
		if (numberOfTimesCoOccurred == null)
			coOccurrences.put(coOccurredItem, (long)1);
		else
			coOccurrences.put(coOccurredItem, numberOfTimesCoOccurred+1);
	}//addCoOccurrence(....
	//------------------------------------------------------------------------------------------------------------------------
	//The following method extracts and saves the co-occurrences of SO tags in all SO questions:
	public static void extractCoOccurrencesOfTagsInDataSet(String postsTSVInputPathAndFileName, String outputPathAndFileName, 
			int showProgressInterval, long testOrReal){
		//Read info of all questions (by field id): (total Q: 7,214,697      total lines: 19,881,020          --3,642,245)
		Date d1 = new Date();
		MyUtils.println("-----------------------------------", 1);
		MyUtils.println("-----------------------------------", 1);
		MyUtils.println("Start ...", 1);
		TreeMap<String, String[]> posts1ById = TSVManipulations.readUniqueKeyAndItsValueFromTSV(
				postsTSVInputPathAndFileName, null, 0, 9, "5", LogicalOperation.IGNORE_THE_SECOND_OPERAND, 1, ConditionType.EQUALS, "1", 
				FieldType.NOT_IMPORTANT, 0, ConditionType.NOTHING, "", FieldType.NOT_IMPORTANT, true, showProgressInterval, 2, testOrReal, "1");
		TreeMap<String, Long> coOccurrences = new TreeMap<String, Long>();
		for (Map.Entry<String, String[]> entry: posts1ById.entrySet()){
			String s = entry.getValue()[0];
			//Removing the "[" and "]" from the sides:
			s = s.substring(1, s.length()-1);
			//Separate the tags:
			String[] tags = s.split(Constants.TAGS_SEPARATOR);
			//Count the co-occurrences:
			for (int i=1; i<tags.length; i++)
				for (int j=0; j<i; j++)
					addCoOccurrence(tags[i], tags[j], coOccurrences);
		}
		
		//Testing:
//		for (Map.Entry<String, Long> entry: coOccurrences.entrySet())
//			System.out.println(entry.getKey() + "\t" + entry.getValue());
		
		//Saving:
		String[] titles = {"Tag1", "Tag2", "CoOccurrence"};
		TSVManipulations.saveKeyAndValuesAsTSVFile(outputPathAndFileName, coOccurrences, 3, titles, true, 
				showProgressInterval, 2, testOrReal, "2");

		Date d2 = new Date();
		System.out.println();
		MyUtils.println("Total time: " + (float)(d2.getTime()-d1.getTime())/1000  + " seconds.", 2);
		MyUtils.println("End.", 1);
		MyUtils.println("-----------------------------------", 1);
		MyUtils.println("-----------------------------------", 1);
	}
	//------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		extractCoOccurrencesOfTagsInDataSet(Constants.DATASET_DIRECTORY_TSV + "\\Posts.tsv", Constants.DATASET_DIRECTORY_TSV_OUTPUT + "\\coOccurrences.tsv", 
				500000, Constants.THIS_IS_REAL);
//		System.out.println(Integer.parseInt("3"));
	}

}
