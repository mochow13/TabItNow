package com.example.mottakin.tabitnow;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.StringTokenizer;

/**
 * Created by mottakin on 5/15/16.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {


    String register_url="http://192.168.10.2/loginapp/register.php";
    String login_url="http://192.168.10.2/loginapp/login.php";
    String create_url="http://192.168.10.2/loginapp/create_tournament.php";
    String search_url="http://192.168.10.2/loginapp/archive_search.php";
    String search_archive_url="http://192.168.10.2/loginapp/archive_search_only.php";
    String show_my_tournaments_url="http://192.168.10.2/loginapp/show_tournaments.php";
    String add_debater_url="http://192.168.10.2/loginapp/add_debater.php";
    String join_debater_url="http://192.168.10.2/loginapp/join_debater.php";
    String add_adj_url="http://192.168.10.2/loginapp/add_adj.php";
    String currentUser="";

    Context ctx;
    Activity activity;


    AlertDialog.Builder builder;
    ProgressDialog progressDialog;

    public BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
        activity=(Activity)ctx;
    }

    public void setUser(String user)
    {
        currentUser=user;
    }

    @Override
    protected void onPreExecute() {

        builder=new AlertDialog.Builder(activity);
        progressDialog=new ProgressDialog(ctx);
        progressDialog.setTitle("Please wait!");
        progressDialog.setMessage("Connecting to the server...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method=params[0];

        if(method.equals("register"))
        {
            try {
                URL url=new URL(register_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String name=params[1]; //name=name.toLowerCase();
                String username=params[2]; //username=username.toLowerCase();
                String email=params[3]; //email=email.toLowerCase();
                String phone=params[4]; //phone=phone.toLowerCase();
//                String institution=params[5];
                String password=params[5]; //password=password.toLowerCase();

                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
//                        URLEncoder.encode("institution","UTF-8")+"="+URLEncoder.encode(institution,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("login"))
        {
            try {
                URL url=new URL(login_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String username, password;

                username=params[1]; //username=username.toLowerCase();
                password=params[2];

                String data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("create_tournament"))
        {
            try {
                URL url=new URL(create_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String codeName=params[1]; //codeName=codeName.toLowerCase();
                String compTitle=params[2]; //compTitle=compTitle.toLowerCase();
                String orgClub=params[3]; //orgClub=orgClub.toLowerCase();
                String hostUsername=params[4]; //hostUsername=hostUsername.toLowerCase();
                String venueName=params[5]; //venueName=venueName.toLowerCase();
                String startDate=params[6];
                String endDate=params[7];

                String data= URLEncoder.encode("compid","UTF-8")+"="+URLEncoder.encode(codeName,"UTF-8")+"&"+
                        URLEncoder.encode("compname","UTF-8")+"="+URLEncoder.encode(compTitle,"UTF-8")+"&"+
                        URLEncoder.encode("orgclub","UTF-8")+"="+URLEncoder.encode(orgClub,"UTF-8")+"&"+
                        URLEncoder.encode("hostuser","UTF-8")+"="+URLEncoder.encode(hostUsername,"UTF-8")+"&"+
                        URLEncoder.encode("venue","UTF-8")+"="+URLEncoder.encode(venueName,"UTF-8")+"&"+
                        URLEncoder.encode("startdate","UTF-8")+"="+URLEncoder.encode(startDate,"UTF-8")+"&"+
                        URLEncoder.encode("enddate","UTF-8")+"="+URLEncoder.encode(endDate,"UTF-8")+"&"+
                        URLEncoder.encode("champion","UTF-8")+"="+URLEncoder.encode("N/A","UTF-8")+"&"+
                        URLEncoder.encode("runnerup","UTF-8")+"="+URLEncoder.encode("N/A","UTF-8")+"&"+
                        URLEncoder.encode("bestspeaker","UTF-8")+"="+URLEncoder.encode("N/A","UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("search"))
        {
            try {
                URL url=new URL(search_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String search_query;

                search_query=params[1]; //search_query=search_query.toLowerCase();

                String data=URLEncoder.encode("keywords","UTF-8")+"="+URLEncoder.encode(search_query,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("search_archive"))
        {
            try {
                URL url=new URL(search_archive_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String search_query;

                search_query=params[1]; //search_query=search_query.toLowerCase();

                String data=URLEncoder.encode("keywords","UTF-8")+"="+URLEncoder.encode(search_query,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("show_my_tournaments"))
        {
            try {
                URL url=new URL(show_my_tournaments_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String search_query;

                search_query=params[1]; //search_query=search_query.toLowerCase();

                String data=URLEncoder.encode("keywords","UTF-8")+"="+URLEncoder.encode(search_query,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(method.contains("add_debater"))
        {
            try {
                URL url=new URL(add_debater_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String tableName, Member, Team, Inst;

                tableName=params[1]; //search_query=search_query.toLowerCase();
                Member=params[2];
                Team=params[3];
                Inst=params[4];

                String js="";
                String role="debater";
                String marks="0";

                String data= URLEncoder.encode("tablename","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(Member,"UTF-8")+"&"+
                        URLEncoder.encode("role","UTF-8")+"="+URLEncoder.encode(role,"UTF-8")+"&"+
                        URLEncoder.encode("joinstatus","UTF-8")+"="+URLEncoder.encode(js,"UTF-8")+"&"+
                        URLEncoder.encode("institution","UTF-8")+"="+URLEncoder.encode(Inst,"UTF-8")+"&"+
                        URLEncoder.encode("teamname","UTF-8")+"="+URLEncoder.encode(Team,"UTF-8")+"&"+
                        URLEncoder.encode("totalmarks","UTF-8")+"="+URLEncoder.encode(marks,"UTF-8");

//                Intent intent=new Intent(activity,DebugActivity.class);
//                intent.putExtra("DEBUG",data);
//                activity.startActivity(intent);

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else if(method.contains("add_adj"))
        {
            try {
                URL url=new URL(add_adj_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String tableName, Team, Adj, Inst;

                tableName=params[1]; //search_query=search_query.toLowerCase();
                Adj=params[2];
                Inst=params[3];
                Team="N/A";

                String js="";
                String role="adj";
                String marks="0";

                String data= URLEncoder.encode("tablename","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(Adj,"UTF-8")+"&"+
                        URLEncoder.encode("role","UTF-8")+"="+URLEncoder.encode(role,"UTF-8")+"&"+
                        URLEncoder.encode("joinstatus","UTF-8")+"="+URLEncoder.encode(js,"UTF-8")+"&"+
                        URLEncoder.encode("institution","UTF-8")+"="+URLEncoder.encode(Inst,"UTF-8")+"&"+
                        URLEncoder.encode("totalmarks","UTF-8")+"="+URLEncoder.encode(marks,"UTF-8")+"&"+
                        URLEncoder.encode("teamname","UTF-8")+"="+URLEncoder.encode(Team,"UTF-8");

//                Intent intent=new Intent(activity,DebugActivity.class);
//                intent.putExtra("DEBUG",data);
//                activity.startActivity(intent);

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("join_tournament"))
        {
            try {
                URL url=new URL(join_debater_url);

                HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setDoInput(true);

                OutputStream outputStream=httpurlconnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String tableName, User, Club, Team;

                tableName=params[1]; //search_query=search_query.toLowerCase();
                User=params[2];
                Club=params[3];
                Team=params[4];
                String role=params[5];

                String data= URLEncoder.encode("tablename","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(User,"UTF-8")+"&"+
                        URLEncoder.encode("role","UTF-8")+"="+URLEncoder.encode(role,"UTF-8")+"&"+
                        URLEncoder.encode("institution","UTF-8")+"="+URLEncoder.encode(Club,"UTF-8")+"&"+
                        URLEncoder.encode("teamname","UTF-8")+"="+URLEncoder.encode(Team,"UTF-8");

//                Intent intent=new Intent(activity,DebugActivity.class);
//                intent.putExtra("DEBUG",data);
//                activity.startActivity(intent);

                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpurlconnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder=new StringBuilder();

                String line="";

                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }

                httpurlconnection.disconnect();

                Thread.sleep(1500);

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(String json) {


        try {
            progressDialog.dismiss();
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("server_response");
            JSONObject JO=jsonArray.getJSONObject(0);

            String code=JO.getString("code");
            String message=JO.getString("message");

            if(code.equals("reg_true"))
            {
                showDialog("Registration success!",message,code);
            }
            else if(code.equals("reg_false"))
            {
                showDialog("Registration failed!",message,code);
            }
            else if(code.equals("login_true"))
            {
                Intent intent=new Intent(activity,AfterLoginActivity.class);
                intent.putExtra("USER_NAME",message);
                activity.startActivity(intent);
            }
            else if(code.equals("login_false"))
            {
                showDialog("Login failed!",message,code);
            }
            else if(code.equals("creation_false"))
            {

                showDialog("Failed! :(",message,code);
            }
            else if(code.equals("creation_true"))
            {
                showDialog("Success! :D",message,code);
            }
            else if(code.equals("search"))
            {
//                showDialog("Searched successfully!", message, code);
                Intent intent=new Intent(activity,SearchResultsActivity.class);
                intent.putExtra("USER_NAME",currentUser);
                intent.putExtra("SEARCH_RESULT",message);
                activity.startActivity(intent);
            }
            else if(code.equals("search_archive_only"))
            {
                Intent intent=new Intent(activity,ViewArchiveActivity.class);
                intent.putExtra("ARCHIVE_SEARCH_RESULT",message);
                activity.startActivity(intent);
            }
            else if(code.equals("show_tournaments"))
            {
                Intent intent=new Intent(activity,myTournamentsBoard.class);
                intent.putExtra("ALL_TOURNAMENTS",message);
                activity.startActivity(intent);
            }
            else if(code.equals("add_debater_true"))
            {
                showDialog("Success! :D",message,code);
            }
            else if(code.equals("add_debater_false"))
            {
                showDialog("Failed! :(", message,code);
            }
            else if(code.equals("join_debater_true"))
            {
                showDialog("Success! :D", message, code);
            }
            else if(code.equals("join_debater_false"))
            {
                showDialog("Failed! :(", message, code);
            }
            else if(code.equals("add_adj_true"))
            {
                showDialog("Success! :D",message,code);
            }
            else if(code.equals("add_adj_false"))
            {
                showDialog("Failed! :(", message,code);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void showDialog(String title, String message, String code)
    {
        builder.setTitle(title);

        final String codeMsg=code;

        if(code.equals("reg_true") || code.equals("reg_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if(codeMsg.equals("reg_true"))
                        activity.finish();
                }
            });
        }
        else if(code.equals("creation_true") || code.equals("creation_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if(codeMsg.equals("creation_true"))
                        activity.finish();
                }
            });
        }
        else if(code.equals("add_debater_true") || code.equals("add_debater_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        else if(code.equals("add_adj_true") || code.equals("add_adj_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        else if(code.equals("join_debater_true") || code.equals("join_debater_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        else if(code.equals("login_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText userName, passWord;

                    userName=(EditText)activity.findViewById(R.id.usernameTextField);
                    passWord=(EditText)activity.findViewById(R.id.passwordTextField);

                    userName.setText("");
                    passWord.setText("");

                    dialog.dismiss();
                }
            });
        }
//        else if(code.equals("search_successful"))
//        {
//            builder.setMessage(message);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });
//        }

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

}




















