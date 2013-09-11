package com.bnr.geoquiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private Button mPreviousButton;
	private TextView mQuestionTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		mQuestionTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		mNextButton = (Button) findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		mPreviousButton = (Button) findViewById(R.id.previous_button);
		mPreviousButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (checkNegative(mCurrentIndex) - 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		mTrueButton = (Button) findViewById(R.id.True_Button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.Correct_String, Toast.LENGTH_SHORT).show();
				checkAnswer(true);
			}
		});
		mFalseButton = (Button) findViewById(R.id.False_Button);
		mFalseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.Incorrect_String, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
			}
		});
		
		updateQuestion();
	}
	
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_earth, false),
			new TrueFalse(R.string.question_mother, true),
			new TrueFalse(R.string.question_oceans, true)
	};
	
	private int mCurrentIndex = 0;
	
	private void updateQuestion() {
		// TODO Auto-generated method stub
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}
	
	private int checkNegative(int i) {
		if (i == 0) {
			return mQuestionBank.length;
		}		
		return i;
	}
	
	private void checkAnswer(boolean userPressedTrue){
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		
		int messageResId = 0;
		
		if (userPressedTrue == answerIsTrue) {
			messageResId = R.string.Correct_String;
		}
		else {
			messageResId = R.string.Incorrect_String;
		}
		
		Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}*/

}
