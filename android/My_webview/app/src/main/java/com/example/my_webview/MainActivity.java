package com.example.my_webview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView mWebView;
    WebSettings mWebSettings;

    WebView mWebView2;
    WebSettings mWebSettings2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹뷰 시작
        mWebView = (WebView) findViewById(R.id.web1);
        mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebSettings = mWebView.getSettings(); //세부 세팅 등록
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부
        mWebView.loadUrl("http://25.7.177.23:8081/stream.mjpg"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작

        // 웹뷰 시작
        mWebView2 = (WebView) findViewById(R.id.web1);
        mWebView2.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebSettings2 = mWebView2.getSettings(); //세부 세팅 등록
        mWebSettings2.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings2.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings2.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        mWebSettings2.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings2.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings2.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings2.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings2.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings2.setDomStorageEnabled(true); // 로컬저장소 허용 여부
        mWebView2.loadUrl("http://25.7.177.23:8000/mobile"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//뒤로가기 버튼 이벤트
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {//웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }


}
