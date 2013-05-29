/*Title: SimpleMATHActivity.java
 *Author: Juan Trinidad Jr
 *
 *This activity generates two random integers and prepares them for addition.  At random, the mathematics operator is
 *chosen, and the question is prompted.  The user is presented with a series of buttons allowing them to answer the
 *question using voice-input, or repeat the randomization process to prompt a new question. 
 * 
 * This is the Meat and Potatoes of this application.
 * */

package simple.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import simple.math.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SimpleMATHActivity extends Activity {
	//SimpleMATHActivity Variables//
	
	int	number1;	//First integer
	int	number2;	//Second integer
	int	number3;	//This will become the appropriate answer
	

		
	/**Prepare for an array!  Hold the approval code!*/
	ArrayList<Integer> numeros = new ArrayList<Integer>();
	ArrayList<Integer> numeros1 = new ArrayList<Integer>();
	private static final int REQUEST_CODE = 1234;
	
    /**Let's go.*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =  getIntent();
        
        setContentView(R.layout.pasdequestion);
        shuffleBitches();
        askQuestion();
        //askAdditionQuestion();
        //askSubtractionQuestion();
        //askMultiplicationQuestion();
        //askDivisionQuestion();
        
        //Let's start some MADNESS
        Button speakButton = (Button) findViewById(R.id.speakButton);
        Button newQuestionButton = (Button) findViewById(R.id.newQuestionButton);
        View newQuestionView = (View) findViewById(R.id.newQuestionButton);
       	 newQuestionView.setVisibility(View.GONE);
       	//newQuestionView.setVisibility(View.VISIBLE);
       	
        //Check for recognition service       
        PackageManager pm = getPackageManager();        
        List<ResolveInfo> activities = pm.queryIntentActivities(                
        new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);        
        if (activities.size() == 0)        {            
        speakButton.setEnabled(false);            
        speakButton.setText("Recognizer not present");        }}
    
    	private void newQuestion() {
    		shuffleBitches();
    		TextView resultword1 = (TextView) findViewById(R.id.sma2);
    		resultword1.setText("");
    		TextView resultResponse = (TextView) findViewById(R.id.sma3);
       	   	resultResponse.setText("");
    		askQuestion();
       	   	//askDivisionQuestion();
    		
    	   	 View newQuestionView = (View) findViewById(R.id.newQuestionButton);
    	   	 newQuestionView.setVisibility(View.GONE);
    	}
    
	    private void askAdditionQuestion() {
	        TextView tv = (TextView) findViewById(R.id.sma);
	        tv.setText("What is " + number1 + " + " + number2 + " ?" );
	        number3 = number1 + number2;
	        //TextView resultword1 = (TextView) findViewById(R.id.sma1);
	        //resultword1.setText(Integer.toString(number3));
		
	}
	    
	    private void askSubtractionQuestion() {
	        TextView tv = (TextView) findViewById(R.id.sma);
	        tv.setText("What is " + number1 + " - " + number2 + " ?" );
	        number3 = number1 - number2;
	        //TextView resultword1 = (TextView) findViewById(R.id.sma1);
	        //resultword1.setText(Integer.toString(number3));
	}
	    
	    private void askMultiplicationQuestion() {
	        TextView tv = (TextView) findViewById(R.id.sma);
	        tv.setText("What is " + number1 + " x " + number2 + " ?" );
	        number3 = number1 * number2;
	        //TextView resultword1 = (TextView) findViewById(R.id.sma1);
	        //resultword1.setText(Integer.toString(number3));
	}
	    
	    private void askDivisionQuestion() {
	    	
	    	if(number2 == 0){
	    		number2 = 1;
	    	}
	    	if(checkDivision()){
	    		number3 = number1 / number2;
		        TextView tv = (TextView) findViewById(R.id.sma);
		        tv.setText("What is " + number1 + " / " + number2 + " ?" );
	    	}
	    	else {
	    		shuffleBitches();
	    		askDivisionQuestion();
	    	}
	}

		private boolean checkDivision(){
	    	if(number1 % number2 == 0) {
	    	return true;
	    	}
	    	else {return false;
	    		}
	    	}
	    
		private void askQuestion(){
			int num1;
	    	for(int i=1;i<=4;i++)
	        {
	            numeros1.add(i);
	        }
	        
	        //Yo Mama wants them bitches shuffled.  Do it, then grab the first and second number.  Assign them bitches!
	        Collections.shuffle(numeros1);
	        num1 = numeros1.get(0);
	        switch (num1) {
	        case 1: askAdditionQuestion();
	        		break;
	        case 2: askSubtractionQuestion();
	        		break;		
	        case 3: askMultiplicationQuestion();
    				break;
	        case 4: askDivisionQuestion();
	        		break;
	        }
	    }

		private void shuffleBitches(){
			//Add all integers between zero and ten into array
	    	for(int i=0;i<=10;i++)
	        {
	            numeros.add(i);
	        }
	        
	        //Yo Mama wants them bitches shuffled.  Do it, then grab the first and second number.  Assign them bitches!
	        Collections.shuffle(numeros);
	        /*num1 = numeros.get(0);
	        num2 = numeros.get(1);
            number1 = num1;
	        number2 = num2;*/
	        number1 = numeros.get(0);
	        number2 = numeros.get(1);
	    }

		/**     * Handle the action of the button being clicked     */    
        public void speakButtonClicked(View v)    {        
        startVoiceRecognitionActivity();    }
        
        public void newQuestionButtonClicked(View v) {
        	newQuestion();
        }
        
        /**     * Fire an intent to start the voice recognition activity.     */    
        private void startVoiceRecognitionActivity()    {      
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,                
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);        
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "");        
        startActivityForResult(intent, REQUEST_CODE);    }    
        
        /**     * Handle the results from the voice recognition activity.     */   
       // @Override    
        protected void onActivityResult(int requestCode, int resultCode, Intent data){    
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)        {   
        	
        // Populate the wordsList with the String values the recognition engine thought it heard           
        ArrayList<String> matches = data.getStringArrayListExtra( 		 
        RecognizerIntent.EXTRA_RESULTS);
   	 	TextView resultword = (TextView) findViewById(R.id.sma2);
   	 	resultword.setText(matches.get(0).toString());
   	 	String result0 = matches.get(0).toString().trim();
   	 	String result1 = Integer.toString(number3).trim();
   	 	results(result0, result1);
        super.onActivityResult(requestCode, resultCode, data);    
        	}//END THE MADNESS     
        }	

		private void results(String res0, String res1) {
			/**See if you can make it vibrate!*/
			int	dot = 100;
			int	dots = 500;
			int	short_gap = 100;

			long [] pattern1 = {
					0, dot, short_gap, dot, short_gap, dot	};
			long [] pattern2 = {
					0, dots	};
			//Compare
		   	if((res0 == res1) || (res0.equals(res1))){
		   	//if((result1 == result0) || (result0.contains(result1))){
		   		TextView resultResponse = (TextView) findViewById(R.id.sma3);
		   		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		   		v.vibrate(pattern1, -1);
		   	   	resultResponse.setText("You're right!");
		   	   	
		   	 View newQuestionView = (View) findViewById(R.id.newQuestionButton);
		   	 newQuestionView.setVisibility(View.VISIBLE);
		   	 
		   	}
		   	else{
		   		TextView resultResponse = (TextView) findViewById(R.id.sma3);
		   		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		   		v.vibrate(pattern2, -1);
		   	   	resultResponse.setText("You're incorrect. :(");
		   	 //Button speakButton = (Button) findViewById(R.id.speakButton);
		   	 //speakButton.setText("Try Again?");
		   	 View newQuestionView = (View) findViewById(R.id.newQuestionButton);
		   	 newQuestionView.setVisibility(View.VISIBLE);
		   	 //resultword.setText(matches.get(0).toString());
		       // if (number1 = 3)
		   	 
		        } 
			
		}}