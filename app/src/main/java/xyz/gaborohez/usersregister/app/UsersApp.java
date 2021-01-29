package xyz.gaborohez.usersregister.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import xyz.gaborohez.usersregister.R;

/**
 * Created by Gabriel Rodríguez on 07/12/20.
 * Email gabow95k@gmail.com
 */
public class UsersApp extends Application {

    public static Context context;
    public static ResourcesManager resourcesManager;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getBaseContext();
        resourcesManager = new ResourcesManager(getResources());
    }

    public static class ResourcesManager {
        private Resources resources;

        public ResourcesManager(Resources resources) {
            this.resources = resources;
        }

        public String getErrorServer() {
            return resources.getString(R.string.server_error);
        }


        public String getEmailErrorMessage() {
            return resources.getString(R.string.email_error_message);
        }

        public String getPasswordError() {
            return resources.getString(R.string.password_error_message);
        }

        public String getPasswordIncorrect() {
            return resources.getString(R.string.password_incorrect_message);
        }

        public String getPasswordErrorMessage() {
            return resources.getString(R.string.password_not_match);
        }

        public String getErrorNameEquals(){
            return resources.getString(R.string.new_equal_current_name);
        }
    }
}
