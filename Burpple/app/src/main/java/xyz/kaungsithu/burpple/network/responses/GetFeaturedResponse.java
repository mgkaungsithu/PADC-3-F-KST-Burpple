package xyz.kaungsithu.burpple.network.responses;

import xyz.kaungsithu.burpple.data.vo.FeaturedVO;

import java.util.List;

/**
 * Created by User on 1/12/2018.
 */

public class GetFeaturedResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<FeaturedVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<FeaturedVO> getFeatured() {
        return featured;
    }
}
