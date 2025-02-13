import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Problem {
	public static void main(String [] args) {
		Trie trie = new Trie();
		String fileName = args[0]; 
		try{
			 BufferedReader buf = new BufferedReader(new FileReader(fileName));
	         String lineJustFetched = null;
	         String[] commands;
	         while(true){
	             lineJustFetched = buf.readLine();
	             if(lineJustFetched == null) 
	                 break;
	             else {
	            	 commands = lineJustFetched.split(" ");
	            	 if(commands[0].equals("insert")){
	            		 if(trie.insert(trie, commands[1]))
	            			 System.out.println(commands[1]+" insertion succeeded");
	            		 else
	            			 System.out.println(commands[1]+" insertion failed");
	            	 }
	            	 else if(commands[0].equals("print")){
	            		 
	            	 }
	            	 else if(commands[0].equals("height")){
	            		 
	            	 }
	            	 else if(commands[0].equals("search")){
	            		 if(trie.search(trie, commands[1]))
	            			 System.out.println(commands[1]+" found");
	            		 else
	            			 System.out.println(commands[1]+" not found");
	            	 }
	            	 else if(commands[0].equals("smallest")) {
	            		 
	            	 }
	            	 else if(commands[0].equals("largest")) {
	            		 
	            	 }
	            	 else if(commands[0].equals("size")) {
	            		 
	            	 }
	             }
	         }
	         buf.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
}
