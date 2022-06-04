package ru.mirea.survillo.mireaproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ru.mirea.survillo.mireaproject.R;
import ru.mirea.survillo.mireaproject.databinding.FragmentHomeBinding;
import ru.mirea.survillo.mireaproject.ui.autentification.Autification;

public class HomeFragment extends Fragment {

    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        auth = FirebaseAuth.getInstance();
        view.findViewById(R.id.sign_out_btn).setOnClickListener(this::onSignOutClick);
        return view;
    }

    private void onSignOutClick(View view){
        if (auth != null){
            auth.signOut();
            Intent intent = new Intent(getContext(), Autification.class);
            startActivity(intent);
        }
    }

}