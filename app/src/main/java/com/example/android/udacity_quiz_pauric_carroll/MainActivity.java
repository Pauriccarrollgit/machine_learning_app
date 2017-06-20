package com.example.android.udacity_quiz_pauric_carroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * This app is Machine Learning App
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The number of correct answers
     */
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the end test button is clicked.
     */
    public void end_Test(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Called question checking methods
        question_1();
        question_2();
        question_3();
        question_4();
        question_5();

        // Display the test result on the screen
        String test_result = createTestResult(name, score);
        displayResult(test_result);

        // Disabled "End Test" button after clicking on it.
        Button endTestButton = (Button) findViewById(R.id.end_test_button);
        endTestButton.setEnabled(false);
    }

    /**
     * Create summary of the test result.
     *
     * @param name of the passing the test
     * @param score of the counting of right answers
     * @return text of the test result
     * here is where I could add an intent
     */
    private String createTestResult(String name, int score) {
        String test_result = getString(R.string.test_result_name) + name;
        test_result += "\n" + getString(R.string.test_result_score) + score;
        return test_result;
    }

    /**
     * This method counter correct answers in question 1
     * Which of the following are types of machine learning? Check all that apply? (Choose 3 best answers)
     */
    public void question_1() {
        // Figure out if the user chose "Unsupervised" answer
        CheckBox AnswerOneCheckBox = (CheckBox) findViewById(R.id.answer_one);
        boolean hasAnswerOne = AnswerOneCheckBox.isChecked();

        if (hasAnswerOne) {
            increment_score();
        }

        // Figure out if the user chose "AnswerTwo" answer
        CheckBox AnswerTwoCheckBox = (CheckBox) findViewById(R.id.answer_2);
        boolean hasAnswerTwo = AnswerTwoCheckBox.isChecked();

        if (hasAnswerTwo) {
            increment_score();
        }

        // Figure out if the user chose "AnswerThree" answer
        CheckBox AnswerThree = (CheckBox) findViewById(R.id.answer_3);
        boolean hasAnswerThree = AnswerThree.isChecked();

        if (hasAnswerThree) {
            increment_score();
        }
    }

    /**
     * This method counter correct answers in question 2
     * "Which of the following statements best describes confidentiality of information?"
     */
    public void question_2() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_2);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_2_1_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.answer_2_1_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer_2_2_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_2_3_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_2_4_radiobutton);
        }
    }

    /**
     * This method counter correct answers in question 3
     * "According to Cisco, organizational data is classified into four categories. Which of the following is NOT classification category?"
     */
    public void question_3() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_3);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.trusty_worthy_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.trusty_worthy_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.publ_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.sensitive_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.confidential_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.private_radiobutton);
        }
    }

    /**
     * This method counter correct answers in question 4
     * "What are the THREE security solution that Cisco recommends for comprehensive security?"
     */
    public void question_4() {
        // Figure out if the user chose "Decision Tree Learning" answer
        CheckBox DecisionTreeLearning = (CheckBox) findViewById(R.id.decisionTreeLearning);
        boolean hasDecisionTreeLearning = DecisionTreeLearning.isChecked();

        if (hasDecisionTreeLearning) {
            increment_score();
        }

        // Figure out if the user chose "Associate Rule Learning" answer
        CheckBox Associate = (CheckBox) findViewById(R.id.associate);
        boolean hasAssociate = Associate.isChecked();

        if (hasAssociate) {
            increment_score();
        }

        // Figure out if the user chose "Artifical Neural Networks" answer
        CheckBox Artifical = (CheckBox) findViewById(R.id.artifical);
        boolean hasArtifical = Artifical.isChecked();

        if (hasArtifical) {
            increment_score();
        }
    }

    /**
     * This method counter correct answers in question 5
     * Which of the following are examples of machine learning applications
     */
    public void question_5() {
        // Figure out if the user choose Bioinformatic
        CheckBox Answer_5_1_CheckBox = (CheckBox) findViewById(R.id.answer_5_1_checkbox);
        boolean hasAnswer_5_1_CheckBox = Answer_5_1_CheckBox.isChecked();

        if (hasAnswer_5_1_CheckBox) {
            increment_score();
        }

        // Figure out if the user chose DNA Sequencing
        CheckBox Answer_5_3_CheckBox = (CheckBox) findViewById(R.id.answer_5_3_checkbox);
        boolean hasAnswer_5_3_CheckBox = Answer_5_3_CheckBox.isChecked();

        if (hasAnswer_5_3_CheckBox) {
            increment_score();
        }

        // Figure out if the user chose Standing in FieldsPauric
        CheckBox Answer_5_4_CheckBox = (CheckBox) findViewById(R.id.answer_5_4_checkbox);
        boolean hasAnswer_5_4_CheckBox = Answer_5_4_CheckBox.isChecked();

        if (hasAnswer_5_4_CheckBox) {
            increment_score();
        }
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayResult(String result) {
        TextView testResultTextView = (TextView) findViewById(R.id.test_result_text_view);
        testResultTextView.setText(result);
    }

    /**
     * This method is called when user selected the correct answer.
     * Added +1 to score for each correct answer
     */
    private int increment_score() {
        score = ++score;
        return score;
    }
}

