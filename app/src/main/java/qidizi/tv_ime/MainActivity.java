package qidizi.tv_ime;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建用来显示帮助说明html的text view
        EditText tv = new EditText(this);
        // 允许点击链接
        tv.setClickable(true);
        tv.setPadding(50, 50, 50, 50);
        String app_name = getString(R.string.app_name);
        tv.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
        String html = getString(R.string.help).replace("{{app_name}}", app_name);

        // 兼容低版本
        if (Build.VERSION.SDK_INT < 24) //noinspection deprecation
            tv.setText(Html.fromHtml(html));
        else tv.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));

        // 长内容允许滚动
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        setContentView(tv);
    }
}