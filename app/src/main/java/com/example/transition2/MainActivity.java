package com.example.transition2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity { //클래스를 상속받아 MainActivity 클래스를 작성한다.

    private LinearLayout layout; //선형 레이아웃을 layout으로 선언한다.
    private Button fadeButton, slideButton, explodeButton; //버튼을 선언한다.
    private ImageView imageView; //이미지뷰를 선언한다.
    boolean visible; //visible를 선언한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) { //onCreate 메소드의 매개변수는 앱의 이전 실행 상태를 전달한다.
        super.onCreate(savedInstanceState); //상위클래스의 onCreate를 호출한다.
        setContentView(R.layout.activity_main); //메인을 띄운다.

        layout = (LinearLayout) findViewById(R.id.layout); //layout의 정보를 받아 layout과 연결한다.
        fadeButton = (Button) findViewById(R.id.fade); //fade의 정보를 받아 fadeButton과 연결한다.
        slideButton = (Button) findViewById(R.id.slide); //slide의 정보를 받아 slideButton과 연결한다.
        explodeButton = (Button) findViewById(R.id.explode); //explode의 정보를 받아 explodeButton과 연결한다.
        imageView = (ImageView) findViewById(R.id.imageview); //imageview의 정보를 받아 imageView와 연결한다.

        fadeButton.setOnClickListener(new View.OnClickListener() { //fadeButton을 클릭하면
            @Override
            public void onClick(View v) { //클릭할 때
                TransitionManager.beginDelayedTransition(layout, new Fade());
                //TransitionManger가 beginDelayedTransition 메소드를 호출하여 layout의 정보를 가져와 fade 효과를 설정한다.
                visible = !visible;
                //visible의 정보값을 반대로 입력한다.
                imageView.setVisibility(visible? View.VISIBLE : View.GONE);
                //visible이 true이면 보여지고 false이면 뷰가 사라진다.
            }
        });
        slideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(layout, new Slide());
                visible = !visible;
                imageView.setVisibility(visible? View.VISIBLE : View.GONE);
            }
        });
        explodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(layout, new Explode());
                visible = !visible;
                imageView.setVisibility(visible? View.VISIBLE : View.GONE);
            }
        });
    }
}
