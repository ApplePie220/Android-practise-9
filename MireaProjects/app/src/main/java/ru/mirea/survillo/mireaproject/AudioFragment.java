package ru.mirea.survillo.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.survillo.mireaproject.databinding.FragmentAudioBinding;
import ru.mirea.survillo.mireaproject.ui.PLayingMusic;

public class AudioFragment extends Fragment {
    private FragmentAudioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAudioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.startSongButton.setOnClickListener(this::onClickPlayMusic);
        binding.stopSongButton.setOnClickListener(this::onClickStopMusic);

        return root;
    }

    public void onClickPlayMusic(View view) {
        MainActivity activity = (MainActivity) requireActivity();
        Log.d("MediaPlayerFragment", "onClickPlayMusic: " + activity.getLocalClassName());
        activity.startService(
                new Intent(activity, PLayingMusic.class));
    }
    public void onClickStopMusic(View view) {
        MainActivity activity = (MainActivity) requireActivity();
        Log.d("MediaPlayerFragment", "onClickStopMusic: ");
        activity.stopService(
                new Intent(activity, PLayingMusic.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}