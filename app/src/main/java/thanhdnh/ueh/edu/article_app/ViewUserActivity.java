package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class ViewUserActivity extends AppCompatActivity {
  ImageView iv_detail;
  TextView tv_detail_title, tv_detail_description;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_article); // Có thể dùng chung layout cũ hoặc đổi tên file xml tương ứng

    getSupportActionBar().hide();

    iv_detail = findViewById(R.id.iv_detail);
    tv_detail_title = findViewById(R.id.tv_detail_title);
    tv_detail_description = findViewById(R.id.tv_detail_description);

    int id = (int) getIntent().getLongExtra("id", 0);
    User user = UserData.getUserFromId(id);

    if (user != null) {
      Picasso.get().load(user.getUrl_profile()).resize(400, 500).centerCrop().into(iv_detail);
      tv_detail_title.setText(user.getUname()); // Hiển thị username ở phần tiêu đề
      tv_detail_description.setText("Bio: " + user.getShort_bio()); // Hiển thị short bio ở phần mô tả
    }
  }
}