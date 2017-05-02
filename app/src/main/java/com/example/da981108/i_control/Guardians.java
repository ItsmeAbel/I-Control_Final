package com.example.da981108.i_control;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Guardians extends AppCompatActivity {
    //putting a number so the delete works
    private static final int  DELETE = 1;
    // getting all the Strings we made in the Contact class
   EditText nameTxt, phoneTxt, emailTxt, addressTxt;
   ImageView contactImageImgView;
    // make the list an Array list so we have more then one
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;
    Uri ImageUri = Uri.parse("android.resource://org.com.example.ak970617.i_control4real/drawable/no_user_logo.png");
    DatabaseHandler dbHandler;
    int longClickedItemIndex;
    ArrayAdapter<Contact> contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardians);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar() .setHomeButtonEnabled(true);
        getSupportActionBar() .setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Does not work yet", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nameTxt = (EditText) findViewById(R.id.Contactname);
        phoneTxt = (EditText) findViewById(R.id. Phonenumber);
        emailTxt = (EditText) findViewById(R.id.Email);
        addressTxt = (EditText) findViewById(R.id.Address);
        contactListView = (ListView)findViewById(R.id.ListView);
        contactImageImgView = (ImageView) findViewById(R.id.ContactImage);
        dbHandler = new DatabaseHandler(getApplicationContext());

        registerForContextMenu(contactListView);

        contactListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickedItemIndex = position;
                return false;
            }
        });

        TabHost tabHost =(TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.creatorTab);
        tabSpec.setIndicator("creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.ContactList);
        tabSpec.setIndicator("list");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.button2);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact(dbHandler.getContactsCount(), String.valueOf(nameTxt.getText()),
                        String.valueOf(phoneTxt.getText()),
                        String.valueOf(emailTxt.getText()), String.valueOf(addressTxt.getText()), ImageUri);
                if (!contactExists(contact)) {
                    dbHandler.createContact(contact);
                    Contacts.add(contact);
                    contactAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText())
                            + " has been added to your Contacts!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText())
                        + " already exists. Please use a different name.", Toast.LENGTH_SHORT).show();
            }
        });
        //get the charSequence code
        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence , int i, int i2, int i3) {
                addBtn.setEnabled(String.valueOf(nameTxt.getText()).trim().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        contactImageImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Contact Image"), 1);
            }

        });

        if (dbHandler.getContactsCount() != 0)
            Contacts.addAll(dbHandler.getAllContacts());

        populateList();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        menu.setHeaderIcon(R.drawable.pencil);
        menu.setHeaderTitle("Contact Options");
        menu.add(Menu.NONE, DELETE, menu.NONE, "Delete Contact");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE:
                dbHandler.deleteContact(Contacts.get(longClickedItemIndex));
                Contacts.remove(longClickedItemIndex);
                contactAdapter.notifyDataSetChanged();
                break;

        }
        Toast.makeText(getApplicationContext()," Contact has been deleted from the list", Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }

    private boolean contactExists(Contact contact) {
        String name = contact.getName();
        int contactCount = Contacts.size();

        for (int i = 0; i < contactCount; i++) {
            if (name.compareToIgnoreCase(Contacts.get(i).getName()) == 0)
                return true;
        }
        return false;
    }



    public void onActivityResult (int reqCode, int resCode, Intent data){
        if(reqCode == RESULT_OK){
            if(reqCode == 1)
                ImageUri = data.getData();

                contactImageImgView.setImageURI(data.getData());
        }
    }

    private void populateList(){
        contactAdapter = new ContactListAdapter();
        contactListView.setAdapter(contactAdapter);
    }


    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter(){
            super(Guardians.this,R.layout.listview_item,Contacts);
        }


        @Override

        public View getView(int position, View view, ViewGroup parent){
            if (view == null)
            view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Contact currentContact = Contacts.get(position);

            TextView name = (TextView) view.findViewById(R.id.ContactName);
            name.setText(currentContact.getName());
            TextView phone = (TextView) view.findViewById(R.id.PhoneNumber);
            phone.setText(currentContact.getPhone());
            TextView email = (TextView) view.findViewById(R.id.Email);
            email.setText(currentContact.getEmail());
            TextView address = (TextView) view.findViewById(R.id.Address);
            address.setText(currentContact.getAddress());
            ImageView ivContactImage = (ImageView) view.findViewById(R.id.ivContactimage);
            ivContactImage.setImageURI(currentContact.getImageURI());

            return view;
        }
    }

    }



