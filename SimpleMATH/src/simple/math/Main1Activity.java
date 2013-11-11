package simple.math;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Main1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		
	       //.setNegativeButton("Err, no", new DialogInterface.OnClickListener() {
		           //public void onClick(DialogInterface dialog, int id) {
		             //   dialog.cancel();
		           //}
	
   //});

			
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
		return true;
	}*/
	
	public void onClick1(View v){
		//SettingsActivity sa = new SettingsActivity();
		if (checkForOperators())  {
			
			boolean mobileNwInfo = false;  
			ConnectivityManager conxMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);  
			try { mobileNwInfo = conxMgr.getActiveNetworkInfo().isConnected(); }  
			catch (NullPointerException e) { mobileNwInfo = false; }  
			if ( mobileNwInfo == true ) {
			  // Your code goes here...
				startSimpleMATHActivity();
			}
			else {		
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("Please check your Wireless & Network settings.")
				       .setCancelable(false).setTitle("Network Error")
				       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
				                // fire an intent go to your next activity
				        	   //startSimpleMATHActivity();
				        	   dialog.cancel();
				           }
				       });
				AlertDialog alert = builder.create();
			
			alert.show();}
			//startSimpleMATHActivity();
		}
		else {startSettingsActivity();}
		}
	
	public void onClick2(View v){
		startSettingsActivity();
	}
	
	public void onClick3(View v){
		startAboutActivity();
	}
	  
    public void startSimpleMATHActivity()    {      
    Intent i = new Intent(this,SimpleMATHActivity.class);        
    startActivity(i);
    }	
    
    public void startAboutActivity()    {      
    Intent i = new Intent(this,AboutActivity.class);        
    startActivity(i);
    }	
    
    public void startSettingsActivity()    {      
    Intent i = new Intent(this,SettingsActivity.class);        
    startActivity(i);
    }
    
    public boolean checkForOperators() {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Boolean add = sp.getBoolean("add", true);
		Boolean subtract = sp.getBoolean("subtract", true);
		Boolean multiply = sp.getBoolean("multiply", true);
		Boolean divide = sp.getBoolean("divide", true);
		if (!add && !subtract && !multiply && !divide)
		{
			Context context = this;
			CharSequence text = "You must select at least one operator.";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.setGravity(Gravity.BOTTOM, 0, 3);
			toast.show();
			return false;
    }
		return true;
    }
}
