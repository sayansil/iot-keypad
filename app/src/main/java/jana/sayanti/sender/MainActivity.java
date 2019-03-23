package jana.sayanti.sender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bclr,bgo;
    String IP;
    String pass;

    TextView displayTextView;
    EditText ipEditText;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass = "";
        IP = "";

        queue = Volley.newRequestQueue(this);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        bclr = findViewById(R.id.clrbtn);
        b0 = findViewById(R.id.btn0);
        bgo = findViewById(R.id.gobtn);
        displayTextView = findViewById(R.id.et1);
        ipEditText = findViewById(R.id.et);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "1";
                displayTextView.setText(pass);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "2";
                displayTextView.setText(pass);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "3";
                displayTextView.setText(pass);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "4";
                displayTextView.setText(pass);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "5";
                displayTextView.setText(pass);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "6";
                displayTextView.setText(pass);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "7";
                displayTextView.setText(pass);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "8";
                displayTextView.setText(pass);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "9";
                displayTextView.setText(pass);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = pass + "0";
                displayTextView.setText(pass);
            }
        });

        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = "";
                displayTextView.setText(pass);
            }
        });

        bgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IP = ipEditText.getText().toString();
                sendRequest();
            }
        });
    }

    public void sendRequest() {
        String url = "http://" + IP + "/bugsbunny?pass=" + pass;
        Log.d("Request URL", url);

        StringRequest myRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Password applied... Validating.", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong! :(", Toast.LENGTH_SHORT).show();
            }
        });

        myRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
            }
        });

        queue.add(myRequest);
    }
}
