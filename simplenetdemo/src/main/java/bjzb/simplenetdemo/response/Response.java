package bjzb.simplenetdemo.response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bjzb.simplenetdemo.request.Request;

/**
 * Created by bjhl-penghaoyou on 16/11/12.
 * 响应结果类  放置相应的结果数据
 *
 * 响应状态行数据
 * 响应体
 */

public class Response {

    /**
     * 原始的Response主体数据
     */
    public byte[] rawData = new byte[]{};

    private int mCode;
    private String mReason;

    Map<String, List<String>> headerFields = new HashMap<>();


    public Response(int code,String reason){
        mCode = code;
        mReason = reason;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }


    public static class HttpEntity{
        InputStream mInputStream;
        int mContentLength;
        String mContentEncoding;
        String mContentType;
        public HttpEntity(InputStream inputStream, int contentLength, String contentEncoding, String contentType) {
            mInputStream = inputStream;
            mContentEncoding = contentEncoding;
            mContentLength = contentLength;
            mContentType = contentType;
        }

//        public byte[] getRawByte(){
//            byte[] bytes = new byte[]{};
//            //这里不能根据ContentLength来判断 因为在用纯java进行请求没事  如果用手机android请求老是返回 －1
//            if(mContentLength>0){
//                bytes = new byte[mContentLength];
//                try {
//                    mInputStream.read(bytes,0,mContentLength);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        mInputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return bytes;
//        }

        public byte[] getRawByte(){
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据
            int rc = 0;
            try {
                while ((rc = mInputStream.read(buff, 0, 100)) > 0) {
                    swapStream.write(buff, 0, rc);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return swapStream.toByteArray();
        }
    }




    public Map<String, List<String>> getHeaderFields() {
        return headerFields;
    }

    public void setHeaderFields(Map<String, List<String>> headerFields) {
        this.headerFields = headerFields;
    }

    public int getmCode() {
        return mCode;
    }

    public String getmReason() {
        return mReason;
    }
}
