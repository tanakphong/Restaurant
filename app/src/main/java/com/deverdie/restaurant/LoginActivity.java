package com.deverdie.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.deverdie.restaurant.Interface.LoginInterface;
import com.deverdie.restaurant.model.LoginRes;
import com.deverdie.restaurant.util.RetrofitClient;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "dlg " + LoginActivity.class.getSimpleName() + ": ";

    // UI references.
    private AutoCompleteTextView mUsernameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mUsernameView = findViewById(R.id.username);

        mPasswordView = findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        // Reset errors.
        mUsernameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mUsernameView.setError(getString(R.string.error_field_required));
            focusView = mUsernameView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            LoginInterface loginInterface = RetrofitClient.getClient().create(LoginInterface.class);

            RequestBody formBody = new FormBody.Builder()
                    .add("username", email)
                    .add("password", password)
                    .build();

            Call<LoginRes> verifyPWS = loginInterface.verifyPWS(formBody);

            verifyPWS.enqueue(new Callback<LoginRes>() {
                @Override
                public void onResponse(@NonNull Call<LoginRes> call, @NonNull Response<LoginRes> response) {
                    LoginRes responseBody = response.body();
                    if (response.isSuccessful()) {
                        Log.i(TAG, "onResponse: Successfully.");
                        assert responseBody != null;
                        if (responseBody.isReturnX()) {
                            Log.d(TAG, "onResponse: " + responseBody.getData().getUsr_code());
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                    } else {
                        Log.e(TAG, "" + response.code() + " " + response.message());
                        String msg;
                        switch (response.code()) {
                            case 403:
                                msg = getResources().getString(R.string.error_incorrect_password);
                                break;

                            case 404:
                                msg = getResources().getString(R.string.error_invalid_username);
                                break;
                            default:
                                msg = "";
                        }
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(@NonNull Call<LoginRes> call, @NonNull Throwable t) {
                    Log.e(TAG, "call loginInterface.verifyPWS: failure.");
                }
            });
        }
    }
}

