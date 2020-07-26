package com.example.finaltutorialapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

public class HtmlQuizActivity extends AppCompatActivity {

    private Toolbar toolbar;

    int score = 0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_quiz);



    }


    public void end_Test(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Called question checking methods
        question_1();
        question_2();
        question_3();
        question_4();
        question_5();
        question_6();
        question_7();
        question_8();
        question_9();
        question_10();

        // Display the test result on the screen
        String test_result = createTestResult(name, score);
        displayResult(test_result);



        // Disabled "End Test" button after clicking on it.
        Button endTestButton = (Button) findViewById(R.id.end_test_buttonh);
        endTestButton.setEnabled(false);
    }


    private String createTestResult(String name, int score) {
        String test_result = getString(R.string.test_result_name) + name;
        test_result += "\n" + getString(R.string.test_result_score) + score;
        return test_result;
    }


    public void question_1() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_1);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer2_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.answer2_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer1_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer3_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer4_radiobutton);
        }
    }

    public void question_2() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_2);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer2_2radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.answer4_2radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer3_2radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer2_2radiobutton);
        }
    }
    public void question_3() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_3 );
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.private_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.sensitive_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.publ_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.confidential_radiobutton);
        }
    }
    public void question_4() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_4h);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.managerial_checkbox:
                answerRadio = (RadioButton) findViewById(R.id.physical_checkbox);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.logical_checkbox);
                answerRadio = (RadioButton) findViewById(R.id.managerial_checkbox);
        }
    }
    public void question_5() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_5);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_5_2_checkbox:
                answerRadio = (RadioButton) findViewById(R.id.answer_5_1_checkbox);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer_5_2_checkbox);
                answerRadio = (RadioButton) findViewById(R.id.answer_5_3_checkbox);
        }
    }


    public void question_6() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_6);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.passive_attack_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.close_in_attack_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.active_attack_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.passive_attack_radiobutton);
        }
    }
    public void question_7() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_7);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.physical_security_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.administrative_security_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.physical_security_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.logical_security_radiobutton);
        }
    }
    public void question_8() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_7);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.packet_capture_checkbox:
                answerRadio = (RadioButton) findViewById(R.id.packet_capture_checkbox);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.password_attack_8_checkbox);
                answerRadio = (RadioButton) findViewById(R.id.dumpster_driving_8_checkbox);
        }
    }
    public void question_9() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_7);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.packetcapture_checkbox:
                answerRadio = (RadioButton) findViewById(R.id.dumpsterdriving_8_checkbox);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.passwordattack_8_checkbox);
                answerRadio = (RadioButton) findViewById(R.id.packetcapture_checkbox);
        }
    }

    public void question_10() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_7);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.packetcapture_checkbox:
                answerRadio = (RadioButton) findViewById(R.id.passwordattack8_checkbox);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.packetcaptureheckbox);
                answerRadio = (RadioButton) findViewById(R.id.dumpsterdriving_checkbox);
        }
    }


    private void displayResult(String result) {
        TextView testResultTextView = (TextView) findViewById(R.id.test_result_text_viewh);
        testResultTextView.setText(result);
    }

    private int increment_score() {
        score = ++score;
        return score;
    }
}
