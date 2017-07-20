package bolalob.develops.stud11314025.availaballs.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.FileUtil;
import bolalob.develops.stud11314025.availaballs.Widget.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahLapanganActivity extends AppCompatActivity {

    @BindView(R.id.eTNamaLapangan)
    EditText etNamaLapangan;

    @BindView(R.id.upload_img)
    ImageView upload_img;

    private static final int ASK_MULTIPLE_PERMISSION = 1111;
    private static final int REQUEST_FROM_CAMERA = 1001;
    private static final int REQUEST_FROM_ALBUM = 1002;

    private Uri imageUri;
    private String imagePath;

    private Context getContext() {
        return TambahLapanganActivity.this;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan);
        ButterKnife.bind(this);

        addActionBar();
        addTextWatcher();
    }

    @OnClick(R.id.upload_img)
    void onButtonClick() {
        if (Utils.checkSupportCamera(this)) {
            onAskPermission();
        } else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }

    private void onAskPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, ASK_MULTIPLE_PERMISSION);
        } else {
            onPermissionGranted();
        }
    }

    private void onPermissionGranted() {
        AlertDialog.Builder takebgCoverDialog = new AlertDialog.Builder(this);
        takebgCoverDialog.setTitle("Ambil Foto");
        takebgCoverDialog.setItems(new CharSequence[]{"Kamera", "Album"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                switch (position) {
                    case 0:
                        imageUri = FileUtil.getFromCamera(getContext());
                        break;
                    case 1:
                        FileUtil.getFromAlbum(getContext());
                        break;
                }
            }
        });
        takebgCoverDialog.show();
    }

    private void attachToImageView(String imagePath){
        Glide.with(getContext())
                .load(imagePath)
                .dontAnimate()
                .into(upload_img);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ASK_MULTIPLE_PERMISSION && grantResults.length > 0) {
            boolean cameraPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            boolean writeExternalFile = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            if (cameraPermission && writeExternalFile) {
                onPermissionGranted();
            } else {
                System.out.println("permission not granted.");
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FROM_CAMERA) {
            if (resultCode == RESULT_OK) {
                imagePath = FileUtil.compressImage(this, imageUri.getPath(), 640);
                attachToImageView(imagePath);
            }
        } else if (requestCode == REQUEST_FROM_ALBUM) {
            if (resultCode == RESULT_OK) {
                imageUri = data.getData();
                boolean isFromGoogleDrive = imageUri.toString().contains("com.google.android.apps.docs.storage");
                imagePath = FileUtil.compressImage(this, isFromGoogleDrive ?
                        FileUtil.downloadFromGoogleDrive(this, imageUri) :
                        FileUtil.getPath(this, imageUri), 640);
                attachToImageView(imagePath);
            }
        }
    }

    public void addTextWatcher() {
        final View llnamalapangan = findViewById(R.id.layoutNamaLapangan);

        TextWatcher namaWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                llnamalapangan.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = etNamaLapangan.getText().length();
                if (length == 0) {
                    llnamalapangan.setAlpha(0.5f);
                } else llnamalapangan.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                int length = etNamaLapangan.getText().length();
                if (length == 0) {
                    llnamalapangan.setAlpha(0.5f);
                } else llnamalapangan.setAlpha(1.0f);
            }
        };
        etNamaLapangan.addTextChangedListener(namaWatcher);
    }

    public void nextStep(View view) {
        Intent intent = new Intent(TambahLapanganActivity.this, TambahLapanganStepDuaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void addActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Daftarkan Lapangan");

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

}
