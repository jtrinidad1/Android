package simple.math;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
	
	public void onClick(View v){
	Intent intent = new Intent(Intent.ACTION_SEND);
	//intent.setType("text/plain"); // send email as plain text
	intent.setType("message/rfc822");//send email as a fucking email - cause that's what I said.  
	intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "jtrinidadj@gmail.com;" });
	intent.putExtra(Intent.EXTRA_SUBJECT, "Excited simpleMATH User!");
	//intent.putExtra(Intent.EXTRA_TEXT, "mail body");
	startActivity(Intent.createChooser(intent, ""));
	}
}
