package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheackBox = (CheckBox) findViewById(R.id.checkBox_Whipped_Cream);
        boolean hasWhippedCream = whippedCreamCheackBox.isChecked();
        CheckBox Chocolate = (CheckBox) findViewById(R.id.checkBox_Chocolate);
        boolean Chocolataa = Chocolate.isChecked();
        gmail(hasWhippedCream, Chocolataa);
        displayMessage(createOrderSummary(hasWhippedCream, Chocolataa, getName()));
    }

    private void gmail(Boolean x, Boolean y) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT, "Cilantro Cafe  " + getName() + " ORDER");
        //intent.putExtra(intent.EXTRA_EMAIL,"mohamedhesho96@gmail.com" ); not Working
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "customerservice@cilantrocafe.net "  });

        intent.putExtra(intent.EXTRA_TEXT, createOrderSummary(x, y, getName()));


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private String getName() {
        int get;
        EditText userName = (EditText) findViewById(R.id.name);
        String value = userName.getText().toString();
        return value;
    }
    private String createOrderSummary(boolean hasWhippedCream, boolean Chocolataa, String values) {
        String String_WhippedCream = "Don't Add " ;
        String String_Chocolataa = "Don't Add " ;
        if (hasWhippedCream == true)
        {
            String_WhippedCream = "Add ";
        }
        if (Chocolataa == true)
        {
            String_Chocolataa = "Add ";
        }

        String priceMessage = "Name : " + values;
        priceMessage += "\nAdd whipping cream : " + String_WhippedCream;
        priceMessage += "\nAdd Chocolate : " + String_Chocolataa;
        priceMessage += "\nQuantity : " + number;
        priceMessage += "\nthe  Total Cost of Coffe : " + price(number, hasWhippedCream, Chocolataa) + "$";
        priceMessage += " \n" + getString(R.string.Happy_Drink);
        Toast.makeText(this, "Happy Drink and Keep Smile   ;)", Toast.LENGTH_LONG).show();


        return priceMessage;
    }
    public int price(int number, boolean hasWhippedCream, boolean Chocolataa) {
        int extra = 0;
        if (Chocolataa) {
            extra += 2;
        }
        if (hasWhippedCream) {
            extra += 1;
        }
        number = number * (5 + extra);
        return number;
    }
    public void increment(View view) {
        number = number + 1;
        display(number);
    }
    public void decrement(View view) {
        number = number - 1;
        if (number < 1) {
            number = 1;
            Toast.makeText(this, "You can't drink 0 coffe friend ;)", Toast.LENGTH_LONG).show();
        }
        display(number);
    }
}
