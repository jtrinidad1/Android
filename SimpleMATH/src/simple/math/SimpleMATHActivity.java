package simple.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;


public class SimpleMATHActivity extends Activity {
	//private static final int REQUEST_CODE = 1234; 
    /** Called when the activity is first created. Let's go.*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasdequestion);

        /** Yo Mama wants an Integer Array.  Insert 0-9 please..*/
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for(int i=0;i<=9;i++)
        {
            numeros.add(i);
        }
        
        /** Yo Mama wants them bitches shuffled.  Do it, then grab the first and second number.*/
        Collections.shuffle(numeros);
        int number1 = numeros.get(0);
        int number2 = numeros.get(1);
        //int number3;
        TextView tv = (TextView) findViewById(R.id.sma);
        
        if (number1 >=0 && number1 <= 10 && number2 >=0 && number2 <= 10 && (numeros != null))
        
        {
        	
        	//tv.setText(findViewById(R.string.math_question).toString());
        	tv.setText("What is " + number1 + " + " + number2 + " ?" );
        	int number3 = (number1 + number2);
        	
        	if (number3 > 10)
        	{
        		TextView tv1 = (TextView) findViewById(R.id.sma1);
        		tv1.setText("That shit was HARD!!" );
        		tv1.setTextColor(Color.RED);
        	}
        	if (number3 < 10)
        	{
        		TextView tv1 = (TextView) findViewById(R.id.sma1);
        		tv1.setText("Fuck it, it's easy!!" );
        		tv1.setTextColor(Color.MAGENTA);
        	}
        	if (number3 == 10)
        	{
        		TextView tv1 = (TextView) findViewById(R.id.sma1);
        		tv1.setText("You just found a special case." );
        		tv1.setTextSize(47);
        		tv1.setTextColor(Color.YELLOW);
        	}
        	
        }
        else
        {
        	//number3 = 0;
        	//tv.setText(findViewById(R.string.incorrect).toString());
        	tv.setText("incorrect");
        }
                
    }

}