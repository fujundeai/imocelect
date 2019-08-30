package com.example.imocelect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.latte_core.activities.ProxyActivity;
import com.example.latte_core.delegates.LatteDelegate;

public class WebActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootFragment() {
        return WebExampleFragment.create(Config.INDEX_URL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }
}
