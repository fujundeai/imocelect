package com.example.latte_core.net.download;

import android.os.AsyncTask;

import com.example.latte_core.net.RestCreator;
import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.IRequest;
import com.example.latte_core.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-14
 * Time: 15:28
 */
public class DownloadHandler {
    private final WeakHashMap<String, Object> PARAMS;
    private final String URL;
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String url,WeakHashMap<String, Object> params,  IRequest request,
                           String download_dir, String extension, String name, ISuccess success,
                           IFailure failure, IError error) {
        this.PARAMS = params;
        this.URL = url;
        this.REQUEST = request;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    public void handleDownload() {
        if(REQUEST!=null){
            REQUEST.requestStart();
        }
        RestCreator.getRestService().download(URL,PARAMS).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    final ResponseBody body=response.body();
                    final SavaFileTask task=new SavaFileTask(REQUEST,SUCCESS);
                    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,DOWNLOAD_DIR,EXTENSION,body,NAME);

                    //这里一定要注意判断，否则下载不全
                    if(task.isCancelled()){
                        if(REQUEST!=null){
                            REQUEST.requestEnd();
                        }
                    }
                }else {
                    if(ERROR!=null){
                        ERROR.onError(response.code(),response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if(FAILURE!=null){
                    FAILURE.onFailure();
                }
            }
        });
    }
}
