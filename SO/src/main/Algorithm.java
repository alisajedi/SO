package main;

//import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//import Utils.Constants;
import Utils.Constants.FieldType;
//import Utils.DataManipulation;
//import Utils.Post;
import Utils.Constants.LogicalOperand;
import Utils.TSVManipulations;
import Utils.Constants.ConditionType;
//import Utils.Constants.SortOrder;

public class Algorithm {
	//The following method extracts and saves the co-occurrences of SO tags in all SO questions:
	public static void extractCoOccurrencesOfTagsInDataSet(String postsTSVInputPathAndFileName, String outputPathAndFileName, 
			int showProgressInterval, long testOrReal){
		//Read info of all questions (by field id): (total Q: 7,214,697      total lines: 19,881,020          --3,642,245)
		TreeMap<String, String[]> posts1ById = TSVManipulations.readUniqueKeyAndItsValueFromTSV(
				postsTSVInputPathAndFileName, null, 0, 9, "ALL", LogicalOperand.IGNORE_THE_SECOND_OPERAND, 1, ConditionType.EQUALS, "1", 
				FieldType.NOT_IMPORTANT, 0, ConditionType.NOTHING, "", FieldType.NOT_IMPORTANT, true, showProgressInterval, 1, testOrReal, "1");
		for (Map.Entry<String, String[]> entry: posts1ById.entrySet()){
			System.out.println(entry.getKey());
		}
		//Read info of all answers (by field parentId): (total: ????????)
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
//		TreeMap<String, ArrayList<String[]>> posts2ByQuestionId = TSVManipulations.readNonUniqueKeyAndItsValueFromTSV(
//				postsInputPathAndTSV, null, 3, SortOrder.DEFAULT_FOR_STRING , 9, "0$3$7", LogicalOperand.OR, 7, ConditionType.GREATER_OR_EQUAL, "5", FieldType.INTEGER, 7, ConditionType.GREATER_OR_EQUAL, "10", FieldType.INTEGER, showProgressInterval, testOrReal, 1);
//		ArrayList<Post> answersOfThisQuestionAL = null;
//		for (Map.Entry<String, ArrayList<String[]>> entry: posts2ByQuestionId.entrySet()){
//			String thisQuestionId = entry.getKey();
//			answersOfThisQuestionAL = DataManipulation.copyPosts_ContentsFromArrayListOfStringArray_OnlyThereAreSomeFields1(entry.getValue());
//			Post post = DataManipulation.copyPostContentsFromStringArray_OnlyThereAreSomeFields1(posts1ById.get(thisQuestionId));
//			if (answersOfThisQuestionAL.size() > 50)
//				System.out.println("QId: " + thisQuestionId + "\t#ofAnswers: " + answersOfThisQuestionAL.size() + "\tAnswerCount: " + post.answerCount);
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		filterPostsTo_QuestionsWithAtLEast5AnswersPlusTheirAnswers(Constants.DATASET_DIRECTORY + "\\Posts.tsv", 
//				2000000, Constants.THIS_IS_REAL);
//		System.out.println("7".compareTo(""));
//		System.out.println(Integer.parseInt("3"));
	}

}
