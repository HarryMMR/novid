package software.techbase.novid.domain.remote.api;

import java.io.Serializable;

import retrofit2.Call;
import software.techbase.novid.domain.remote.domain.RestInvoker;
import software.techbase.novid.domain.remote.domain.XApplicationAPIServiceContext;
import software.techbase.novid.domain.remote.service.XApplicationAPIService;

/**
 * Created by Wai Yan on 3/31/20.
 */
public class DoSignIn extends RestInvoker<XApplicationAPIService, DoSignIn.Request, DoSignIn.Response> {

    public DoSignIn() {
        super(XApplicationAPIServiceContext.getAPIService());
    }

    @Override
    protected Call<Response> call(Request request) {
        return this.getService().doSignIn(request);
    }

    public static class Request implements Serializable {

        public String mobile;
        public String code;
    }

    public static class Response implements Serializable {

        public String token;
        public String userId;
    }
}
