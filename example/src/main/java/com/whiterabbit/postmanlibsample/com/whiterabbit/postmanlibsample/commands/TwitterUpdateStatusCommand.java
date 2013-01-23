package com.whiterabbit.postmanlibsample.com.whiterabbit.postmanlibsample.commands;

import android.content.Context;
import android.os.Parcel;
import com.whiterabbit.postman.commands.RestServerCommand;
import com.whiterabbit.postman.commands.ResultParseException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

/**
 * Created with IntelliJ IDEA.
 * User: fedepaol
 * Date: 12/18/12
 * Time: 12:41 AM
 */
public class TwitterUpdateStatusCommand extends RestServerCommand {
    private static final String url = "https://api.twitter.com/1.1/statuses/update.json";
    private String mStatus;


    public TwitterUpdateStatusCommand(String status){
        super(Verb.POST, url);
        mStatus = status;
    }

    @Override
    protected void processHttpResult(Response result, Context context) throws ResultParseException {
        //TODO Autogenerated
    }

    @Override
    protected void addParamsToRequest(OAuthRequest request) {
        request.addBodyParameter("status", mStatus);
    }

    @Override
    public int describeContents() {
        return 0;  //TODO Autogenerated
    }



    public static final Creator<TwitterUpdateStatusCommand> CREATOR
            = new Creator<TwitterUpdateStatusCommand>() {
        public TwitterUpdateStatusCommand createFromParcel(Parcel in) {
            return new TwitterUpdateStatusCommand(in);
        }

        public TwitterUpdateStatusCommand[] newArray(int size) {
            return new TwitterUpdateStatusCommand[size];
        }
    };


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(mStatus);
    }

    public TwitterUpdateStatusCommand(Parcel in){
        super(in);
        mStatus = in.readString();
    }

}