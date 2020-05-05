package com.comp1601.truefalsequiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mEButton;
    private Button mSubmitButton;
    private Button mPreviousButton;
    private Button mNextButton;
    private Button mQuit;


    private final String TAG = this.getClass().getSimpleName() + " @"+ System.identityHashCode(this);

    private int mCurrentQuestionIndex=0;
    ArrayList<Question> mQuestions = new ArrayList<Question>(10);
    TextView mQuestionTextView;
    String [] previousAnswers = new String[10];
    int [] answerCount = new int [10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAButton = findViewById(R.id.a_button);
        mBButton = findViewById(R.id.b_button);
        mCButton = findViewById(R.id.c_button);
        mDButton = findViewById(R.id.d_button);
        mEButton = findViewById(R.id.e_button);
        mQuit = findViewById(R.id.quit_button);
        mSubmitButton = findViewById(R.id.sumbit_button);
        mPreviousButton = findViewById(R.id.previous_button);
        mNextButton = findViewById(R.id.next_button);

//adding questions to array of questions
        mQuestions.add(new Question(getString(R.string.question1)));
        mQuestions.add(new Question(getString(R.string.question2)));
        mQuestions.add(new Question(getString(R.string.question3)));
        mQuestions.add(new Question(getString(R.string.question4)));
        mQuestions.add(new Question(getString(R.string.question5)));
        mQuestions.add(new Question(getString(R.string.question6)));
        mQuestions.add(new Question(getString(R.string.question7)));
        mQuestions.add(new Question(getString(R.string.question8)));
        mQuestions.add(new Question(getString(R.string.question9)));
        mQuestions.add(new Question(getString(R.string.question10)));

        mQuestionTextView = findViewById(R.id.question_text_view);
        mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
        //questions text colour
        mQuestionTextView.setTextColor(Color.rgb(180,5,180));

//loops printing questions and answers
        for (Question q : mQuestions)
            System.out.println("Q: " + q.getQuestion() + "A: " + q.getAnswer());

//when next button is clicked all buttons turn black and next index increases by 1
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAButton.setBackgroundColor(Color.BLACK);
                mBButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.BLACK);
                mDButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.BLACK);
                mCurrentQuestionIndex++;
                //shows next questions
                if (mCurrentQuestionIndex >= mQuestions.size()) mCurrentQuestionIndex = 0;
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());

            }
        });
//when previous button is clicked
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if previous button is clicked at first index print that there is no previous question
                if (mCurrentQuestionIndex==0){
                    System.out.println("No previous question because it is the first one...");
                }
                //subtract 1 from current index to go to previous question
                else{
                mCurrentQuestionIndex--;
                //toast previous answer that is saved in previousAnswers array
                Toast.makeText(MainActivity.this, ("Your previous answer was "+ previousAnswers[mCurrentQuestionIndex]), Toast.LENGTH_SHORT).show();
                if (mCurrentQuestionIndex >= mQuestions.size()) mCurrentQuestionIndex = 0;
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
            }}
        });


//when a button is clicked
        mAButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //set answer to current question to a
                previousAnswers[mCurrentQuestionIndex]= "A";
                //change all buttons black except A
                mBButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.BLACK);
                mDButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.BLACK);
                mAButton.setBackgroundColor(Color.rgb(180,5,180));
                Log.i(TAG, "A Button Clicked");
                    //if correct answerCount at this current question is equal to 1 point
                        if(mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("A"))
                        {
                            answerCount[mCurrentQuestionIndex]=1;
                        }
                        //if incorrect answerCount at this current question is equal to 0 point
                        else{
                            answerCount[mCurrentQuestionIndex]=0;
                        }

            };
        });


        mBButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousAnswers[mCurrentQuestionIndex]= "B";
                mAButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.BLACK);
                mDButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.BLACK);
                mBButton.setBackgroundColor(Color.rgb(180,5,180));

                Log.i(TAG, "B Button Clicked");

                        if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("B")) {
                            answerCount[mCurrentQuestionIndex]=1;
                        }
                        else{
                            answerCount[mCurrentQuestionIndex]=0;
                        }
                ;
            };
        });
        mCButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousAnswers[mCurrentQuestionIndex]= "C";
                mAButton.setBackgroundColor(Color.BLACK);
                mBButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.rgb(180,5,180));
                mDButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.BLACK);


                Log.i(TAG,"C Button Clicked");

                        if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("C")) {
                            answerCount[mCurrentQuestionIndex]=1;
                        }
                        else{
                            answerCount[mCurrentQuestionIndex]=0;
                        }
                    ;
                };
            ;
        });
        mDButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousAnswers[mCurrentQuestionIndex]= "D";
                mAButton.setBackgroundColor(Color.BLACK);
                mBButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.BLACK);
                mDButton.setBackgroundColor(Color.rgb(180,5,180));


                Log.i(TAG,"D Button Clicked");

                        if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("D")) {
                            answerCount[mCurrentQuestionIndex]=1;
                        }
                        else{
                            answerCount[mCurrentQuestionIndex]=0;
                        }
                        }
                    ;
            ;
        });

        mEButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousAnswers[mCurrentQuestionIndex]= "E";
                mAButton.setBackgroundColor(Color.BLACK);
                mBButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.BLACK);
                mDButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.rgb(180,5,180));

                Log.i(TAG, "E Button Clicked");

                if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("E")) {

                    answerCount[mCurrentQuestionIndex]=1;
                }
                else{
                    answerCount[mCurrentQuestionIndex]=0;
                }
            }

                });
            ;
//when submit button is clicked
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            int totalScore = 0;
            @Override
            public void onClick(View v) {
                //sum total points by adding each index of answerCount array
                for (int k=0;k<answerCount.length;k++){
                    totalScore+=answerCount[k];
                }
                //toast final score
                Toast.makeText(MainActivity.this, ("Your score is "+ totalScore + "/"+ mQuestions.size()) + "\nClick Quit to avoid errors", Toast.LENGTH_LONG).show();
                //empty all arrays that saved answers and points
                for (int i =0; i<answerCount.length-1;i++) {
                    previousAnswers[i] = "";
                    answerCount[i]=0;
                }
                //reset totalScore to 0
                totalScore=0;
                //make all buttons black
                mAButton.setBackgroundColor(Color.BLACK);
                mBButton.setBackgroundColor(Color.BLACK);
                mCButton.setBackgroundColor(Color.BLACK);
                mDButton.setBackgroundColor(Color.BLACK);
                mEButton.setBackgroundColor(Color.BLACK);
                //reset current index to zero(to start of questions)
                mCurrentQuestionIndex =0;
                //show first question
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
            }

        });
//if quit button is clicked exit app
        mQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }}
