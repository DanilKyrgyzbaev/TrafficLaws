package com.pdd.trafficlaws.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Browser;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.pdd.trafficlaws.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    static MainActivity mActivity;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://e.gov.kg/pdd/index");
        webView.setWebViewClient(new com.pdd.trafficlaws.activity.WebViewClient());
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.setWebChromeClient(new WebChromeClient());

    }
    public static MainActivity getInstance() {
        return mActivity;
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();

        } else {
            new AlertDialog.Builder(this).setTitle("Подтвердите действие ")
                    .setMessage("Вы действительно хотите выйти?")
                    .setNegativeButton(android.R.string.no, (dialog, which) -> dialog.dismiss())
                    .setPositiveButton(android.R.string.yes, (arg0, arg1) -> {
                        finish();
                        //moveTaskToBack(true);
                        //MainActivity.super.onBackPressed();
                    }).create().show();
            //super.onBackPressed();
        }

    }
}