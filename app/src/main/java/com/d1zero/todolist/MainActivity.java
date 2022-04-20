package com.d1zero.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> addItem());

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(itemsAdapter);
        list.setOnItemLongClickListener((adapterView, view, i, l) -> remove(i));

    }

    private boolean remove(int position) {
        Context context = getApplicationContext();
        Toast.makeText(context, "Item removed", Toast.LENGTH_LONG).show();
        items.remove(position);
        itemsAdapter.notifyDataSetChanged();
        return true;
    }

    private void addItem() {
        EditText input = findViewById(R.id.edit_text);
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))) {
            itemsAdapter.add(itemText);
            input.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Please enter text", Toast.LENGTH_LONG).show();
        }
    }
}