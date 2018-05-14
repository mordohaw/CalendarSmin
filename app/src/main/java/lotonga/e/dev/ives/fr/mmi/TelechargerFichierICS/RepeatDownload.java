package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import java.util.logging.Handler;

public class RepeatDownload {

    private final static int INTERVAL = 1000 * 60 * 2; //2 minutes
    Handler mHandler = new Handler();

    Runnable mHandlerTask = new Runnable()
    {
        @Override
        public void run() {
            TelechargerDepuisURL.getContentTO("");
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    void startRepeatingTask()
    {
        mHandlerTask.run();
    }

    void stopRepeatingTask()
    {
        mHandler.close();
    }
}
