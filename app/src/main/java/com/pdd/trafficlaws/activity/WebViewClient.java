package com.pdd.trafficlaws.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public class WebViewClient extends android.webkit.WebViewClient {

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if (request.getUrl().toString().startsWith("tel:")) {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse(request.getUrl().toString()));
            WebViewActivity.getInstance().startActivity(intent);
        }else if(request.getUrl().toString().startsWith("http:") || request.getUrl().toString().startsWith("https:")) {
            view.loadUrl(request.getUrl().toString());
        }

        return true;
    }
}
