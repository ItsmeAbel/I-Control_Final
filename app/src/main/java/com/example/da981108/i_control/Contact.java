package com.example.da981108.i_control;

import android.net.Uri;

/**
 * Created by da981108 on 2017-01-10.
 */
//contact class were all the Strings we use in Guardians are created here
public class Contact {
    // make the Strings
    private String _name, _phone, _email, _address;
    private Uri _imageURI;
    private int _id;

    public Contact(int id, String name, String phone, String email, String address, Uri imageURI) {
        _id = id;
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
        _imageURI = imageURI;
    }
    //implementing the Strings
    public int getId() { return _id; }

    public String getName() {
        return _name;
    }

    public String getPhone() {
        return _phone;
    }

    public String getEmail() {
        return _email;
    }

    public String getAddress() {
        return _address;
    }

    public Uri getImageURI() { return _imageURI; }
}
