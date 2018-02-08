package com.framgia.demo_mvvm.data.source.remote;

import android.os.AsyncTask;

import com.framgia.demo_mvvm.data.UserDataSource;
import com.framgia.demo_mvvm.data.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2/7/2018.
 */

public class UserRemoteDataSource implements UserDataSource {
    private static final String NAME_USER = "login";
    private static final String ID_USER = "id";
    private static final String AVATAR_USER = "avatar_url";
    private static UserDataSource sSource;
    private OnFetchDataListener mListener;

    public static UserDataSource getInstance() {
        if (sSource == null) {
            sSource = new UserRemoteDataSource();
        }
        return sSource;
    }

    @Override
    public void getUsers(String urls, UserDataSource.OnFetchDataListener onFetchDataListener) {
        new FetchDataFromUrl().execute(urls);
        mListener = onFetchDataListener;
    }


    class FetchDataFromUrl extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(15000);
                connection.setDoOutput(true);
                connection.connect();
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                String s = sb.toString();
                connection.disconnect();
                return s;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                if (s == null || s.equals("") ) {
                    mListener.onFail();
                    return;
                }
                JSONObject jsonRoot = new JSONObject(s);
                JSONArray arrayItem = jsonRoot.optJSONArray("items");
                if (arrayItem.length() == 0) {
                } else {
                    List<User> users = new ArrayList<>();
                    String name, id, avatarUrl;
                    for (int i = 0; i < arrayItem.length(); i++) {
                        JSONObject items = arrayItem.optJSONObject(i);
                        id = items.optString(ID_USER);
                        name = items.optString(NAME_USER);
                        avatarUrl = items.optString(AVATAR_USER);
                        users.add(new User(avatarUrl, id, name));
                    }
                    mListener.onSuccess(users);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
