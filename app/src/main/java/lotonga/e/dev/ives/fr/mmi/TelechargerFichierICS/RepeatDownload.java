package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class RepeatDownload {

    private static final long RAFRAICHISSEMENT = 1000 * 60 * 2; //2 minutes
    private final static int INTERVAL = 1000 * 60 * 2; //2 minutes
    Handler mHandler = new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

    Runnable mHandlerTask = new Runnable()
    {
        @Override
        public void run() {
            TelechargerDepuisURL.getContentTO("");
            //mHandler.postDelayed(mHandlerTask, INTERVAL);
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
