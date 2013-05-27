package simple.math;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;

public class Main1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
		return true;
	}
	
	public void onClick(View v){
		startSimpleMATHActivity();
	}
	
    /**     * Fire an intent to start the voice recognition activity.     */    
    public void startSimpleMATHActivity()    {      
    Intent i = new Intent(this,SimpleMATHActivity.class);        
    startActivity(i);

}}
