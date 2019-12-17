package br.com.zup.components.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import br.com.zup.components.R;
import br.com.zup.components.databinding.ActivityIncludeBinding;

public class IncludeActivity extends AppCompatActivity {

    ActivityIncludeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
    }
}
