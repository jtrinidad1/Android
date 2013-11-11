package simple.math;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Toast;

public class SettingsActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            onCreatePreferenceActivity();
        } else {
            onCreatePreferenceFragment();
        }
    }
	@SuppressLint("NewApi")
	public static class MyPreferenceFragment extends PreferenceFragment
	{
	    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@SuppressLint("NewApi")
	    @Override
	    public void onCreate(final Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        addPreferencesFromResource(R.xml.settings);
	    }
	}

    /**
     * Wraps legacy {@link #onCreate(Bundle)} code for Android < 3 (i.e. API lvl
     * < 11).
     */
    @SuppressWarnings("deprecation")
    private void onCreatePreferenceActivity() {
        addPreferencesFromResource(R.xml.settings);
    }

    /**
     * Wraps {@link #onCreate(Bundle)} code for Android >= 3 (i.e. API lvl >=
     * 11).
     */
    @SuppressLint("NewApi")
    private void onCreatePreferenceFragment() {
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment ())
                .commit();
    }
    
    public void onBackPressed() {
		/*SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
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
			toast.show();*/
    	if (checkForOperators()) { 
    		finish(); }
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
