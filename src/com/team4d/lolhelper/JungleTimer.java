package com.team4d.lolhelper;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team4d.lolhelper.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class JungleTimer extends Activity
{
	TextView GR, GB, LR, LB, DR, BA;
	ImageButton GRback, GBback, LRback, LBback, DRback, BAback; // Backgrounds
	Timer[] timer = new Timer[6];
	boolean reset[] = { true, true, true, true, true, true };
	boolean running[] = { false, false, false, false, false, false };
	private final int[] TimeLeft = new int[6];

	Uri notification;
	Ringtone ringtone;

	/** The view to show the ad. */
	private AdView adView;

	/* Your ad unit id. Replace with your actual ad unit id. */
	private static final String AD_UNIT_ID = "ca-app-pub-9973141875464346/2397347111";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// Keeps screen from sleeping
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_jungle_timer);

		RelativeLayout layout = (RelativeLayout) findViewById(R.id.container);
		if (((GlobalVariables) this.getApplication()).getskin() == 1)
		{
			layout.setBackgroundResource(R.drawable.bg);
		}
		if (((GlobalVariables) this.getApplication()).getskin() == 2)
		{
			layout.setBackgroundResource(R.drawable.bg2);
		}

		GR = (TextView) findViewById(R.id.textView1);
		LR = (TextView) findViewById(R.id.textView2);
		GB = (TextView) findViewById(R.id.textView3);
		LB = (TextView) findViewById(R.id.textView4);
		DR = (TextView) findViewById(R.id.textView5);
		BA = (TextView) findViewById(R.id.textView6);

		GRback = (ImageButton) findViewById(R.id.imageButton1);
		LRback = (ImageButton) findViewById(R.id.imageButton2);
		GBback = (ImageButton) findViewById(R.id.ImageButton3);
		LBback = (ImageButton) findViewById(R.id.ImageButton4);
		DRback = (ImageButton) findViewById(R.id.ImageButton5);
		BAback = (ImageButton) findViewById(R.id.ImageButton6);

		notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);

		LinearLayout adlayout = (LinearLayout) findViewById(R.id.container2);

		// Create an ad.
		adView = new AdView(this);
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(AD_UNIT_ID);

		// Add the AdView to the view hierarchy. The view will have no size
		// until the ad is loaded.
		adlayout.addView(adView);

		// Create an ad request. Check logcat output for the hashed device ID to
		// get test ads on a physical device.
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				// .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
				.build();

		// Start loading the ad in the background.
		adView.loadAd(adRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);

		return true;
	}

	@Override
	public void onResume()
	{
		super.onResume();
		if (adView != null)
		{
			adView.resume();
		}
	}

	@Override
	public void onPause()
	{
		if (adView != null)
		{
			adView.pause();
		}
		super.onPause();
	}

	/** Called before the activity is destroyed. */
	@Override
	public void onDestroy()
	{
		// Destroy the AdView.
		if (adView != null)
		{
			adView.destroy();
		}
		super.onDestroy();
	}

	//
	// All the timer methods
	//
	private void TimerMethod0()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[0] <= 0)
				{
					ringtone.play();
					GR.setText("Alive");
					running[0] = false;
					timer[0].cancel();
					timer[0].purge();
					GRback.setBackgroundColor(0xff7A1F00);
				} else if (TimeLeft[0] > 0)
				{
					if (TimeLeft[0] == 30000)
					{
						ringtone.play();
						GRback.setBackgroundColor(Color.YELLOW);
					} else if (TimeLeft[0] == 10000)
					{
						GRback.setBackgroundColor(Color.RED);
					}
					GR.setText("" + TimeLeft[0] / 60000 + ":" + String.format("%02d", (TimeLeft[0] / 1000) % 60));
					TimeLeft[0] -= 1000;
				}

			}
		});
	}

	private void TimerMethod1()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[1] <= 0)
				{
					ringtone.play();
					LR.setText("Alive");
					running[1] = false;
					timer[1].cancel();
					timer[1].purge();
					LRback.setBackgroundColor(0xff7A1F00);
				}
				else if (TimeLeft[1] > 0)
				{
					if (TimeLeft[1] == 30000)
					{
						ringtone.play();
						LRback.setBackgroundColor(Color.YELLOW);
					} else if (TimeLeft[1] == 10000)
					{
						LRback.setBackgroundColor(Color.RED);
					}
					LR.setText("" + TimeLeft[1] / 60000 + ":" + String.format("%02d", (TimeLeft[1] / 1000) % 60));
					TimeLeft[1] -= 1000;
				}

			}
		});
	}

	private void TimerMethod2()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[2] <= 0)
				{
					ringtone.play();
					GB.setText("Alive");
					running[2] = false;
					timer[2].cancel();
					timer[2].purge();
					GBback.setBackgroundColor(0xff001F3D);
				}
				else if (TimeLeft[2] > 0)
				{
					if (TimeLeft[2] == 30000)
					{
						ringtone.play();
						GBback.setBackgroundColor(Color.YELLOW);
					} else if (TimeLeft[2] == 10000)
					{
						GBback.setBackgroundColor(Color.RED);
					}
					GB.setText("" + TimeLeft[2] / 60000 + ":" + String.format("%02d", (TimeLeft[2] / 1000) % 60));
					TimeLeft[2] -= 1000;
				}

			}
		});
	}

	private void TimerMethod3()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[3] <= 0)
				{
					ringtone.play();
					LB.setText("Alive");
					running[3] = false;
					timer[3].cancel();
					timer[3].purge();
					LBback.setBackgroundColor(0xff001F3D);
				}
				else if (TimeLeft[3] > 0)
				{
					if (TimeLeft[3] == 30000)
					{
						ringtone.play();
						LBback.setBackgroundColor(Color.YELLOW);
					} else if (TimeLeft[3] == 10000)
					{
						LBback.setBackgroundColor(Color.RED);
					}
					LB.setText("" + TimeLeft[3] / 60000 + ":" + String.format("%02d", (TimeLeft[3] / 1000) % 60));
					TimeLeft[3] -= 1000;
				}

			}
		});
	}

	private void TimerMethod4()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[4] <= 0)
				{
					ringtone.play();
					DR.setText("Alive");
					running[4] = false;
					timer[4].cancel();
					timer[4].purge();
					DRback.setBackgroundColor(0xff3C3C3C);
				}
				else if (TimeLeft[4] > 0)
				{
					if (TimeLeft[4] == 30000)
					{
						ringtone.play();
						DRback.setBackgroundColor(Color.YELLOW);
					} else if (TimeLeft[4] == 10000)
					{
						DRback.setBackgroundColor(Color.RED);
					}
					DR.setText("" + TimeLeft[4] / 60000 + ":" + String.format("%02d", (TimeLeft[4] / 1000) % 60));
					TimeLeft[4] -= 1000;
				}

			}
		});
	}

	private void TimerMethod5()
	{
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (TimeLeft[5] <= 0)
				{
					ringtone.play();
					BA.setText("Alive");
					running[5] = false;
					timer[5].cancel();
					timer[5].purge();
					BAback.setBackgroundColor(0xff3C3C3C);
				}
				else if (TimeLeft[5] > 0)
				{
					if (TimeLeft[5] == 60000)
					{
						BAback.setBackgroundColor(Color.LTGRAY);
					} else if (TimeLeft[5] == 30000)
					{
						ringtone.play();
						BAback.setBackgroundColor(Color.YELLOW);
					} else if (TimeLeft[5] == 10000)
					{
						BAback.setBackgroundColor(Color.RED);
					}
					BA.setText("" + TimeLeft[5] / 60000 + ":" + String.format("%02d", (TimeLeft[5] / 1000) % 60));
					TimeLeft[5] -= 1000;
				}

			}
		});
	}

	//
	// Called when each of these buttons is clicked
	//
	public void RedGolem(View view)
	{
		TimeLeft[0] = 300000;
		if (!running[0])
		{
			running[0] = true;
			timer[0] = new Timer();
			timer[0].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod0();
				}
			}, 0, 1000);
		} else
		{
			timer[0].cancel();
			timer[0].purge();
			GRback.setBackgroundColor(0xff7A1F00);
			GR.setText("Canceled");
			running[0] = false;
		}
	}

	public void RedLizard(View view)
	{
		TimeLeft[1] = 300000;
		if (!running[1])
		{
			running[1] = true;
			timer[1] = new Timer();
			timer[1].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod1();
				}
			}, 0, 1000);
		} else
		{
			timer[1].cancel();
			timer[1].purge();
			LRback.setBackgroundColor(0xff7A1F00);
			LR.setText("Canceled");
			running[1] = false;
		}
	}

	public void BlueGolem(View view)
	{
		TimeLeft[2] = 300000;
		if (!running[2])
		{
			running[2] = true;
			timer[2] = new Timer();
			timer[2].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod2();
				}
			}, 0, 1000);
		} else
		{
			timer[2].cancel();
			timer[2].purge();
			GBback.setBackgroundColor(0xff001F3D);
			GB.setText("Canceled");
			running[2] = false;
		}
	}

	public void BlueLizard(View view)
	{
		TimeLeft[3] = 300000;
		if (!running[3])
		{
			running[3] = true;
			timer[3] = new Timer();
			timer[3].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod3();
				}
			}, 0, 1000);
		} else
		{
			timer[3].cancel();
			timer[3].purge();
			LBback.setBackgroundColor(0xff001F3D);
			LB.setText("Canceled");
			running[3] = false;
		}

	}

	public void Dragon(View view)
	{
		TimeLeft[4] = 360000;
		if (!running[4])
		{
			running[4] = true;
			timer[4] = new Timer();
			timer[4].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod4();
				}
			}, 0, 1000);
		} else
		{
			timer[4].cancel();
			timer[4].purge();
			DRback.setBackgroundColor(0xff3C3C3C);
			DR.setText("Canceled");
			running[4] = false;
		}

	}

	public void Baron(View view)
	{
		TimeLeft[5] = 420000;
		if (!running[5])
		{
			running[5] = true;
			timer[5] = new Timer();
			timer[5].schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					TimerMethod5();
				}
			}, 0, 1000);
		} else
		{
			timer[5].cancel();
			timer[5].purge();
			BAback.setBackgroundColor(0xff3C3C3C);
			BA.setText("Canceled");
			running[5] = false;
		}
	}
}
