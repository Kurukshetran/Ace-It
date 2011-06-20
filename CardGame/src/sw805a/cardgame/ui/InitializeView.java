package sw805a.cardgame.ui;

import sw805a.cardgame.R;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class InitializeView extends ABaseActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView(R.layout.initialize_view);
        
        
        
        MediaPlayer mp = MediaPlayer.create(this, R.raw.jingle);
        mp.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
		        getGameEngine().hardReset();
		        startActivity(new Intent(InitializeView.this, CommunicationSelectView.class));
		        finish();
			}
		});
        mp.start();
	}

}
