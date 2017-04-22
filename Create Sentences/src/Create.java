import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Create {
	
	private List<String> verbs;
	private List<String> subjects;
//	private List<String> verbs;
	
	
	public Create(){
		
		verbs = new ArrayList<>();
		subjects = new ArrayList<>();
		
		try {
			
			getWordList("verbs.txt");
			getWordList("subjects.txt");
			
		} catch (IOException e) {e.printStackTrace();}
		
		
		
		for(int i = 0; i < 10; i++){
			System.out.println(createSentence());
		}
		
		
	}
	
	private String createSentence(){
		
		String subject = adjustSubject(subjects.get(getRandomInt(subjects.size())));
		String verb = adjustVerb(verbs.get(getRandomInt(verbs.size())));
		
		
		
		return subject + " " + verb;
	}
	
	private String adjustSubject(String subject){
		
		if(subject.contains("%")){
			subject = "the " + subject;
			subject = subject.replace("%", "");
		}
		
		if(subject.contains("^")){
			String[] subjectArray = subject.split("");
			subjectArray[0] = subjectArray[0].toUpperCase();
			subject = "";
			
			for(int i = 0; i < subjectArray.length; i++){
				if(!(subjectArray[i].contains("^"))){

					subject = subject + subjectArray[i];
				}
			}
		}
		
		return subject;
	}
	
	private String adjustVerb(String verb){
		
		
		return verb;
		
	}
	
	private int getRandomInt(int x){
		Random rand = new Random();
		
		return rand.nextInt(x);
	}
	

    private void getWordList(String path) throws IOException{


           BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(path)));

           String line;
           
           List<String> temp;
           
           if(path.contains("verb")){
        	   temp = verbs;
           } else if(path.contains("subject")){
        	   temp = subjects;
           } else{
        	   temp = new ArrayList<>();
        	   System.out.println("ERROR");
           }
           
           
           while((line = br.readLine()) != null){
        	   temp.add(line);

           }


           br.close();

    }

}
